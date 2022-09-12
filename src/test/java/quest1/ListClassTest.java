package quest1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListClassTest {
    ListClass<Integer> testList = new ListClass<>();
    int expectedListSize = 0;

    @Test
    public void add() {

        int result = testList.add(0);
        expectedListSize = 1;
        assertEquals(result, testList.get(0), "Method returns wrong value");
        assertEquals(0, testList.get(0), "Elements don't equals");
        assertEquals(expectedListSize, testList.size(), "Размер должен быть равен 1");
    }

    @Test
    void add2() {
        for (int i = 0; i < 10; i++) {
            testList.add(i);
        }
        expectedListSize = 11;
        assertEquals(expectedListSize, testList.size(), "Size must be 11");
    }

    @Test
    void testAdd() {
        testList.add(0, 1);
        assertEquals(1, testList.get(0), "Elements don't equals");
        testList.add(0, 2);
        expectedListSize = 2;
        assertEquals(2, testList.get(0), "Elements don't equals");
        assertEquals(2, testList.size(), "Size is wrong");


    }

    @Test
    void replace() {
        int replacingElement = 5;
        int replacedElement = 1;
        testList.add(replacedElement);
        int result = testList.replace(replacingElement, 0);
        assertEquals(result, replacedElement, "Method returns wrong value");
        assertEquals(replacingElement, testList.get(0), "Elements don't equals");

    }

    @Test
    void removeByElement() {
        testList.add(1);
        testList.add(2);
        testList.add(3);
        int size = testList.size();
        int result = testList.remove(Integer.valueOf(2));
        assertEquals(size - 1, testList.size(), "Method doesn't reduce size");
        assertEquals(result, 2, "Method returns wrong value");


    }
    @Test
    void removeByIndex() {
        testList.add(1);
        testList.add(2);
        testList.add(3);
        int size = testList.size();
        int result = testList.remove(0);
        assertEquals(size - 1, testList.size(), "Method doesn't reduce size");
        assertEquals(result, 1, "Method returns wrong value");
    }

    @Test
    void size() {
        int oldSize = 0;
        testList.add(5);
        assertEquals(oldSize + 1, testList.size(), "Size must be 1");
    }

    @Test
    void reduce() {
        testList.add(1);
        testList.add(null);
        testList.add(2);
        testList.add(null);
        int oldSize = testList.size();
        testList.reduce();
        assertNotNull(testList.get(0), "Element is Null");
        assertNotNull(testList.get(1), "Element is Null");
        assertEquals(oldSize - 2, testList.size(), "Method doesn't reduce size");
    }

    @Test
    void toArray() {
        Integer[] array = new Integer[10];
        testList.add(1);
        testList.add(2);
        testList.toArray(array);
        assertEquals(1, array[0], "Method returns wrong value");
        assertEquals(2, array[1], "Method returns wrong value");
    }
}