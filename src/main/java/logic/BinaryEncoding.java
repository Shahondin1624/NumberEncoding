package logic;

import java.util.Arrays;
import java.util.StringJoiner;

public class BinaryEncoding extends Encoding {

    public BinaryEncoding() {
        super("01".toCharArray());
    }

    public String toHex(String binary, boolean withPrint) {
        if (withPrint) System.out.println(binary + " = ");
        int paddingRequired = 4 - binary.length() % 4;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < paddingRequired; i++) {
            builder.append("0");
        }
        //pads the required amount of zeros
        binary = builder.append(binary).toString();
        String[] blocks = splitInFourths(binary);
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

    public String toOctal(String input, boolean withPrint) {
        return new OctalEncoding().fromDecimal(toDecimal(input, false), withPrint);
    }

    private String[] splitInFourths(String binary) {
        String formatted = binary.replaceAll("(?<=\\G\\d{4})", "-");
        return formatted.split("-");
    }

}
