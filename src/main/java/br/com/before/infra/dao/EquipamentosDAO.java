package br.com.before.infra.dao;

import br.com.before.dominio.Equipamento;
import br.com.before.dominio.RepositorioEquipamentos;
import br.com.before.infra.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipamentosDAO implements RepositorioEquipamentos  {

    private Connection connection;

    public EquipamentosDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public List<Equipamento> obter(Long idEmpresa) {
        List<Equipamento> equipamentos = new ArrayList<>();
        try {
            String sql = "SELECT eq.* FROM tb_empresas emp INNER JOIN tb_empresa_equipamento emp_eq ON emp.id_empresa = emp_eq.id_empresa INNER JOIN tb_equipamentos eq ON emp_eq.id_equipamentos = eq.id_equipamentos WHERE emp.id_empresa = ?";
            PreparedStatement cmdInsert = connection.prepareStatement(sql);
            cmdInsert.setLong(1, idEmpresa);
            ResultSet rs = cmdInsert.executeQuery();
            while (rs.next()) {
                Equipamento equipamento = new Equipamento(rs.getLong("id_equipamentos"),
                                                          rs.getString("nome_equipamento"),
                                                          rs.getString("setor"),
                                                          rs.getDouble("potencia"),
                                                          rs.getInt("quantidade"),
                                                          rs.getInt("hora_operacao"));
                equipamentos.add(equipamento);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return equipamentos;
    }

    public void adicionar(Long idEmpresa, Equipamento equipamento) {
        String sql = "INSERT INTO tb_equipamentos(nome_equipamento, setor, potencia, quantidade, hora_operacao) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement cmdInsert = connection.prepareStatement(sql);
            cmdInsert.setString(1, equipamento.getNomeEquipamento());
            cmdInsert.setString(2, equipamento.getSetor());
            cmdInsert.setDouble(3, equipamento.getPotencia());
            cmdInsert.setInt(4, equipamento.getQuantidade());
            cmdInsert.setInt(5, equipamento.getHoraOperacao());
            cmdInsert.execute();
            cmdInsert.close();
            equipamento.setIdEquipamento(obterIdEquipamento());
            adicionarEmpresaEquipamento(idEmpresa, equipamento.getIdEquipamento());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void adicionarEmpresaEquipamento(Long idEmpresa, Long idEquipamento) {
        String sql = "INSERT INTO tb_empresa_equipamento VALUES(?,?)";
        try {
            PreparedStatement cmdInsert = connection.prepareStatement(sql);
            cmdInsert.setLong(1, idEquipamento);
            cmdInsert.setLong(2, idEmpresa);
            cmdInsert.execute();
            cmdInsert.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Long obterIdEquipamento() {
        Long id = null;
        try {
            String sql = "SELECT tb_equipamentos_id_equipamento.NEXTVAL FROM DUAL";
            PreparedStatement cmdSelect = connection.prepareStatement(sql);
            ResultSet rs = cmdSelect.executeQuery();
            while(rs.next()) {
                id = rs.getLong(1) - 1;
            }
            rs.close();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    public void fechar() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
