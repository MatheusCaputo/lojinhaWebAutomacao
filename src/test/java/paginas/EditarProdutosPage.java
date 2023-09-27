package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditarProdutosPage {

    private WebDriver navegador;

    public EditarProdutosPage(WebDriver navegador){

        this.navegador = navegador;
    }

    public String capturarMsgExibida (){
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
