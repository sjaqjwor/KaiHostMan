package chap3;

import java.util.Random;

public class RandomSequenceTest{

    private static Random generator= new Random();
    static class RandomSequence implements Sequence{
        int low;
        int hight;

        public RandomSequence(int low,int hight){
            this.low=low;
            this.hight=hight;
        }

        @Override
        public boolean hasNext(){
            return true;
        }
        @Override
        public int next(){
            return low+generator.nextInt(hight-low+1);
        }
    }
    public static Sequence randomInts(int low , int hight){
        return new RandomSequence(low,hight);
    }

}
