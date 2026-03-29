package main.java.LLD.VendingMachine.vendingStates.impl;

import main.java.LLD.VendingMachine.models.Coin;
import main.java.LLD.VendingMachine.models.Item;
import main.java.LLD.VendingMachine.repository.ItemInventory;
import main.java.LLD.VendingMachine.service.VendingMachine;
import main.java.LLD.VendingMachine.vendingStates.VendingState;

public class ProductSelectionVendingState implements VendingState {
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
        ItemInventory itemInventory =vm.getItemInventory();
        Item item = itemInventory.getItem(codeNumber);
        int itemPrice = item.getPrice();
        System.out.println("Selected item's price is " +  itemPrice);
        int receivedCash = vm.getCoins().stream().mapToInt(Coin::getValue).sum();
        System.out.println("Received coins are " +  receivedCash);
        if(receivedCash<itemPrice)
            throw new Exception("Received Coins < Item Price. Transaction cancelled.");
        getChange(vm,receivedCash-itemPrice);
        vm.setState(new DispenseProductVendingState(vm,codeNumber));
    }

    private void getChange(VendingMachine vm, int diff) {
        if(diff==0)
            return;
        for (Coin coin : Coin.values()) {
            if (diff%coin.getValue()==0) {
                System.out.println("Please collect you change of " + diff/coin.getValue() + " " + coin.name() + " coins.");
                return;
            }
        }

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
