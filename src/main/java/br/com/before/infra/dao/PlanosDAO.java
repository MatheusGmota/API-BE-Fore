package br.com.before.infra.dao;

import br.com.before.dominio.Planos;
import br.com.before.dominio.RepositorioPlanos;
import br.com.before.infra.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlanosDAO implements RepositorioPlanos {

    private Connection connection;

    public PlanosDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public ArrayList<Planos> obterTodos(){
        ArrayList<Planos> planos = new ArrayList<>();
        try{
            String sql = "SELECT * FROM tb_planos";
            PreparedStatement cmdSelect = connection.prepareStatement(sql);
            ResultSet rs = cmdSelect.executeQuery();
            while(rs.next()) {
                Planos plano = new Planos(rs.getLong("id_plano"),
                                            rs.getString("tipo"),
                                            rs.getDouble("valor_mensal"));
                planos.add(plano);
            }
            rs.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return planos;
    }

    public void fechar(){
        try{
            connection.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
