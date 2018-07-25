package by.paulouskin.todolist.abstractions;

import by.paulouskin.todolist.implementations.TodoListItemImpl;
import by.paulouskin.todolist.interfaces.Obtainable;

public interface TodoList extends Obtainable {
    void toggleAll();
    boolean deleteItem(String title);
    boolean deleteItem(int number);
    int addItem(String title);
    int addItem(TodoListItemImpl item);
    boolean toggle(String item);
    int length();
}
