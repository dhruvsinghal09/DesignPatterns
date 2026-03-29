package main.java.LLD.VendingMachine.service;

import main.java.LLD.VendingMachine.models.Coin;
import main.java.LLD.VendingMachine.repository.ItemInventory;
import main.java.LLD.VendingMachine.vendingStates.VendingState;
import main.java.LLD.VendingMachine.vendingStates.impl.IdleVendingState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private VendingState state;
    private ItemInventory itemInventory;
    private List<Coin> coinList;

    public VendingMachine(ItemInventory itemInventory){
        this.state=new IdleVendingState();
        this.itemInventory=itemInventory;
        coinList=new ArrayList<>();
    }

    public VendingState getState() {
        return state;
    }

    public void setState(VendingState state) {
        this.state = state;
    }

    public ItemInventory getItemInventory() {
        return itemInventory;
    }

    public void addCoins(Coin coin){
        coinList.add(coin);
    }

    public List<Coin> getCoins(){
        return coinList;
    }

    public List<Coin> removeCoins(){
        List<Coin> returnCoins = new ArrayList<>(coinList);
        coinList.clear();
        return returnCoins;
    }
}
