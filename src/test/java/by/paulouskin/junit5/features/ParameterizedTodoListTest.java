package by.paulouskin.junit5.features;

import by.paulouskin.todolist.implementations.TodoListImpl;
import by.paulouskin.todolist.implementations.TodoListItemImpl;
import org.apiguardian.api.API;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

@Tag("parameterized")
@Tag("all")
public class ParameterizedTodoListTest {

    private TodoListImpl list;

    @BeforeEach
    public void setUp() {
        list = new TodoListImpl();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Todo Item Value 1","Todo Item Value 2"})
    public void parameterizedWithValueSourceTodoListTest(String todoItemTitle) {
        list.addItem(todoItemTitle);
        list.deleteItem(todoItemTitle);
        assertThat(list.length(), is(equalTo(0)));
    }

    @ParameterizedTest
    @CsvSource({"Todo Item CSV 1", "Todo Item CSV 2"})
    public void parameterizedWithCsvSourceArgumentAggregatorTodoListTest(@AggregateWith(TodoItemArgumentsAggregator.class) TodoListItemImpl todo) {
        list.addItem(todo);
        list.deleteItem(todo.getTitle());
        assertThat(list.length(), is(equalTo(0)));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/todos.csv")
    public void parameterizedWithCsvFileSourceTodoListTest(String todoItemTitle) {
        list.addItem(todoItemTitle);
        list.deleteItem(todoItemTitle);
        assertThat(list.length(), is(equalTo(0)));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/todos.csv")
    public void parameterizedWithCsvFileSourceImplicitConversionTodoListTest(TodoListItemImpl todo) {
        list.addItem(todo);
        list.deleteItem(todo.getTitle());
        assertThat(list.length(), is(equalTo(0)));
    }

    @ParameterizedTest
    @MethodSource("listItemsProvider")
    public void parameterizedWithMethodSourceTodoListTest(String todoItemTitle) {
        list.addItem(todoItemTitle);
        list.deleteItem(todoItemTitle);
        assertThat(list.length(), is(equalTo(0)));
    }

    static List<String> listItemsProvider() {
        return Arrays.asList("Todo Item Method 1", "Todo Item Method 2");
    }

    @AfterEach
    public void tearDown() {
        list = null;
    }
}
