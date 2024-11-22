package br.com.before.infra.dao;

import br.com.before.dominio.*;
import br.com.before.infra.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaDAO implements RepositorioEmpresas {
    private Connection connection;

    public EmpresaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionar(Empresa empresa) {
        String sql = "INSERT INTO tb_empresas(nome, local_emp, id_tipo) VALUES(?,?,?)";
        try {
            PreparedStatement cmdInsert = connection.prepareStatement(sql);
            cmdInsert.setString(1, empresa.getNome());
            cmdInsert.setString(2, empresa.getLocal());
            cmdInsert.setLong(3, empresa.getIdTipo());
            cmdInsert.execute();
            cmdInsert.close();
            empresa.setId(obterIdEmpresa());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void adicionarResposta(Long idEmp, Resposta resposta) {
        String sql = "INSERT INTO tb_empresa_respostas(id_questao, id_empresa, resposta) VALUES(?,?,?)";
        try {
            PreparedStatement cmdInsert = connection.prepareStatement(sql);
            cmdInsert.setLong(1, resposta.getIdQuestao());
            cmdInsert.setLong(2, idEmp);
            cmdInsert.setString(3, resposta.getResposta());
            cmdInsert.execute();
            cmdInsert.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void adicionarProducaoMensal(Long idEmp, double producaoMensal) {
        String sql = "INSERT INTO tb_producao_mensal VALUES(?,?)";
        try {
            PreparedStatement cmdInsert = connection.prepareStatement(sql);
            cmdInsert.setLong(1, idEmp);
            cmdInsert.setDouble(2, producaoMensal);
            cmdInsert.execute();
            cmdInsert.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Empresa obter(Long id) {
        return null;
//        Método a ser implementado para retornar a empresa para o relatório da eficiencia energetica
    }

    public double obterProducaoMensal(Long idEmpresa) {
        double producaoMensal = 0.0;
        try {
            String sql = "SELECT producao_mensal FROM tb_producao_mensal WHERE id_empresa = ?";
            PreparedStatement cmdInsert = connection.prepareStatement(sql);
            cmdInsert.setLong(1, idEmpresa);
            ResultSet rs = cmdInsert.executeQuery();
            while (rs.next()) {
                producaoMensal = rs.getDouble("producao_mensal");
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producaoMensal;
    }

    private Long obterIdEmpresa() {
        Long id = null;
        try {
            String sql = "SELECT tb_empresas_id_empresa_seq.NEXTVAL FROM DUAL";
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
