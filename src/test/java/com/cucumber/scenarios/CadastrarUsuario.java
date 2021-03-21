package com.cucumber.scenarios;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.core.Driver;
import com.cucumber.pages.CadastroDeUsuariosPage;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CadastrarUsuario {

	private static WebDriver driver;
	CadastroDeUsuariosPage page;

	String nomeCorreto = "David Oliveira";
	String emailCorreto = "david@gmail.com";
	String senhaCorreta = "12345678";
	String nomeCorreto2 = "Alvaro Gonçalves";
	String emailCorreto2 = "alvaro@gmail.com";
	String senhaCorreta2 = "87654321";

	@Before
	public void before() {
		page = new CadastroDeUsuariosPage(driver);
	}

	@After(order = 1)
	public void screenshot(Scenario cenario) {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file,
					new File("target//screenshot//" + cenario.getName() + "." + cenario.getLine() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@After(order = 0)
	public void fimDoTeste() {
		Driver.close(driver);
	}

	/**
	 * Metodo: Abre a instância do browser e acessa a URL
	 * 
	 * @return void
	 * @author dalvesoliveira
	 */
	@Dado("que estou acessando a tela de cadastro")
	public void queEstouAcessandoATelaDeCadastro() throws Throwable {
		driver = new Driver().getDriver();
		Driver.acessarURL(driver, "http://prova.stefanini-jgr.com.br/teste/qa/");
	}

	/**
	 * Metodo: Informar e-mail válido
	 * 
	 * @param email
	 * @return void
	 * @author dalvesoliveira
	 */
	@Dado("informo o e-mail {string}")
	public void informoOEMail(String string) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(string);
	}

	/**
	 * Metodo: Informar senha válida
	 * 
	 * @param senha
	 * @return void
	 * @author dalvesoliveira
	 */
	@Dado("informo a senha {string}")
	public void informoASenha(String string) throws Throwable {
		driver.findElement(By.id("password")).sendKeys(string);
	}

	/**
	 * Metodo: Clicar em Cadastrar
	 * 
	 * @return void
	 * @author dalvesoliveira
	 */
	@Quando("clico em Cadastrar")
	public void clicoEmCadastrar() throws Throwable {
		driver.findElement(By.id("register")).click();
	}

	/**
	 * Metodo: Validar cadastro de Usuário sem Nome
	 * 
	 * @return É exibido mensagem de erro "O campo Nome é obrigatório."
	 * @author dalvesoliveira
	 */
	@Então("visualizo mensagem de erro sem nome {string}")
	public void visualizoMensagemDeErroSemNome(String string) throws Throwable {
		String texto = driver.findElement(By.xpath("//*[.='O campo Nome é obrigatório.']")).getText();
		Assert.assertEquals(string, texto);
	}

	/**
	 * Metodo: Informar nome válido
	 * 
	 * @param nome
	 * @return void
	 * @author dalvesoliveira
	 */
	@Dado("informo o nome completo {string}")
	public void informoONomeCompleto(String string) throws Throwable {
		driver.findElement(By.id("name")).sendKeys(string);
	}

	/**
	 * Metodo: Cadastrar Usuário sem Email
	 * 
	 * @return É exibido mensagem de erro "O campo E-mail é obrigatório."
	 * @author dalvesoliveira
	 */
	@Então("visualizo mensagem de erro sem email {string}")
	public void visualizoMensagemDeErroSemEmail(String string) throws Throwable {
		String texto = driver.findElement(By.xpath("//*[.='O campo E-mail é obrigatório.']")).getText();
		Assert.assertEquals(string, texto);
	}

	/**
	 * Metodo: Cadastrar Usuário sem Senha
	 * 
	 * @return É exibido mensagem de erro "O campo Senha é obrigatório."
	 * @author dalvesoliveira
	 */
	@Então("visualizo mensagem de erro sem senha {string}")
	public void visualizoMensagemDeErroSemSenha(String string) throws Throwable {
		String texto = driver.findElement(By.xpath("//*[.='O campo Senha é obrigatório.']")).getText();
		Assert.assertEquals(string, texto);
	}

	/**
	 * Metodo: Cadastrar Usuário sem nenhum dado
	 * 
	 * @return É exibido mensagem de erro "O campo Nome é obrigatório.", "O campo
	 *         E-mail é obrigatório." e "O campo Senha é obrigatório."
	 * @author dalvesoliveira
	 */
	@Então("visualizo mensagem de erro sem informação {string} e {string} e {string}")
	public void visualizoMensagemDeErroSemInformaçãoEE(String string, String string2, String string3) throws Throwable {
		String texto = driver.findElement(By.xpath("//*[.='O campo Nome é obrigatório.']")).getText();
		Assert.assertEquals(string, texto);

		String texto2 = driver.findElement(By.xpath("//*[.='O campo E-mail é obrigatório.']")).getText();
		Assert.assertEquals(string2, texto2);

		String texto3 = driver.findElement(By.xpath("//*[.='O campo Senha é obrigatório.']")).getText();
		Assert.assertEquals(string3, texto3);
	}

	/**
	 * Metodo: Informar Nome incompleto
	 * 
	 * @param nome
	 * @return void
	 * @author dalvesoliveira
	 */
	@Dado("informo o nome {string}")
	public void informoONome(String string) throws Throwable {
		driver.findElement(By.id("name")).sendKeys(string);
	}

	/**
	 * Metodo: Informar e-mail válido
	 * 
	 * @param email
	 * @return void
	 * @author dalvesoliveira
	 */
	@Dado("informo o email {string}")
	public void informoOEmail(String string) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(string);
	}

	/**
	 * Metodo: Cadastrar Usuário com Nome incompleto
	 * 
	 * @return É exibido mensagem de erro "Por favor, insira um nome completo."
	 * @author dalvesoliveira
	 */
	@Então("visualizo mensagem de erro de nome incompleto {string}")
	public void visualizoMensagemDeErroDeNomeIncompleto(String string) throws Throwable {
		String texto = driver.findElement(By.xpath("//*[.='Por favor, insira um nome completo.']")).getText();
		Assert.assertEquals(string, texto);
	}

	/**
	 * Metodo: Informar e-mail inválido
	 * 
	 * @param email
	 * @return void
	 * @author dalvesoliveira
	 */
	@Dado("informo o email inválido {string}")
	public void informoOEmailInválido(String string) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(string);
	}

	/**
	 * Metodo: Cadastrar Usuário com Email inválido
	 * 
	 * @return É exibido mensagem de erro "Por favor, insira um nome completo."
	 * @author dalvesoliveira
	 */
	@Então("visualizo mensagem de erro {string}")
	public void visualizoMensagemDeErro(String string) throws Throwable {
		String texto = driver.findElement(By.xpath("//*[.='Por favor, insira um e-mail válido.']")).getText();
		Assert.assertEquals(string, texto);
	}

	/**
	 * Metodo: Informar senha com menos de 8 caracteres
	 * 
	 * @param senha
	 * @return void
	 * @author dalvesoliveira
	 */
	@Dado("informo a senha com menos caracteres {string}")
	public void informoASenhaComMenosCaracteres(String string) throws Throwable {
		driver.findElement(By.id("password")).sendKeys(string);
	}

	/**
	 * Metodo: Cadastrar Usuário com Senha com menos de 8 caracteres
	 * 
	 * @return É exibido mensagem de erro "A senha deve conter ao menos 8
	 *         caracteres."
	 * @author dalvesoliveira
	 */
	@Então("visualizo mensagem de erro de senha pequena {string}")
	public void visualizoMensagemDeErroDeSenhaPequena(String string) throws Throwable {
		String texto = driver.findElement(By.xpath("//*[.='A senha deve conter ao menos 8 caracteres.']")).getText();
		Assert.assertEquals(string, texto);
	}

	/**
	 * Metodo: Informar Nome Completo
	 * 
	 * @param nome
	 * @return void
	 * @author dalvesoliveira
	 */
	@Dado("informo o nome completo")
	public void informoONomeCompleto() throws Throwable {
		driver.findElement(By.id("name")).sendKeys(nomeCorreto);

	}

	/**
	 * Metodo: Informar E-mail válido
	 * 
	 * @param email
	 * @return void
	 * @author dalvesoliveira
	 */
	@Dado("informo o email")
	public void informoOEmail() throws Throwable {
		driver.findElement(By.id("email")).sendKeys(emailCorreto);
	}

	/**
	 * Metodo: Informar Senha válida
	 * 
	 * @param senha
	 * @return void
	 * @author dalvesoliveira
	 */
	@Dado("informo a senha")
	public void informoASenha() throws Throwable {
		driver.findElement(By.id("password")).sendKeys(senhaCorreta);
	}

	/**
	 * Metodo: Cadastrar Usuário com dados válidos
	 * 
	 * @return É exibido abaixo do formulário uma tabela com os dados do usuário
	 *         informados
	 * @author dalvesoliveira
	 */
	@Então("visualizo os dados preenchidos na tabela de resultados")
	public void visualizoOsDadosPreenchidosNaTabelaDeResultados() throws Throwable {
		String nomeUsuario = driver.findElement(By.id("tdUserName1")).getText();
		String emailUsuario = driver.findElement(By.id("tdUserEmail1")).getText();
		Assert.assertEquals(nomeUsuario, nomeCorreto);
		Assert.assertEquals(emailUsuario, emailCorreto);
	}

	/**
	 * Metodo: Informar Nome do novo usuário válido
	 * 
	 * @param nomeUsuario2
	 * @return void
	 * @author dalvesoliveira
	 */
	@Dado("informo o nome completo novo usuário")
	public void informoONomeCompletoNovoUsuário() throws Throwable {
		driver.findElement(By.id("name")).sendKeys(nomeCorreto2);
	}

	/**
	 * Metodo: Informar E-mail do novo usuário válido
	 * 
	 * @param emailUsuario2
	 * @return void
	 * @author dalvesoliveira
	 */
	@Dado("informo o email	novo usuário")
	public void informoOEmailNovoUsuário() throws Throwable {
		driver.findElement(By.id("email")).sendKeys(emailCorreto2);
	}

	/**
	 * Metodo: Informar Senha do novo usuário válido
	 * 
	 * @param senhaUsuario2
	 * @return void
	 * @author dalvesoliveira
	 */
	@Dado("informo a senha novo usuário")
	public void informoASenhaNovoUsuário() throws Throwable {
		driver.findElement(By.id("password")).sendKeys(senhaCorreta2);
	}

	/**
	 * Metodo: Cadastrar dois Usuário com dados válidos
	 * 
	 * @return É exibido abaixo do formulário uma tabela com os dados dos usuários
	 *         informados, ordenando-os pelo id
	 * @author dalvesoliveira
	 */
	@Então("visualizo os dados dos dois usuários preenchidos na tabela de resultados")
	public void visualizoOsDadosDosDoisUsuáriosPreenchidosNaTabelaDeResultados() throws Throwable {
		String nomeUsuario = driver.findElement(By.id("tdUserName1")).getText();
		String emailUsuario = driver.findElement(By.id("tdUserEmail1")).getText();
		Assert.assertEquals(nomeUsuario, nomeCorreto);
		Assert.assertEquals(emailUsuario, emailCorreto);

		String nomeUsuario2 = driver.findElement(By.id("tdUserName2")).getText();
		String emailUsuario2 = driver.findElement(By.id("tdUserEmail2")).getText();
		Assert.assertEquals(nomeUsuario2, nomeCorreto2);
		Assert.assertEquals(emailUsuario2, emailCorreto2);
	}

	/**
	 * Metodo: Clicar em excluir o primeiro usuário cadastrado
	 * 
	 * @return void
	 * @author dalvesoliveira
	 */
	@Quando("clico em excluir")
	public void clicoEmExcluir() throws Throwable {
		driver.findElement(By.id("removeUser1")).click();
	}

	/**
	 * Metodo: Excluir primeiro Usuário Cadastrado
	 * 
	 * @return É excluida a linha em questão, exibindo a tabela sem interferir nos
	 *         ids dos demais itens e em sua ordenação
	 * @author dalvesoliveira
	 */
	@Então("o primeiro usuário é excluido")
	public void oPrimeiroUsuárioÉExcluido() throws Throwable {
		String nomeUsuario2 = driver.findElement(By.id("tdUserName2")).getText();
		String emailUsuario2 = driver.findElement(By.id("tdUserEmail2")).getText();
		String idUsuario2 = driver.findElement(By.id("tdUserId2")).getText();
		Assert.assertEquals(nomeUsuario2, nomeCorreto2);
		Assert.assertEquals(emailUsuario2, emailCorreto2);
		Assert.assertEquals(idUsuario2, "2");
	}

}
