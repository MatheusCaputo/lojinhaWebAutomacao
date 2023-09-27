package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListarProdutosPage {

    private WebDriver navegador;

    public ListarProdutosPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public AdicionarProdutosPage adicionarProduto(){
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();
        return new AdicionarProdutosPage(navegador);
    }

    public String capturarMsgExibida(){
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
