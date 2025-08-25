import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {
    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
//        Dimension newSize = new Dimension(800, 600);
//        driver.manage().window().setSize(newSize);
        driver.manage().window().maximize();
        driver.get("https://leafground.com/button.xhtml");
    }

    @Test
    public void buttonTests(){

        // click and confirm title
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Actual title is equal to expected title");
        } else {
            System.out.println("Actual title is not equal to expected title");
        }
        //Assert.assertEquals(actualTitle,expectedTitle,"Title mismatched");

        //find the position of submit  button
        driver.navigate().back();
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("x: " + x + " y: " + y);


        //find the save button color
        WebElement buttoncolor = driver.findElement(By.id("j_idt88:j_idt96"));
        String color = buttoncolor.getCssValue("background-color");
        System.out.println("Button color: " + color);

        // find the height and width of the button
        WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
        int height = size.getSize().getHeight();
        int width = size.getSize().getWidth();
        System.out.println("Height: " + height + " Width: " + width);


    }
}
