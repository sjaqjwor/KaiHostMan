package chap4.PracticeExam;

import java.util.Objects;

public class Item {

    private String description;
    private double price;

    public Item(String description , double price){
        this.description=description;
        this.price=price;
    }

    @Override
    public boolean equals(Object object){

        if(this==object) return true;

        if(!(object instanceof Item)) return false;

        Item it = (Item)object;

        return Objects.equals(this.description,it.description) && new Double(this.price).equals(new Double(it.price));


    }

    public String getDescription(){
        return this.description;
    }

    public double getPrice(){
        return this.price;
    }

    @Override
    public int hashCode(){

        return Objects.hash(this.description,this.price);

    }

}
