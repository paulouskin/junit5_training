package by.paulouskin.todolist.implementations;

import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TodoListImplTest {

    private TodoListImpl list;
    private TodoListItemImpl[] todos;

    @BeforeAll
    public static void setUpAll() {

    }
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

    @Test
    public void can_add_item_with_title_to_the_list() {
        list.addItem("Go to training for trainers");
        assertThat(list.length(),equalTo(1));
    }

    @Test
    public void toggle_item_in_the_list() {
        list.addItem(todos[0]);
        assertThat(list.toggle("Go for a walk with the dog"),equalTo(true));
    }

    @Test
    @DisplayName("Exception have been thrown when we toggle non-existing item")
    public void throw_exception_when_toggle_non_existing_item() {
        Assertions.assertThrows(
                NullPointerException.class,
                () -> list.toggle("Non-existing item in list")
        );
    }

    @Test
    public void can_not_add_two_items_with_the_same_titles() {
        list.addItem(todos[0]);
        list.addItem("Go for a walk with the dog");
        assertThat(list.length(),equalTo(1));
    }

    @AfterEach
    public void tearDown() {

    }

    @AfterAll
    public static void tearDownAll() {
    }
}
