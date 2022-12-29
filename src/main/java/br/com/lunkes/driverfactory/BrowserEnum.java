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
            ChromeOptions capabilites = new ChromeOptions();
            if(ci){
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
                capabilites.setBinary("/usr/bin/google-chrome-stable");
                capabilites.addArguments("--headless");
            }else{
                System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
            }
            String [] arguments = {
                    "--no-sandbox",
                    "--disable-dev-shm-usage",
                    "--verbose",
                    "--allow-running-insecure-content",
                    "--allow-insecure-localhost",
                    "--disable-gpu"
            };

            capabilites.addArguments(arguments);

            return new ChromeDriver(capabilites);
        }
    }

}
