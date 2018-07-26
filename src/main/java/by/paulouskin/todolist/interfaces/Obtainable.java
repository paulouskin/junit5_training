package by.paulouskin.todolist.interfaces;

import by.paulouskin.todolist.implementations.TodoListItemImpl;

public interface Obtainable {
    TodoListItemImpl getItem(String title);
    TodoListItemImpl getItem(int number);
}
