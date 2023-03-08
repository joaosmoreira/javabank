import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;

public class Main {
	public static void main (String[] args) {
		
		Prompt prompt = new Prompt (System.in, System.out);
		
		// criar gestor
		AccountManager manager = new AccountManager ();
		
		// criar banco
		Bank bank = new Bank (manager);
		
		// criar novo cliente
		Customer customer = new Customer ();
		bank.addCustomer (customer);
		
		// passo para inserir numero da conta
		IntegerInputScanner accountNumber = new IntegerInputScanner ();
		accountNumber.setMessage ("Please insert your customer number:\n");
		prompt.getUserInput (accountNumber);
		
		while (true) {
			// opcoes do menu
			String[] menuOptions = {
					"View Balance",
					"Make Deposit",
					"Make Withdrawal",
					"Open Account",
					"Quit"
			};
			
			// criar e e mostrar menu
			MenuInputScanner menu = new MenuInputScanner (menuOptions);
			menu.setMessage ("Welcome to Javabank.\n");
			int menuID = prompt.getUserInput (menu);
			
			
			switch (menuID) {
				case 1:
					System.out.println (customer.getBalance () + " €\n");
					break;
				case 2:
					IntegerInputScanner deposit = new IntegerInputScanner ();
					deposit.setMessage ("Please insert amount:\n");
					int amount = prompt.getUserInput (deposit);
					
					System.out.println (customer.getBalance () + "€\n");
					break;
				case 3:
					
					break;
				case 4:
					int idCustomer = customer.openAccount (AccountType.CHECKING);
					System.out.println ("criei novo costumer " + idCustomer);
					break;
				case 5:
					System.exit (0);
					break;
			}
			
		}
		
	}
}