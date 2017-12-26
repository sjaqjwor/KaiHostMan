package chap5;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Chap5PracticeExam {

    @Test
    public void test(){
        FileNotFoundExam f = new FileNotFoundExam();
        try{
            ArrayList<Double> list = f.readValue("test.txt");
            list.forEach(s->System.out.println(s));
        }catch (FileNotFoundException ex){
                System.err.println("error 내용 : "+ex.toString());
        }catch (NumberFormatException ex){
               System.err.println("error 내용 : "+ex.toString());
        }
    }

    @Test
    public void test1(){
        FileNotFoundExam f = new FileNotFoundExam();
        try{
            System.out.println(f.sumOfValues("test.txt"));
        }catch (FileNotFoundException ex){
            System.err.println("error 내용 : "+ex.toString());
        }catch (NumberFormatException ex){
            System.err.println("error 내용 : "+ex.toString());
        }
    }

    @Test
    public void test2(){
        Scanner sc=null;
        PrintWriter printWriter=null;
        try{
            sc = new Scanner(Paths.get("test.txt"));
            printWriter = new PrintWriter("text.txt");
            while(sc.hasNext()){
                printWriter.println(sc.next().toLowerCase());
            }
        }catch (IOException ex){

        }finally {
            if(sc!=null) {
                try {

                    sc.close();

                } catch (Exception ex) {

                }
            }
            if(printWriter!=null) {
                try {
                    printWriter.close();
                } catch (Exception ex) {

                }
            }

        }
    }

    @Test
    public void test3(){
        BufferedReader in = null;
        try{
            in = Files.newBufferedReader(Paths.get("text.txt"));
        }catch (IOException ex){
         System.err.println(ex.getMessage());
        }finally {
            if(in!=null)
                try{
                    in.close();
                }catch (IOException ex){
            }
        }
        try(BufferedReader bu = Files.newBufferedReader(Paths.get("text.txt"))){

        }catch (IOException ex){

        }
    }

    @Test
    public void test4(){
        Scanner sc = new Scanner(System.in);
        sc.next();

    }

    @Test
    public void test5(){
        FactorialClass factorialClass = new FactorialClass();
        factorialClass.fact(10);

    }

    @Test
    public void test11(){
        Object object = null;
        assert object!=null;
    }

    @Test
    public void test13(){
        Logger logger = Logger.getLogger("chap5");
        String str= "hello world people sex drug";
        String str1= "aaadssd";
        logger.setFilter((s)->{
            if(s.getMessage().contains("C++") || s.getMessage().contains("drug")||s.getMessage().contains("sex")){
                return false;
            }
            else{
                return true;
            }
        });
        logger.info(str1);
        logger.info(str);


    }

    @Test
    public void test14() throws IOException{
        Logger logger = Logger.getLogger("chap5");
        ConsoleHandler fileHandler = new ConsoleHandler();
        fileHandler.setFormatter(new HtmlFormater());
        logger.addHandler(fileHandler);
        logger.info("test");

    }




}
