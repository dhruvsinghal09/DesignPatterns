package main.java.LLD.VendingMachine.vendingStates.impl;

import main.java.LLD.VendingMachine.models.Coin;
import main.java.LLD.VendingMachine.models.ItemShelf;
import main.java.LLD.VendingMachine.service.VendingMachine;
import main.java.LLD.VendingMachine.vendingStates.VendingState;

public class DispenseProductVendingState implements VendingState {

    public DispenseProductVendingState(VendingMachine vm, int codeNumber) throws Exception {
        System.out.println("Please collect your item from the tray.");
        dispenseProduct(vm,codeNumber);
    }
    @Override
    public void onPressInsertCashButton(VendingMachine vm) throws Exception {
        throw new Exception("Invalid Selection for current state of machine.");
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
        ItemShelf itemShelf = vm.getItemInventory().getItemShelf(codeNumber);
        itemShelf.setSoldOut(true);
        vm.removeCoins();
        vm.setState(new IdleVendingState());
    }

    @Override
    public void cancelButton(VendingMachine vm) throws Exception {
        throw new Exception("Invalid Selection for current state of machine.");
    }


}
