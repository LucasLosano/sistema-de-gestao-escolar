package br.cefsa.edu.classeslib.DAO;

import br.cefsa.edu.classeslib.entities.Aluno;
import br.cefsa.edu.classeslib.entities.Curso;
import br.cefsa.edu.classeslib.entities.Turma;
import br.cefsa.edu.classeslib.interfaces.InterfaceDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDAO implements InterfaceDAO<Aluno> {

    @Override
    public List<Aluno> GetAll() {
        String sql = "SELECT * FROM Aluno a "
                + "INNER JOIN Turma t ON t.TURMAID = a.TURMAID "
                + "INNER JOIN Curso c ON c.CURSOID = t.CURSOID"
                + "ORDER BY ALUNOID";

        List<Aluno> alunos = new ArrayList();
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                alunos.add(ResultSetToAluno(result));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return alunos;
    }

    @Override
    public Aluno GetById(int id) {
        String sql = "SELECT * FROM Aluno a "
                + "INNER JOIN Turma t ON t.TURMAID = a.TURMAID "
                + "INNER JOIN Curso c ON c.CURSOID = t.CURSOID "
                + "WHERE ALUNOID = ?";

        Aluno aluno = null;
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, id);
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                aluno = ResultSetToAluno(result);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return aluno;
    }

    @Override
    public void Delete(int id) {
        String sql = "DELETE FROM ALUNO WHERE ALUNOID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, id);
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void Update(Aluno aluno) {
        String sql = "UPDATE ALUNO SET ALUNONOME=?,  ALUNOEMAIL = ?, ALUNOTELEFONE = ?, ALUNORUA = ?, ALUNOCIDADE = ?, TURMAID = ? WHERE ALUNOID = ?";
                                                                    
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, aluno.getNome());
            pStatement.setString(2, aluno.getEmail());
            pStatement.setString(3, aluno.getTelefone());
            pStatement.setString(4, aluno.getRua());
            pStatement.setString(5, aluno.getCidade());
            pStatement.setInt(6, aluno.getTurma().getId());
            pStatement.setInt(7, aluno.getId());
            pStatement.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void Insert(Aluno aluno) {
        String sql = "INSERT INTO Aluno (ALUNOID, ALUNONOME, ALUNOEMAIL, ALUNOTELEFONE, ALUNORUA, ALUNOCIDADE, TURMAID) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                                                                    
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, aluno.getId());
            pStatement.setString(2, aluno.getNome());
            pStatement.setString(3, aluno.getEmail());
            pStatement.setString(4, aluno.getTelefone());
            pStatement.setString(5, aluno.getRua());
            pStatement.setString(6, aluno.getCidade());
            pStatement.setInt(7, aluno.getTurma().getId());
            pStatement.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Aluno ResultSetToAluno(ResultSet result) throws SQLException {
        return new Aluno(
                result.getInt("alunoId"),
                result.getString("alunoNome"),
                result.getString("alunoEmail"),
                result.getString("alunoTelefone"),
                result.getString("alunoRua"),
                result.getString("alunoCidade"),
                new Turma(
                        result.getInt("turmaId"),
                        new Curso(result.getInt("cursoId"), result.getString("cursoNome"), result.getInt("cursoQuantidadePeriodos")),
                        result.getInt("turmaPeriodoAtual"))
        );
    }
}
