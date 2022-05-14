/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.edu.cefsa.aluno;

import br.cefsa.edu.classeslib.business.Calculos;
import br.cefsa.edu.classeslib.entities.Aluno;
import br.cefsa.edu.classeslib.entities.Materia;
import br.cefsa.edu.classeslib.entities.Nota;
import br.cefsa.edu.classeslib.entities.PeriodoLetivo;
import br.cefsa.edu.classeslib.entities.Turma;
import br.cefsa.edu.classeslib.enums.EnumTipoNota;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author losan
 */
public class ValidoraAluno {
    
    public ValidoraAluno() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void SeMediaDoAlunoMaiorQueMediaConfiguradaAlunoSeraAprovado() throws Exception {
        //arrange
        //PeriodoLetivo periodo = pe
        //Configuracoes(String nomeInstituicao, PeriodoLetivo periodo, float[] pesos, float media, boolean fatorFrequencia, String logoInstituicao)
        //Curso curso = new Curso(1, "Engenharia de Test", 10);
        //Turma turma = new Turma(1, curso, 5);
        Aluno aluno = new Aluno(1, "Test Silva", "Test.Silva5@gmail.com", "9-83788378", "Jardim Test", "São Test", new Turma());
        
        Nota[] notas = {
            new Nota(1, EnumTipoNota.N1, 10, aluno, new Materia(), new PeriodoLetivo()),
            new Nota(2, EnumTipoNota.N2, 10, aluno, new Materia(), new PeriodoLetivo()),
            new Nota(3, EnumTipoNota.N3, 10, aluno, new Materia(), new PeriodoLetivo()),
            new Nota(4, EnumTipoNota.N4, 10, aluno, new Materia(), new PeriodoLetivo())
        };
        
        double media = Calculos.CalculaMedia(notas, new double[]{0.25, 0.25, 0.2, 0.3});
        
        Assertions.assertEquals(10,media);
    }
    
    @Test
    public void SeMediaDoAlunoMenorQueMediaConfiguradaAlunoSeraReprovado() {
        
    }
}
