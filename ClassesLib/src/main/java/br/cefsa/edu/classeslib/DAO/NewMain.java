/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.cefsa.edu.classeslib.DAO;

import br.cefsa.edu.classeslib.entities.Configuracoes;
import br.cefsa.edu.classeslib.enums.EnumPeriodoLetivo;

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
        ConfiguracoesDAO c = new ConfiguracoesDAO();
        double[] d = new double[]{0.2, 0.2, 0.2, 0.4};
        Configuracoes a = new Configuracoes("aaaa", EnumPeriodoLetivo.Anual, d, true, "sdadasdsa");
        c.Insert(a);
    }
    
}
