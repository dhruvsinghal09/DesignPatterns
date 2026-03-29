package main.java.LLD.VendingMachine;

import main.java.LLD.VendingMachine.models.Coin;
import main.java.LLD.VendingMachine.models.ItemType;
import main.java.LLD.VendingMachine.models.Item;
import main.java.LLD.VendingMachine.models.ItemShelf;
import main.java.LLD.VendingMachine.repository.ItemInventory;
import main.java.LLD.VendingMachine.service.VendingMachine;
import main.java.LLD.VendingMachine.vendingStates.VendingState;

public class Main {

    public static void main(String[] args) throws Exception {
        ItemInventory itemInventory = new ItemInventory(12);
        fillInventory(itemInventory);
        printInventory(itemInventory);
        VendingMachine vm = new VendingMachine(itemInventory);
        VendingState state = vm.getState();
        state.onPressInsertCashButton(vm);
        VendingState insertMoneyState = vm.getState();
        insertMoneyState.insertCoins(vm, Coin.NICKEL);
        insertMoneyState.insertCoins(vm,Coin.DIME);
        insertMoneyState.insertCoins(vm,Coin.QUARTER);
        System.out.println(vm.getCoins());
        insertMoneyState.onPressSelectProductButton(vm);
        VendingState productSelectionState = vm.getState();
        productSelectionState.cancelButton(vm);
        productSelectionState.selectProduct(vm,101);
    }

    private static void printInventory(ItemInventory itemInventory) {
        System.out.print("The inventory has ");
        for(ItemShelf itemShelf:itemInventory.getItemShelves()){
            if(null!=itemShelf.getItem()){
                System.out.print(itemShelf.getItem().getItem().name() + " ");
            }
        }
    }

    private static void fillInventory(ItemInventory itemInventory){
        for(int i=0;i<3;i++){
            Item item = new Item(ItemType.COKE);
            itemInventory.addItem(item);
        }
        for(int i=3;i<6;i++){
            Item item = new Item(ItemType.PEPSI);
            itemInventory.addItem(item);
        }
        for(int i=6;i<9;i++){
            Item item = new Item(ItemType.FANTA);
            itemInventory.addItem(item);
        }
        for(int i=9;i<12;i++){
            Item item = new Item(ItemType.LIMCA);
            itemInventory.addItem(item);
        }
    }
}
