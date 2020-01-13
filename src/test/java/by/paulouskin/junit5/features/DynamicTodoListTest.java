package by.paulouskin.junit5.features;

import by.paulouskin.todolist.implementations.TodoListImpl;
import by.paulouskin.todolist.implementations.TodoListItemImpl;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@Tag("all")
public class DynamicTodoListTest {

    private TodoListImpl list;

    @BeforeEach
    public void setUp() {
        list = new TodoListImpl();
    }

    @TestFactory
    Collection<DynamicTest> dynamicTestForTodoList() {
        String itemTitle = "Item for dynamic test";
        TodoListItemImpl item = new TodoListItemImpl(itemTitle);
        return Arrays.asList(
          dynamicTest("Testing item insertion", () ->{list.addItem(item);assertEquals(1,list.length());}),
          dynamicTest("Testing item deletion", () -> {list.addItem(item);list.deleteItem(itemTitle);assertEquals(0,list.length());}
        ));
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsWithIntStream() {
        return IntStream.iterate(1, n->n + 1)
                .limit(6)
                .mapToObj(n -> DynamicTest.dynamicTest(
                        "test for n = " + n,
                        () -> assertTrue(n % 2 == 0)
                ));
    }

    @TestFactory
    Stream<DynamicTest> todoListItemDynamicTest() {
        List<String> todoItems = Arrays.asList(
          "Todo Item 1", "Todo Item 2"
        );

        return todoItems.stream()
                .map(item -> DynamicTest.dynamicTest(
                        "Check title for " + item + " item",
                        () -> {
                            TodoListItemImpl todo = new TodoListItemImpl(item);
                            assertEquals(item, todo.getTitle());
                        }
                ));
    }

    @AfterEach
    public void tearDown() {
        list = null;
    }
}
