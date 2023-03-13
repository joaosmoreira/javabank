package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.view.LoginView;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class LoginControllerTest {
	
	private LoginController loginController;
	private AuthService authService;
	private View loginView;
	private Controller nextController;
	
	
	@Before
	public void setup() {
		loginController = new LoginController ();
		authService = Mockito.mock(AuthService.class);
		loginView = Mockito.mock(LoginView.class);
		nextController = Mockito.mock(Controller.class);
		
		loginController.setNextController (nextController);
		loginController.setView(loginView);
		loginController.setAuthService(authService);
	}
	
	@Test // testint if init is showing/starting
	public void initTest() {
		loginController.init();
		verify(loginView).show ();
		System.out.println ("# ------------------------------");
		System.out.println ("estou a mostrar o cocó do init\n");
	}
	
	@Test // if authentication is ok
	public void loginWorking () {
		// setup
		int id = 5;
		when (authService.authenticate (id)).thenReturn (true);
		
		// exercise
		loginController.onLogin (id);
		
		// verify
		verify (nextController).init ();
		verify (loginView, never ()).show ();
		System.out.println ("# ------------------------------");
		System.out.println ("passei tá ok\n");
	}
	
	@Test // if authentication is nok
	public void loginNotWorking () {
		int id = 10;
		when (authService.authenticate (id)).thenReturn (false);
		
		loginController.onLogin (id);
		
		verify (nextController, never ()).init ();
		verify (loginView).show ();
		System.out.println ("# ------------------------------");
		System.out.println ("não passei tá ok também\n");
	}
}
