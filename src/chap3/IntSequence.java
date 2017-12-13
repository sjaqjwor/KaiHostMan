package chap3;


public class IntSequence {

    public static Sequence of(int ...arr){
        return new Sequence(){
            int index=0;

            @Override
            public boolean hasNext(){
                return arr.length>index;
            }
            @Override
            public int next(){
                return arr[index++];
            }
        };
    }

    public static Sequence constant(int num){
        return ()->num;
    }
}
