package com.jsystems.qa.quajunit;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Junit test")
@Tag("unit")
public class JunitTest {

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
