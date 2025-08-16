# 🚀 Teste Técnico Java - Projeto de Gestão de Funcionários

Este é um projeto de demonstração em Java, desenvolvido para atender aos requisitos de um teste técnico. O projeto simula a gestão de uma lista de funcionários, executando diversas operações como manipulação de dados, cálculos, ordenação e agrupamento.

## 💻 Tecnologias Utilizadas

* **Linguagem:** [Java](https://www.java.com/pt-BR/download/ie_manual.jsp) ([versão 17](https://www.oracle.com/java/technologies/downloads/))
* **IDE:** [Eclipse IDE](https://www.eclipse.org/downloads/)
* **Gerenciador de Dependências:** Maven (opcional, mas recomendado para a estrutura)

## 📁 Estrutura do Projeto

A arquitetura do projeto segue um modelo de camadas simplificado, inspirado em boas práticas de design como o Domain-Driven Design (DDD).

-   `src/main/java/br.com.projedata.Application`: Contém a classe principal da aplicação (`Principal.java`), responsável pela execução das operações.
-   `src/main/java/br.com.projedata.Domain.Entities`: Contém as classes de modelo de dados (`Pessoa.java` e `Funcionario.java`), que representam as entidades de negócio.

## ▶️ Como Executar

Para executar o projeto, siga os passos abaixo:

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/marcelogmoura/Iniflex](https://github.com/marcelogmoura/Iniflex)
    ```
2.  **Importe o projeto no Eclipse:**
    * Abra o Eclipse e vá em `File` > `Import...`.
    * Selecione `Maven` > `Existing Maven Projects` e clique em `Next`.
    * Navegue até a pasta onde o projeto foi clonado e clique em `Finish`.
3.  **Execute a classe principal:**
    * No `Package Explorer`, clique com o botão direito na classe `Principal.java`.
    * Vá em `Run As` > `Java Application`.

O resultado das operações será exibido diretamente no console do próprio Eclipse.

## ✨ Funcionalidades Implementadas

A classe `Principal.java` executa as seguintes operações em sequência, conforme solicitado no teste:

1.  Criação de uma lista com todos os funcionários da tabela fornecida.
2.  Remoção do funcionário "João" da lista.
3.  Impressão da lista completa de funcionários, com formatação de data (`dd/mm/aaaa`) e salários (ponto para milhar e vírgula para decimal).
4.  Aumento de 10% no salário de todos os funcionários.
5.  Agrupamento dos funcionários por função em um `Map`.
6.  Impressão da lista agrupada por função.
7.  Identificação e impressão dos funcionários que fazem aniversário nos meses de outubro (10) e dezembro (12).
8.  Identificação e impressão do funcionário mais velho, mostrando seu nome e idade.
9.  Impressão da lista de funcionários em ordem alfabética de nome.
10. Cálculo e impressão do valor total dos salários de todos os funcionários.
11. Cálculo e impressão de quantos salários mínimos cada funcionário recebe, considerando R$ 1212.00 como salário mínimo.

---

**Autor:** Marcelo Moura

**Contato:**  

📧 **Email:** mgmoura@gmail.com  

🔗 **LinkedIn:** https://www.linkedin.com/in/marcelogmoura/
