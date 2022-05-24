package br.cefsa.edu.classeslib.DAO;
import br.cefsa.edu.classeslib.interfaces.InterfaceDAO;
import br.cefsa.edu.classeslib.entities.Pessoa;
import br.cefsa.edu.classeslib.enums.EnumCargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDAO implements InterfaceDAO<Pessoa>{
    
    
    
    @Override
    public List<Pessoa> GetAll() {
        String sql = "SELECT * FROM LOGIN";

        List<Pessoa> Pessoas = new ArrayList();
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                Pessoas.add(ResultSetToPessoa(result));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return Pessoas;
    }

    
    @Override
    public Pessoa GetById(int id) {
        Pessoa pessoa = new Pessoa();
        try {
            throw new Exception("Não é possível buscar pelo id");
        } catch (Exception ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pessoa;
    }
    
    
    
    public boolean ValidateLogin(String email, String senha) throws Exception {
        String sql = "SELECT * FROM login WHERE email = ?";
        Pessoa pessoa = null;
        Pessoa pessoaValidar = new Pessoa();
        pessoaValidar.setSenha(senha);
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, email);
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                pessoa = ResultSetToPessoa(result);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return pessoa != null && pessoa.getSenha() != null ? pessoa.getSenha().equals(pessoaValidar.getSenha()) : false;
        
    }
    
    
    
    @Override
    public void Delete(int id) {
        try {
            throw new Exception("Não é possível deletar pelo id");
        } catch (Exception ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void Delete(String email) {
        String sql = "DELETE FROM login where email = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, email);
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void Update(Pessoa pessoa) {
        String sql = "UPDATE Login SET email = ?, senha = ?, cargo = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, pessoa.getEmail());
            pStatement.setString(2, pessoa.getSenha());
            pStatement.setInt(2, pessoa.getCargo().ordinal());
            pStatement.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void Insert(Pessoa pessoa) {
        String sql = "INSERT INTO Login(email, senha, cargo) VALUES(?, ?, ?)";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, pessoa.getEmail());
            pStatement.setString(2, pessoa.getSenha());
            pStatement.setInt(3, pessoa.getCargo().ordinal());
            pStatement.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Pessoa ResultSetToPessoa(ResultSet result) throws SQLException {
        return new Pessoa(
                result.getString("email"),
                result.getString("senha"),
                EnumCargo.values()[result.getInt("cargo")]
        );
    }
}
