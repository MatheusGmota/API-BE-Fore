package br.com.before.dominio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class DefineVisaoGeral {
    public void definir(EficienciaGeral eficienciaGeral) {
        try {
            String visaoGeral = definirTextoPorEficiencia(eficienciaGeral.getEficienciaEnergetica());
            eficienciaGeral.setVisaoGeral(visaoGeral);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public void definir(EficienciaSetor eficienciaSetor) {
        try {
            String visaoGeral = definirTextoPorEficiencia(eficienciaSetor.getEficienciaEnergetica());
            eficienciaSetor.setVisaoGeral(visaoGeral);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private String definirTextoPorEficiencia(double eficiencia) throws IOException{
        File arquivoVisaoGeral = new File("src/main/java/br/com/before/resource/visao-geral.txt");

        List<String> linhas = Files.readAllLines(arquivoVisaoGeral.toPath());

        if (eficiencia <= 0.3) {
            return linhas.get(0);
        } else if (eficiencia > 0.3 && eficiencia <= 0.5) {
            return linhas.get(1);
        } else if (eficiencia > 0.5 && eficiencia <= 0.7) {
            return linhas.get(2);
        } else {
            return linhas.get(3);
        }
    }

    private String definirTextoPorIdQuestao(long idQuestao) throws IOException {
        File fileFeedback = new File("src/main/java/br/com/before/resource/feedback.txt");

        List<String> linhas = Files.readAllLines(fileFeedback.toPath());

        StringBuilder feedback = new StringBuilder();
        boolean capturarTexto = false;

        for (String linha : linhas) {
            if (linha.startsWith("Propostas de Melhoria:")) {
                capturarTexto = true;
                continue;
            }
            if (capturarTexto) {
                if (linha.startsWith("---")) {
                    break;
                }
                feedback.append(linha).append("\n");
            }
        }

        return feedback.toString().trim();

    }

    public void feedback(FeedbackQuestoes feedbackQuestoes) {
        try {
            String feedback = definirTextoPorIdQuestao(feedbackQuestoes.getIdQuestao());
            feedbackQuestoes.setFeedback(feedback);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
