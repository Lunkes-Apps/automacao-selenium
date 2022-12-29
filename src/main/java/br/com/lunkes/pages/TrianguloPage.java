package br.com.lunkes.pages;

import br.com.lunkes.errorexception.DriverNotConfigured;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static br.com.lunkes.driverfactory.DriverFactory.getDriver;

public class TrianguloPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(),'Dados os três lados de um triângulo')]")
    private WebElement textoInicial;

    @FindBy(name = "V1")
    private WebElement verticeUm;

    @FindBy(name = "V2")
    private WebElement verticeDois;

    @FindBy(name = "V3")
    private WebElement verticeTres;

    @FindBy(css = "body > div:nth-child(7)")
    private WebElement resposta;

    @FindBy(css = "[value='Identificar']")
    private WebElement botaoIdentificar;

    public TrianguloPage vaiParaPaginaTriangulo(){
        try {
            getDriver().get("https://www.vanilton.net/triangulo/");
            wait.until(ExpectedConditions.visibilityOf(textoInicial));
        } catch (DriverNotConfigured e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public TrianguloPage inserirVerticeUm(String valor) {
        verticeUm.sendKeys(valor);
        return this;
    }

    public TrianguloPage inserirVerticeDois(String valor) {
        verticeDois.sendKeys(valor);
        return this;
    }

    public TrianguloPage inserirVerticeTres(String valor) {
        verticeTres.sendKeys(valor);
        return this;
    }

    public TrianguloPage clicarNoBotaoIdentificar(){
        botaoIdentificar.click();
        return this;
    }

    public String respostaTipoTriangulo(){
        return resposta.getText();
    }

}
