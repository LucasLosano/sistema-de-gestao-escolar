package br.cefsa.edu.classeslib.DAO;
import br.cefsa.edu.classeslib.entities.Login;
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

public class LoginDAO implements InterfaceDAO<Login>{
    
    
    
    @Override
    public List<Login> GetAll() {
        String sql = "SELECT * FROM LOGIN";

        List<Login> Pessoas = new ArrayList();
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                Pessoas.add(ResultSetToLogin(result));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
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
    public Login GetById(int id) {
        try {
            throw new Exception("Não é possível buscar pelo id");
        } catch (Exception ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean ValidateLogin(Login loginValidar) throws Exception {
        String sql = "SELECT * FROM login WHERE email = ?";
        Login pessoa = null;
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, loginValidar.getEmail());
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                pessoa = ResultSetToLogin(result);
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
        boolean isValido = pessoa != null && pessoa.getSenha() != null ? pessoa.getSenha().equals(loginValidar.getSenha()) : false;
        if(isValido) {
            loginValidar.setCargo(pessoa.getCargo());
            loginValidar.setIdUsuario(pessoa.getIdUsuario());
        }
        return isValido;
        
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
    public void Update(Login pessoa) {
        String sql = "UPDATE Login SET senha = ?, cargo = ?, idUsuario = ? WHERE email = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, pessoa.getSenha());
            pStatement.setInt(2, pessoa.getCargo().ordinal());
            pStatement.setInt(3, pessoa.getIdUsuario());
            pStatement.setString(4, pessoa.getEmail());
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
    public void Insert(Login pessoa) {
        String sql = "INSERT INTO Login(email, senha, cargo, idUsuario) VALUES(?, ?, ?,?)";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, pessoa.getEmail());
            pStatement.setString(2, pessoa.getSenha());
            pStatement.setInt(3, pessoa.getCargo().ordinal());
            pStatement.setInt(4, pessoa.getIdUsuario());
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

    private Login ResultSetToLogin(ResultSet result) throws SQLException, Exception {
        Login login = new Login();
        login.setCargo(EnumCargo.values()[result.getInt("cargo")]);
        login.setEmail(result.getString("email"));
        login.setIdUsuario(result.getInt("idUsuario"));
        login.setSenhaBanco(result.getString("senha"));
        return login;
    }
}
