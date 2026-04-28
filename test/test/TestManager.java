package test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import de.tum.cit.aet.levenshtein.LevenshteinTest;
import static de.tum.cit.aet.levenshtein.StructuralLevenshtein.DetailLevel.ONE_PER_CLASS;
import static de.tum.cit.aet.levenshtein.StructuralLevenshtein.structuralTestFactory;
import wrappers.MainWrapper;



@LevenshteinTest
public class TestManager {

    static MainWrapper<?> mainClz;

    public static MainWrapper<?> mainClz() {
        return mainClz;
    }

    @BeforeAll
    static void beforeAll() {
        mainClz = new MainWrapper<>();
    }

    void testCompilationAndSetup() {
        assertThat(mainClz).isNotNull();
        assertThat(mainClz).isInstanceOf(MainWrapper.class);

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
    void testMain() {
        try {
            Tests.testMain();
        }
        catch (AssertionError e) {
            fail(e.getMessage());
        }
    }



}    

