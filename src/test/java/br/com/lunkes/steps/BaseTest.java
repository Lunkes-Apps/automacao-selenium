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
        String ci = System.getProperty("ci");

        browser = (browser != null ? browser : "chrome").toUpperCase();
        ci = ci != null ? ci : "não";
        WebDriver driver = getDriver(BrowserEnum.valueOf(browser), ci.equals("sim"));
        int timeout = Integer.parseInt(retornaPropriedade("timeout"));

        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void tearDown() throws DriverNotConfigured {
        killDriver();
    }
}
