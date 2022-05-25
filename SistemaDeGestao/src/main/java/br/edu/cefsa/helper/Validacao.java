/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.cefsa.helper;

/**
 *
 * @author losan
 */
public class Validacao {
    public static void validaTexto(String texto) throws Exception
    {
        if(texto.isEmpty())
            throw new Exception("Texto não pode ser vazio");
    }
}
