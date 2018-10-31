package by.paulouskin.junit5.features;

import by.paulouskin.hamcrest.examples.IsEmptyTodoList;
import by.paulouskin.todolist.implementations.TodoListImpl;
import org.junit.jupiter.api.*;

import static by.paulouskin.hamcrest.examples.IsEmptyTodoList.isAnEmptyTodoList;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("A todo list")
public class NestedTodoListTests {

    TodoListImpl todoList;

    @Nested
    @DisplayName("when new")
    class WhenNewTodoList {

        @BeforeEach
        void setUpEmptyTodoList() {
            todoList = new TodoListImpl();
        }

        @Test
        @DisplayName("is empty")
        void newTodoListIsEmpty() {
            assertThat(todoList,isAnEmptyTodoList());
        }

        @Test
        @DisplayName("throws exception when toggle all items in empty list")
        void throwsExceptionWhenToggleNonExistingItem() {
            Assertions.assertThrows(NullPointerException.class,
                    () -> todoList.toggleAll());
        }

    }
}
