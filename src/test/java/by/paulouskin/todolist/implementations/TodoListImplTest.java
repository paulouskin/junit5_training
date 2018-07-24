package by.paulouskin.todolist.implementations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoListImplTest {

    TodoListImpl list;
    TodoListItemImpl[] todos;

    @BeforeEach
    public void setUp() {
        todos = new TodoListItemImpl[]{
                new TodoListItemImpl("Go for a walk with the dog"),
                new TodoListItemImpl("Buy milk and sugar"),
                new TodoListItemImpl("See favourite TV series")
        };
        list = new TodoListImpl();
    }

    @Test
    public void can_add_items_to_the_list(){
        list.addItem(todos[0]);
        list.addItem(todos[1]);
        Assertions.assertEquals(2,list.length());
    }

    @Test
    public void can_add_an_array_of_items_to_the_list() {
        list.addItems(todos);
        Assertions.assertEquals(3, list.length());
    }

    @AfterEach
    public void tearDown() {

    }
}
