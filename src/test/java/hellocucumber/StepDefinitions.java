package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.lang.model.element.Element;

import static org.junit.Assert.*;

public class StepDefinitions {
    static {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");
    }
    WebDriver driver = new ChromeDriver();


    private String result = null;
    private String toTest = null;

    public void clickSearch(){
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(Keys.RETURN);
    }
    @Given("User enters Google")
    public void enterGoogle(){
        driver.get("https://www.google.com/");

    }
    @When("User enters english query")
    public void enterEnglish(){
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("sample request");
        clickSearch();
        result = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/a/h3/span")).getText();
    }
    @When("User enters chinese query")
    public void enterChinese(){
        enterGoogle();
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("绝不会放弃你");
        clickSearch();
    }
    @When("User enters upper case request")
    public void enterLowerCase() {
        enterGoogle();
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("SAMPLE REQUEST");
        clickSearch();
        toTest = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/a/h3/span")).getText();
    }
    @When("User searches for calculator")
    public void searchCalc(){
        enterGoogle();
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("calculator");
        clickSearch();
    }
    @When("User searches for Google converter services")
    public void searchConvert(){
        enterGoogle();
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("converter services");
        clickSearch();
    }
    @Then("Converter services are at the top of search panel")
    public void checkConvert(){
        if (driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/a/h3/span")).isDisplayed())
            System.out.println("The first result is converter service");
        else Assert.fail();
        driver.quit();
    }
    @Then("A calculator is displayed")
    public void checkCalc(){
        if (driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div")).isDisplayed())
            System.out.println("Calculator is displayed");
        else Assert.fail();
    }
    @Then("User gets same results")
    public void getCaseTestResult(){
        if (toTest.equals(result))
            System.out.println("Not case sensitive");
        else Assert.fail();

    }
    @Then("User gets results")
    public void checkResults(){
        if (driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div[1]/a/h3/span")).isDisplayed())
            System.out.println("Got results");
        else Assert.fail();
    }


}
