package org.academiadecodigo.javabank;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.controller.MainController;
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.view.MainView;
import org.academiadecodigo.javabank.view.Messages;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
@RunWith (JUnitParamsRunner.class)

public class MainControllerTest {
	
	private MainController mainController;
	private AuthService authService;
	private View mainView;
	private Map<Integer,Controller> controllerMap;
	private Controller controller;
	private Messages messages;
	private static boolean hasPrinted = false;
	
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
		
	}
	
	@Test // if
	public void initTest() {
		mainController.init ();
		verify(mainView).show();
		System.out.println ("=== === 1. TESTE AO INIT === ===");
	}
	
	@Test
	@Parameters ({"1", "2", "3", "4"})
	public void menuSelectionValidOptionsButNotQuit (int i) {
		// exercise
		controllerMap.put (i,controller);
		mainController.onMenuSelection (i);
		
		// verify
		verify (mainView).show ();
		
		if (!hasPrinted) {
			System.out.println ("=== === 2. TESTA TODAS AS OPCOES VALIDAS EXCEPTUANDO QUIT === ===");
			hasPrinted = true;
		}
	}
	
	@Test // testing option quit
	public void menuSelectionQuit () {
		mainController.onMenuSelection (5);
		verifyNoMoreInteractions (controller);
		System.out.println ("=== === 3. TESTE A OPCAO QUIT === ===");
	}
	
	@Test (expected = IllegalStateException.class) // testing an invalid option
	public void menuSelectionInvalidOption()  {
		int option = 7;
		try {
			mainController.onMenuSelection(option);
		} finally {
			System.out.println("=== === 4. TESTE A UMA OPCAO INVALIDA === ===");
		}
	}
}
