package by.paulouskin.todolist.implementations;

import by.paulouskin.todolist.abstractions.TodoList;
import by.paulouskin.todolist.abstractions.TodoListItem;

import java.util.ArrayList;
import java.util.Arrays;

public class TodoListImpl implements TodoList {

    private ArrayList<TodoListItemImpl> items;

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
        addItemToList(title);
        return items.size();
    }

    @Override
    public int addItem(TodoListItemImpl item) {
        addItemToList(item.getTitle());
        return items.size();
    }

    private void addItemToList(String title) {
        if (findItemInList(title) == null )
            items.add(new TodoListItemImpl(title));
    }

    private TodoListItemImpl findItemInList(String title) {
        return items
                .stream()
                .filter(item -> item.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public void addItems(TodoListItemImpl[] todos) {
        items.addAll(Arrays.asList(todos));
    }

    @Override
    public boolean toggle(String title) {
        TodoListItemImpl target = findItemInList(title);
        target.toggle();
        return target.isToggled();
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
