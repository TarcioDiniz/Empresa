package salario;

import cargaHoraria.CargaHoraria;
import salario.interfac.SalarioCalculator;
import salario.model.Salario;

import java.math.BigDecimal;

public class SalarioCalculatorPadrao implements SalarioCalculator {
    @Override
    public BigDecimal calculaSalario(CargaHoraria cargaHoraria, int tempoDeServico) {
        BigDecimal tempoDeServicoMultiplier = new BigDecimal("250");
        return Salario.getSalarioBase()
                .multiply(new BigDecimal(cargaHoraria.getCargaHoraria()))
                .add(tempoDeServicoMultiplier.multiply(new BigDecimal(tempoDeServico)));
    }
}