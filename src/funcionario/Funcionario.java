package funcionario;

import cargaHoraria.CargaHoraria;
import salario.SalarioThisFuncionario;
import salario.interfac.SalarioCalculator;
import salario.model.Salario;

import java.math.BigDecimal;

public class Funcionario {
    private final String name;
    private final SalarioThisFuncionario salario;

    public Funcionario(
            String name,
            CargaHoraria cargaHoraria,
            int tempoDeServico,
            SalarioCalculator salarioCalculator) {
        this.name = name;
        this.salario = new SalarioThisFuncionario(cargaHoraria, tempoDeServico, salarioCalculator);
        Salario.registrarObservador(this);
    }

    public void atualizarSalario() {
        salario.atualizarSalario();
    }

    public String getName() {
        return name;
    }

    public CargaHoraria getCargaHoraria() {
        return salario.getCargaHoraria();
    }

    public void setCargaHoraria(CargaHoraria cargaHoraria) {
        salario.setCargaHoraria(cargaHoraria);
    }

    public int getTempoDeServico() {
        return salario.getTempoDeServico();
    }

    public void setTempoDeServico(int tempoDeServico) {
        salario.setTempoDeServico(tempoDeServico);
    }

    public BigDecimal getSalario() {
        return salario.getSalarioFuncionario();
    }
}
