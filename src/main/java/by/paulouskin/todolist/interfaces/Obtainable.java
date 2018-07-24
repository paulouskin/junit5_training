package by.paulouskin.todolist.interfaces;

import by.paulouskin.todolist.abstractions.TodoListItem;

public interface Obtainable {
    TodoListItem getItem(String title);
    TodoListItem getItem(int number);
}
