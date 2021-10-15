package main;

import logic.BinaryEncoding;
import logic.DecimalEncoding;
import logic.HexEncoding;
import logic.OctalEncoding;

public class Aufgaben {
    public static void main(String[] args) {
        BinaryEncoding binaryEncoding = new BinaryEncoding();
        HexEncoding hexEncoding = new HexEncoding();
        DecimalEncoding decimalEncoding = new DecimalEncoding();
        OctalEncoding octalEncoding = new OctalEncoding();

        System.out.println(decimalEncoding.toHex(54L, true));
        System.out.println(decimalEncoding.toBinary(54L, true));
        System.out.println();
        System.out.println(hexEncoding.toDecimal("14F5B", true));
        System.out.println(hexEncoding.toBinary("14F5B", true));
        System.out.println();
        System.out.println(binaryEncoding.toDecimal("1101111010", true));
        System.out.println(binaryEncoding.toHex("1101111010", true));
        System.out.println();
        System.out.println(decimalEncoding.toHex(5351L, true));
        System.out.println(decimalEncoding.toBinary(5351L, true));
        System.out.println();
        System.out.println(binaryEncoding.toDecimal("1101", true));
        System.out.println(binaryEncoding.toHex("1101", true));
        System.out.println();
        System.out.println(binaryEncoding.toDecimal("1010110", true));
        System.out.println(binaryEncoding.toHex("1010110", true));
        System.out.println();
        System.out.println(hexEncoding.toDecimal("AB3D", true));
        System.out.println(hexEncoding.toBinary("AB3D", true));
        System.out.println();
        System.out.println(decimalEncoding.toHex(195L, true));
        System.out.println(decimalEncoding.toBinary(195L, true));
        System.out.println();
        System.out.println(binaryEncoding.toDecimal("1100110011", true));
        System.out.println(binaryEncoding.toHex("1100110011", true));
        System.out.println();
        System.out.println(decimalEncoding.toHex(3785L, true));
        System.out.println(decimalEncoding.toBinary(3785L, true));
        System.out.println();
        System.out.println(hexEncoding.toDecimal("45EA3", true));
        System.out.println(hexEncoding.toBinary("45EA3", true));
        System.out.println();
        System.out.println(binaryEncoding.toDecimal("10000000", true));
        System.out.println(binaryEncoding.toHex("10000000", true));
        System.out.println();
        System.out.println(decimalEncoding.toHex(63L, true));
        System.out.println(decimalEncoding.toBinary(63L, true));
        System.out.println();
        System.out.println(hexEncoding.toDecimal("C23", true));
        System.out.println(hexEncoding.toBinary("C23", true));
        System.out.println();
        System.out.println(decimalEncoding.toHex(256L, true));
        System.out.println(decimalEncoding.toBinary(256L, true));
        System.out.println();
        System.out.println(binaryEncoding.toDecimal("101111", true));
        System.out.println(binaryEncoding.toHex("101111", true));
        System.out.println();
        System.out.println(decimalEncoding.toOctal(5, true));
        System.out.println(decimalEncoding.toOctal(8L, true));
        System.out.println(decimalEncoding.toOctal(14L, true));
        System.out.println(decimalEncoding.toOctal(16L, true));
        System.out.println(decimalEncoding.toOctal(32L, true));
        System.out.println(decimalEncoding.toOctal(64L, true));
    }
}
