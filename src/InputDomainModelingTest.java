import Dom_1.InputDomainModeling;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InputDomainModelingTest {
    private Dom_1.InputDomainModeling setDifferenceChecker;

    @BeforeEach
    public void setup() {
        setDifferenceChecker = new InputDomainModeling();
    }


    Set<Object> set1 = new HashSet<>();
    Set<Object> set2 = new HashSet<>();
    Set<Object> result ;

    //--------------------- INTERFACE BASED  ------------------------

    @Test
    public void testInterfaceBasedBaseCase(){
        set1 = Stream.of("str1", 2, 3).collect(Collectors.toSet());
        set2 = Stream.of(3, 4, "str2").collect(Collectors.toSet());
        result = new HashSet<>(Arrays.asList("str1", 2));

        assertEquals(setDifferenceChecker.setDifference(set1,set2), result);
    }

    @Test
    public void testInterfaceBased2(){
        set1 = Stream.of("str1", 2, 3).collect(Collectors.toSet());
        set2 = Collections.emptySet();

        assertEquals(setDifferenceChecker.setDifference(set1, set2),set1);
    }

    @Test
    public void testInterfaceBased3(){
        set1 = Collections.emptySet();
        set2 = Stream.of(3, 4, "str2").collect(Collectors.toSet());

        assertNull(setDifferenceChecker.setDifference(set1, set2));
    }

    @Test
    public void testShouldThrowNullPointerException1(){
        set1 = null;
        set2 = Stream.of(3, 4, "str2").collect(Collectors.toSet());

        assertThrows(NullPointerException.class, ()-> setDifferenceChecker.setDifference(set1, set2));
    }

    @Test
    public void testShouldThrowNullPointerException2(){
        set1 = Stream.of("str1", 2, 3).collect(Collectors.toSet());
        set2 = null;

        assertThrows(NullPointerException.class, ()-> setDifferenceChecker.setDifference(set1, set2));
    }

    //---------------- FUNCTIONALITY BASED  -------------------------

    @Test
    public void testFunctionalityBased_BaseCase(){
        set1 = Stream.of(1, 2, 3).collect(Collectors.toSet());
        set2 = Stream.of(3, 4, 5).collect(Collectors.toSet());
        result = new HashSet<>(Arrays.asList(1, 2));

        assertEquals(setDifferenceChecker.setDifference(set1, set2),result);
    }

    @Test
    public void testFunctionalityBased2(){
        set1 = Stream.of(1, 2, 3).collect(Collectors.toSet());
        set2 = Stream.of(4, 5, 6).collect(Collectors.toSet());

        assertEquals(setDifferenceChecker.setDifference(set1, set2), set1);
    }

    @Test
    public void testFunctionalityBased3(){
        set1 = Stream.of(1, 2).collect(Collectors.toSet());
        set2 = Stream.of(1, 2, 3).collect(Collectors.toSet());

        assertNull(setDifferenceChecker.setDifference(set1, set2));
    }

    @Test
    public void testFunctionalityBased4(){
        set1 = Stream.of(1, 2, 3).collect(Collectors.toSet());
        set2.add(1);
        result = new HashSet<>(Arrays.asList(2, 3));

        assertEquals(setDifferenceChecker.setDifference(set1, set2), result);
    }

    @Test
    public void testFunctionalityBased5(){
        set1 = Stream.of(1, 2, 3).collect(Collectors.toSet());
        set2 = Stream.of(1, 2, 3).collect(Collectors.toSet());

        assertNull(setDifferenceChecker.setDifference(set1, set2));
    }

}