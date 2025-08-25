import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/link.xhtml");
    }

    @Test
    public void LinkTests(){
        // take to the dashboard
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        // find my destination
        WebElement destination = driver.findElement(By.partialLinkText("Find the URL"));
        String path = destination.getAttribute("href");
        System.out.println("This link is going to: " + path);

        // Am i broken link
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();
        String title = driver.getTitle();
        if(title.contains("404")){
            System.out.println("This is a broken link");
        } else {
            System.out.println("This is not a broken link");
        }
        driver.navigate().back();

        // duplicate link
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();

        // count page links
        List<WebElement> countfullpageLinks = driver.findElements(By.tagName("a"));
        int pageLinkCount = countfullpageLinks.size();
        System.out.println("Total links in the page: " + pageLinkCount);

        // count layout links
        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countOfLayoutLinks = layoutElement.findElements(By.tagName("a"));
        System.out.println("Total links in the layout: " + countOfLayoutLinks.size());
    }
}
