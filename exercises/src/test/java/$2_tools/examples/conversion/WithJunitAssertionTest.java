
package $2_tools.examples.conversion;

import $2_tools.examples.Person;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.*;

/**
 * This class is just used to check the effect of the script that migrates JUnit assertions to AssertJ assertions.
 */
public class WithJunitAssertionTest {

    @Test
    public void using_various_junit_assertions() {
        List<String> list = newArrayList();
        assertEquals("test context", 0, list.size());
        assertEquals("test context", 0, list.size());
        assertEquals(0, list.size());
        assertEquals(0, list.size());

        list = newArrayList("a", "b", "c");
        assertEquals("test context", 3, list.size());
        assertEquals("test context", 3, list.size());
        assertEquals(3, list.size());
        assertEquals(3, list.size());

        Person joe = new Person("Joe", 39);
        assertEquals("test name", "Joe", joe.getName());
        assertEquals("test age", 39, joe.getAge());
        assertEquals("Joe", joe.getName());
        assertEquals(39, joe.getAge());

        assertEquals("test context", 1.0, 1.1, 0.2);
        assertEquals("test context", 1.0, 1.1, 0.2);
        assertEquals(1.0, 1.1, 0.2);
        assertEquals(1.0, 1.1, 0.2);

        Object[] actual = {"a"};
        Object[] expected = {"a"};
        assertArrayEquals("test context", expected, actual);
        assertArrayEquals("test context", expected, actual);
        assertArrayEquals(expected, actual);
        assertArrayEquals(expected, actual);

        actual = expected;
        assertSame("test context", expected, actual);
        assertSame("test context", expected, actual);
        assertSame(expected, actual);
        assertSame(expected, actual);

        actual = new Object[]{"not the same"};
        assertNotSame("test context", expected, actual);
        assertNotSame("test context", expected, actual);
        assertNotSame(expected, actual);
        assertNotSame(expected, actual);

        actual = null;
        assertNull("test context", actual);
        assertNull("test context", actual);
        assertNull(actual);
        assertNull(actual);

        actual = new Object[]{"not null"};
        assertNotNull("test context", actual);
        assertNotNull("test context", actual);
        assertNotNull(actual);
        assertNotNull(actual);

        assertTrue("test context", actual != null);
        assertTrue("test context", actual != null);
        assertTrue(actual != null);
        assertTrue(actual != null);

        assertFalse("test context", actual == null);
        assertFalse("test context", actual == null);
        assertFalse(actual == null);
        assertFalse(actual == null);
    }
}
