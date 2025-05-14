package br.igor.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTeste {

    protected WebDriver navChrome;

    @BeforeEach
    public void inicializarNavegadorBase() {
        WebDriverManager.chromedriver().setup();
        navChrome = new ChromeDriver();
        navChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }

    @AfterEach
    public void finalizarNavegadorBase() {
        if (navChrome != null) {
            navChrome.quit();
        }
    }
}
