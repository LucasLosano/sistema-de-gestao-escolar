/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.cefsa.edu.classeslib.DAO;

import br.cefsa.edu.classeslib.entities.Aluno;
import br.cefsa.edu.classeslib.entities.Curso;
import br.cefsa.edu.classeslib.entities.Frequencia;
import br.cefsa.edu.classeslib.entities.Materia;
import br.cefsa.edu.classeslib.entities.Professor;
import br.cefsa.edu.classeslib.entities.Turma;
import java.time.LocalDate;

/**
 *
 * @author rafae
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FrequenciaDAO f = new FrequenciaDAO();
        Frequencia frequencia = new Frequencia();
        var aluno = new Aluno(1, "Test Silva", "Test.Silva5@gmail.com", "9-83788378", "Jardim Test", "São Test", new Turma());
        var materia = new Materia(1, "Materia", new Curso(), 5, new Professor());
        frequencia.setAluno(aluno);
        frequencia.setData(LocalDate.now());
        frequencia.setStatus(true);
        frequencia.setMateria(materia);
        frequencia.setId(4);
        //frequencia.setPeriodo("teste");
        
        f.Update(frequencia);
        System.out.println("Teste!");
    }
    
}
