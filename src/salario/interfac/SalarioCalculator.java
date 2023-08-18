package salario.interfac;

import cargaHoraria.CargaHoraria;

import java.math.BigDecimal;

public interface SalarioCalculator {
    BigDecimal calculaSalario(CargaHoraria cargaHoraria, int tempoDeServico);
}