package br.com.before.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculadoraEficienciaEnergetica {

    public double calcularConsumoPorEquipamento(Equipamento e) {
        return e.getPotencia() * e.getQuantidade() * e.getHoraOperacao()/ 1000;
    }

    public List<EficienciaSetor> calcularEficienciaEnergeticaPorSetor(List<Equipamento> equipamentos, double producaoMensal) {
        HashMap<String, Double> consumoPorSetor = new HashMap<>();
        HashMap<String, Integer> quantidadeEquipamentosPorSetor = new HashMap<>();
        List<EficienciaSetor> eficienciaSetores = new ArrayList<>();

        for (Equipamento equipamento : equipamentos) {
            double consumoPorEquipamento = calcularConsumoPorEquipamento(equipamento);
            String setor = equipamento.getSetor();

            consumoPorSetor.put(setor, consumoPorSetor.getOrDefault(setor, 0.0) + consumoPorEquipamento);
            quantidadeEquipamentosPorSetor.put(setor, quantidadeEquipamentosPorSetor.getOrDefault(setor, 0) + equipamento.getQuantidade());
        }

        double consumoTotal = consumoPorSetor.values().stream().mapToDouble(Double::doubleValue).sum();

        for (Map.Entry<String, Double> entrada : consumoPorSetor.entrySet()) {
            String setor = entrada.getKey();
            Double consumoMensal = entrada.getValue();

            double proporcaoProducaoSetor = consumoMensal / consumoTotal;
            double producaoSetor = proporcaoProducaoSetor * producaoMensal;

            double eficienciaPorSetor = producaoSetor / producaoMensal;

            EficienciaSetor eficienciaEnergeticaSetor = new EficienciaSetor(setor, eficienciaPorSetor, consumoMensal, "");
            eficienciaSetores.add(eficienciaEnergeticaSetor);
        }
        return eficienciaSetores;
    }

    public EficienciaEnergetica gerarEficienciaEnergetica(List<Equipamento> equipamentos, double producaoMensal) {
        List<EficienciaSetor> eficienciaSetores = calcularEficienciaEnergeticaPorSetor(equipamentos, producaoMensal);
        double somaEficiencia = 0.0;
        double somaConsumo = 0.0;

        DefineVisaoGeral defineVisaoGeral = new DefineVisaoGeral();

        for (EficienciaSetor eficienciaSetor : eficienciaSetores) {
            somaEficiencia += eficienciaSetor.getEficienciaEnergetica();
            somaConsumo += eficienciaSetor.getConsumoMensal();
            defineVisaoGeral.definir(eficienciaSetor);
        }

        EficienciaGeral eficiencieEnergeticaGeral = new EficienciaGeral(somaEficiencia*0.8, somaConsumo);
        defineVisaoGeral.definir(eficiencieEnergeticaGeral);

        return new EficienciaEnergetica(eficienciaSetores, eficiencieEnergeticaGeral);
    }

}
