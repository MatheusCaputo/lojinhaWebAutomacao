package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdicionarProdutosPage {

    private WebDriver navegador;

    public AdicionarProdutosPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public AdicionarProdutosPage preencherNome(String nome){
        navegador.findElement(By.id("produtonome")).sendKeys(nome);
        return this;
    }

    public AdicionarProdutosPage preencherValor(String valor){
        navegador.findElement(By.id("produtovalor")).sendKeys(valor);
        return this;
    }

    public AdicionarProdutosPage preencherCores(String cores){
        navegador.findElement(By.id("produtocores")).sendKeys(cores);
        return this;
    }

    public ListarProdutosPage submeterProdutoInvalido(){
        navegador.findElement(By.name("action")).click();
        return new ListarProdutosPage(navegador);
    }

    public EditarProdutosPage submeterProdutoValido(){
        navegador.findElement(By.name("action")).click();
        return new EditarProdutosPage(navegador);
    }
}
