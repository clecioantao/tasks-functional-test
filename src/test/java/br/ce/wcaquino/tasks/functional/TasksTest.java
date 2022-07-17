package br.ce.wcaquino.tasks.functional;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;


public class TasksTest {
	
	public WebDriver acessarAplicacao() throws MalformedURLException {
    	WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://192.168.2.68:8080/tasks/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;	
	}
	
	@SuppressWarnings("deprecation")
	
	@Test
	public void deveSalavarTarefaComSucesso() throws MalformedURLException {
		
		WebDriver driver = acessarAplicacao();
		
		try {
		
			// clicar em add todo
			driver.findElement(By.id("addTodo")).click();
			
			// escrever descrição
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
			
			// escrever data
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2022");
			
			// clicar em salvar
			driver.findElement(By.id("saveButton")).click();
			
			// validar mensagem
			String mensagem = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Sucesso!", mensagem);
			
		} finally {
			
			// fechar o browser
			driver.quit();			
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void naoDeveSalavarTarefaSemDescricao() throws MalformedURLException {
		
		WebDriver driver = acessarAplicacao();
		
		try {
		
			// clicar em add todo
			driver.findElement(By.id("addTodo")).click();
					
			// escrever data
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2022");
			
			// clicar em salvar
			driver.findElement(By.id("saveButton")).click();
			
			// validar mensagem
			String mensagem = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the task description", mensagem);
			
		} finally {
			
			// fechar o browser
			driver.quit();			
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void naoDeveSalavarTarefaSemData() throws MalformedURLException {
		
		WebDriver driver = acessarAplicacao();
		
		try {
		
			// clicar em add todo
			driver.findElement(By.id("addTodo")).click();
			
			// escrever descrição
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
					
			// clicar em salvar
			driver.findElement(By.id("saveButton")).click();
			
			// validar mensagem
			String mensagem = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the due date", mensagem);
			
		} finally {
			
			// fechar o browser
			driver.quit();			
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void naoDeveSalavarTarefaComDataPassada() throws MalformedURLException {
		
		WebDriver driver = acessarAplicacao();
		
		try {
		
			// clicar em add todo
			driver.findElement(By.id("addTodo")).click();
			
			// escrever descrição
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
			
			// escrever data
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2012");
			
			// clicar em salvar
			driver.findElement(By.id("saveButton")).click();
			
			// validar mensagem
			String mensagem = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Due date must not be in past", mensagem);
			
		} finally {
			
			// fechar o browser
			driver.quit();			
			
		}
		
	}	

}