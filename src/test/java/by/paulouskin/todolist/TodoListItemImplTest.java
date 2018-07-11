package by.paulouskin.todolist;

import by.paulouskin.todolist.implementations.TodoListItemImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TodoListItemImplTest {

    TodoListItemImpl item;

    @Before
    public void setUp() {
        item = new TodoListItemImpl("Todo item for test");
    }

    @Test
    public void complete_an_item() {
        boolean status = item.complete();
        Assertions.assertTrue(status);
    }

    @Test
    public void uncomplete_an_item() {
        item.complete();
        Assertions.assertFalse(item.uncomplete());
    }

    @Test
    public void item_is_not_completed_after_creation() {
        Assertions.assertFalse(item.isCompleted());
    }

    @Test
    public void throws_exception_when_complete_completed() {
        item.complete();
        Assertions.assertThrows(IllegalStateException.class, () ->item.complete());
    }

    @Test
    public void throws_exception_when_uncomplete_uncompleted() {
        Assertions.assertThrows(IllegalStateException.class, () -> item.uncomplete());
    }

    @Test
    public void item_have_title() {
        Assertions.assertEquals("Todo item for test", item.getTitle());
    }

    @After
    public void tearDown() {

    }

}
