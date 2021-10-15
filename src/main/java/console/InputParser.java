package console;

import logic.BinaryEncoding;
import logic.DecimalEncoding;
import logic.HexEncoding;
import logic.OctalEncoding;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private BinaryEncoding binaryEncoding;
    private DecimalEncoding decimalEncoding;
    private HexEncoding hexEncoding;
    private OctalEncoding octalEncoding;

    protected InputParser() {
        binaryEncoding = new BinaryEncoding();
        decimalEncoding = new DecimalEncoding();
        hexEncoding = new HexEncoding();
        octalEncoding = new OctalEncoding();
    }

    public String parseInput(String input) {
        String[] split = clean(reformat(input).split(" ", -1));
        try {
            String enc = split[0].toLowerCase();
            String value = split[1];
            switch (split[2].toLowerCase()) {
                case "bin" -> {
                    switch (enc) {
                        case "bin" -> {
                            return value;
                        }
                        case "dec" -> {
                            return decimalEncoding.toBinary(Long.parseLong(value), true);
                        }
                        case "hex" -> {
                            return hexEncoding.toBinary(value, true);
                        }
                        case "oct" -> {
                            return octalEncoding.toBinary(value, true);
                        }
                    }
                }
                case "dec" -> {
                    switch (enc) {
                        case "bin" -> {
                            return String.valueOf(binaryEncoding.toDecimal(value, true));
                        }
                        case "dec" -> {
                            return value;
                        }
                        case "hex" -> {
                            return String.valueOf(hexEncoding.toDecimal(value, true));
                        }
                        case "oct" -> {
                            return String.valueOf(octalEncoding.toDecimal(value, true));
                        }
                    }
                }
                case "hex" -> {
                    switch (enc) {
                        case "bin" -> {
                            return binaryEncoding.toHex(value, true);
                        }
                        case "dec" -> {
                            return decimalEncoding.toHex(Long.parseLong(value), true);
                        }
                        case "hex" -> {
                            return value;
                        }
                        case "oct" -> {
                            return octalEncoding.toHex(value, true);
                        }
                    }
                }
                case "oct" -> {
                    switch (enc) {
                        case "bin" -> {
                            return binaryEncoding.toOctal(value, true);
                        }
                        case "dec" -> {
                            return decimalEncoding.toOctal(Long.parseLong(value), true);
                        }
                        case "hex" -> {
                            return hexEncoding.toOctal(value, true);
                        }
                        case "oct" -> {
                            return value;
                        }
                    }
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return "";
    }
    //TODO if an encoding with a base set that contains any of the cleaned characters is created, this method has to be refactored
    private String reformat(String input) {
        return input.replaceAll(":", "").replaceAll("->", "");
    }
    //removes empty strings
    private String[] clean(String[] arr) {
        List<String> list = new ArrayList<>();
        for (String s : arr) {
            if (s != null && !s.isEmpty()) list.add(s);
        }
        return list.toArray(String[]::new);
    }
}
