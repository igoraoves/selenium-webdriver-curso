package br.igor.automationpractice;

import br.igor.utils.BaseTeste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class TesteCampoTreinamento extends BaseTeste {

    @Test
    @DisplayName("Escreve texto no input nome")
    public void adicionarNome() {
        // Encontra elemento e insere texto
        navChrome.findElement(By.id("elementosForm:nome")).sendKeys("Igor");
        // Verifica se o texto foi escrito
        Assertions.assertEquals("Igor", navChrome.findElement(By.id("elementosForm:nome")).getAttribute("value"));
    }

    @Test
    @DisplayName("Escreve texto no textArea")
    public void adicionaTextoNaTextArea(){
        // Encontra elemento e insere texto
        navChrome.findElement(By.id("elementosForm:sugestoes")).sendKeys("Esse é um texto qualquer que estou colocando aqui");
        // Verifica se o texto foi escrito
        Assertions.assertEquals("Esse é um texto qualquer que estou colocando aqui", navChrome.findElement((By.id("elementosForm:sugestoes"))).getDomProperty("value"));
    }

    @Test
    @DisplayName("Seleciona um radioButton")
    public void selecionaRadioButton(){
        // Encontra elemento e clica
        navChrome.findElement(By.id("elementosForm:sexo:0")).click();
        // Verifica se o elemento foi selecionado
        Assertions.assertTrue(navChrome.findElement(By.id("elementosForm:sexo:0")).isSelected());
    }

    @Test
    @DisplayName("Seleciona elemento 'Pizza' no Checkbox")
    public void selecionaCheckbox() {
        // Seleciona elemento e clica
        navChrome.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        // Verifica se o elemento foi selecionado
        Assertions.assertTrue(navChrome.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
    }

    @Test
    @DisplayName("Seleciona elemento do combo box")
    public void selecionaElementoCombobox() {
        // seleciona elemento
        WebElement element = navChrome.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        // combo.selectByIndex(3);
        // combo.selectByValue("superior");
        combo.selectByContainsVisibleText("Especializacao");

        // Verifica se o elemento foi selecionado
        Assertions.assertEquals("Especializacao", combo.getFirstSelectedOption().getText());
    }

    @Test
    @DisplayName("Deve interagir com o Botão")
    public void interageComBotao() {
        // Seleciona elemento
        navChrome.findElement(By.id("buttonSimple")).click();

        // Verifica se o elemento foi alterado
        Assertions.assertEquals("Obrigado!", navChrome.findElement(By.id("buttonSimple")).getDomProperty("value"));
    }

    @Test
    @DisplayName("Deve interagir com o link")
    public void interageComLink() {
        navChrome.findElement(By.linkText("Voltar")).click();

    }

    @Test
    @DisplayName("Deve interagir com o alert")
    public void interageComAlert(){

        navChrome.findElement(By.id("alert")).click();
        Alert alert = navChrome.switchTo().alert();

        Assertions.assertEquals("Alert Simples", alert.getText());
    }

    @Test
    @DisplayName("Deve confirmar o alert")
    public void confirmaAlert() {

        // Captura elemento
        navChrome.findElement(By.id("confirm")).click();
        // Muda contexto para manipular o alert
        Alert alert = navChrome.switchTo().alert();
        // Confirma mensagem do alert
        alert.accept();
        // Verifica se realmente foi aceito
        Assertions.assertEquals("Confirmado", alert.getText());
    }

    @Test
    @DisplayName("Deve cancelar o alert")
    public void cancelaAlert() {

        // Captura elemento
        navChrome.findElement(By.id("confirm")).click();
        // Muda contexto para manipular o alert
        Alert alert = navChrome.switchTo().alert();
        // Confirma mensagem do alert
        alert.dismiss();
        // Verifica se realmente foi aceito
        Assertions.assertEquals("Negado", alert.getText());
    }




}
