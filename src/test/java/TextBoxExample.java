import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {
    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/input.xhtml");
        //Thread.sleep(3000);
    }

    @Test
    public void TextBoxTests(){
        // tye your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Nethsilu Marasinghe");

        // append country
        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("Sri Lanka");

        // verify if text box is disabled
        boolean isEnabled = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is the text box enabled? " + !isEnabled);


        // clear the typed text
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        // retrieve the typed text
        WebElement textElemnt = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = textElemnt.getAttribute("value");

        // type email and tab ctrl moved to the next one
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("kasuntharamarasinghe@gmail.com" + Keys.TAB + "Confirmed control moved to the next element");
    }
}
