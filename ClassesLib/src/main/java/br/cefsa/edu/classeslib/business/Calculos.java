package br.cefsa.edu.classeslib.business;

import br.cefsa.edu.classeslib.entities.Frequencia;
import br.cefsa.edu.classeslib.entities.Nota;
import br.cefsa.edu.classeslib.enums.EnumTipoNota;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Calculos {
    
    private static final double FATOR_FREQUENCIA_MAX = 1.1;
    private static final double FATOR_FREQUENCIA_MIN = 1;
    
    public static double calculaMedia(Nota[] notas, double[] pesos) throws Exception {
        ValidaNotas(notas);
        ValidaPesos(pesos);

        double media = 0;
        for (int i = 0; i < notas.length; i++) {
            media += notas[i].getValor() * pesos[i];
        }

        return arredondaParaDuasCasas(media);
    }

    public static double calculaMedia(Nota[] notas, double[] pesos, Frequencia[] frequencias) throws Exception {
        double media = calculaMedia(notas, pesos);
        ValidaFrequencia(frequencias);
        
        media = media * calculaFatorFrequencia(frequencias);
        media = media > 10 ? 10 : media;
        return arredondaParaDuasCasas(media);
    }

    private static void ValidaPesos(double[] pesos) throws Exception {
        if (pesos.length != 4) {
            throw new Exception("São necessários 4 pesos");
        }

        if (Arrays.stream(pesos).anyMatch(peso -> peso == 0)) {
            throw new Exception("Os pesos devem ser diferentes de 0");
        }

        if (Arrays.stream(pesos).sum() != 1) {
            throw new Exception("A soma dos pesos deve ser 1");
        }
    }

    private static void ValidaNotas(Nota[] notas) throws Exception {
        if (notas.length > 4 && notas.length != 0) {
            throw new Exception("São necessários menos de 4 notas e pelo menos 1 nota");
        }

        int alunoId = notas[0].getAluno().getId();
        if (!Arrays.stream(notas).allMatch(nota -> nota.getAluno().getId() == alunoId)) {
            throw new Exception("Todas as notas devem ser do mesmo aluno");
        }

        if (Arrays.stream(notas).anyMatch(nota -> nota.getValor() > 10 || nota.getValor() < 0)) {
            throw new Exception("As notas devem ser maior que 0 e menor ou igual a 10");
        }

        List<EnumTipoNota> notasPassadas = new ArrayList();
        notasPassadas.add(notas[0].getTipoNota());
        for (int i = 1; i < notas.length; i++) {
            if (notasPassadas.contains(notas[i].getTipoNota())) {
                throw new Exception("As notas devem ser de tipos diferentes");
            }

            notasPassadas.add(notas[i].getTipoNota());
        }
    }

    private static void ValidaFrequencia(Frequencia[] frequencias) throws Exception {

        if (frequencias.length == 0) {
            throw new Exception("É necessário pelo menos 1 frequência");
        }

        int alunoId = frequencias[0].getAluno().getId();
        if (!Arrays.stream(frequencias).allMatch(frequencia -> frequencia.getAluno().getId() == alunoId)) {
            throw new Exception("Todas as frequências devem ser do mesmo aluno");
        }

        int materiaId = frequencias[0].getMateria().getId();
        if (!Arrays.stream(frequencias).allMatch(frequencia -> frequencia.getMateria().getId() == materiaId)) {
            throw new Exception("Todas as frequências devem ser da mesma matéria");
        }
        
        int periodoLetivoId = frequencias[0].getPeriodo().getId();
        if (!Arrays.stream(frequencias).allMatch(frequencia -> frequencia.getPeriodo().getId() == periodoLetivoId)) {
            throw new Exception("Todas as frequências devem ser do mesmo período Letivo");
        }
    }
    
    private static double arredondaParaDuasCasas(double valor)
    {
        return (double) Math.round(valor * 100) / 100;
    }

    private static double calculaFatorFrequencia(Frequencia[] frequencias) {
        double porcentagemFrequencia = (double)(Arrays.stream(frequencias).filter(frequencia -> frequencia.isStatus()).count() / frequencias.length);
        double fatorFrequencia = FATOR_FREQUENCIA_MAX * porcentagemFrequencia;
        
        fatorFrequencia = fatorFrequencia < FATOR_FREQUENCIA_MIN ? FATOR_FREQUENCIA_MIN : fatorFrequencia;
        return fatorFrequencia;
    }
}
