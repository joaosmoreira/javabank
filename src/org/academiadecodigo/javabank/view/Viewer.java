package org.academiadecodigo.javabank.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.application.operations.Operation;
import org.academiadecodigo.javabank.model.domain.Bank;

import java.util.Map;

public abstract class Viewer {
    private Prompt prompt;
    private MenuInputScanner mainMenu;
    private Map<Integer, Operation> operationMap;
    private Bank bank;
    private int accessingCustomerId;

    public Viewer(Bank bank) {
        this.bank = bank;
        this.prompt = new Prompt(System.in, System.out);
    }

    public Prompt getPrompt() {
        return prompt;
    }

    public MenuInputScanner getMainMenu() {
        return mainMenu;
    }

    public Map<Integer, Operation> getOperationMap() {
        return operationMap;
    }

    public Bank getBank() {
        return bank;
    }

    public int getAccessingCustomerId() {
        return accessingCustomerId;
    }

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    public void setMainMenu(MenuInputScanner mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void setOperationMap(Map<Integer, Operation> operationMap) {
        this.operationMap = operationMap;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setAccessingCustomerId(int accessingCustomerId) {
        this.accessingCustomerId = accessingCustomerId;
    }
}
