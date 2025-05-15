package br.igor.utils;

import br.igor.automationpractice.CampoTreinamentoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTeste {

    protected WebDriver driver;
    protected DSL dsl;
    protected CampoTreinamentoPage page;

    @BeforeEach
    public void inicializarNavegadorBase() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL(driver);
        page = new CampoTreinamentoPage(driver);
    }

    @AfterEach
    public void finalizarNavegadorBase() {
            driver.quit();
    }
}
