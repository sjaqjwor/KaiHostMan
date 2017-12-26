package chap5;

public class FactorialClass {

    public int fact(int n){
        try{
            throw new Exception();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        if(n<=1){
            return  n;
        }else{
            return fact(n-1)*n;
        }
    }
}
