package console;

import logic.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/***
 * Takes input during runtime and attempts to evaluate it and calculate the results
 * input must be in form of "source-encoding" (first 3 characters) actual value -> and "target-encoding"
 * (first 3 chars): 'bin 10001 -> dec
 * TODO make the @link{InputParser} more robust against malformed inputs
 */
public class ConverterConsole {
    private static Scanner scanner;
    private static final Map<String, Encoding> encodingMap = new HashMap<>();
    private static InputParser parser = new InputParser();

    public static void main(String[] args) {
        encodingMap.put("bin", new BinaryEncoding());
        encodingMap.put("dec", new DecimalEncoding());
        encodingMap.put("hex", new HexEncoding());
        encodingMap.put("oct", new OctalEncoding());
        scanner = new Scanner(System.in);
        String input = null;
        while (!"exit".equalsIgnoreCase(input)) {
            input = takeInput("Type in your command");
            handleInput(input);
        }
    }

    private static String takeInput(String message) {
        System.out.println(message);
        System.out.print("input>");
        return scanner.nextLine();
    }

    private static void handleInput(String input) {
        if ("exit".equalsIgnoreCase(input)) {
            return;
        } else if ("help".equalsIgnoreCase(input)) {
            System.out.println(String.join(", ", encodingMap.keySet()));
            System.out.println("Enter a command for conversion like: 'bin: 10001 -> hex");
        } else {
            System.out.println(parser.parseInput(input));
        }
    }
}
