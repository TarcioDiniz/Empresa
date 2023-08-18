import cargaHoraria.CargaHoraria;
import funcionario.Funcionario;
import salario.model.Salario;
import salario.interfac.SalarioCalculator;
import salario.SalarioCalculatorPadrao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void printDadosFuncionario(Funcionario funcionario) {
        System.out.println("Nome: " + funcionario.getName());
        System.out.println("Carga Horária: " + funcionario.getCargaHoraria().getCargaHoraria());
        System.out.println("Tempo de Serviço: " + funcionario.getTempoDeServico());
        System.out.println("Salário: " + funcionario.getSalario());
    }

    public static String nomeAleatorio() {
        List<String> nomes = Arrays.asList(
                "Sofia Oliveira", "Lucas Santos", "Isabella Pereira", "Mateus Almeida", "Laura Costa",
                "Enzo Rodrigues", "Manuela Fernandes", "Pedro Barbosa", "Julia Martins", "Gabriel Silva",
                "Valentina Carvalho", "Rafaela Gomes", "João Santos", "Bianca Oliveira", "Miguel Rodrigues",
                "Helena Pereira", "Eduardo Castro", "Beatriz Lima", "Leonardo Ferreira", "Giovanna Souza"
        );

        Random random = new Random();
        int index = random.nextInt(nomes.size());
        return nomes.get(index);
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static Funcionario criarFuncionario(SalarioCalculator salarioCalculator) {
        CargaHoraria cargaHoraria = new CargaHoraria(randInt(30, 40));
        int tempoDeServico = randInt(1, 15);
        return new Funcionario(nomeAleatorio(), cargaHoraria, tempoDeServico, salarioCalculator);
    }

    public static List<Funcionario> gerarFuncionarios(int numFuncionarios, SalarioCalculator salarioCalculator) {
        List<Funcionario> funcionarios = new ArrayList<>();

        for (int i = 0; i < numFuncionarios; i++) {
            funcionarios.add(criarFuncionario(salarioCalculator));
        }

        return funcionarios;
    }

    public static void main(String[] args) {
        SalarioCalculator salarioCalculator = new SalarioCalculatorPadrao();

        // a) Criação de três funcionários com nomes e cargas horárias diferentes
        List<Funcionario> listaFuncionarios = gerarFuncionarios(3, salarioCalculator);

        // Exibindo dados iniciais dos funcionários
        System.out.println("Dados iniciais dos funcionários:");
        for (Funcionario funcionario : listaFuncionarios) {
            printDadosFuncionario(funcionario);
            System.out.println("------------------------");
        }

        // Simulando o efeito de atualização com pontos suspensivos
        try {
            for (int i = 0; i < 3; i++) {
                System.out.print("Atualizando Dados");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.print(".");
                Thread.sleep(500);
                System.out.print(".\r");
                Thread.sleep(500);
            }
            System.out.println("Concluído\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // b) Alterando o salário base de todos os funcionários
        BigDecimal novoSalarioBase = new BigDecimal("20");
        Salario.setSalarioBase(novoSalarioBase);

        // Exibindo dados após a atualização do salário base
        System.out.println("Dados após atualização do salário base:");
        for (Funcionario funcionario : listaFuncionarios) {
            printDadosFuncionario(funcionario);
            System.out.println("------------------------");
        }
    }

}

/*

a) Atributos Estáticos e Não Estáticos:

Atributos Estáticos:

- salarioBase em salario.model.Salario: Este é um atributo estático porque é compartilhado entre
todas as instâncias da classe salario.model.Salario e não varia de uma instância para outra.
Ele é usado como uma base para calcular os salários dos funcionários, mas seu valor é constante
para todas as instâncias da classe.

Atributos Não Estáticos:

- name em funcionario.Funcionario: Esse atributo é específico para cada instância de funcionario.
Funcionario. Cada funcionário tem um nome único associado a ele.

- salarioFuncionario em salario.SalarioThisFuncionario: Esse atributo armazena o salário específico
de cada instância de salario.SalarioThisFuncionario. Cada funcionário terá um salário calculado
individualmente.

- cargaHoraria em salario.SalarioThisFuncionario e cargaHoraria.CargaHoraria: A carga horária é
específica para cada funcionário, portanto, é um atributo de instância. Cada funcionário pode ter
uma carga horária diferente.

- tempoDeServico em salario.SalarioThisFuncionario: O tempo de serviço também é específico para
cada funcionário, então é um atributo de instância.


b) Importância de Encapsulamento e Ocultação de Informação:
O encapsulamento e a ocultação de informações são princípios fundamentais da programação orientada a
objetos que oferecem diversos benefícios em qualquer situação, incluindo a presente:

Encapsulamento:

Protege os detalhes internos: Encapsular os atributos e métodos de uma classe permite ocultar os
detalhes internos de implementação. Isso impede que o código externo acesse e modifique diretamente o
estado interno da classe, prevenindo erros e garantindo consistência dos dados.

Interface controlada: Através do encapsulamento, você pode fornecer uma interface bem definida para
interações externas. Isso simplifica o uso da classe, evita que os clientes cometam erros e facilita
a evolução da implementação sem afetar o código cliente.

Ocultação de Informação:

Manutenção e evolução: A ocultação de informações permite que você altere a implementação interna de
uma classe sem afetar as partes que a utilizam. Isso é crucial para a manutenção e evolução do sistema,
pois você pode refatorar, otimizar ou melhorar a classe sem causar impacto nas outras partes do código.

Prevenção de dependências: A ocultação de informações reduz a dependência das classes externas sobre os
detalhes internos. Isso facilita a modificação e evolução das classes sem causar um efeito cascata nas
demais partes do sistema.

No contexto específico do projeto, o encapsulamento e a ocultação de informações permitem que você
modele as classes de forma mais robusta, evitando que detalhes internos sejam expostos ao código
cliente. Isso melhora a organização, segurança e flexibilidade do seu sistema, tornando-o mais fácil
de manter e estender ao longo do tempo.

*/
