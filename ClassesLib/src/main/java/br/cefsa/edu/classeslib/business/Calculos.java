/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.classeslib.business;

import br.cefsa.edu.classeslib.entities.Nota;
import br.cefsa.edu.classeslib.enums.EnumTipoNota;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author losan
 */
public abstract class Calculos {
    public static double CalculaMedia(Nota[]notas, double[] pesos) throws Exception {
        ValidaNotas(notas);
        ValidaPesos(pesos);
        
        double media = 0;
        for(int i = 0; i < notas.length; i++)
        {
            media += notas[i].getValor() * pesos[i];
        }
        
        return (double)Math.round(media * 100) / 100;
    }
    
    private static void ValidaPesos(double[] pesos) throws Exception
    {
        if(pesos.length != 4)
            throw new Exception("São necessários 4 pesos");
        
        if(Arrays.stream(pesos).anyMatch(peso -> peso == 0))
            throw new Exception("O peso deve ser diferente de 0");
        
        if(Arrays.stream(pesos).sum() != 1)
            throw new Exception("A soma dos pesos deve ser 1");
    }
    
    private static void ValidaNotas(Nota[] notas) throws Exception
    {
        if(notas.length > 4 && notas.length != 0)
            throw new Exception("São necessários menos de 4 notas e pelo menos 1 nota");
        
        int alunoId = notas[0].getAluno().getId();
        if(!Arrays.stream(notas).allMatch(nota -> nota.getAluno().getId() == alunoId))  
            throw new Exception("Todas as notas devem ser do mesmo aluno");
        
        List<EnumTipoNota> notasPassadas = new ArrayList();
        notasPassadas.add(notas[0].getTipoNota());
        for(int i = 1; i < notas.length; i++){
            if(notasPassadas.contains(notas[i].getTipoNota()))
                throw new Exception("As notas devem ser de tipos diferentes");
            
            notasPassadas.add(notas[i].getTipoNota());
        }
    }
}
