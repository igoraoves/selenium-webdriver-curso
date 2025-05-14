package br.igor.automationpractice;

import br.igor.utils.BaseTeste;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TesteJanelas extends BaseTeste {

    @Test
    @DisplayName("Testa uso com janelas")
    public void deveInteragirComJanela() {
        navChrome.findElement(By.id("buttonPopUpEasy")).click();
        navChrome.switchTo().window("Popup");
        navChrome.findElement(By.tagName("textarea")).sendKeys("Funcionou?");
        navChrome.switchTo().window("");
        navChrome.findElement(By.tagName("textarea")).sendKeys("Funcionou?");
    }
}
