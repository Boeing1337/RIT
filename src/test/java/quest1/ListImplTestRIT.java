package quest1;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

class ListImplTestRIT {

    private final List<MyClass> target = new ListClass<>();

    @Test
    void addTwo() {
        var addedElements = 2;
        fillList(addedElements);
        assertEquals(addedElements, target.size(), format("Size must be %s, but was %s", addedElements, target.size()));
    }

    @Test
    void testAddTen() {
        var addedElements = 10;
        fillList(addedElements);
        assertEquals(addedElements, target.size(), format("Size must be %s, but was %s", addedElements, target.size()));
    }

    @Test
    void testAddByIndex1ContainsThreeElements() {
        var addedIndex = 1;
        var expectedSize = 4;
        var elementIndex1 = new MyClass(10);
        var addedElement = new MyClass(100);

        fillList(1);
        target.add(elementIndex1);
        fillList(1);

        var result = target.add(addedIndex, addedElement);
        assertAll(
                () -> assertEquals(
                        expectedSize, target.size(), format("Size must be %s, but was %s", expectedSize, target.size())
                ),
                () -> assertEquals(
                        elementIndex1,
                        result, format("Returned object after adding by index %s doesn't equals the added", addedElement)
                ),
                () -> assertNotEquals(
                        addedElement,
                        target.get(0), format("Element added by index %s was added in the wrong index %s", addedIndex, 0)
                ),
                () -> assertEquals(
                        addedElement,
                        target.get(addedIndex), format("Element added by index %s isn't equals to the added", addedIndex)
                ),
                () -> assertNotEquals(
                        addedElement,
                        target.get(2), format("Element added by index %s was added in the wrong index %s", addedIndex, 2)
                )
        );

    }

    @Test
    void replaceByIndex1WhenSize3() {
        var replacedIndex = 1;
        var expectedSize = 3;
        var elementIndex1 = new MyClass(10);
        var addedElement = new MyClass(100);

        fillList(1);
        target.add(elementIndex1);
        fillList(1);

        var result = target.replace(addedElement, replacedIndex);

        assertAll(
                () -> assertEquals(
                        expectedSize, target.size(), format("Size must be %s, but was %s", expectedSize, target.size())
                ),
                () -> assertEquals(
                        elementIndex1,
                        result, format("Returned object after replacing by index %s doesn't equals the replaced", replacedIndex)
                ),
                () -> assertNotEquals(
                        addedElement,
                        target.get(0), format("Element replaced by index %s was added in the wrong index %s", replacedIndex, 0)
                ),
                () -> assertEquals(
                        addedElement,
                        target.get(1), format("Element replaced by index %s was added in the wrong index %s", replacedIndex, 1)
                ),
                () -> assertNotEquals(
                        addedElement,
                        target.get(2), format("Element replaced by index %s was added in the wrong index %s", replacedIndex, 2)
                )
        );
    }

    @Test
    void replaceByIndex1WhenSize2() {
        var replacedIndex = 1;
        var expectedSize = 2;
        var elementIndex1 = new MyClass(10);
        var addedElement = new MyClass(100);

        fillList(1);
        target.add(elementIndex1);

        var result = target.replace(addedElement, replacedIndex);

        assertAll(
                () -> assertEquals(
                        expectedSize, target.size(), format("Size must be %s, but was %s", expectedSize, target.size())
                ),
                () -> assertEquals(
                        elementIndex1,
                        result, format("Returned object after replacing by index %s doesn't equals the replaced", replacedIndex)
                ),
                () -> assertNotEquals(
                        addedElement,
                        target.get(0), format("Element replaced by index %s was added in the wrong index %s", replacedIndex, 0)
                ),
                () -> assertEquals(
                        addedElement,
                        target.get(1), format("Element replaced by index %s was added in the wrong index %s", replacedIndex, 1)
                )
        );
    }

    @Test
    void removeByIndex9WhenSize10() {
        var removedIndex = 9;
        var expectedSize = 9;
        var elementIndex9 = new MyClass(10);

        fillList(9);
        target.add(elementIndex9);

        var result = target.remove(removedIndex);

        assertAll(
                () -> assertEquals(
                        expectedSize, target.size(), format("Size must be %s, but was %s", expectedSize, target.size())
                ),
                () -> assertEquals(
                        elementIndex9,
                        result, format("Returned object after removing by index %s doesn't equals the replaced", removedIndex)
                )
        );
    }

    @Test
    void removeByObject() {
        var removedIndex = 9;
        var expectedSize = 9;
        var elementIndex9 = new MyClass(10);

        fillList(9);
        target.add(elementIndex9);

        var result = target.remove(new MyClass(10));

        assertAll(
                () -> assertEquals(
                        expectedSize, target.size(), format("Size must be %s, but was %s", expectedSize, target.size()
                        )
                ),
                () -> assertEquals(
                        elementIndex9,
                        result, format("Returned object after removing by index %s doesn't equals the replaced", removedIndex)
                )
        );
    }

    @Test
    void removeNull() {
        var expectedSize = 3;

        fillList(3);
        var result = target.remove(null);

        assertAll(
                () -> assertEquals(
                        expectedSize, target.size(), format("Size must be %s, but was %s after remove null", expectedSize, target.size())
                ),
                () -> assertNull(result, "Returned object after removing by null %s must be null")
        );
    }

    @Test
    void size() {
        assertEquals(0, target.size(), format("Size must be 0 if no elements added but was %s", target.size()));

        fillList(1);
        assertEquals(1, target.size(), format("Size must be 1 if 1 element added but was %s", target.size()));

        fillList(9);
        assertEquals(10, target.size(), format("Size must be 10 if 10 elements added but was %s", target.size()));
    }

    @Test
    void reduceWithNullOnly() {
        target.add(null);
        target.reduce();
        assertEquals(0, target.size(), "Size must be 0 after reducing if only null values was presented");
    }

    @Test
    void toArrayAfterAdding3Elements() {
        var myClass1 = new MyClass(1);
        var myClass2 = new MyClass(2);
        var myClass3 = new MyClass(3);
        var expectedArray = new MyClass[]{myClass1, myClass2, myClass3};

        target.add(myClass1);
        target.add(myClass2);
        target.add(myClass3);

        assertArrayEquals(expectedArray, target.toArray(new MyClass[0]));
    }

    @Test
    void toArrayAfterReduce() {
        var myClass1 = new MyClass(1);
        var myClass2 = new MyClass(2);
        var myClass3 = new MyClass(3);
        var expectedArray = new MyClass[]{myClass1, myClass2, myClass3};

        target.add(null);
        target.add(null);
        target.add(myClass1);
        target.add(null);
        target.add(null);
        target.add(myClass2);
        target.add(null);
        target.add(null);
        target.add(myClass3);
        target.add(null);
        target.add(null);

        target.reduce();
        assertArrayEquals(expectedArray, target.toArray(new MyClass[0]), "Expected array may not contain null values after reduce");
    }

    @Test
    void toArrayAEmpty() {
        var expectedArray = new MyClass[]{};
        assertArrayEquals(expectedArray, target.toArray(new MyClass[0]));
    }

    private void fillList(int times) {
        for (int i = times; i > 0; i--) {
            target.add(new MyClass());
        }
    }

    private static class MyClass {
        private static int NUMBER = 1;

        private final int thisNumber;

        private MyClass() {
            thisNumber = NUMBER++;
        }

        private MyClass(int number) {
            thisNumber = number;
        }

        private int getThisNumber() {
            return thisNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MyClass)) return false;
            MyClass myClass = (MyClass) o;
            return getThisNumber() == myClass.getThisNumber();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getThisNumber());
        }
    }
}