/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.classeslib.DAO;

import br.cefsa.edu.classeslib.entities.Aluno;
import br.cefsa.edu.classeslib.entities.Curso;
import br.cefsa.edu.classeslib.entities.Frequencia;
import br.cefsa.edu.classeslib.entities.Materia;
import br.cefsa.edu.classeslib.entities.Nota;
import br.cefsa.edu.classeslib.entities.PeriodoLetivo;
import br.cefsa.edu.classeslib.entities.Professor;
import br.cefsa.edu.classeslib.entities.Turma;
import br.cefsa.edu.classeslib.interfaces.InterfaceDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrequenciaDAO implements InterfaceDAO<Frequencia> {

    @Override
    public List<Frequencia> GetAll() {
        String sql = "SELECT * FROM Frequencia f " +
                     "LEFT JOIN Aluno a ON a.alunoId = f.alunoId\n" +
                     "LEFT JOIN Materia m ON m.id = f.materiaId\n" +
                     "LEFT JOIN Curso c ON c.CURSOID = m.CURSOID\n" +
                     "LEFT JOIN Turma t ON t.TURMAID = a.TURMAID\n" +
                     "LEFT JOIN Professor p ON p.PROFESSORID = m.PROFESSORID";

        List<Frequencia> frequencia = new ArrayList();
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                frequencia.add(ResultSetToFrequencia(result));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return frequencia;
    }

    @Override
    public Frequencia GetById(int id) {
        String sql = "SELECT * FROM Frequencia f " +
                     "LEFT JOIN Aluno a ON a.alunoId = f.alunoId " +
                     "LEFT JOIN Materia m ON m.id = f.materiaId " +
                     "LEFT JOIN Curso c ON c.CURSOID = m.CURSOID " +
                     "LEFT JOIN Turma t ON t.TURMAID = a.TURMAID " +
                     "LEFT JOIN Professor p ON p.PROFESSORID = m.PROFESSORID " +
                     "WHERE f.Id = ?";

        Frequencia frequencia = null;
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, id);
            ResultSet result = pStatement.executeQuery();
            if (result.next()) {
                frequencia = ResultSetToFrequencia(result);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return frequencia;
    }
    
    public List<Frequencia> GetByAluno(int Id) {
                String sql = "SELECT * FROM Frequencia f " +
                             "LEFT JOIN Aluno a ON a.alunoId = f.alunoId " +
                             "LEFT JOIN Materia m ON m.id = f.materiaId " +
                             "LEFT JOIN Curso c ON c.CURSOID = m.CURSOID " +
                             "LEFT JOIN Turma t ON t.TURMAID = a.TURMAID " +
                             "LEFT JOIN Professor p ON p.PROFESSORID = m.PROFESSORID " +
                             "WHERE f.alunoId = ?";

        List<Frequencia> frequencia = new ArrayList();
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, Id);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                frequencia.add(ResultSetToFrequencia(result));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return frequencia;
    }

    @Override
    public void Delete(int id) {
        String sql = "DELETE FROM Frequencia WHERE id = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void Update(Frequencia frequencia) {
        String sql = "UPDATE Frequencia SET dataFrequencia = ?, status = ?, materiaId = ?, "
                    + "alunoId = ?, periodo = ? WHERE id = ?";
        Date date = java.sql.Date.valueOf(frequencia.getData());
        
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setDate(1, date);
            pStatement.setBoolean(2, frequencia.isStatus());
            pStatement.setInt(3, frequencia.getMateria().getId());
            pStatement.setInt(4, frequencia.getAluno().getId());
            pStatement.setString(5, "Teste");
            pStatement.setDouble(6, frequencia.getId());
            pStatement.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void Insert(Frequencia frequencia) {
        String sql = "INSERT INTO FREQUENCIA(dataFrequencia, status, materiaId, "
                   + "alunoId, periodo) VALUES(?, ?, ?, ?, ?)";
        Date date = java.sql.Date.valueOf(frequencia.getData());

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setDate(1, date);
            pStatement.setBoolean(2, frequencia.isStatus());
            pStatement.setInt(3, frequencia.getMateria().getId());
            pStatement.setInt(4, frequencia.getAluno().getId());
            pStatement.setString(5, "Teste");
            pStatement.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Frequencia ResultSetToFrequencia(ResultSet result) throws SQLException {
        return new Frequencia(
                result.getInt("id"),
                result.getDate("dataFrequencia").toLocalDate(),
                result.getBoolean("status"),
                new Materia(
                    result.getInt("materiaId"),
                    result.getString("nome"),
                    new Curso(result.getInt("cursoId"), result.getString("cursoNome"), result.getInt("cursoQuantidadePeriodos")),
                    result.getInt("periodoLecionado"),
                    new Professor(
                            result.getInt("professorId"),
                            result.getString("professorNome"),
                            result.getString("professorEmail"),
                            result.getString("professorTelefone"),
                            result.getString("professorRua"),
                            result.getString("professorCidade"),
                            result.getBoolean("professorCoordenador")
                    )
                ),
                new Aluno(
                    result.getInt("alunoId"),
                    result.getString("alunoNome"),
                    result.getString("alunoEmail"),
                    result.getString("alunoTelefone"),
                    result.getString("alunoRua"),
                    result.getString("alunoCidade"),
                    new Turma(
                            result.getInt("turmaId"),
                            new Curso(result.getInt("cursoId"), result.getString("cursoNome"), result.getInt("cursoQuantidadePeriodos")),
                            result.getInt("turmaPeriodoAtual")
                    )
                ),
                new PeriodoLetivo()
        );
    }
}
