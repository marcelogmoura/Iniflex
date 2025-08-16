package br.com.projedata.Application;

import br.com.projedata.Domain.Entities.Funcionario;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {
        // 3.1 
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloisa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // 3.2 
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // 3.3 
        System.out.println("--- Lista de funcionários ---");
        imprimirFuncionarios(funcionarios);

        // 3.4  
        BigDecimal aumento = new BigDecimal("1.10");
        for (Funcionario f : funcionarios) {
            BigDecimal novoSalario = f.getSalario().multiply(aumento).setScale(2, RoundingMode.HALF_UP);
            f.setSalario(novoSalario);
        }
        System.out.println("\n--- Salários atualizados (10% de aumento) ---");
        imprimirFuncionarios(funcionarios);

        // 3.5 
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
            .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // 3.6 
        System.out.println("\n--- Funcionários agrupados por função ---");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            imprimirFuncionarios(lista);
        });

        // 3.8  
        System.out.println("\n--- Aniversariantes de Outubro e Dezembro ---");
        funcionarios.stream()
            .filter(f -> f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
            .forEach(f -> System.out.println("Nome: " + f.getNome() + 
                               ", Data de Nascimento: " + f.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));

        // 3.9 
        System.out.println("\n--- Funcionário com a maior idade ---");
        Funcionario maisVelho = funcionarios.stream()
            .min(Comparator.comparing(Funcionario::getDataNascimento))
            .orElse(null);
        if (maisVelho != null) {
            Period idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now());
            System.out.println("Nome: " + maisVelho.getNome() + ", Idade: " + idade.getYears() + " anos");
        }
        
        // 3.10  
        System.out.println("\n--- Funcionários por ordem alfabética ---");
        funcionarios.stream()
            .sorted(Comparator.comparing(Funcionario::getNome))
            .forEach(f -> System.out.println("Nome: " + f.getNome()));

        // 3.11  
        System.out.println("\n--- Total dos salários ---");
        BigDecimal totalSalarios = funcionarios.stream()
            .map(Funcionario::getSalario)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total dos salários: " + String.format(Locale.of("pt", "BR"), "%,.2f", totalSalarios));

        // 3.12 
        System.out.println("\n--- Salários mínimos por funcionário ---");
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        for (Funcionario f : funcionarios) {
            BigDecimal salariosMinimos = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println("Nome: " + f.getNome() + ", Salários Mínimos: " + salariosMinimos);
        }

    }
    
    private static void imprimirFuncionarios(List<Funcionario> lista) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale localeBR = Locale.of("pt", "BR");
        
        for (Funcionario f : lista) {
            String dataFormatada = f.getDataNascimento().format(dateFormatter);
            String salarioFormatado = String.format(localeBR, "%,.2f", f.getSalario());
            
            System.out.println("Nome: " + f.getNome() + 
                               ", Data Nascimento: " + dataFormatada + 
                               ", Salário: " + salarioFormatado + 
                               ", Função: " + f.getFuncao());
        }
    }
}