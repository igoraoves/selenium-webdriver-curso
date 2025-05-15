package br.igor.utils;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
    private WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;

    }

    public void escrever(String id_campo, String texto) {
        driver.findElement(By.id(id_campo)).sendKeys(texto);
    }

    public String obterValorCampo(String id_campo) {
        return driver.findElement(By.id(id_campo)).getDomProperty("value");
    }

    public void clicarRadio(String id_campo) {
        driver.findElement(By.id(id_campo)).click();
    }

    public void isRadioMarcado(String id_campo){
        Assertions.assertTrue(driver.findElement(By.id(id_campo)).isSelected());
    }

    public void selecionarCombo(String id_campo, String valor){
        WebElement element = driver.findElement(By.id(id_campo));
        Select combo = new Select(element);
        combo.selectByContainsVisibleText(valor);
    }

    public String obterValorCombo(String id_campo){
        WebElement element = driver.findElement(By.id(id_campo));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public void clicarBotao(String id_campo) {
        driver.findElement(By.id(id_campo)).click();
    }
}
