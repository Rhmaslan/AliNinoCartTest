package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


public class AliVeNinoStepDefinition {

    public WebDriver driver;

    @Given("User is on landing page")
    public void user_is_on_landing_page() {

    }
    @When("User searches for {string} keyword")
    public void user_searches_for_keyword(String string) {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://alinino.az/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/form/input")).sendKeys("Mahmud"); //mahmud yazdi
    }
    @Then("User clicks on cart icon")
    public void user_clicks_on_cart_icon() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/form/button")).click(); //tap sozune klikledi
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String ChildWindow = i1.next();
        driver.switchTo().window(ChildWindow);
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[1]/div/div/form/a")).click(); //kitabda sebet isaresine klikledi


    }

    @And("item added to cart")
    public void item_added_to_cart() {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/a/span[2]")).click(); //sebet ikonu

        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div[2]/form/div[2]/a/span"))).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/form/div[2]/a/span")).click(); //sebete kecid
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String ChildWindow = i1.next();
        driver.switchTo().window(ChildWindow);
        driver.quit();
    }



}


