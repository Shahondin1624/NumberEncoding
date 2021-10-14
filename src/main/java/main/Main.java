package main;

import logic.BinaryEncoding;
import logic.DecimalEncoding;
import logic.HexEncoding;

public class Main {
    public static void main(String[] args) {
        BinaryEncoding binaryEncoding = new BinaryEncoding();
        HexEncoding hexEncoding = new HexEncoding();
        DecimalEncoding decimalEncoding = new DecimalEncoding();

        System.out.println(decimalEncoding.toHex(74L, true));
        System.out.println(decimalEncoding.toHex(45673L, true));
        System.out.println(decimalEncoding.toHex(290350L, true));
        System.out.println(decimalEncoding.toHex(255L, true));
        System.out.println();
        System.out.println(decimalEncoding.toBinary(17L, true));
        System.out.println(decimalEncoding.toBinary(2053L, true));
        System.out.println(decimalEncoding.toBinary(6265L, true));
        System.out.println(decimalEncoding.toBinary(127L, true));
        System.out.println();
        System.out.println(binaryEncoding.toDecimal("1101101010011010", true));
        System.out.println(binaryEncoding.toDecimal("11110000111100001111", true));
        System.out.println(binaryEncoding.toDecimal("10001111011", true));
        System.out.println(binaryEncoding.toDecimal("10011011100", true));
        System.out.println();
        System.out.println(binaryEncoding.toHex("11110001", true));
        System.out.println(binaryEncoding.toHex("1010010111011011", true));
        System.out.println(binaryEncoding.toHex("11011111111100100110", true));
        System.out.println(binaryEncoding.toHex("11111111", true));
        System.out.println();
        System.out.println(hexEncoding.toDecimal("AF34DD", true));
        System.out.println(hexEncoding.toDecimal("212142", true));
        System.out.println(hexEncoding.toDecimal("EBBE", true));
        System.out.println(hexEncoding.toDecimal("FACEB00C", true));
        System.out.println();
        System.out.println(hexEncoding.toBinary("E932A", true));
        System.out.println(hexEncoding.toBinary("BADE5EE", true));
        System.out.println(hexEncoding.toBinary("110110101", true));
        System.out.println(hexEncoding.toBinary("ABBA", true));
    }
}
