package br.cefsa.edu.classeslib.entities;

import java.util.List;

public class GradeHoraria {
    private List<Materia> materias;

    public GradeHoraria() {
    }

    public GradeHoraria(List<Materia> materias) {
        this.materias = materias;
    }
    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}
