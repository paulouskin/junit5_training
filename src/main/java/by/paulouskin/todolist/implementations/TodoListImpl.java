package by.paulouskin.todolist.implementations;

import by.paulouskin.todolist.abstractions.TodoList;

import java.util.ArrayList;
import java.util.Arrays;

public class TodoListImpl implements TodoList {

    private ArrayList<TodoListItemImpl> items;

    public TodoListImpl() {
        items = new ArrayList<>();
    }


    @Override
    public void toggleAll() {
        if (items.size() == 0) throw new NullPointerException("No items in list");
        items.stream()
                .forEach(TodoListItemImpl::toggle);
    }

    @Override
    public void deleteItem(String title) {
        items.removeIf(todoListItem -> todoListItem.getTitle().equalsIgnoreCase(title));
    }

    @Override
    public void deleteItem(int index) {
        items.remove(index - 1);
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
        items.addAll(new ArrayList<>(Arrays.asList(todos)));
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
    public TodoListItemImpl getItem(String title) {
        return findItemInList(title);
    }

    @Override
    public TodoListItemImpl getItem(int index) {
        return null;
    }
}
