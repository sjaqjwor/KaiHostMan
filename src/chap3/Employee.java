package chap3;

public class Employee  implements Measurable{

    String name;
    double measurable;


    public Employee(String name, double measurable){
        this.name=name;
        this.measurable=measurable;
    }
    @Override
    public double getMeasurable(){
        return this.measurable;
    }
    public String getName(){
        return this.name;
    }

    public static double average(Measurable[] emplyees){
        double sum=0;
        for(Measurable employee : emplyees){
            sum+=employee.getMeasurable();
        }
        return sum/emplyees.length;
    }
    public static String largest(Measurable[] emplyees){
        double max=0;
        String name=null;
        for(Measurable employee : emplyees){
         if(max<employee.getMeasurable()){
             max=employee.getMeasurable();
             Employee e = (Employee)employee;
             name= e.name;
         }
        }
        return name;
    }

    @Override
    public String toString(){
        return String.format("%s %f",this.name,this.measurable);
    }


}
