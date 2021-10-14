package logic;

import java.util.Stack;
import java.util.StringJoiner;

/***
 * Base class that all encodings have to extend and every encoding can use the provided methods to encode from or to decimal
 * #withPrint allows to dis-/enable printing of the calculation path (this should also be implemented this way in every custom encoder)
 */
public abstract class Encoding {
    private final char[] acceptedCharacters;

    public Encoding(char[] acceptedCharacters) {
        this.acceptedCharacters = acceptedCharacters;
    }

    /***
     * Method will apply short division with a remainder and reverse the result (with the stack) for a correct output
     * @return the encoded value as a String
     */
    public String fromDecimal(long number, boolean withPrint) {
        if (withPrint) System.out.println("" + number + " = ");
        Stack<Character> stack = new Stack<>();
        int base = acceptedCharacters.length;
        long curr = number;
        long printCurr = curr;
        while (curr >= base) {
            long r = curr % base;
            stack.push(acceptedCharacters[(int) r]);
            printCurr = curr;
            curr /= base;
            if (withPrint)
                System.out.printf("%d / %d = %d R: %c\n", printCurr, base, curr, acceptedCharacters[(int) r]);
        }
        stack.push(acceptedCharacters[(int) curr]);
        if (withPrint) System.out.printf("%d / %d = %d R: %c\n", curr, base, 0, acceptedCharacters[(int) curr]);
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }

    /***
     * Method will iterate over the provided String and multiply all values to the respective base^i
     * for better readability of the calculation path the order of operations is reversed afterwards
     * @return the decimal value of the provided encoded String
     */
    public long toDecimal(String string, boolean withPrint) {
        if (withPrint) System.out.println(string + " = ");
        char[] reversed = reverse(string);
        long result = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < reversed.length; i++) {
            result += findInAcceptedCharacters(reversed[i]) * Math.pow(getAcceptedCharacters().length, i);
            stack.push(findInAcceptedCharacters(reversed[i]) + " * " + getAcceptedCharacters().length + "^" + i);
        }
        StringJoiner joiner = new StringJoiner(" + ");
        while (!stack.isEmpty()) {
            joiner.add(stack.pop());
        }
        if (withPrint) System.out.println(joiner);
        return result;
    }

    private char[] reverse(String string) {
        char[] rightOrder = string.toCharArray();
        char[] reversed = new char[rightOrder.length];
        Stack<Character> stack = new Stack<>();
        for (char c : rightOrder) {
            stack.push(c);
        }
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = stack.pop();
        }
        return reversed;
    }

    public char[] getAcceptedCharacters() {
        return acceptedCharacters;
    }

    /***
     *
     * @return the position or decimal equal for char c if included in base set
     */
    private int findInAcceptedCharacters(char c) {
        for (int i = 0; i < acceptedCharacters.length; i++) {
            if (acceptedCharacters[i] == c) return i;
        }
        return -1;
    }
}
