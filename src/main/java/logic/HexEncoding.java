package logic;

import java.util.StringJoiner;

public class HexEncoding extends Encoding {
    public HexEncoding() {
        super("0123456789ABCDEF".toCharArray());
    }

    public char getCharacterForDecimalNumber(int decimal) {
        if (decimal < 16 && decimal >= 0) {
            return getAcceptedCharacters()[decimal];
        } else return 0;
    }

    /***
     * Each hex character will be converted into a decimal value and afterwards into a binary block
     */
    public String toBinary(String hex, boolean withPrint) {
        if (withPrint) System.out.println(hex + " = ");
        BinaryEncoding binaryEncoding = new BinaryEncoding();
        StringBuilder result = new StringBuilder();
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            long decimal = toDecimal(String.valueOf(c), false);
            String binary = binaryEncoding.fromDecimal(decimal, false);
            joiner.add(c + " = " + binary);
            result.append(binary);
        }
        if (withPrint) System.out.println(joiner);
        return result.toString();
    }

    public String toOctal(String hex, boolean withPrint) {
        if (withPrint) System.out.println(hex + " = ");
        OctalEncoding octalEncoding = new OctalEncoding();
        StringBuilder result = new StringBuilder();
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            long decimal = toDecimal(String.valueOf(c), false);
            String binary = octalEncoding.fromDecimal(decimal, false);
            joiner.add(c + " = " + binary);
            result.append(binary);
        }
        if (withPrint) System.out.println(joiner);
        return result.toString();
    }
}
