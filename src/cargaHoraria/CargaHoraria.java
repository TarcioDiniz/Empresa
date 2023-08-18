package cargaHoraria;

public class CargaHoraria {
    private int cargaHoraria;

    public CargaHoraria(int valorCargaHoraria) {
        if (valorCargaHoraria < 0) {
            throw new IllegalArgumentException("Carga Horaria menor que 0");
        }
        this.cargaHoraria = valorCargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int valorCargaHoraria) {
        if (valorCargaHoraria < 0) {
            throw new IllegalArgumentException("Carga Horaria menor que 0");
        }
        this.cargaHoraria = valorCargaHoraria;
    }
}