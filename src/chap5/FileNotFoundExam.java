package chap5;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileNotFoundExam {

    int ref=0;

    public ArrayList<Double> readValue(String name) throws FileNotFoundException,NumberFormatException{
        Scanner s = new Scanner(new File(name));
        ArrayList<Double> list= new ArrayList<>();

        while(s.hasNext()){
            list.add(Double.parseDouble(s.next()));
        }
        return list;
    }

    public double sumOfValues(String filename) throws FileNotFoundException,NumberFormatException{
        double sum = 0;
        Scanner s = new Scanner(new File(filename));

        while(s.hasNext()){
            sum+=s.nextDouble();
        }
        return sum;
    }

    public ArrayList<Double> readValueTwo(String name){
        Scanner s ;
        ArrayList<Double> list=null;
        try {
            s = new Scanner(new File(name));
            list = new ArrayList<>();
            while(s.hasNext()){
                list.add(Double.parseDouble(s.next()));
            }
        }catch (FileNotFoundException ex){
            ref=1;
        }catch (NumberFormatException ex){
            ref=2;
        }
        return list;

    }

}
