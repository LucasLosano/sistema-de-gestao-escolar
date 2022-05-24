package br.cefsa.edu.classeslib.DAO;

import br.cefsa.edu.classeslib.entities.Aluno;
import br.cefsa.edu.classeslib.entities.Curso;
import br.cefsa.edu.classeslib.entities.Materia;
import br.cefsa.edu.classeslib.entities.Nota;
import br.cefsa.edu.classeslib.entities.PeriodoLetivo;
import br.cefsa.edu.classeslib.entities.Professor;
import br.cefsa.edu.classeslib.entities.Turma;
import br.cefsa.edu.classeslib.enums.EnumPeriodoLetivo;
import br.cefsa.edu.classeslib.enums.EnumTipoNota;
import br.cefsa.edu.classeslib.interfaces.InterfaceDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotaDAO implements InterfaceDAO<Nota> {

    @Override
    public List<Nota> GetAll() {
        String sql = "SELECT * FROM NOTA n\n" +
                     "LEFT JOIN Aluno a ON a.alunoId = n.alunoId\n" +
                     "LEFT JOIN Materia m ON m.materiaId = n.materiaId\n" +
                     "LEFT JOIN Curso c ON c.CURSOID = m.CURSOID\n" +
                     "LEFT JOIN Turma t ON t.TURMAID = a.TURMAID\n" +
                     "LEFT JOIN Professor p ON p.PROFESSORID = m.PROFESSORID";

        List<Nota> notas = new ArrayList();
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                notas.add(ResultSetToNota(result));
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
        return notas;
    }

    @Override
    public Nota GetById(int id) {
        throw new UnsupportedOperationException("Método não suportado!");
    }

    public List<Nota> GetByAluno(int alunoId) {
                String sql = "SELECT * FROM NOTA n\n" +
                             "LEFT JOIN Aluno a ON a.alunoId = n.alunoId\n" +
                             "LEFT JOIN Materia m ON m.materiaId = n.materiaId\n" +
                             "LEFT JOIN Curso c ON c.CURSOID = m.CURSOID\n" +
                             "LEFT JOIN Turma t ON t.TURMAID = a.TURMAID\n" +
                             "LEFT JOIN Professor p ON p.PROFESSORID = m.PROFESSORID\n" +
                             "WHERE n.alunoId = ?";

        List<Nota> notas = new ArrayList();
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, alunoId);
            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                notas.add(ResultSetToNota(result));
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
        return notas;
    }

    @Override
    public void Delete(int id) {
        String sql = "DELETE FROM NOTA WHERE ID = ?";

        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1, id);
            pStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void Update(Nota nota) {
        String sql = "UPDATE NOTA SET tipoNota = ?, valor = ?, alunoId = ?, materiaId = ?, periodo = ?\n" +
                     "WHERE id = ?";
                                                                    
        Connection connection = null;
        try {
            connection = Conexao.getInstance().getConnection();
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, nota.getTipoNota().ordinal());
            pStatement.setFloat(2, nota.getValor());
            pStatement.setInt(3, nota.getAluno().getId());
            pStatement.setInt(4, nota.getMateria().getId());
            pStatement.setString(5, "test");
            pStatement.setInt(6, nota.getId());
            pStatement.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void Insert(Nota nota) {
//        String sql = "INSERT INTO Aluno (ALUNOID, ALUNONOME, ALUNOEMAIL, ALUNOSENHA, ALUNOTELEFONE, ALUNORUA, ALUNOCIDADE, TURMAID) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
//                                                                    
//        Connection connection = null;
//        try {
//            connection = Conexao.getInstance().getConnection();
//            PreparedStatement pStatement = connection.prepareStatement(sql);
//            pStatement.setInt(1, aluno.getId());
//            pStatement.setString(2, aluno.getNome());
//            pStatement.setString(3, aluno.getEmail());
//            pStatement.setString(4, aluno.getSenha());
//            pStatement.setString(5, aluno.getTelefone());
//            pStatement.setString(6, aluno.getRua());
//            pStatement.setString(7, aluno.getCidade());
//            pStatement.setInt(8, aluno.getTurma().getId());
//            pStatement.execute();
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }

    private Nota ResultSetToNota(ResultSet result) throws SQLException {
        return new Nota(
                result.getInt("id"),
                EnumTipoNota.values()[result.getInt("tipoNota")],
                result.getFloat("valor"),
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
                new Materia(
                    result.getInt("materiaId"),
                    result.getString("materiaNome"),
                    new Curso(result.getInt("cursoId"), result.getString("cursoNome"), result.getInt("cursoQuantidadePeriodos")),
                    result.getInt("materiaPeriodoLecionado"),
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
                new PeriodoLetivo()
        );
    }

}
