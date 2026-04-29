package b2j.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.fail;

import b2j.wrappers.TaschenrechnerWrapper;
import static de.tum.cit.aet.levenshtein.Utils.saveCast;

public class Tests {
    private static String[] outLines;
    private static PrintStream originalOut;
    private static ByteArrayOutputStream outContent;
    private static TaschenrechnerWrapper<?> h;

    private static double[][] values = {
        { 0, 1 },
        { 1, 1 },
        { 2, 3 },
        { 3, 2 },
        { 5, 7 },
        { 7, 5 },
        { 10, 15 },
        { 15, 10 },
        { 100, 200 },
        { 200, 100 },
        { 1000, 2000 }
    };

    static void setup() {
        h = new TaschenrechnerWrapper<>();
    }

    private static String messageBuilder(double z1, double z2, double expected, double actual, String method) {
        return """ 
            Fehler in Methode %s:
            z1: %f
            z2: %f
            Erwarteter Rückgabewert: %f
            Dein Rückgabewert: %f
        """.formatted(method, z1, z2, expected, actual);
    }

    public static void testAddieren() {
        setup();

        for(int i = 0; i < 4; i++) {
            for (double[] value : values) {
                double z1 = i < 2 ? value[0] : -value[0];
                double z2 = i > 1 ? value[1] : -value[1];

                double expected = z1 + z2;
                double actual = (double) saveCast(h.addieren().invoke(z1, z2), double.class);
                if (Double.compare(expected, actual) != 0) {
                    fail(messageBuilder(z1, z2, expected, actual, "addieren"));
                }
            }
        }
    }
    public static void testSubtrahieren() {
        setup();

        for(int i = 0; i < 4; i++) {
            for (double[] value : values) {
                double z1 = i < 2 ? value[0] : -value[0];
                double z2 = i > 1 ? value[1] : -value[1];

                double expected = z1 - z2;
                double actual = (double) saveCast(h.subtrahieren().invoke(z1, z2), double.class);
                if (Double.compare(expected, actual) != 0) {
                    fail(messageBuilder(z1, z2, expected, actual, "subtrahieren"));
                }
            }
        }
    }
    public static void testMultiplizieren() {
        setup();

        for(int i = 0; i < 4; i++) {
            for (double[] value : values) {
                double z1 = i < 2 ? value[0] : -value[0];
                double z2 = i > 1 ? value[1] : -value[1];

                double expected = z1 * z2;
                double actual = (double) saveCast(h.multiplizieren().invoke(z1, z2), double.class);
                if (Double.compare(expected, actual) != 0) {
                    fail(messageBuilder(z1, z2, expected, actual, "multiplizieren"));
                }
            }
        }
    }

    public static void testDividieren() {
        setup();

        for(int i = 0; i < 4; i++) {
            for (double[] value : values) {
                double z1 = i < 2 ? value[0] : -value[0];
                double z2 = i > 1 ? value[1] : -value[1];

                double expected = z1 / z2;
                double actual = (double) saveCast(h.dividieren().invoke(z1, z2), double.class);
                if (Double.compare(expected, actual) != 0) {
                    fail(messageBuilder(z1, z2, expected, actual, "dividieren"));
                }
            }
        }
    }


    public static void testMittelwert() {
        setup();

        for(int i = 0; i < 4; i++) {
            for (double[] value : values) {
                double z1 = i < 2 ? value[0] : -value[0];
                double z2 = i > 1 ? value[1] : -value[1];

                double expected = (z1 + z2) / 2;
                double actual = (double) saveCast(h.mittelwert().invoke(z1, z2), double.class);
                if (Double.compare(expected, actual) != 0) {
                    fail(messageBuilder(z1, z2, expected, actual, "mittelwert"));
                }
            }
        }
    }


    public static void testPotenzieren() {
        setup();

        for(int i = 0; i < 4; i++) {
            for (double[] value : values) {
                double z1 = i < 2 ? value[0] : -value[0];
                double z2 = i > 1 ? value[1] : -value[1];

                double expected = Math.pow(z1, z2);
                double actual = (double) saveCast(h.potenzieren().invoke(z1, z2), double.class);
                if (Double.compare(expected, actual) != 0) {
                    fail(messageBuilder(z1, z2, expected, actual, "potenzieren"));
                }
            }
        }
    }
}
