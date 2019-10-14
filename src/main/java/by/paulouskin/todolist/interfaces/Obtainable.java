package by.paulouskin.todolist.interfaces;

import by.paulouskin.todolist.abstractions.TodoListItem;
import by.paulouskin.todolist.implementations.TodoListItemImpl;

public interface Obtainable {
    TodoListItem getItem(String title);
    TodoListItem getItem(int number);
}
