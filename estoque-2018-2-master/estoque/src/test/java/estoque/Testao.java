package estoque;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Testao {
	
	@Before
	public void setup(){
		
	}
	
	@Test
	public void preencheFormularioChrome() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/100934752/Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("C:/Users/100934752/git/estoque-2018-2/estoque/src/main/webapp/lista-compras.html");

		Select select = new Select(driver.findElement(By.id("select")));
		select.selectByVisibleText("Caju");
		WebElement inputQuantidade = driver.findElement(By.id("quantidade"));
		inputQuantidade.sendKeys("10");
		WebElement inputValorUnitario = driver.findElement(By.id("valorUnitario"));
		inputValorUnitario.sendKeys("5");

		WebElement buttonCalcular = driver.findElement(By.id("calcularBtn"));
		buttonCalcular.click();
		
		Thread.sleep(4000);
		WebElement total = driver.findElement(By.id("valorTotal"));
		
		assertEquals("50", total.getAttribute("value"));

	}
	
	@Test
	public void preencheFormularioFirefox() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:/Users/100934752/Desktop/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/100934752/git/estoque-2018-2/estoque/src/main/webapp/lista-compras.html");

		Select select = new Select(driver.findElement(By.id("select")));
		select.selectByVisibleText("Caju");
		WebElement inputQuantidade = driver.findElement(By.id("quantidade"));
		inputQuantidade.sendKeys("10");
		WebElement inputValorUnitario = driver.findElement(By.id("valorUnitario"));
		inputValorUnitario.sendKeys("5");

		WebElement buttonCalcular = driver.findElement(By.id("calcularBtn"));
		buttonCalcular.click();
		
		Thread.sleep(4000);
		WebElement total = driver.findElement(By.id("valorTotal"));
		
		assertEquals("50", total.getAttribute("value"));

	}
}
