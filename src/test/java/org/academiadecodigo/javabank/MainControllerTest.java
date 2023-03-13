package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.controller.MainController;
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.view.MainView;
import org.academiadecodigo.javabank.view.Messages;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class MainControllerTest {
	
	private MainController mainController;
	private AuthService authService;
	private View mainView;
	private Map<Integer,Controller> controllerMap;
	private Controller controller;
	private Messages messages;
	
	@Before
	public void setup() {
		mainController = new MainController ();
		authService = Mockito.mock (AuthService.class);
		mainView = Mockito.mock (MainView.class);
		controllerMap = new HashMap<Integer, Controller> ();
		controller = Mockito.mock (Controller.class);
	    messages = Mockito.mock (Messages.class);
		
		mainController.setView (mainView);
		mainController.setAuthService (authService);
		mainController.setControllerMap (controllerMap);
		
		controllerMap.put (1, controller);
	}
	
	@Test // if
	public void initTest() {
		mainController.init ();
		verify(mainView).show();
		System.out.println ("# -----------------------");
		System.out.println ("estou a mostrar se o init do main inicia\n");
	}
	
	@Test // testing option quit
	public void menuSelectionQuit () {
		mainController.onMenuSelection (5);
		verifyNoMoreInteractions (controller);
		System.out.println ("# -----------------------");
		System.out.println ("verifiquei as opcoes e escolhi o quit\n");
	}
	
	@Test (expected = IllegalStateException.class) // testing an invalid option
	public void menuSelectionInvalidOption()  {
		int option = 7;
		mainController.onMenuSelection(option);
	}
	
	@Test //
}
