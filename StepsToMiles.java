/*****************************
 * Author : Mehedi H Shohag  *
 * CSC 221-Section F         *
 * EMPLID:23614013           *
 *****************************/

import java.util.GregorianCalendar;
import java.util.Calendar;

public class StepsToMiles {
    private String name;
    private double feet;
    private double inches;

    /**
     This is the default constructor and it initializes all the member variables.
     */

    public StepsToMiles(){
        name=null;
        feet=-1;
        inches=-1;
    }

    /**
     * This is the non default constructor and sets the name and height of a person.
     * @param name is the name of a person
     * @param feet is the height in feet
     * @param inches is the fraction of the height of a person that user inputs as inch
     */

    public StepsToMiles(String name, double feet, double inches) {
        this.name = name;
        this.feet = feet;
        this.inches = inches;
    }

    /**
     * The getName method returns the persons name
     * @return The value in the name field
     */

    public String getName() {
        return name;
    }

    /**
     * The setName method sets the Name
     * @param name the value, as a String, to store in
     *             the name field
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * The getFeet method returns the persons height in feet
     * @return The value in the feet field
     */
    public double getFeet() {
        return feet;
    }

    /**
     * The setFeet method sets the heights feet portion
     * @param feet the value, as a double, to store in
     *             the feet field
     */

    public void setFeet(double feet) {
        this.feet = feet;
    }

    /**
     * The getInches method returns the persons heights inch portion
     * @return The value in the inches field
     */
    public double getInches() {
        return inches;
    }


    /**
     * The setInches method sets the heights inches portion
     * @param inches the value, as a double, to store in
     *             the inches field
     */
    public void setInches(double inches) {
        this.inches = inches;
    }

    /**
     * This method convert the feet to inches
     * @return the value,as double in inches
     */

    public double height_inches(){
        return feet*12;
    }

    /**
     * This method calculates the stride
     * @return the stride valu,as double
     */
    public double strideLength_inches(){
        double stride = (height_inches()+inches)*0.413;
        return stride;
    }

    /**
     * this method calculates how many miles a person ran based on the user inputs
     * @param steps the value,as int is passed from the user to calculate the total mile
     * @return the value as double,is the total number of mile that a person walks
     */
    public double miles(int steps){
        double miles=(strideLength_inches()*steps)/(12*5280);
        return miles;
    }

    /**
     * This method calculates todays date
     * @return the value as String is the current date,whenever this program has run
     */

    public String currDate(){
        {
            GregorianCalendar today = new GregorianCalendar();
            return today.get(Calendar.MONTH)+"/"+today.get(Calendar.DATE)+"/"+today.get(Calendar.YEAR);
        }
    }



}






    public void printPositions() {
        if (hare < tortoise) {
            for (int i = 0; i < hare; i++) {
                moves[tortoise]='T';

                for (i = 0; i < tortoise - hare; i++) {
                    System.out.printf(" ");
                    System.out.printf("T\n");
                }
            }

        } else {
            for (int i = 0; i < tortoise; i++)
                System.out.printf("T");

            for (int i = 0; i < hare - tortoise; i++) {
                System.out.printf(" ");
                System.out.print("H\n");
            }


        }
    public void printPositions() {
        if (hare < tortoise) {
            for (int i = 0; i < hare; i++) {
                moves[hare]='H';

                for (i = 0; i < tortoise - hare; i++) {
                    moves[tortoise]='T';
                }
            }

        } else {
            for (int i = 0; i < tortoise; i++)
                moves[tortoise]='T';

            for (int i = 0; i < hare - tortoise; i++) {
                moves[hare]='H';
            }