package com.time.zz.allbar.data;

/**
 * Created by admin on 2017/3/29.
 */
public class Card {
    private String name;
    private int cardId;
    public int  width;

    public int height;

    public Card(int width,int height) {
        this.width=width;
        this.height=height;
    }
    public Card(String name, int cardId){
        this.name=name;
        this.cardId=cardId;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }



}
