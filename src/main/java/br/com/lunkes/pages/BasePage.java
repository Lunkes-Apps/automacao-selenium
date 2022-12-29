package br.com.lunkes.pages;

import br.com.lunkes.errorexception.DriverNotConfigured;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static br.com.lunkes.driverfactory.DriverFactory.getDriver;
import static br.com.lunkes.utils.Utils.retornaPropriedade;

public class BasePage {

    protected  WebDriverWait wait;

    public BasePage(){
        int timeout = Integer.parseInt(retornaPropriedade("timeout"));
        try {
            PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(),timeout), this);
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        } catch (DriverNotConfigured e) {
            throw new RuntimeException(e);
        }
    }

}
