package pl.pragmatists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {

    public static final String ELEMENT = "elements";
    private Stack stack = new Stack(999);

    @Test
    public void newStackShouldBeEmpty() throws Exception {
        assertStackSize(0);
    }

    @Test
    public void afterAddingElementStackIsNotEmpty() throws Exception {
        stack.push(ELEMENT);

        assertStackSize(1);
    }

    @Test
    public void stackSizeAfterPushAndPopShouldBe0() throws Exception {
        stack.push(ELEMENT);
        stack.pop();

        assertStackSize(0);
    }

    @Test(expected = EmptyStackException.class)
    public void poppingFromEmptyStackShouldThrowException() throws Exception {
        stack.pop();
    }

    @Test(expected = FullStackException.class)
    public void pushingAFullStackShouldThrowException() throws Exception {
        stack = new Stack(0);

        stack.push(ELEMENT);
    }

    @Test
    public void popReturnsPushedElement() throws Exception {
        stack.push(ELEMENT);

        String poppedElement = stack.pop();

        assertEquals(ELEMENT, poppedElement);
    }

    @Test
    public void shouldReturnPushedElementsInReverseOrder() throws Exception {
        stack.push("first pushed");
        stack.push("second pushed");

        String firstPopped = stack.pop();
        String secondPopped = stack.pop();

        assertEquals("second pushed", firstPopped);
        assertEquals("first pushed", secondPopped);
    }

    private void assertStackSize(int expectedSize) {
        assertEquals(expectedSize, stack.size());
    }

    private class Stack {
        private int size;
        private String elements[];

        public Stack(int capacity) {
            this.elements = new String[capacity];
        }

        public int size() {
            return size;
        }

        public void push(String element) {
            if (isFull()) {
                throw new FullStackException();
            }
            this.elements[size++] = element;

        }

        private boolean isFull() {
            return size == elements.length;
        }

        public String pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return elements[--size];
        }

        private boolean isEmpty() {
            return size == 0;
        }
    }

    private class EmptyStackException extends RuntimeException {
    }

    private class FullStackException extends RuntimeException {
    }
}
