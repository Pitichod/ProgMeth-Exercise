package logic;

public class OrderItem {
    private Item item;
    private int itemAmount;

    public OrderItem(Item item, int itemAmount) {
        this.item = item;
        if(itemAmount > 0){
            this.itemAmount = itemAmount;
        } else {
            this.itemAmount = 0;
        }
    }

    public void increaseItemAmount(int amount) {
        if (amount > 0) {
            this.itemAmount += amount;
        }
    }

    public int calculateTotalPrice() {
        //TODO
        return item.getPricePerPiece() * this.itemAmount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        if(itemAmount > 0) {
            this.itemAmount = itemAmount;
        } else {
            this.itemAmount = 0;
        }
    }
}
