package com.cucumber.uimaps;

import org.openqa.selenium.WebDriver;

import com.cucumber.core.Element;
import com.cucumber.enums.ByValue;

public class CadastroDeUsuariosMap {

	WebDriver driver;

	public CadastroDeUsuariosMap(WebDriver driver) {
		this.driver = driver;
	}

	public Element digitarNome = new Element(driver, ByValue.ID, "name");
	public Element digitarEmail = new Element(driver, ByValue.ID, "email");
	public Element digitarSenha = new Element(driver, ByValue.ID, "password");
	public Element clicarCadastrar = new Element(driver, ByValue.ID, "register");

}
