/*****************************
 * Author : Mehedi H Shohag  *
 * CSC 221-Section F         *
 * EMPLID:23614013           *
 *****************************/
import java.util.Scanner;

public class TestStepsToMiles {
    public static void main(String[] args) {
        String Name;
        double height_ft,height_inch;

        StepsToMiles obj1=new StepsToMiles();//first object of StepsToMiles class
        obj1.setName("Jane Doe");           //calls the setName method and initializes the name field
        obj1.setFeet(5);                   //calls the setFeet method and initializes the feet field
        obj1.setInches(4.50);             //calls the setInches method and initializes the inches field

        //Print all the values
        //calls all the getter

        System.out.printf("%13s%s\n","Todays date: ",obj1.currDate());
        System.out.printf("%13s%s\n","Name: ",obj1.getName());
        System.out.printf("%13s%.2f'%.2f\"\n","Height: ",obj1.getFeet(),obj1.getInches());
        System.out.printf("%13s%.2f\n","Stride: ",obj1.strideLength_inches());
        System.out.printf("%13s%,d\n","Steps: ",12345);
        System.out.printf("%13s%.2f miles\n","Walk: ",obj1.miles(12345));

        Scanner keyboard = new Scanner(System.in);  //creates Scanner class object

        System.out.printf("Enter Name : \n");
        Name=keyboard.nextLine();       //takes user input
        System.out.printf("Enter Height (ft and in : \n");
        height_ft= keyboard.nextDouble();    //takes user input
        height_inch= keyboard.nextDouble(); //takes user input

        StepsToMiles obj2=new StepsToMiles();  //second object of StepsToMiles class
        obj1.setName(Name);                   //calls the setName method and initializes the name field
        obj1.setFeet(height_ft);             //calls the setFeet method and initializes the feet field
        obj1.setInches(height_inch);        //calls the setInches method and initializes the inches field

        //Print all the values
        //calls all the getter

        System.out.printf("%13s%s\n","Name: ",obj1.getName());
        System.out.printf("%13s%.2f'%.2f\"\n","Height: ",obj1.getFeet(),obj1.getInches());
        System.out.printf("%13s%.2f\n","Stride: ",obj1.strideLength_inches());
        System.out.printf("%13s%,d\n","Steps: ",1000);
        System.out.printf("%13s%.2f miles\n","Walk: ",obj1.miles(1000));
    }
}
