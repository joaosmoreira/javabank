package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.model.domain.Bank;
import org.academiadecodigo.javabank.view.AccountView;
import org.academiadecodigo.javabank.view.MenuView;
import org.academiadecodigo.javabank.view.Viewer;

public class MenuController extends Controller implements Init {


    private MenuView menuView;
    private AccountView accountView;

    public MenuController(Bank bank) {
        super(bank);
        menuView = new MenuView(bank);
        accountView = new AccountView(bank);
    }

    private void menuLoop(){
        int userChoice = menuView.getPrompt().getUserInput(menuView.getMainMenu());

        if(userChoice == UserOptions.QUIT.getOption()){
            return;
        }
        accountView.getOperationMap().get(userChoice).execute();
        menuLoop();
    }

    @Override
    public void init() {
        menuView.setMainMenu(menuView.buildMAinMenu());
        menuLoop();
    }
}
