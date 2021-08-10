package Chapter20_Stack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * A set of tools which operate on a Stack
 */
public class StackOperations {


    /**
     * Uses Java's streams to generate a Queue object from an existing Stack object in the same order.
     * Use the LinkedLists class since it implements the Queue interface
     *
     * @param stackOriginal the stack to be converted to a Queue
     * @return a queue containing all the elements of the original Stack in the same order
     */
    public static Queue<Character> toQueue(Stack<Character> stackOriginal) {
        Queue<Character> q = new LinkedList<Character>();
        stackOriginal.forEach(ltr -> q.add(ltr));
        return q;

    }

    /**
     * Uses Java's streams to generate a new Stack object from an existing Stack object but in reversed order.
     * The original stack's becomes empty after copied over
     *
     * @param stackOriginal the stack to be reversed
     * @return a new stack containing the same items from the original Stack
     */
    public static Stack<Character> reverseStack(Stack<Character> stackOriginal) {
        Stack <Character> stack = new Stack<Character>();
        Collections.reverse(stackOriginal);
        stackOriginal.forEach(cont -> stack.push(cont));
        return stack;

    }

    /**
     * Uses Java's streams to sum all items between the star and end positions inclusive.
     * Account for invalid ranges such as endPosition < startPosition or large ranges
     *
     * @param stackOriginal the stack with the items to sum
     * @param startPosition the position of the starting element in the sum (included)
     * @param endPosition   the position of the end element in the sum (included)
     * @return the sum of all items between the star and end positions inclusive. The method returns -1 if the sum range is invalid
     */
    public static int sumBetween(Stack<Integer> stackOriginal, int startPosition, int endPosition) {
        double size = stackOriginal.stream().count();
        int sum=0;
        if(startPosition<endPosition&&startPosition>=0&&endPosition<size) {
            sum = IntStream.rangeClosed(0, (int) size).
                    filter(x -> x >= startPosition && x <= endPosition).
                    sum();
            return sum;
        }
        else
            return  -1;
    }

    /**
     * Uses Java's streams to read the characters from InputFile.txt one character at a time.
     * If the character read is a number, it is added to a Stack. Otherwise, the character is simply discarded.
     * In case of an Exception, simply print the stack trace which will cause the method to stop the read process and return.
     * <p>
     * Here is an example which filters the characters from a String
     *
     * <pre>   {@code
     *
     * String line = "abc0123!@#$";
     *   line.chars()
     *       .mapToObj(i -> (char) i)
     *       .forEach(c -> System.out.println(c));
     *
     * }</pre> </p>
     *
     * @param filePath the input file containing alpha-numeric characters
     * @return a stack containing numeric characters only
     */
    public static Stack<Character> readNumericFromFile(final String filePath) throws IOException {
        Stack<Character> number = new Stack<Character>();
        BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
        reader.lines()
                .forEach(i -> i.chars()
                        .mapToObj(j -> (char) j)
                        .filter(k->Character.isDigit(k))
                        .forEach(k->number.add((char)k)));

        return number;
    }

}
