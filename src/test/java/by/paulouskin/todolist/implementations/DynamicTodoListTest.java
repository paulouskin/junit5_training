package by.paulouskin.todolist.implementations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

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

    @AfterEach
    public void tearDown() {
        list = null;
    }
}
