package estoque;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class JBSelenium extends Steps {
	static WebDriver chromeDriver;

	JBSelenium() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/100942987/Desktop/chromedriver.exe");
		chromeDriver = new ChromeDriver();
		chromeDriver.get("C:/Users/100942987/git/estoque-2018-2/estoque/src/main/webapp/lista-compras.html");
	}

	@Given("estou na lista de compras")
	private static void irParaLista() {

	}

	@When("seleciono o produto '$produto'")
	private static void selecionarProduto(String produto) {
		// TODO Auto-generated method stub
		Select select = new Select(chromeDriver.findElement(By.id("select")));
		select.selectByVisibleText(produto);

	}

	@Then("informo a quantidade '$quantidade'")
	private static void informarQuantidade(String quantidade) {
		// TODO Auto-generated method stub
		WebElement inputQuantidade = chromeDriver.findElement(By.id("quantidade"));
		inputQuantidade.sendKeys(quantidade);

	}

	@Then("informo o valor unitário '$valor' reais")
	private static void informarValorUnitario(String valor) {
		// TODO Auto-generated method stub
		WebElement inputValorUnitario = chromeDriver.findElement(By.id("valorUnitario"));
		inputValorUnitario.sendKeys(valor);

	}

	@Then("confirmo a compra")
	private static void confirmarCompra() {
		// TODO Auto-generated method stub
		WebElement buttonCalcular = chromeDriver.findElement(By.id("calcularBtn"));
		buttonCalcular.click();

	}

	@Then("terei de pagar '$valorPagamento' reais")
	private static void confirmarPagamento(String valorPagamento) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(4000);
		WebElement total = chromeDriver.findElement(By.id("valorTotal"));
		assertEquals(valorPagamento, total.getAttribute("value"));

	}

	// @Test
	public void preencheFormularioFirefox() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:/Users/100942987/Desktop/geckodriver.exe");
		WebDriver fireDriver = new FirefoxDriver();
		fireDriver.get("file:///C:/Users/100942987/git/estoque-2018-2/estoque/src/main/webapp/lista-compras.html");
		Select select = new Select(fireDriver.findElement(By.id("select")));
		select.selectByVisibleText("Manga");
		WebElement inputQuantidade = fireDriver.findElement(By.id("quantidade"));
		inputQuantidade.sendKeys("10");
		WebElement inputValorUnitario = fireDriver.findElement(By.id("valorUnitario"));
		inputValorUnitario.sendKeys("5");

		WebElement buttonCalcular = fireDriver.findElement(By.id("calcularBtn"));
		buttonCalcular.click();

		Thread.sleep(4000);
		WebElement total = fireDriver.findElement(By.id("valorTotal"));

		assertEquals("50", total.getAttribute("value"));

	}

}
