/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.classeslib.exception.messages;

/**
 *
 * @author victo
 */
public interface NotasException {

    public final String ENTRE_UM_E_QUATRO = "São necessários menos de 4 notas e pelo menos 1 nota";
    public final String MESMO_ALUNO = "Todas as notas devem ser do mesmo aluno";
    public final String ENTRE_ZERO_E_DEZ = "As notas devem ser maior que 0 e menor ou igual a 10";
    public final String TIPOS_DIFERENTES = "As notas devem ser de tipos diferentes";
}
