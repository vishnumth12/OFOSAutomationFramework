package GenericUtilitiesPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	
	/**
	 * this method will create the webdriver object and launch browser and load URL into it
	 * @param browser
	 * @param url
	 * @return
	 */
	public WebDriver launchBrowserAndLoadURL(String browser, String url) {
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Incomptable browser type");
		}
		driver.get(url);
		return driver;
		
	}
	/**
	 * this method will enter the given url into the browser window 
	 * @param driver
	 * @param url
	 */
	public void getUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	
	/**
	 * this method will quit the browser
	 * @param driver
	 */
	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	
	/**
	 * this method will maximize the browser window as it loads
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * this method will minimize the browser window as it loads
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * this method will wait for the page to load with all its elements
	 * @param driver
	 * @param sec
	 */
	public void waitForPageToLoad(WebDriver driver, int sec) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	
	/**
	 * this method will return the object of WebDriverWait needed for explicit wait
	 * @param driver
	 * @param sec
	 * @return
	 */
	
	
	
	public WebDriverWait createExplicitWaitObject(WebDriver driver, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}
	
	/**
	 * this method will wait until the webelement to be visible on dom
	 * @param driver
	 * @param ele
	 * @param sec
	 */
	public void waitUntilElementIsVisible(WebDriver driver, WebElement ele, int sec) {
		createExplicitWaitObject(driver, sec).until(ExpectedConditions.visibilityOf(ele));
	}
	
	/**
	 * this method will wait until the element at dom is clickable
	 * @param driver
	 * @param ele
	 * @param sec
	 */
	public void waitUntilElementIsClickable(WebDriver driver, WebElement ele, int sec) {
		createExplicitWaitObject(driver, 20).until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	/**
	 * this method will wait until title is loaded on the webpage and compares the expected and actual value to do so
	 * @param driver
	 * @param title
	 * @param sec
	 */
	public void waitUntilTitleToBeVisible(WebDriver driver, String title, int sec) {
		createExplicitWaitObject(driver, sec).until(ExpectedConditions.titleContains(title));
	}
	
	/**
	 * this method waits until alert pop up is loaded on the webpage
	 * @param driver
	 * @param sec
	 */
	public void waitUntilAlertToBePresent(WebDriver driver, int sec) {
		createExplicitWaitObject(driver, sec).until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * this method will create an object of select class
	 * @param ele
	 * @return
	 */
	public Select createSelectClassObject(WebElement ele) {
		Select s = new Select(ele);
		return s;
	}
	
	
	/**
	 * this method will select an option by its visible text
	 * @param ele
	 * @param text
	 */
	public void handleDropDown(WebElement ele, String text) {
		createSelectClassObject(ele).selectByVisibleText(text);
	}
	
	/**
	 * this method will select an option in dropdown by its index
	 * @param ele
	 * @param index
	 */
	public void handleDropDown(WebElement ele, int index) {
		createSelectClassObject(ele).selectByIndex(index);
	}
	
	/**
	 * this method will select an option in dropdown by the value attribute
	 * @param value
	 * @param ele
	 */
	public void handleDropDown(String value, WebElement ele) {
		createSelectClassObject(ele).selectByValue(value);
	}
	
	/**
	 * this method creates an obect of actions class in selenium
	 * @param driver
	 * @return
	 */
	public Actions createActionObject(WebDriver driver) {
		Actions action = new Actions(driver);
		return action;
	}
	
	/**
	 * this method is used to press the enter key using the actions class after a iving input to text fields
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver) {
		createActionObject(driver).sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * this method will move the pointer to the webelement mentioned
	 * @param driver
	 * @param ele
	 */
	public void mouseHover(WebDriver driver, WebElement ele) {
		createActionObject(driver).moveToElement(ele).perform();
	}
	
	/**
	 * this method will drag and drop the element from one point to another
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest) {
		createActionObject(driver).dragAndDrop(src, dest).perform();
	}
	
	/**
	 * this method will move the element from the given ele to any point mentioned
	 * @param driver
	 * @param ele
	 * @param x
	 * @param y
	 */
	public void dragAndDrop(WebDriver driver, WebElement ele, int x, int y) {
		createActionObject(driver).dragAndDropBy(ele, x, y).perform();
	}
	
	/**
	 * this method will double click at the place where the pointer is currently present
	 * @param driver
	 */
	public void doubleClick(WebDriver driver) {
		createActionObject(driver).doubleClick().perform();
	}
	
	/**
	 * this method will double click on the webelement mentioned
	 * @param driver
	 * @param ele
	 */
	public void doubleClick(WebDriver driver, WebElement ele) {
		createActionObject(driver).doubleClick(ele).perform();;
	}
	
	/**
	 * this method will right click at the place the pointer is located
	 * @param driver
	 */
	public void rightClick(WebDriver driver) {
		createActionObject(driver).contextClick().perform();
	}
	
	/**
	 * this method will right click on the webelement mentioned
	 * @param driver
	 * @param ele
	 */
	public void rightClick(WebDriver driver, WebElement ele) {
		createActionObject(driver).contextClick(ele).perform();
	}

	/**
	 * this method is used to switch the control to child window
	 * @param driver
	 * @param expWin
	 */
	public void switchToWindow(WebDriver driver, String expWin) {
		Set <String> allWin = driver.getWindowHandles();
		
		Iterator <String> it = allWin.iterator();
		
		while(it.hasNext()) {
			String window = it.next();
			driver.switchTo().window(expWin);
			
			if(window.contains(expWin)) {
				break;
			}
		}
	}
	/**
	 * this method is used to return an object of robot class to be utilized
	 * @return
	 * @throws AWTException
	 */
	public Robot createRobotClassObject() throws AWTException {
		Robot robot = new Robot();
		return robot;
	}
	
	/**
	 * this method is used to press the enter key using the robot class
	 * @throws AWTException
	 */
	public void enterPress() throws AWTException {
		createRobotClassObject().keyPress(KeyEvent.VK_ENTER);
	}
	
	/**
	 * this method is used to release the enter key 
	 * @throws AWTException
	 */
	public void enterRelease() throws AWTException {
		createRobotClassObject().keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * this method takes the screenshot of the webpage and returns the path of the screenshot
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String getScreenshot(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\Screenshots"+screenShotName+".png";
		File dest = new File("path");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}
	
	/**
	 * this method will switch to the frame identified by the index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * this method will switch to the frame identified by its name or id attribute
	 * @param driver
	 * @param idOrName
	 */
	public void switchToFrame(WebDriver driver, String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	/**
	 * this method will switch to frame identified by the element address
	 * @param driver
	 * @param ele
	 */
	public void switchToFrame(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}
	
	/**
	 * this method accepts an alert popup
	 * @param driver
	 */
	public Alert acceptAlertPopup(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
		return al;
	}
	
	/**
	 * 
	 * this method is used to dismiss an alert popup
	 * @param driver
	 * @return 
	 */
	public Alert dismissAlertPopup(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		al.accept();
		return al;
	}
	
	/**
	 * this method is used to create an object of javascriptexecutor
	 * @param driver
	 * @return
	 */
	public JavascriptExecutor createJavascriptObject(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}
	
	/**
	 * this method is used to click on a webelement using javascript
	 * @param driver
	 * @param ele
	 * @return
	 */
	public JavascriptExecutor javascriptClick(WebDriver driver, WebElement ele) {
		createJavascriptObject(driver).executeScript("arguments[0].click();", ele);
		return null;
	}
	
	/**
	 * this method is used to scrol into view of an element
	 * @param driver
	 * @param ele
	 */
	

	/**
	 * this method will scroll the scrollbar randomly to the given point
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollRandomnly(WebDriver driver, int x, int y) {
		createJavascriptObject(driver).executeScript("window.scrollBy("+x+","+y+");");
	}
	
	public void javascriptScrollToWebElement(WebDriver driver, WebElement ele) {
		createJavascriptObject(driver).executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	/**
	 * this method is used to scroll the page to the element
	 * @param ele
	 * @param driver
	 */
	public void javascriptScrollToWebElement(WebElement ele, WebDriver driver) {
		int y = ele.getLocation().getY();
		createJavascriptObject(driver).executeScript("window.scrollBy(0, "+y+");", ele);
	}
	
	/**
	 * this method is used to scroll the webpage to the bottom
	 * @param driver
	 */
	public void scrollTillBottom(WebDriver driver) {
		createJavascriptObject(driver).executeScript("window.scrollBy(0, document.body.scrollHeight);");
	}
	
	/**
	 * this method is used to scroll the webpge until a given element is visible
	 * @param driver
	 * @param ele
	 */
	public void scrollUpTillElementToBeVisible(WebDriver driver, WebElement ele) {
		Point p = ele.getLocation();
		int x = p.getX();
		int y = p.getY();
		createJavascriptObject(driver).executeScript("window.scrollBy("+x+", "+y+")");
	}
	
	/**
	 * this method is used to scroll the webpage to the bottom and then to the top
	 * @param driver
	 */
	public void scrollTillBottomAndThenTop(WebDriver driver) {
		createJavascriptObject(driver).executeScript("window.scrollBy(0, document.body.scrollHeight);");
		createJavascriptObject(driver).executeScript("window.scrollBy(0, document.body.-scrollHeight);");
	}

	/**
	 * this method is used to senekeys using javascriptExecutor
	 * @param driver
	 * @param ele
	 * @param expData
	 */
	public void javascriptSendKeys(WebDriver driver, WebElement ele, String expData) {
		createJavascriptObject(driver).executeScript("arguments[0].value=arguments[1]", ele, expData);
	}
	

}
