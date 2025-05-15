package br.igor.automationpractice;

import br.igor.utils.BaseTeste;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;


public class TesteCampoTreinamento extends BaseTeste {

    @Test
    @DisplayName("Escreve texto no input nome")
    public void adicionarNome() {
        // Encontra elemento e insere texto
        dsl.escrever("elementosForm:nome", "Igor");
        // Verifica se o texto foi escrito
        Assertions.assertEquals("Igor", dsl.obterValorCampo("elementosForm:nome"));
    }

    @Test
    @DisplayName("Escreve texto no textArea")
    public void adicionaTextoNaTextArea(){
        // Encontra elemento e insere texto
        dsl.escrever("elementosForm:sugestoes", "Esse é um texto qualquer");
        // Verifica se o texto foi escrito
        Assertions.assertEquals("Esse é um texto qualquer", dsl.obterValorCampo("elementosForm:sugestoes"));
    }

    @Test
    @DisplayName("Seleciona um radioButton")
    public void selecionaRadioButton(){
        // Encontra elemento e clica
        dsl.clicarRadio("elementosForm:sexo:0");
        // Verifica se o elemento foi selecionado
        dsl.isRadioMarcado("elementosForm:sexo:0");
    }

    @Test
    @DisplayName("Seleciona elemento 'Pizza' no Checkbox")
    public void selecionaCheckbox() {
        // Seleciona elemento e clica
        dsl.clicarRadio("elementosForm:comidaFavorita:2");
        // Verifica se o elemento foi selecionado
        dsl.isRadioMarcado("elementosForm:comidaFavorita:2");
    }

    @Test
    @DisplayName("Seleciona elemento do combo box")
    public void selecionaElementoCombobox() {
        // seleciona elemento
        dsl.selecionarCombo("elementosForm:escolaridade","Especializacao");

        // Verifica se o elemento foi selecionado
        Assertions.assertEquals("Especializacao", dsl.obterValorCombo("elementosForm:escolaridade"));
    }

    @Test
    @DisplayName("Deve interagir com o Botão")
    public void interageComBotao() {
        // Seleciona elemento
        driver.findElement(By.id("buttonSimple")).click();

        // Verifica se o elemento foi alterado
        Assertions.assertEquals("Obrigado!", driver.findElement(By.id("buttonSimple")).getDomProperty("value"));
    }

    @Test
    @DisplayName("Deve interagir com o link")
    public void interageComLink() {
        driver.findElement(By.linkText("Voltar")).click();

    }

    @Test
    @DisplayName("Deve interagir com o alert")
    public void interageComAlert(){

        driver.findElement(By.id("alert")).click();
        Alert alert = driver.switchTo().alert();

        Assertions.assertEquals("Alert Simples", alert.getText());
    }

    @Test
    @DisplayName("Deve confirmar o alert")
    public void confirmaAlert() {

        // Captura elemento
        driver.findElement(By.id("confirm")).click();
        // Muda contexto para manipular o alert
        Alert alert = driver.switchTo().alert();
        // Confirma mensagem do alert
        alert.accept();
        // Verifica se realmente foi aceito
        Assertions.assertEquals("Confirmado", alert.getText());
    }

    @Test
    @DisplayName("Deve cancelar o alert")
    public void cancelaAlert() {

        // Captura elemento
        driver.findElement(By.id("confirm")).click();
        // Muda contexto para manipular o alert
        Alert alert = driver.switchTo().alert();
        // Confirma mensagem do alert
        alert.dismiss();
        // Verifica se realmente foi aceito
        Assertions.assertEquals("Negado", alert.getText());
    }




}
