/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.classeslib.DAO;

import br.cefsa.edu.classeslib.business.Calculos;
import br.cefsa.edu.classeslib.entities.Configuracoes;
import br.cefsa.edu.classeslib.enums.EnumPeriodoLetivo;
import br.cefsa.edu.classeslib.interfaces.InterfaceDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author losan
 */
public class ConfiguracoesDAO implements InterfaceDAO<Configuracoes> {

    @Override
    public List<Configuracoes> GetAll() {
        String sql = "SELECT * FROM Configuracoes";

        List<Configuracoes> configuracoes = new ArrayList();
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                configuracoes.add(ResultSetToConfiguracoes(result));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfiguracoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConfiguracoesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return configuracoes;
    }

    //Como só teremos uma linha por tabela nesse caso,
    //O Select por Id fica igual ao SelectAll
    @Override
    public Configuracoes GetById(int id) {
        String sql = "SELECT * FROM Configuracoes";

        Configuracoes configuracoes = null;
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                configuracoes = ResultSetToConfiguracoes(result);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfiguracoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConfiguracoesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return configuracoes;
    }

    @Override
    public void Delete(int id) {
        String sql = "DELETE FROM Configuracoes";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfiguracoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConfiguracoesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void Update(Configuracoes configuracoes) {
        String sql = "UPDATE CONFIGURACOES SET nomeInstituicao = ?, periodoLetivo = ?, peso1 = ?, "
                    + "peso2 = ?, peso3 = ?, peso4 = ?, fatorFrequencia = ?, logoInstituicao = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, configuracoes.getNomeInstituicao());
            pStatement.setInt(2, configuracoes.getPeriodo().getTipoPeriodo().ordinal());
            pStatement.setDouble(3, configuracoes.getPeso(0));
            pStatement.setDouble(4, configuracoes.getPeso(1));
            pStatement.setDouble(5, configuracoes.getPeso(2));
            pStatement.setDouble(6, configuracoes.getPeso(3));
            pStatement.setBoolean(7, configuracoes.isFatorFrequencia());
            pStatement.setString(8, configuracoes.getLogoInstituicao());
            pStatement.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfiguracoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConfiguracoesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void Insert(Configuracoes configuracoes) {
        String sql = "INSERT INTO CONFIGURACOES(nomeInstituicao, periodoLetivo, peso1, peso2, "
                    + "peso3, peso4, fatorFrequencia, logoInstituicao) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, configuracoes.getNomeInstituicao());
            pStatement.setInt(2, configuracoes.getPeriodo().getTipoPeriodo().ordinal());
            pStatement.setDouble(3, configuracoes.getPeso(0));
            pStatement.setDouble(4, configuracoes.getPeso(1));
            pStatement.setDouble(5, configuracoes.getPeso(2));
            pStatement.setDouble(6, configuracoes.getPeso(3));
            pStatement.setBoolean(7, configuracoes.isFatorFrequencia());
            pStatement.setString(8, configuracoes.getLogoInstituicao());
            pStatement.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConfiguracoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracoesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConfiguracoesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Configuracoes ResultSetToConfiguracoes(ResultSet result) throws SQLException {
        return new Configuracoes(
                result.getString("nomeInstituicao"),
                EnumPeriodoLetivo.values()[result.getInt("periodoLetivo")],
                new double[]{
                    Calculos.arredondaParaDuasCasas(result.getFloat("peso1")),
                    Calculos.arredondaParaDuasCasas(result.getFloat("peso2")),
                    Calculos.arredondaParaDuasCasas(result.getFloat("peso3")),
                    Calculos.arredondaParaDuasCasas(result.getFloat("peso4"))},
                result.getBoolean("fatorFrequencia"),
                result.getString("logoInstituicao")
        );
    }
}
