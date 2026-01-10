package logic;

import java.util.ArrayList;

public class Item {
    private String name;
    private int pricePerPiece;

    public Item(String name, int pricePerPiece) {
        // TODO
        this.name = name;

        if(pricePerPiece < 1){
            this.pricePerPiece = 1;
        } else {
            this.pricePerPiece = pricePerPiece;
        }
    }

    public String getName() {
        // TODO
        return name;
    }

    public void setName(String name) {
        // TODO
        this.name = name;
    }

    public int getPricePerPiece() {
        // TODO
        return pricePerPiece;
    }

    public void setPricePerPiece(int pricePerPiece) {
        // TODO
        if(pricePerPiece < 1){
            this.pricePerPiece = 1;
        } else {
            this.pricePerPiece = pricePerPiece;
        }
    }
}