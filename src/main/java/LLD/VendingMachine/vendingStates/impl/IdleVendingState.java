package main.java.LLD.VendingMachine.vendingStates.impl;

import main.java.LLD.VendingMachine.models.Coin;
import main.java.LLD.VendingMachine.service.VendingMachine;
import main.java.LLD.VendingMachine.vendingStates.VendingState;

public class IdleVendingState implements VendingState {
    @Override
    public void onPressInsertCashButton(VendingMachine vm) {
        System.out.println("Please insert the coins.");
        vm.setState(new InsertMoneyVendingState());
    }

    @Override
    public void insertCoins(VendingMachine vm, Coin coin) throws Exception {
        throw new Exception("Invalid Selection for current state of machine.");
    }

    @Override
    public void onPressSelectProductButton(VendingMachine vm) throws Exception {
        throw new Exception("Invalid Selection for current state of machine.");
    }

    @Override
    public void selectProduct(VendingMachine vm, int codeNumber) throws Exception {
        throw new Exception("Invalid Selection for current state of machine.");
    }

    @Override
    public void dispenseProduct(VendingMachine vm,int codeNumber) throws Exception {
        throw new Exception("Invalid Selection for current state of machine.");
    }

    @Override
    public void cancelButton(VendingMachine vm) throws Exception {
        throw new Exception("Invalid Selection for current state of machine.");
    }
}
