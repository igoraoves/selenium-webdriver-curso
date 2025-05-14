package br.igor.automationpractice;

import br.igor.utils.BaseTeste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FluxoCadastro extends BaseTeste {

    @Test
    @DisplayName("Realiza fluxo de cadastro de usuário")
    public void fluxoDeCadastro () {

        // Captura elemento, adiciona nome e valida dado inserido
        navChrome.findElement(By.id("elementosForm:nome")).sendKeys("Igor");
        Assertions.assertEquals("Igor", navChrome.findElement(By.id("elementosForm:nome")).getDomProperty("value"));

        // Captura elemento, adiciona sobrenome e valida dado inserido
        navChrome.findElement(By.id("elementosForm:sobrenome")).sendKeys("Alves");
        Assertions.assertEquals("Alves", navChrome.findElement(By.id("elementosForm:sobrenome")).getDomProperty("value"));

        // Captura elemento, seleciona elemento e valida dado inserido
        navChrome.findElement(By.id("elementosForm:sexo:0")).click();
        Assertions.assertTrue(navChrome.findElement(By.id("elementosForm:sexo:0")).isSelected());

        // Captura elemento, seleciona elemento e valida dado inserido
        navChrome.findElement(By.id("elementosForm:comidaFavorita:1")).click();
        navChrome.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        Assertions.assertTrue(navChrome.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());
        Assertions.assertTrue(navChrome.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());

        // Seleciona elemento do Select e valida
        WebElement elemento = navChrome.findElement((By.id("elementosForm:escolaridade")));
        Select comida = new Select(elemento);
        comida.selectByContainsVisibleText("Especializacao");

        Assertions.assertEquals("Especializacao", comida.getFirstSelectedOption().getText());

        // Seleciona elemento do Select e valida
        WebElement element = navChrome.findElement((By.id("elementosForm:esportes")));
        Select esporte = new Select(element);
        esporte.selectByContainsVisibleText("Karate");

        Assertions.assertEquals("Karate", esporte.getFirstSelectedOption().getText());

        // Captura elemento, seleciona elemento e valida dado inserido
        navChrome.findElement(By.id("elementosForm:sugestoes")).sendKeys("Deixe a UI mais bonita!");
        Assertions.assertEquals("Deixe a UI mais bonita!", navChrome.findElement(By.id("elementosForm:sugestoes")).getDomProperty("value"));

        // Captura elemento do botão e clica
        navChrome.findElement(By.id("elementosForm:cadastrar")).click();


        // Captura elemento e verifica se ele está visivel
        Assertions.assertTrue(navChrome.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
        Assertions.assertTrue(navChrome.findElement(By.id("descNome")).getText().endsWith("Igor"));
        Assertions.assertTrue(navChrome.findElement(By.id("descSobrenome")).getText().endsWith("Alves"));
        Assertions.assertTrue(navChrome.findElement(By.id("descSexo")).getText().endsWith("Masculino"));
        Assertions.assertTrue(navChrome.findElement(By.id("descComida")).getText().endsWith("Frango Pizza"));
        Assertions.assertTrue(navChrome.findElement(By.id("descEscolaridade")).getText().endsWith("especializacao"));
        Assertions.assertTrue(navChrome.findElement(By.id("descEsportes")).getText().endsWith("Karate"));
        Assertions.assertTrue(navChrome.findElement(By.id("descSugestoes")).getText().endsWith("Deixe a UI mais bonita!"));

    }

}
