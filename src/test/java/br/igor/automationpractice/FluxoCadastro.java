package br.igor.automationpractice;

import br.igor.utils.BaseTeste;
import br.igor.utils.DSL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FluxoCadastro extends BaseTeste {

    private DSL dsl;

    @Test
    @DisplayName("Realiza fluxo de cadastro de usuário")
    public void fluxoDeCadastro () {

        page.setNome("Igor");
        page.setSobrenome("Alves");
        page.setSexoMasculino();
        page.setComidaPizza();
        page.setEscolaridade("Especializacao");
        page.setEsportes("Karate");
        page.setSugestao("Deixe a UI mais bonita!");
        page.setClicarBotao();

        Assertions.assertEquals("Igor", page.getNome());
        Assertions.assertEquals("Alves", page.getSobrenome());
        Assertions.assertEquals("Especializacao", page.getEscolaridade());
        Assertions.assertEquals("Karate", page.getEsporte());
        Assertions.assertEquals("Deixe a UI mais bonita!", page.getSugestoes());


        // Captura elemento e verifica se ele está visivel
        Assertions.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
        Assertions.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Igor"));
        Assertions.assertTrue(driver.findElement(By.id("descSobrenome")).getText().endsWith("Alves"));
        Assertions.assertTrue(driver.findElement(By.id("descSexo")).getText().endsWith("Masculino"));
        Assertions.assertTrue(driver.findElement(By.id("descComida")).getText().endsWith("Pizza"));
        Assertions.assertTrue(driver.findElement(By.id("descEscolaridade")).getText().endsWith("especializacao"));
        Assertions.assertTrue(driver.findElement(By.id("descEsportes")).getText().endsWith("Karate"));
        Assertions.assertTrue(driver.findElement(By.id("descSugestoes")).getText().endsWith("Deixe a UI mais bonita!"));
    }
}
