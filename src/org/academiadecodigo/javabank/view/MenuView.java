package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.application.Messages;
import org.academiadecodigo.javabank.application.UserOptions;
import org.academiadecodigo.javabank.model.domain.Bank;

public class MenuView extends Viewer implements  Show {

    //falta controller.
    public MenuView(Bank bank) {
        super(bank);
    }
    public MenuInputScanner buildMAinMenu(){
        MenuInputScanner mainMenu =  new MenuInputScanner(UserOptions.getMessages());
        mainMenu.setError(Messages.ERROR_INVALID_OPTION);
        mainMenu.setMessage(Messages.MENU_WELCOME);

        return mainMenu;
    }

    @Override
    public void show() {
        buildMAinMenu();
    }
}
