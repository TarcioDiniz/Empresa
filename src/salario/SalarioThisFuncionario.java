package salario;

import cargaHoraria.CargaHoraria;
import salario.interfac.SalarioCalculator;
import salario.model.Salario;

import java.math.BigDecimal;

public class SalarioThisFuncionario extends Salario {
    private BigDecimal salarioFuncionario;
    private final SalarioCalculator salarioCalculator;
    private CargaHoraria cargaHoraria;
    private int tempoDeServico;

    public SalarioThisFuncionario(CargaHoraria cargaHoraria, int tempoDeServico, SalarioCalculator salarioCalculator) {
        this.cargaHoraria = cargaHoraria;
        this.tempoDeServico = tempoDeServico;
        this.salarioCalculator = salarioCalculator;
        this.salarioFuncionario = calculaSalario();
    }

    private BigDecimal calculaSalario() {
        return salarioCalculator.calculaSalario(cargaHoraria, tempoDeServico);
    }

    public BigDecimal getSalarioFuncionario() {
        return salarioFuncionario;
    }

    public void setSalarioFuncionario(BigDecimal salarioFuncionario) {
        this.salarioFuncionario = salarioFuncionario;
    }

    public CargaHoraria getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(CargaHoraria cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
        this.salarioFuncionario = calculaSalario();
    }

    public int getTempoDeServico() {
        return tempoDeServico;
    }

    public void setTempoDeServico(int tempoDeServico) {
        this.tempoDeServico = tempoDeServico;
        this.salarioFuncionario = calculaSalario();
    }

    public void atualizarSalario() {
        this.salarioFuncionario = calculaSalario();
    }
}
