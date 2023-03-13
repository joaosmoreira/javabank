package test.java.org.academiadecodigo.javabank;

import o
import org.academiadecodigo.javabank.controller.LoginController;

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
	
	@Test
	public void initTest() {
		loginController.init();
		
	}
}
