package br.com.lunkes.driverfactory;

import br.com.lunkes.errorexception.DriverNotConfigured;
import org.openqa.selenium.WebDriver;

public class DriverFactory{
    private static WebDriver driver;

    public static WebDriver getDriver() throws DriverNotConfigured {
        if(driver == null){
            throw new DriverNotConfigured();
        }
        return driver;
    }

    public static WebDriver getDriver(BrowserEnum browser){
        if(driver != null){
            return driver;
        }
        driver = browser.driver();
        return driver;
    }

    public static void killDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
