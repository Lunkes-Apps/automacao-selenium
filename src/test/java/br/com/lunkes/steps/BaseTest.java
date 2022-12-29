package br.com.lunkes.steps;

import br.com.lunkes.driverfactory.BrowserEnum;
import br.com.lunkes.errorexception.DriverNotConfigured;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static br.com.lunkes.driverfactory.DriverFactory.getDriver;
import static br.com.lunkes.driverfactory.DriverFactory.killDriver;
import static br.com.lunkes.utils.Utils.retornaPropriedade;

public class BaseTest {

    @Before
    public void setUp() throws DriverNotConfigured {
        String browser = System.getProperty("browser");
        WebDriver driver = getDriver(BrowserEnum.valueOf((browser != null ? browser : "chrome").toUpperCase()));
        int timeout = Integer.parseInt(retornaPropriedade("timeout"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    @After
    public void tearDown() throws DriverNotConfigured {
        killDriver();
    }
}
