package chap4.ExampleTest;

public enum Operation {
    ADD{
        public int eval(int a,int b){return a+b;}
    },
    SUBTRACT{
        public int eval(int a , int b){return (a>b ? a-b : b-a);}
    };

    public abstract int eval(int a,int b);
}
