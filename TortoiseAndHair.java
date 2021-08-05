/*****************************
 * Author : Mehedi H Shohag  *
 * Assignment : 2            *
 * CSC 221-Section F         *
 * EMPLID:23614013           *
 *****************************/

import java.util.Random;

public class TortoiseAndHair {


    static final int MAX_MOVES = 100;           //Total track size
    static final int MAX_ITERATIONS = 2000;    //Total number of race
    Random random = new Random();             //create an instance of Java Random class
    int tortoise = 0;                        //initializes the variable tortoise
    int hare = 0;                           //initializes the variable hare
    int time = 0;                          //initializes the variable time

    /*
    Main method will create an instance of the TortoiseAndHair class
    and will execute all the methods
     */
    public static void main(String[] args) {
        TortoiseAndHair start_race=new TortoiseAndHair();
    }

    /*
    Default constructor will print out some strings and values
    It will call the printPositions(),simulateHareMove() and simulateTortoiseMove() function
    Also it will print the amount of time elapsed and the result of the race
     */
    TortoiseAndHair() {
        int i = 1;
        System.out.printf("ON YOUR MARK,GET SET\n");
        System.out.printf("BANG !!!!!\n");
        System.out.printf("AND THERE YOU OFF !!!!!\n");
        do {
            System.out.printf("Iteration %d",i);
            System.out.printf("\n");
            printPositions();
            simulateHareMove();
            simulateTortoiseMove();

            time++;
            i++;
            System.out.printf("\n-------------------------\n");
        } while (tortoise < MAX_ITERATIONS && hare < MAX_ITERATIONS);

        if (tortoise > hare) {
            System.out.printf("\nTORTOISE WINS!!! YAY!!!");
            System.out.printf("\nTIME ELAPSED = %d seconds", time);
        } else if (hare > tortoise) {
            System.out.printf("\nHARE WINS.Yuch!");
            System.out.printf("\nTIME ELAPSED = %d seconds", time);
        } else if (hare == tortoise) {
            System.out.printf("\nIt's a tie");
            System.out.printf("\nTIME ELAPSED = %d seconds", time);


        } else {
            System.out.printf("\nTimes Out!");

            if (tortoise > hare) {
                System.out.printf("\nTORTOISE WINS!!! YAY!!!");
                System.out.printf("\nTIME ELAPSED = %d seconds", time);
            } else {
                System.out.printf("\nHARE WINS.Yuch!");
                System.out.printf("\nTIME ELAPSED = %d seconds", time);
            }
        }
    }

    /*
    This method will generate a random number between to integers
    @param number1 is the large number
    @param number1 is the small number
    @return The value of the random number in the number variable
     */
    public int randomBetween(int number1, int number2) {
        int number = random.nextInt(number1 - number2 + 1) + number2;
        return number;
    }

    /*
    This method will determine how many blocks the Tortoise will travel
     */
    public void simulateTortoiseMove() {

        int direction = 0;
        switch (random.nextInt(10)) {
            case 1:
                direction = 0;
                break;
            case 2:
                direction = randomBetween(3, 1);
                break;
            case 3:
                direction = randomBetween(3, 1);
                break;
            case 4:
                direction = randomBetween(3, 1);
                break;
            case 5:
                direction = randomBetween(3, 1);
                break;
            case 6:
                direction = -randomBetween(6, 1);
                break;
            case 7:
                direction = -randomBetween(6, 1);
                break;
            case 8:
                direction = -randomBetween(6, 1);
                break;
            case 9:
                direction = randomBetween(1, 0);
                break;
            case 10:
                direction = randomBetween(1, 0);
                break;
        }
        if (tortoise + direction < 0)
            tortoise = 0;
        else
            tortoise += direction;

    }


    /*
    This method will determine how many blocks the Hare will travel
     */
    public void simulateHareMove() {

        int direction = 0;
        switch (random.nextInt(10)) {
            case 1:
                direction = 0;
                break;
            case 2:
                direction = randomBetween(5, 1);
                break;
            case 3:
                direction = randomBetween(5, 1);
                break;
            case 4:
                direction = randomBetween(5, 1);
                break;
            case 5:
                direction = -randomBetween(2, 1);
                break;
            case 6:
                direction = -randomBetween(2, 1);
                break;
            case 7:
                direction = -randomBetween(7, 1);
                break;
            case 8:
                direction = randomBetween(1, 0);
                break;
            case 9:
                direction = randomBetween(1, 0);
                break;
            case 10:
                direction = randomBetween(1, 0);
                break;
        }
        if (hare + direction < 0)
            hare = 0;
        else
            hare += direction;


    }

    /*
    This method will print out the position of the hare and tortoise in the area
     */
    public void printPositions() {
        if (hare < tortoise) {
            for (int i = 0; i < hare; i++) {
                System.out.printf("H");

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

    }

}
