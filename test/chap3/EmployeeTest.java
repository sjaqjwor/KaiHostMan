package chap3;

import chap3.Employee;
import chap3.Measurable;
import org.junit.Test;

import javax.imageio.stream.ImageOutputStream;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class EmployeeTest {

    @Test
    public void employeeAverageTest(){
        Measurable[] employees = new Measurable[4];
        employees[0]=new Employee("이승기",3045);
        employees[1]=new Employee("노욱진",54);
        employees[2]=new Employee("원일준",45);
        employees[3]=new Employee("킴구",454);
        System.out.print(Employee.average(employees));
    }

    @Test
    public void employeeNameTest(){
        Measurable[] employees = new Measurable[4];
        employees[0]=new Employee("이승기",3045);
        employees[1]=new Employee("노욱진",54);
        employees[2]=new Employee("원일준",48885);
        employees[3]=new Employee("킴구",454);
        System.out.print(Employee.largest(employees));

    }

    @Test
    public void superClassTest(){
        System.out.println("String super class or interface");
        System.out.println(String.class.getSuperclass());
        Class<?>[] stringSuper = String.class.getInterfaces();
        Arrays.asList(stringSuper).forEach(s->System.out.println(s));
        System.out.println();
        System.out.println("Scanner super class or interface");
        System.out.println(Scanner.class.getSuperclass());
        Class<?>[] scannerSuper = Scanner.class.getInterfaces();
        Arrays.asList(scannerSuper).forEach(s -> System.out.println(s));
        System.out.println();
        System.out.println("ImageOutOutStream super class or interface");
        System.out.println(ImageOutputStream.class.getSuperclass());
        Class<?>[] imageSuper = ImageOutputStream.class.getInterfaces();
        Arrays.asList(imageSuper).forEach(s -> System.out.println(s));
    }

    @Test
    public void sequenceTest(){
        Sequence sequence = IntSequence.of(3,1,4,1,5,9);
        while(sequence.hasNext()){
            System.out.print(sequence.next()+" ");
        }
    }

    @Test
    public void infinityTest(){
        Sequence sequence = IntSequence.constant(10);
        int count=0;
        while(sequence.hasNext()){

            System.out.println(sequence.next());
            count++;
            if(count==10){
                break;
            }
        }
    }

    @Test
    public void luckSortTest(){
        LuckCollect lc  = new LuckCollect();
        ArrayList<String> list = new ArrayList<String>();
        list.add("b");
        list.add("a");
        list.add("k");
        list.add("d");
        lc.luckySort(list,String::compareTo);
    }
    @Test
    public void greeterTest(){
        Greeter greeter = new Greeter(10,30);
        Greeter greeter1 = new Greeter(20,25);
        Thread thread = new Thread(greeter);
        Thread thread1 = new Thread(greeter1);
        thread.start();
        thread1.start();
    }

    @Test
    public void runTaskTest(){
        Runnable r1= ()->{for(int a=100;a<150;a++){System.out.println(a);}};
        Runnable r2= ()->{for(int a=160;a<200;a++)System.out.println(a);};
        Runnable r3= ()->System.out.println("3");
        Runnable r4= ()->System.out.println("4");
        Greeter.runTogeter(r1,r2,r3,r4);
        Greeter.runInOrder(r1,r2,r3,r4);
    }

    @Test
    public void listFileTest(){
        File file = new File("/home/seungki");
        File[] files = file.listFiles(File::isDirectory);

        for(File file1 : files)
            System.out.println(file1.getName());
        }


    @Test
    public void listFileExtensionTest(){
        File file = new File("/home/seungki/Kaihostman/src/chap3");
        String[] files = file.list((name ,name2) -> name2.startsWith("S"));
        for(String file1 : files){
            System.out.println(file1);
        }
    }


    @Test
    public void sortFIleAndDirectory(){
        File file = new File("/home/seungki");
        File[] files = file.listFiles(File::isDirectory);
        Arrays.sort(files, Comparator.comparing(File::isFile).thenComparing(File::getName));
        for(File file1 : files){
            System.out.println(file1);
        }
    }

    @Test
    public void runableTest(){
        Runnable r1 = () -> System.out.print("승기");
        Runnable r2 = () -> System.out.print("승기1");
        Runnable r3 = () -> System.out.print("승기2");
        Runnable r4 = () -> System.out.print("승기3");
        Runnable runnables = RunnableArray.runnableArrayTest(r1,r2,r3,r4);
        runnables.run();
    }

    @Test
    public void sortMeasureTest(){
        Employee[] employees = new Employee[]{new Employee("승기",456),
                new Employee("승기1",8),new Employee("승기2",78)
        };
        Arrays.sort(employees,Comparator.comparing(Employee::getMeasurable).reversed().thenComparing(Employee::getName));
        for(Employee employee : employees){
            System.out.println(employee.toString());
        }
    }

    @Test
    public void randomSequenceTest(){
        Sequence sequence =RandomSequenceTest.randomInts(10,100);
        int number=0;
        while(sequence.hasNext()){
            number++;
            System.out.println(sequence.next());
            if(number==100){
                break;
            }
        }
    }


}

