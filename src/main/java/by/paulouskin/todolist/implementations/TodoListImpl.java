package by.paulouskin.todolist.implementations;

import by.paulouskin.todolist.abstractions.TodoList;
import by.paulouskin.todolist.abstractions.TodoListItem;
import by.paulouskin.todolist.interfaces.Togglable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoListImpl implements TodoList {

    private List<TodoListItem> items;

    public TodoListImpl() {
        items = new ArrayList<>();
    }


    @Override
    public void toggleAll() {

    }

    @Override
    public boolean deleteItem(String title) {
        return false;
    }

    @Override
    public boolean deleteItem(int number) {
        return false;
    }

    @Override
    public int addItem(String title) {
        items.add(new TodoListItemImpl(title));
        return items.size();
    }

    @Override
    public int addItem(TodoListItem item) {
        items.add(item);
        return items.size();
    }

    public void addItems(TodoListItem[] todos) {
        items.addAll(Arrays.asList(todos));
    }

    @Override
    public boolean toggle(Togglable item) {
        return false;
    }

    @Override
    public int length() {
        return items.size();
    }

    @Override
    public TodoListItem getItem(String title) {
        return null;
    }

    @Override
    public TodoListItem getItem(int number) {
        return null;
    }
}
