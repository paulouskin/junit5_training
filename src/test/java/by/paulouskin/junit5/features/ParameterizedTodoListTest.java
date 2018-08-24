package by.paulouskin.junit5.features;

import by.paulouskin.todolist.implementations.TodoListImpl;
import org.apiguardian.api.API;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class ParameterizedTodoListTest {

    private TodoListImpl list;

    @BeforeEach
    public void setUp() {
        list = new TodoListImpl();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Todo Item 1","Todo Item 2"})
    public void parameterizedTestForTodoList(String todoItemTitle) {
        list.addItem(todoItemTitle);
        list.deleteItem(todoItemTitle);
        assertThat(list.length(), is(equalTo(0)));
    }
    @AfterEach
    public void tearDown() {
        list = null;
    }
}
