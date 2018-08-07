package by.paulouskin.todolist.implementations;

import by.paulouskin.todolist.abstractions.TodoListItem;

public class TodoListItemImpl implements TodoListItem {

    private final String title;
    private boolean toggled;

    public TodoListItemImpl setTitle(String title) {
        if (title.isEmpty()) throw new IllegalArgumentException("New title cannot be empty");
        return new TodoListItemImpl(title);
    }

    public String getTitle() {
        return title;
    }

    public boolean isToggled() {
        return toggled;
    }

    public TodoListItemImpl(String title) {
        if (title.isEmpty()) throw new IllegalArgumentException("Title cannot be empty");
        this.title = title;
        this.toggled = false;
    }

    @Override
    public void toggle() {
        if (toggled) {toggled = false; return;}
        toggled = true;

    }

}
