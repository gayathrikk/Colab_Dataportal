package Sanitytesting.ColabdataportalUI;



import org.testng.Assert;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.Set;



public class Datatesting {


    private RemoteWebDriver driver;

    @BeforeTest
	
	public void setup() throws Exception
	{
		
		  DesiredCapabilities dc = DesiredCapabilities.chrome();
	        URL url = new URL("http://172.12.20.99:4444/wd/hub");
	        driver = new RemoteWebDriver(url, dc);
	
	       
	}

	@Test(priority=1)
	public void login() throws InterruptedException
	{
		driver.get("https://dataportal.colab.humanbrain.in/viewer/annotation/portal");
		driver.manage().window().maximize();
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentURL);
		WebDriverWait wait = new WebDriverWait(driver, 10);
    	driver.switchTo().defaultContent(); // Switch back to default content
    	WebElement viewerElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Viewer']")));
    	if (viewerElement.isEnabled() && viewerElement.isDisplayed()) {
    	    viewerElement.click();
    	    System.out.println("Viewer icon is clicked");
    	} else {
    	    System.out.println("Viewer icon is not clickable");
    	}
    	

        String parentWindow = driver.getWindowHandle();
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
        if (loginButton != null) {
            loginButton.click();
            System.out.println("Login button clicked successfully.");
        } else {
            System.out.println("Login button is not clicked.");
        }
     
	  wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	  Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        if (emailInput != null && emailInput.isDisplayed()) {
            emailInput.sendKeys("teamsoftware457@gmail.com");
            System.out.println("Email was entered successfully.");
        } else {
           System.out.println("Email was not entered.");
        }
      

        WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
        if (nextButton1 != null) {
            nextButton1.click();
            System.out.println("Next button 1 is clicked.");
        } else {
            System.out.println("Next button 1 is not clicked.");
        }
        
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));
        passwordInput.sendKeys("Health#123");
        if (passwordInput.getAttribute("value").equals("Health#123")) {
            System.out.println("Password was entered successfully.");
        } else {
            System.out.println("Password was not entered.");
        }
      
        
        WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
        if (nextButton2 != null) {
            nextButton2.click();
            System.out.println("Next button 2 is clicked.");
        } else {
            System.out.println("Next button 2 is not clicked.");
        }
        

        driver.switchTo().window(parentWindow);
        System.out.println("Login successfully");
       
        System.out.println("************************Login validation done***********************");
	        
	}
	@Test(priority=2)
	public void seriesset_API()
	{
		
		Seriesset_API();
	}
  @Test(priority=3)

  public void goatBrain() throws InterruptedException {

	  

	  WebDriverWait wait = new WebDriverWait(driver, 10);

	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[1]/td[1]" ))).click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[2]/td[2]" ))).click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[3]/td[3]" ))).click();

		Thread.sleep(2000);
		
		System.out.println("Go to Goat Brain-4");
    	
    	WebElement section = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='335'])[1]")));
    	if (section.isEnabled() && section.isDisplayed()) {
    	    section.click();
    	    System.out.println("section is selected");
    	} else {
    	    System.out.println("section is not selected");
    	}
    	Thread.sleep(3000);
    	
    
    	WebElement hd = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='View High Resolution Image']")));
    	if (hd.isEnabled() && hd.isDisplayed()) {
    	    hd.click();
    	    System.out.println("High resolution page is opened");
    	} else {
    	    System.out.println("High resolutin page is not opened");
    	}
    	Thread.sleep(5000);
    	
    
    	WebElement back = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='back']")));
     	if (back.isEnabled() && back.isDisplayed()) {
     	    back.click();
     	    System.out.println("Back to viewer page");
     	} else {
     	    System.out.println("Back to viewer page");
     	}
     	Thread.sleep(6000);
     	
        System.out.println("********************************Hd page validation of goat brain done*****************************");

		

	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Back']" ))).click();

		Thread.sleep(2000);

  }

  

  @Test(priority=4)

  public void mouseBrain() throws InterruptedException {

	  WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[2]/td[1]" ))).click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[3]/td[2]" ))).click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[4]/td[3]" ))).click();

		Thread.sleep(2000);

		System.out.println("Go to MTB-12");

		WebElement section = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='301'])[1]")));
    	if (section.isEnabled() && section.isDisplayed()) {
    	    section.click();
    	    System.out.println("section is selected");
    	} else {
    	    System.out.println("section is not selected");
    	}
    	Thread.sleep(3000);
    	
    
    	WebElement hd = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='View High Resolution Image']")));
    	if (hd.isEnabled() && hd.isDisplayed()) {
    	    hd.click();
    	    System.out.println("High resolution page is opened");
    	} else {
    	    System.out.println("High resolutin page is not opened");
    	}
    	Thread.sleep(5000);
    	
    
    	WebElement back = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='back']")));
     	if (back.isEnabled() && back.isDisplayed()) {
     	    back.click();
     	    System.out.println("Back to viewer page");
     	} else {
     	    System.out.println("Back to viewer page");
     	}
     	Thread.sleep(6000);
     	
        System.out.println("********************************Hd page validation of MTB-12 done*****************************");

	    

	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Back']" ))).click();

		Thread.sleep(2000);

		

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[2]/td[1]" ))).click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[3]/td[2]" ))).click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[5]/td[3]" ))).click();

		Thread.sleep(2000);

		System.out.println("Go to MTB-18");

		WebElement section1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='238'])[1]")));
    	if (section1.isEnabled() && section1.isDisplayed()) {
    	    section1.click();
    	    System.out.println("section is selected");
    	} else {
    	    System.out.println("section is not selected");
    	}
    	Thread.sleep(3000);
    	
    
    	WebElement hd1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='View High Resolution Image']")));
    	if (hd1.isEnabled() && hd1.isDisplayed()) {
    	    hd1.click();
    	    System.out.println("High resolution page is opened");
    	} else {
    	    System.out.println("High resolutin page is not opened");
    	}
    	Thread.sleep(5000);
    	
    
    	WebElement back1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='back']")));
     	if (back1.isEnabled() && back1.isDisplayed()) {
     	    back1.click();
     	    System.out.println("Back to viewer page");
     	} else {
     	    System.out.println("Back to viewer page");
     	}
     	Thread.sleep(6000);
     	
        System.out.println("********************************Hd page validation of MTB-18 done*****************************");
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Back']" ))).click();

		Thread.sleep(2000);

  }
  private void Seriesset_API()
  {
  	Response response1 = RestAssured
  		    .given()
  		    .auth()
  		    .basic("admin", "admin")
  		    .when()
  		    .get("https://dataportal.colab.humanbrain.in/CC/getDetailsOfSeriesStatsAllRestricted/106900966448254245591");
    int statusCode1 = response1.getStatusCode();
    if (statusCode1 == 200) {
        System.out.println("API request to the series set api passed. Status code: " + statusCode1);
    } else {
        System.out.println("API request to the series set api failed. Status code: " + statusCode1);
    }
    Assert.assertEquals(statusCode1, 200, "API request to the series set api  failed");
    
    String jsonBody1 = "{\\\"user_name\\\":\\\"software team\\\",\\\"user_hash\\\":\\\"106900966448254245591\\\",\\\"email\\\":\\\"teamsoftware457@gmail.com\\\",\"\n"
    		+ "		 		+ \"\\\"image\\\":\\\"https://lh3.googleusercontent.com/a/AAcHTte--G1vkdrm_ojhRzgIsEpuDHA-4loc7lX1bl-XensG=s96-c\\\"}";
  	 Response response4 = RestAssured
           .given()
               .auth()
               .preemptive()
               .basic("admin", "admin")
               .contentType(ContentType.JSON)
               .body(jsonBody1)
           .when()
               .post("https://dataportal.colab.humanbrain.in/CC/getLoginUser");
  	 int statusCode4 = response4.getStatusCode();
  	 if (statusCode4 == 200) {
           System.out.println("API request to Get login user passed. Status code: " + statusCode4);
       } else {
           System.out.println("API request to Get login user failed. Status code: " + statusCode4);
       }
       Assert.assertEquals(statusCode4, 200, "API request to Get login user failed");  
    
    
    
  }

  @AfterTest

  public void afterTest() {

	  driver.quit();

  }

	



	





}

