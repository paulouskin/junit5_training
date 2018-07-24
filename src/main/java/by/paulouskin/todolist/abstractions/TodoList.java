package by.paulouskin.todolist.abstractions;

import by.paulouskin.todolist.interfaces.Obtainable;
import by.paulouskin.todolist.interfaces.Togglable;

public interface TodoList extends Obtainable {
    void toggleAll();
    boolean deleteItem(String title);
    boolean deleteItem(int number);
    int addItem(String title);
    int addItem(TodoListItem item);
    boolean toggle(Togglable item);
    int length();
}
