package com.cucumber.pages;

import org.openqa.selenium.WebDriver;

import com.cucumber.uimaps.CadastroDeUsuariosMap;

public class CadastroDeUsuariosPage {
	WebDriver driver;
	CadastroDeUsuariosPage page;

	public CadastroDeUsuariosPage(WebDriver driver) {
		this.driver = driver;
	}

	CadastroDeUsuariosMap cadastroDeUsuariosMap = new CadastroDeUsuariosMap(driver);

	public void escreverNome(String string) {
		cadastroDeUsuariosMap.digitarNome.sendKeys(string);
	}

	public void escreverEmail(String string) {
		cadastroDeUsuariosMap.digitarEmail.sendKeys(string);
	}

	public void escreverSenha(String string) {
		cadastroDeUsuariosMap.digitarSenha.sendKeys(string);
		;
	}

	public void clicarCadastrar(String string) {
		cadastroDeUsuariosMap.clicarCadastrar.click();
	}
}