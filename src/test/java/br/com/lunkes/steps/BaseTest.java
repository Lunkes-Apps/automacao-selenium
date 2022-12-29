package br.com.lunkes.steps;

import br.com.lunkes.driverfactory.BrowserEnum;
import br.com.lunkes.errorexception.DriverNotConfigured;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static br.com.lunkes.driverfactory.DriverFactory.getDriver;
import static br.com.lunkes.driverfactory.DriverFactory.killDriver;
import static br.com.lunkes.utils.Utils.retornaPropriedade;

public class BaseTest {

    @BeforeAll
    public static void setUp() throws DriverNotConfigured {
        String browser = System.getProperty("browser");
        WebDriver driver = getDriver(BrowserEnum.valueOf((browser != null ? browser : "chrome").toUpperCase()));
        int timeout = Integer.parseInt(retornaPropriedade("timeout"));
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void tearDown() throws DriverNotConfigured {
        killDriver();
    }
}
