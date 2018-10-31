package by.paulouskin.todolist.interfaces;

import by.paulouskin.todolist.implementations.TodoListItemImpl;
import by.paulouskin.todolist.interfaces.Togglable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TogglableTest {

    Togglable item;

    @BeforeEach
    public void setUp() {
        item = new TodoListItemImpl("Togglable item");
    }

    @Test
    public void canToggleItem() {
        item.toggle();
        Assertions.assertTrue(item.isToggled());
    }

    @Test
    public void canUntoggleItem() {
        item.toggle();
        item.toggle();
        Assertions.assertFalse(item.isToggled());
    }
}
