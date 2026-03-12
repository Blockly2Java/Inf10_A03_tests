package test;

import wrappers.*;


import static levenshtein.StructuralLevenshtein.DetailLevel.ONE_PER_CLASS;
import static levenshtein.StructuralLevenshtein.structuralTestFactory;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import levenshtein.LevenshteinTest;

import java.util.List;



@LevenshteinTest
public class TestManager {

    static TaschenrechnerWrapper<?> mainClz;

    public static TaschenrechnerWrapper<?> mainClz() {
        return mainClz;
    }

    @BeforeAll
    static void beforeAll() {
        mainClz = new TaschenrechnerWrapper<>();
    }

    void testCompilationAndSetup() {
        assertThat(mainClz).isNotNull();
        assertThat(mainClz).isInstanceOf(TaschenrechnerWrapper.class);

    }
    
    @TestFactory
    List<DynamicTest> strukturTests() {
        testCompilationAndSetup();
        return structuralTestFactory(
            ONE_PER_CLASS,
            mainClz
        );
    }

    @Test
    void testAddieren() {
        try {
            Tests.testAddieren();
        }
        catch (AssertionError e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testSubtrahieren() {
        try {
            Tests.testSubtrahieren();
        }
        catch (AssertionError e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testMultiplizieren() {
        try {
            Tests.testMultiplizieren();
        }
        catch (AssertionError e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testDividieren() {
        try {
            Tests.testDividieren();
        }
        catch (AssertionError e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testMittelwert() {
        try {
            Tests.testMittelwert();
        }
        catch (AssertionError e) {
            fail(e.getMessage());
        }
    }
}
