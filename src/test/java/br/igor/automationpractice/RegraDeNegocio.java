package br.igor.automationpractice;

import br.igor.utils.BaseTeste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegraDeNegocio extends BaseTeste {

    @Test
    @DisplayName("Verifica se o campo nome foi preenchido")
    public void campoNomeObrigatorio() {
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Nome eh obrigatorio", alert.getText());
    }

    @Test
    @DisplayName("Verifica se o campo sobrenome foi preenchido")
    public void campoSobrenomeObrigatorio() {

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Igor");

        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Sobrenome eh obrigatorio", alert.getText());
    }

    @Test
    @DisplayName("Verifica se o campo de sexo foi marcado")
    public void campoSexoObrigatorio() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Igor");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gomes");

        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Sexo eh obrigatorio", alert.getText());
    }

    @Test
    @DisplayName("Verifica se confirmação se vegetariano aparece ao clicar nas opções 'Frango' e 'Vegetariano'")
    public void mensagemVegetariano() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Igor");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gomes");
        driver.findElement(By.id("elementosForm:sexo:0")).click();

        driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();

        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
    }

    @Test
    @DisplayName("Verifica se alert sobre esporte aparece")
    public void mensagemEsporte() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Igor");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gomes");
        driver.findElement(By.id("elementosForm:sexo:0")).click();

        WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
        Select esporte = new Select(elemento);

        esporte.selectByContainsVisibleText("Karate");
        esporte.selectByContainsVisibleText("O que eh esporte?");

        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Voce faz esporte ou nao?", alert.getText());
    }

}
