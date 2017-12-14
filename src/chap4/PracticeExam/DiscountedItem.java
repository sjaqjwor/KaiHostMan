package chap4.PracticeExam;

public class DiscountedItem extends Item{

    private double discount;

    public DiscountedItem(Item item,double discount){
        super(item.getDescription(),item.getPrice());
        this.discount=discount;
    }

    public double getDiscount(){
        return this.discount;
    }

    @Override
    public boolean equals(Object object){
        if(object.getClass() == Item.class){
           return  super.equals(object);
        }
        else if (object.getClass() == DiscountedItem.class){

            super.equals(object);
            DiscountedItem di= (DiscountedItem)object;
            return new Double(di.discount).equals(new Double(this.discount));
        }

            return false;

    }
}
