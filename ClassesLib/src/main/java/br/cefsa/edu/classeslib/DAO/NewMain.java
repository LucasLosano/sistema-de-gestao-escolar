/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.cefsa.edu.classeslib.DAO;

import br.cefsa.edu.classeslib.entities.Aluno;
import br.cefsa.edu.classeslib.entities.Configuracoes;
import br.cefsa.edu.classeslib.entities.Materia;
import br.cefsa.edu.classeslib.entities.Nota;
import br.cefsa.edu.classeslib.entities.PeriodoLetivo;
import br.cefsa.edu.classeslib.entities.Turma;
import br.cefsa.edu.classeslib.enums.EnumPeriodoLetivo;
import br.cefsa.edu.classeslib.enums.EnumTipoNota;

/**
 *
 * @author losan
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //AlunoDAO a = new AlunoDAO();
        //ConfiguracoesDAO c = new ConfiguracoesDAO();
        //double[] d = new double[]{0.2, 0.2, 0.2, 0.4};
        //Configuracoes a = new Configuracoes("aaaa", EnumPeriodoLetivo.Anual, d, true, "sdadasdsa");
        //c.Insert(a);
        NotaDAO n = new NotaDAO();
        
        var aluno = new Aluno(1, "Test Silva", "Test.Silva5@gmail.com", "9-83788378", "Jardim Test", "São Test", new Turma());
        new Nota(1, EnumTipoNota.N1, 10, aluno, new Materia(), new PeriodoLetivo());
        
        var nota = n.GetAll();
        nota.get(0).setValor(0);
        n.Update(nota.get(0));
    }
    
}
