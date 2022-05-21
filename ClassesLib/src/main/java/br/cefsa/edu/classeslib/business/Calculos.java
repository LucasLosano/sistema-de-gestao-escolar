package br.cefsa.edu.classeslib.business;

import br.cefsa.edu.classeslib.entities.Frequencia;
import br.cefsa.edu.classeslib.entities.Nota;
import br.cefsa.edu.classeslib.enums.EnumTipoNota;
import br.cefsa.edu.classeslib.exception.messages.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Calculos {

    private static final double FATOR_FREQUENCIA_MAX = 1.1;
    private static final double FATOR_FREQUENCIA_MIN = 1;

    public static double calculaMedia(Nota[] notas, double[] pesos) throws Exception {
        validaNotas(notas);
        validaPesos(pesos);

        double media = 0;
        for (int i = 0; i < notas.length; i++) {
            media += notas[i].getValor() * pesos[i];
        }

        return arredondaParaDuasCasas(media);
    }

    public static double calculaMedia(Nota[] notas, double[] pesos, Frequencia[] frequencias) throws Exception {
        double media = calculaMedia(notas, pesos);
        validaFrequencia(frequencias);

        media = media * calculaFatorFrequencia(frequencias);
        media = media > 10 ? 10 : media;
        return arredondaParaDuasCasas(media);
    }

    private static void validaPesos(double[] pesos) throws Exception {
        if (pesos.length != 4) {
            throw new Exception(PesosException.IGUAL_A_QUATRO);
        }

        if (Arrays.stream(pesos).anyMatch(peso -> peso <= 0)) {
            throw new Exception(PesosException.MAIOR_QUE_ZERO);
        }

        if (Arrays.stream(pesos).sum() != 1) {
            throw new Exception(PesosException.SOMA_IGUAL_A_UM);
        }
    }

    private static void validaNotas(Nota[] notas) throws Exception {
        if (notas.length == 0)
            return;
        
        if (notas.length > 4) {
            throw new Exception(NotasException.MAXIMO_QUATRO);
        }

        if (Arrays.stream(notas).anyMatch(nota -> nota.getValor() > 10 || nota.getValor() < 0)) {
            throw new Exception(NotasException.ENTRE_ZERO_E_DEZ);
        }

        List<EnumTipoNota> notasPassadas = new ArrayList();
        notasPassadas.add(notas[0].getTipoNota());
        for (int i = 1; i < notas.length; i++) {
            if (notasPassadas.contains(notas[i].getTipoNota())) {
                throw new Exception(NotasException.TIPOS_DIFERENTES);
            }

            notasPassadas.add(notas[i].getTipoNota());
        }
    }

    private static void validaFrequencia(Frequencia[] frequencias) throws Exception {

        if (frequencias.length == 0) {
            throw new Exception(FrequenciasException.MAIOR_QUE_ZERO);
        }

    }

    private static double arredondaParaDuasCasas(double valor) {
        return Math.round(valor * 100) / 100.0;
    }

    private static double calculaFatorFrequencia(Frequencia[] frequencias) {
        int qtdFrequencias = 0;
        for (var frequencia : frequencias) {
            if (frequencia.isStatus())
                qtdFrequencias++;
        }
            
        double porcentagemFrequencia = (double)qtdFrequencias/frequencias.length;
        double fatorFrequencia = FATOR_FREQUENCIA_MAX * porcentagemFrequencia;

        fatorFrequencia = fatorFrequencia < FATOR_FREQUENCIA_MIN ? FATOR_FREQUENCIA_MIN : fatorFrequencia;
        return fatorFrequencia;
    }
}
