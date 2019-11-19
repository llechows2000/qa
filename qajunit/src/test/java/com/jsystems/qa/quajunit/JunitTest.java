package com.jsystems.qa.quajunit;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Junit test")
@Tag("unit")

public class JunitTest extends ConfigJunit {

    @BeforeEach
    public void setupEach(TestInfo testInfo) {
        System.out.println("===================BeforeEach===========================");
        System.out.println(testInfo.getDisplayName());
        System.out.println(testInfo.getTags());
        System.out.println(testInfo.getTestMethod());
    }
    @AfterEach
    public void tearDownEach(){
        System.out.println("=====================AfterEach==========================");
    }

    final String stringTestowy = "stringTestowy";

    @DisplayName("First unit test")
    @Tag("first")
    @Test
    @Disabled("bug: import, JiRA 1230")
    //@RepeatedTest(5)
    public void firstTest() {
        assertTrue(stringTestowy.contains("tr"));
        assertTrue(5 == 2 + 3, "message test result");
        assertFalse(stringTestowy.contains("z"));
        //assertThat(stringTestowy).contains("k");
        assertThat(stringTestowy).isEqualTo("stringTestowy");
        assertThat(stringTestowy).doesNotMatch("[0-9]");
        assertThat(stringTestowy).endsWith("wy");
    }

    @Tag("second")
    @Test
    public void secondTest(){
        System.out.println(0.2*0.2);
        double  result = new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue();
        System.out.println(result);
        assertTrue(result == 0.04);
        //assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue());
    }

    @Test
    public void stringTest(){
        String simpleString = "simpleString";
        String simple = "simpleString";
        String simpleString_2 = new String("simpleString");
        String simpleString_3 = new String("simpleString");
        assertTrue(simpleString == "simpleString");
        assertTrue(simpleString == simple);
        assertFalse(simpleString == simpleString_2);
        assertFalse(simpleString_2 == simpleString_3);
        assertTrue(simpleString.equals(simple));
        assertTrue(simpleString_2.equals(simpleString_3));
        int a = 1;
        Integer a_1 = 1;

    }

    @Test
    public void mainTxCompareTest(){
        String resultString = "Wordpress powers 34% of the internet";
        String expectedString = "Wordpress powers [number]% of the internet";

        assertTrue(resultString.startsWith("Wordpress powers "));
        assertTrue(resultString.endsWith("% of the internet"));
        assertThat(resultString).matches("(Wordpress powers )\\d*(% of the internet)");

        String result = resultString.replace("Wordpress powers ", "").replace("% of the internet","");
        int resultNumber = Integer.parseInt(result);
        assertTrue(resultNumber >= 0);
        assertTrue(resultNumber <= 100);

    }
/*
    @Test
    public void mainTperCompareTest(){
        String resultString = "Wordpress powers 34.44% of the internet";
        String expectedString = "Wordpress powers [number]% of the internet";

        assertTrue(resultString.startsWith("Wordpress powers "));
        assertTrue(resultString.endsWith("% of the internet"));
        //assertThat(resultString).matches("(Wordpress powers )\\d+(% of the internet)");

        String result = resultString.replace("Wordpress powers ", "").replace("% of the internet","");
        double resultNumber = Double.parseDouble(result);
        System.out.println(resultNumber);
        //assertTrue(resultNumber >= 0);
        //assertTrue(resultNumber <= 100);

    }
*/
    @Nested
    public class NestedTest {

        List<Integer>  list1 = Arrays.asList(1,2,3,4,5);
        List<Integer>  list2 = Arrays.asList(3,4,5);

        @Test
        public void fisrtNestedTest(){
            assertTrue(list1.containsAll(list2)); //sprawdzenie czy jedna lista zawiera się w drugiej
            assertThat(list1).hasSize(5);
            assertThat(list1).containsAnyOf(1,2,3);
        }
        @Test
        public void secondNestedTest(){

        }
    }

}
