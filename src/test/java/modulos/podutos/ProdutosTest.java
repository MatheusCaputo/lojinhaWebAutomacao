package modulos.podutos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes Web do módulo produtos")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        //Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver-win64\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        //Maximizar a tela
        this.navegador.manage().window().maximize();

        //Definir tempo de espera padrão de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navegar para página da lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2");
    }

    @Test
    @DisplayName("Não é permitido registrar produto com valor igual a zero")
    public void testValorZerado(){

        //Fazer login
        String msgError = new LoginPage(navegador)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .submeterLogin()
                .adicionarProduto()
                .preencherNome("TV")
                .preencherValor("000")
                .preencherCores("Preto, branco")
                .submeterProdutoInvalido()
                .capturarMsgExibida();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", msgError);

    }

    @Test
    @DisplayName("Não é permitido registrar produto com valor maior que sete mil reais")
    public void testValorMaiorSeteMil(){

        String msg = new LoginPage(navegador)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .submeterLogin()
                .adicionarProduto()
                .preencherNome("Xbox")
                .preencherValor("700001")
                .preencherCores("Cinza")
                .submeterProdutoInvalido()
                .capturarMsgExibida();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", msg);
    }

    @Test
    @DisplayName("Registrando produto com valor entre 0,01 e 7000,00")
    public void testRegistrandoProutoComSucesso(){

            String msg = new LoginPage(navegador)
                    .preencherUsuario("admin")
                    .preencherSenha("admin")
                    .submeterLogin()
                    .adicionarProduto()
                    .preencherNome("Mouse")
                    .preencherValor("15000")
                    .preencherCores("Preto")
                    .submeterProdutoValido()
                    .capturarMsgExibida();

        Assertions.assertEquals("Produto adicionado com sucesso", msg);
    }

    @Test
    @DisplayName("Registrando produto com valor de 0,01")
    public void testRegistrandoProutoValendoUmCentavo(){

        String msg = new LoginPage(navegador)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .submeterLogin()
                .adicionarProduto()
                .preencherNome("Bala")
                .preencherValor("001")
                .preencherCores("Rosa")
                .submeterProdutoValido()
                .capturarMsgExibida();

        Assertions.assertEquals("Produto adicionado com sucesso", msg);
    }

    @Test
    @DisplayName("Registrando produto com valor de 7000,00")
    public void testRegistrandoProutoValendoSeteMilReais(){

        String msg = new LoginPage(navegador)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .submeterLogin()
                .adicionarProduto()
                .preencherNome("Bala")
                .preencherValor("700000")
                .preencherCores("Rosa")
                .submeterProdutoValido()
                .capturarMsgExibida();

        Assertions.assertEquals("Produto adicionado com sucesso", msg);
    }

    @AfterEach
    public void afterEach(){
        //Fechar navegador
        navegador.quit();
    }

}
