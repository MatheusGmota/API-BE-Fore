package br.com.before.infra.dao;

import br.com.before.dominio.RepositorioTipoEmpresas;
import br.com.before.dominio.TipoEmpresa;
import br.com.before.infra.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TipoEmpresaDAO implements RepositorioTipoEmpresas {

    private Connection connection;

    public TipoEmpresaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public ArrayList<TipoEmpresa> obterTipoEmpresa() {
        ArrayList<TipoEmpresa> tipos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_tipo_empresa";
            PreparedStatement cmdSelect = connection.prepareStatement(sql);
            ResultSet rs = cmdSelect.executeQuery();
            while(rs.next()){
                TipoEmpresa tipo = new TipoEmpresa(rs.getLong("id_tipo"),
                                                    rs.getString("tipo"));
                tipos.add(tipo);
            }
            rs.close();
            cmdSelect.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return tipos;
    }

    public void fechar() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
