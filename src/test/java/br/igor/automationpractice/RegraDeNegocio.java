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
        navChrome.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = navChrome.switchTo().alert();
        Assertions.assertEquals("Nome eh obrigatorio", alert.getText());
    }

    @Test
    @DisplayName("Verifica se o campo sobrenome foi preenchido")
    public void campoSobrenomeObrigatorio() {

        navChrome.findElement(By.id("elementosForm:nome")).sendKeys("Igor");

        navChrome.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = navChrome.switchTo().alert();
        Assertions.assertEquals("Sobrenome eh obrigatorio", alert.getText());
    }

    @Test
    @DisplayName("Verifica se o campo de sexo foi marcado")
    public void campoSexoObrigatorio() {
        navChrome.findElement(By.id("elementosForm:nome")).sendKeys("Igor");
        navChrome.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gomes");

        navChrome.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = navChrome.switchTo().alert();
        Assertions.assertEquals("Sexo eh obrigatorio", alert.getText());
    }

    @Test
    @DisplayName("Verifica se confirmação se vegetariano aparece ao clicar nas opções 'Frango' e 'Vegetariano'")
    public void mensagemVegetariano() {
        navChrome.findElement(By.id("elementosForm:nome")).sendKeys("Igor");
        navChrome.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gomes");
        navChrome.findElement(By.id("elementosForm:sexo:0")).click();

        navChrome.findElement(By.id("elementosForm:comidaFavorita:1")).click();
        navChrome.findElement(By.id("elementosForm:comidaFavorita:3")).click();

        navChrome.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = navChrome.switchTo().alert();
        Assertions.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
    }

    @Test
    @DisplayName("Verifica se alert sobre esporte aparece")
    public void mensagemEsporte() {
        navChrome.findElement(By.id("elementosForm:nome")).sendKeys("Igor");
        navChrome.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gomes");
        navChrome.findElement(By.id("elementosForm:sexo:0")).click();

        WebElement elemento = navChrome.findElement(By.id("elementosForm:esportes"));
        Select esporte = new Select(elemento);

        esporte.selectByContainsVisibleText("Karate");
        esporte.selectByContainsVisibleText("O que eh esporte?");

        navChrome.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = navChrome.switchTo().alert();
        Assertions.assertEquals("Voce faz esporte ou nao?", alert.getText());
    }

}
