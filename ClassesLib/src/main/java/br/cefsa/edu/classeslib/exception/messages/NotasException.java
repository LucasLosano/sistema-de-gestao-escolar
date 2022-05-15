package br.cefsa.edu.classeslib.exception.messages;

public interface NotasException {

    public final String MAXIMO_QUATRO = "São necessários no máximo 4 notas";
    public final String MESMO_ALUNO = "Todas as notas devem ser do mesmo aluno";
    public final String ENTRE_ZERO_E_DEZ = "As notas devem ser maior que 0 e menor ou igual a 10";
    public final String TIPOS_DIFERENTES = "As notas devem ser de tipos diferentes";
}
