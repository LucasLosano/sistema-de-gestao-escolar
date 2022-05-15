/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.classeslib.exception.messages;

/**
 *
 * @author victo
 */
public interface FrequenciasException {
    public final String MAIOR_QUE_ZERO = "É necessário pelo menos 1 frequência";
    public final String MESMO_ALUNO = "Todas as frequências devem ser do mesmo aluno";
    public final String MESMA_MATERIA = "Todas as frequências devem ser da mesma matéria";
    public final String MESMO_PERIODO_LETIVO = "Todas as frequências devem ser do mesmo período Letivo";
}
