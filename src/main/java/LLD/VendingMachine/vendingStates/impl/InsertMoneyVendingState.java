package main.java.LLD.VendingMachine.vendingStates.impl;

import main.java.LLD.VendingMachine.models.Coin;
import main.java.LLD.VendingMachine.service.VendingMachine;
import main.java.LLD.VendingMachine.vendingStates.VendingState;

public class InsertMoneyVendingState implements VendingState {
    @Override
    public void onPressInsertCashButton(VendingMachine vm) throws Exception {
        throw new Exception("Invalid Selection for current state of machine.");
    }

    @Override
    public void insertCoins(VendingMachine vm, Coin coin) {
        vm.addCoins(coin);
    }

    @Override
    public void onPressSelectProductButton(VendingMachine vm) {
        System.out.println("Please select the product and enter the product's codeNumber.");
        vm.setState(new ProductSelectionVendingState());
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
        vm.setState(new IdleVendingState());
        throw new Exception("Transaction cancelled by the user. Please collect the coins if any from the tray.");
    }
}
