package by.paulouskin.todolist.abstractions;

import by.paulouskin.todolist.interfaces.Togglable;

public abstract class TodoList {

    public abstract void toggleAll();
    public abstract boolean deleteItem(String title);
    public abstract boolean deleteItem(int number);
    public abstract int addItem(String title);
    public abstract int addItem(TodoListItem item);
    public abstract TodoListItem getItem(String title);
    public abstract TodoListItem getItem(int number);
    public abstract boolean toggle(Togglable item);

}
