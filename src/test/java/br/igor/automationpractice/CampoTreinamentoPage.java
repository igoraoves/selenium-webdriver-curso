package br.igor.automationpractice;

import br.igor.utils.DSL;
import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {

    private WebDriver driver;
    private DSL dsl;

    public CampoTreinamentoPage(WebDriver driver) {
        this.driver = driver;
        dsl = new DSL(driver);
    }

    public void setNome(String nome){
        dsl.escrever("elementosForm:nome", nome);
    }

    public void setSobrenome(String sobrenome) {
        dsl.escrever("elementosForm:sobrenome", sobrenome);
    }

    public void setSexoMasculino(){
        dsl.clicarRadio("elementosForm:sexo:0");
    }

    public void setComidaPizza(){
        dsl.clicarRadio("elementosForm:comidaFavorita:2");
    }

    public void setEscolaridade(String valor){
        dsl.selecionarCombo("elementosForm:escolaridade", valor);
    }

    public void setEsportes(String valor) {
        dsl.selecionarCombo("elementosForm:esportes",valor);
    }

    public void setSugestao(String valor) {
        dsl.escrever("elementosForm:sugestoes",valor);
    }
    public void setClicarBotao() {
        dsl.clicarBotao("elementosForm:cadastrar");
    }

    public String getNome() {
        return dsl.obterValorCampo("elementosForm:nome");
    }

    public String getSobrenome() {
        return dsl.obterValorCampo("elementosForm:sobrenome");
    }

    public String getEscolaridade() {
        return dsl.obterValorCombo("elementosForm:escolaridade");
    }

    public String getEsporte() {
        return dsl.obterValorCombo("elementosForm:esportes");
    }

    public String getSugestoes() {
        return dsl.obterValorCampo("elementosForm:sugestoes");
    }

}
