package br.com.before.infra.dao;

import br.com.before.dominio.Questao;
import br.com.before.dominio.FeedbackQuestoes;
import br.com.before.dominio.RepositorioQuestoes;
import br.com.before.infra.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestoesDAO implements RepositorioQuestoes {

    private Connection connection;

    public QuestoesDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public ArrayList<Questao> obterTodos() {
        ArrayList<Questao> questoes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_questoes";
            PreparedStatement cmdSelect = connection.prepareStatement(sql);
            ResultSet rs = cmdSelect.executeQuery();
            while (rs.next()) {
                Questao questao = new Questao(rs.getLong("id_questao"),
                                              rs.getString("questao"));
                questoes.add(questao);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return questoes;
    }

    public ArrayList<FeedbackQuestoes> obterFeedbackQuestoes(Long idEmpresa) {
        String sql = "SELECT q.id_questao, q.questao, er.resposta FROM tb_empresas emp INNER JOIN tb_empresa_respostas er ON emp.id_empresa = er.id_empresa INNER JOIN tb_questoes q ON er.id_questao = q.id_questao WHERE emp.id_empresa = ?";
        ArrayList<FeedbackQuestoes> listaFeedbacks = new ArrayList<>();
        try {
            PreparedStatement cmdSelect = connection.prepareStatement(sql);
            cmdSelect.setLong(1, idEmpresa);
            ResultSet rs = cmdSelect.executeQuery();
            while (rs.next()) {
                FeedbackQuestoes feedbackQuestoes = new FeedbackQuestoes(rs.getLong("id_questao"),
                                                                            rs.getString("questao"),
                                                                            rs.getString("resposta"));
                listaFeedbacks.add(feedbackQuestoes);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaFeedbacks;
    }

    public void fechar() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
