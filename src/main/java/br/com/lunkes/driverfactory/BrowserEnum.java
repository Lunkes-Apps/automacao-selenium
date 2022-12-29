package br.com.lunkes.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public enum BrowserEnum implements BrowserInterface{

    FIREFOX {
        public FirefoxDriver driver(boolean ci){
            if(ci){
                System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
            }else{
                System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
            }
            FirefoxOptions capabilities = new FirefoxOptions();
            return new FirefoxDriver(capabilities);
        }
    },
    CHROME {
        public WebDriver driver(boolean ci){
            if(ci){
                System.setProperty("webdriver.chrome.driver", "usr/local/bin/chromedriver");
            }else{
                System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
            }
            ChromeOptions capabilites = new ChromeOptions();
            return new ChromeDriver(capabilites);
        }
    }

}
