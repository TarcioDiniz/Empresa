package salario.model;

import funcionario.Funcionario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Salario {
    private static BigDecimal salarioBase = new BigDecimal("50");
    private static final List<Funcionario> observadores = new ArrayList<>();

    public static BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public static void setSalarioBase(BigDecimal novoSalarioBase) {
        salarioBase = novoSalarioBase;
        notificarObservadores();
    }

    public static void registrarObservador(Funcionario funcionario) {
        observadores.add(funcionario);
    }

    private static void notificarObservadores() {
        for (Funcionario funcionario : observadores) {
            funcionario.atualizarSalario();
        }
    }
}
