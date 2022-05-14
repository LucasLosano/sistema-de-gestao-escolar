
package br.cefsa.edu.calculos;

import br.cefsa.edu.classeslib.business.Calculos;
import br.cefsa.edu.classeslib.entities.Aluno;
import br.cefsa.edu.classeslib.entities.Curso;
import br.cefsa.edu.classeslib.entities.Frequencia;
import br.cefsa.edu.classeslib.entities.Materia;
import br.cefsa.edu.classeslib.entities.Nota;
import br.cefsa.edu.classeslib.entities.PeriodoLetivo;
import br.cefsa.edu.classeslib.entities.Professor;
import br.cefsa.edu.classeslib.entities.Turma;
import br.cefsa.edu.classeslib.enums.EnumPeriodoLetivo;
import br.cefsa.edu.classeslib.enums.EnumTipoNota;
import java.time.LocalDate;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ValidadoraCalculos {
    private static Aluno aluno;
    private static Aluno aluno2;
    private static Materia materia;
    private static Materia materia2;
    private static PeriodoLetivo periodoLetivo;
    private static PeriodoLetivo periodoLetivo2;
    private static Nota[] notas;
    private static Frequencia[] frequencias;
    
    public ValidadoraCalculos() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        aluno = new Aluno(1, "Test Silva", "Test.Silva5@gmail.com", "9-83788378", "Jardim Test", "São Test", new Turma());
        aluno2 = new Aluno(2, "Test Silva", "Test.Silva5@gmail.com", "9-83788378", "Jardim Test", "São Test", new Turma());
        materia = new Materia(1, "Materia", new Curso(), 5, new Professor());
        materia2 = new Materia(2, "Materia", new Curso(), 5, new Professor());
        periodoLetivo = new PeriodoLetivo(1, EnumPeriodoLetivo.Semestre, LocalDate.now(), LocalDate.now().plusMonths(6));
        periodoLetivo2 = new PeriodoLetivo(2, EnumPeriodoLetivo.Semestre, LocalDate.now().plusMonths(6), LocalDate.now().plusYears(1));
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        notas = new Nota[]{
            new Nota(1, EnumTipoNota.N1, 10, aluno, new Materia(), new PeriodoLetivo()),
            new Nota(2, EnumTipoNota.N2, 10, aluno, new Materia(), new PeriodoLetivo()),
            new Nota(3, EnumTipoNota.N3, 10, aluno, new Materia(), new PeriodoLetivo()),
            new Nota(4, EnumTipoNota.N4, 10, aluno, new Materia(), new PeriodoLetivo())
        };
        frequencias = new Frequencia[10];
        for(int i = 0; i < 10; i++)
        {
            frequencias[i] = new Frequencia(1, LocalDate.now().plusDays(i), true, materia, aluno, new PeriodoLetivo());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void SeNotasDeAlunoEPesosSaoValidosCalculaMedia() throws Exception {
        
        double media = Calculos.calculaMedia(notas, new double[]{0.25, 0.25, 0.2, 0.3});
        Assertions.assertEquals(10,media);
        
        notas[0].setValor(5);
        notas[1].setValor(6);
        notas[2].setValor(7);
        notas[3].setValor(8);
        media = Calculos.calculaMedia(notas, new double[]{0.1, 0.3, 0.5, 0.1});
        Assertions.assertEquals(6.6,media);
        
        notas[0].setValor(2);
        notas[1].setValor(2);
        notas[2].setValor(2);
        notas[3].setValor(3);
        media = Calculos.calculaMedia(notas, new double[]{0.1, 0.2, 0.3, 0.4});
        Assertions.assertEquals(2.4,media);
    }
    
    @Test
    public void SeNotasDeAlunoEPesosSaoValidosEFatorFrequenciaAtivoCalculaMedia() throws Exception {
        
        double media = Calculos.calculaMedia(notas, new double[]{0.25, 0.25, 0.2, 0.3}, frequencias);
        Assertions.assertEquals(10,media);
    }
    
    @Test
    public void SeQuantidadeDePesosForDiferenteDeQuatroEhEsperadoException() throws Exception {
        
        Exception thrown = Assertions.assertThrows(Exception.class,
                () -> Calculos.calculaMedia(notas, new double[]{0, 0.3, 0, 0.1, 0.1}));
        
        Assertions.assertTrue(thrown.getMessage().contains("São necessários 4 pesos"));
    }
    
    @Test
    public void SePesoForIgualAZeroEhEsperadoException() throws Exception {
        Exception thrown = Assertions.assertThrows(Exception.class,
                () -> Calculos.calculaMedia(notas, new double[]{0, 0.3, 0, 0.1}));
        
        Assertions.assertTrue(thrown.getMessage().contains("O peso deve ser diferente de 0"));
    }
    
    @Test
    public void SeNotasNaoPertencemAoMesmoAlunoEhEsperadoException() throws Exception {
        notas[0].setAluno(aluno2);
        Exception thrown = Assertions.assertThrows(Exception.class,
                () -> Calculos.calculaMedia(notas, new double[]{0.25, 0.25, 0.2, 0.3}));
        
        Assertions.assertTrue(thrown.getMessage().contains("Todas as notas devem ser do mesmo aluno"));
    }
    
     @Test
    public void SeNotasForemMenorQueZeroOuMaiorQueDezEhEsperadoException() throws Exception {
        notas[0].setValor(25);
        Exception thrown = Assertions.assertThrows(Exception.class,
                () -> Calculos.calculaMedia(notas, new double[]{0.25, 0.25, 0.2, 0.3}));
        
        Assertions.assertTrue(thrown.getMessage().contains("As notas devem ser maior que 0 e menor ou igual a 10"));
    }
    
    @Test
    public void SeNotasNaoPertencemAoMesmoTipoEhEsperadoException() throws Exception {
        notas[0].setTipoNota(EnumTipoNota.N2);
        Exception thrown = Assertions.assertThrows(Exception.class,
                () -> Calculos.calculaMedia(notas, new double[]{0.25, 0.25, 0.2, 0.3}));
        
        Assertions.assertTrue(thrown.getMessage().contains("As notas devem ser de tipos diferentes"));
    }
    
    @Test
    public void SeSomaDosPesosForDiferentedeUmEhEsperadoException() throws Exception {
        Exception thrown = Assertions.assertThrows(Exception.class,
                () -> Calculos.calculaMedia(notas, new double[]{0.5, 0.3, 0.5, 0.1}));
        
        Assertions.assertTrue(thrown.getMessage().contains("A soma dos pesos deve ser 1"));
    }
}