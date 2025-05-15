package br.igor.automationpractice;

import br.igor.utils.BaseTeste;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TesteJanelas extends BaseTeste {

    @Test
    @DisplayName("Testa uso com janelas")
    public void deveInteragirComJanela() {
        driver.findElement(By.id("buttonPopUpEasy")).click();
        driver.switchTo().window("Popup");
        driver.findElement(By.tagName("textarea")).sendKeys("Funcionou?");
        driver.switchTo().window("");
        driver.findElement(By.tagName("textarea")).sendKeys("Funcionou?");
    }
}
