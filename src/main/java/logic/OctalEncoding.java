package logic;

import java.util.Arrays;
import java.util.StringJoiner;

public class OctalEncoding extends Encoding {
    public OctalEncoding() {
        super("01234567".toCharArray());
    }

    public String toBinary(String octal, boolean withPrint) {
        if (withPrint) System.out.println(octal + " = ");
        BinaryEncoding binaryEncoding = new BinaryEncoding();
        StringBuilder result = new StringBuilder();
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < octal.length(); i++) {
            char c = octal.charAt(i);
            long decimal = toDecimal(String.valueOf(c), false);
            String binary = binaryEncoding.fromDecimal(decimal, false);
            joiner.add(c + " = " + binary);
            result.append(binary);
        }
        if (withPrint) System.out.println(joiner);
        return result.toString();
    }

    public String toHex(String octal, boolean withPrint) {
        if (withPrint) System.out.println(octal + " = ");
        int paddingRequired = 2 - octal.length() % 2;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < paddingRequired; i++) {
            builder.append("0");
        }
        //pads the required amount of zeros
        octal = builder.append(octal).toString();
        String[] blocks = splitInPairs(octal);
        Arrays.stream(blocks).forEach(System.out::print);
        System.out.println();
        StringBuilder resultBuilder = new StringBuilder();
        HexEncoding hexEncoding = new HexEncoding();
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < blocks.length; i++) {
            char result = hexEncoding.getCharacterForDecimalNumber((int) toDecimal(blocks[i], false));
            //should never be true unless an invalid input was provided
            if (result != 0) {
                joiner.add(blocks[i] + " = " + result);
                resultBuilder.append(result);
            } else joiner.add("Invalid input");
        }
        if (withPrint) System.out.println(joiner);
        return resultBuilder.toString();
    }

    private String[] splitInPairs(String binary) {
        String formatted = binary.replaceAll("(?<=\\G\\d{2})", "-");
        return formatted.split("-");
    }
}
