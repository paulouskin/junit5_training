package by.paulouskin.todolist.implementations;

import by.paulouskin.todolist.implementations.TodoListItemImpl;
import org.junit.jupiter.api.*;

@Tag("todolistitem")
@Tag("all")
public class TodoListItemImplTest {

    TodoListItemImpl item;

    @BeforeEach
    public void setUp() {
        item = new TodoListItemImpl("Todo item for test");
    }

    @Test
    public void item_is_not_toggled_after_creation() {
        Assertions.assertFalse(item.isToggled());
    }

    @Test
    public void item_have_title() {
        Assertions.assertEquals("Todo item for test", item.getTitle());
    }

    @Test
    public void cannot_create_item_with_empty_title() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new TodoListItemImpl(""));
    }

    @Test
    public void can_set_new_title() {
        String new_title = "New title for test item";
        TodoListItemImpl newItem = item.setTitle(new_title);
        Assertions.assertEquals(new_title, newItem.getTitle());
    }

    @Test
    public void cannot_set_empty_title() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> item.setTitle(""));
    }
    @AfterEach
    public void tearDown() {

    }

}
