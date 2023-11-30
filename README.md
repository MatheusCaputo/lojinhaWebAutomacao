# [Lojinha WEB Automação](https://github.com/MatheusCaputo/lojinhaWebAutomacao)

Esse é um repositório que contém a automação de alguns testes de uma Aplicação WEB de um software denominado Lojinha. Os subtópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.

## [Tecnologias Utilizadas](https://github.com/MatheusCaputo/lojinhaAPIAutomacao#tecnologias-utilizadas)

-   Java  [https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
-   JUnit  [https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.8.0-M1)
-   Selenium WebDriver [https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.12.1)
    - Chrome Driver [https://googlechromelabs.github.io/chrome-for-testing/](https://googlechromelabs.github.io/chrome-for-testing/)
-  Maven  [https://maven.apache.org/](https://maven.apache.org/)

## [Testes Automatizados](https://github.com/MatheusCaputo/lojinhaWebAutomacao)

Testes E2E para validar as partições de equivalência relacionadas ao valor do produto na Lojinha, que estão vinculados diretamente a regra de negócio que diz que o valor do produto deve estar entre R$ 0,01 e R$ 7.000,00.

### CT1 - Não é permitido registrar produto com valor igual a zero
**Resultado esperado:** visualizar um pop-up com a seguinte mensagem:
O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00
**Passo a passo:** Faça login na aplicação WEB, adicione um produto com valor igual a 0,00.

**Resultado obtido:** Passou ✅

### CT2 - Não é permitido registrar produto com valor maior que sete mil reais
**Resultado esperado:** visualizar um pop-up com a seguinte mensagem:
O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00

**Passo a passo:** Faça login na aplicação WEB, adicione um produto com valor igual a 7000,01.

**Resultado obtido:** Passou ✅

### CT3 - Registrando produto com valor entre 0,01 e 7000,00 reais
**Resultado esperado:** visualizar um pop-up com a seguinte mensagem:
Produto adicionado com sucesso

**Passo a passo:** Faça login na aplicação WEB, adicione um produto com valor igual a 1500,00.

**Resultado obtido:** Passou ✅

### CT4 - Registrando produto com valor de 0,01 centavo
**Resultado esperado:** visualizar um pop-up com a seguinte mensagem:
Produto adicionado com sucesso

**Passo a passo:** Faça login na aplicação WEB, adicione um produto com valor igual a 0,01.

**Resultado obtido:** Passou ✅


### CT5 - Registrando produto com valor de 7000,00 reais
**Resultado esperado:** visualizar um pop-up com a seguinte mensagem:
Produto adicionado com sucesso

**Passo a passo:** Faça login na aplicação WEB, adicione um produto com valor igual a 7000,00.

**Resultado obtido:** Passou ✅

## [Notas Gerais](https://github.com/MatheusCaputo/lojinhaAPIAutomacao#notas-gerais)

#### OBS:  Sempre se atentar para a versão do Google Chrome que você está utilizando no momento de rodar a automação, pois o Chrome Driver utilizado deve ser sempre compatível com essa versão.

-   Sempre utilizamos a anotação Before Each para configurar o Chrome Driver, que será utilizado posteriormente em todos os métodos de teste.
-   Nesse projeto fiz uso do JUnit 5, que fornece os métodos de teste e a possibilidade de executá-los, além da possibilidade de usar a anotação DisplayName para dar descrições em português para nossos testes.
-  **Design Patterns (Padrões de Projeto)** utilizados:
    -  **Page Object:** Objetiva melhorar a manutenção de testes e reduzir a duplicação de código. Page Object é uma classe orientada a objetos que serve como interface para uma página do seu AUT (Aplicativo Sob Teste). Os testes usam então os métodos desta classe de Page Object sempre que precisam interagir com a UI dessa página. A vantagem é que, se a UI da página mudar, os próprios testes não precisam mudar, apenas o código dentro do Page Object precisa mudar. Subsequentemente, todas as mudanças para suportar essa nova UI estão localizadas em um lugar.
    -   **Fluent Page:** Faz com que seu Page Object retorne a próxima página ou a página atual.