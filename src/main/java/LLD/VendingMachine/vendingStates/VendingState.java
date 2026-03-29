package main.java.LLD.VendingMachine.vendingStates;

import main.java.LLD.VendingMachine.models.Coin;
import main.java.LLD.VendingMachine.service.VendingMachine;

public interface VendingState {

    void onPressInsertCashButton(VendingMachine vm) throws Exception;
    void insertCoins(VendingMachine vm, Coin coin) throws Exception;
    void onPressSelectProductButton(VendingMachine vm) throws Exception;
    void selectProduct(VendingMachine vm,int codeNumber) throws Exception;
    void dispenseProduct(VendingMachine vm,int codeNumber) throws Exception;

    void cancelButton(VendingMachine vm) throws Exception;
}
