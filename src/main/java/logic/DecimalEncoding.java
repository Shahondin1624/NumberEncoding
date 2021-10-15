package logic;

public class DecimalEncoding extends Encoding {
    public DecimalEncoding() {
        super("0123456789".toCharArray());
    }

    public String toHex(long number, boolean withPrint) {
        return new HexEncoding().fromDecimal(number, withPrint);
    }

    public String toBinary(long number, boolean withPrint) {
        return new BinaryEncoding().fromDecimal(number, withPrint);
    }

    public String toOctal(long number, boolean withPrint) {
        return new OctalEncoding().fromDecimal(number, withPrint);
    }
}
