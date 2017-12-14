package chap4.PracticeExam;

import java.util.Objects;

public class LabeledPoint extends Point{
    private String label;

    public LabeledPoint(String label,double x, double y){
        super(x,y);
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }

    public double getX() {
        return x;
    }

    public double getY(){
        return y;
    }

    @Override
    public String toString(){
        return super.toString()+"label : "+this.label;
    }

    @Override
    public boolean equals(Object object){
        if(!(super.equals(object)))return false;
        LabeledPoint lp = (LabeledPoint)object;
        return Objects.equals(this.getLabel(),lp.getLabel());
    }
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(),this.label);
    }
}
