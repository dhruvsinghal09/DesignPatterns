package main.java.LLD.VendingMachine.repository;

import main.java.LLD.VendingMachine.models.Item;
import main.java.LLD.VendingMachine.models.ItemShelf;

public class ItemInventory {

    private ItemShelf[] itemShelves;

    public ItemInventory(int noOfShelves){
        itemShelves=new ItemShelf[noOfShelves];
        initializeEmptyShelves();
    }

    public ItemShelf[] getItemShelves(){
        return itemShelves;
    }

    private void initializeEmptyShelves() {
        int codeNumber=100;
        for(int i=0;i<itemShelves.length;i++){
            ItemShelf itemShelf = new ItemShelf(codeNumber);
            itemShelves[i]=itemShelf;
            codeNumber++;
        }
    }

    public void addItem(Item item){
        for(ItemShelf itemShelf:itemShelves){
            if(null==itemShelf.getItem()){
                itemShelf.setItem(item);
                return;
            }
        }
        throw new RuntimeException("ItemShelfs are all full. Couldn't add the item RN.");
    }

    public Item getItem(int codeNumber) throws Exception {
        ItemShelf itemShelf = getItemShelf(codeNumber);
        return itemShelf.getItem();
    }

    public ItemShelf getItemShelf(int codeNumber) throws Exception {
        for(ItemShelf iS:itemShelves){
            if(iS.getCodeNumber()==codeNumber)
                return iS;
        }
        throw new Exception("There is no itemShelf with codeNumber " + codeNumber);
    }
}
