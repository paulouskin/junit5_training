package by.paulouskin.todolist.implementations;

import by.paulouskin.todolist.abstractions.TodoListItem;

public class TodoListItemImpl extends TodoListItem {

    private String title;
    private boolean toggled;

    public void setTitle(String title) {
        if (title.isEmpty()) throw new IllegalArgumentException("New title cannot be empty");
        this.title = title;
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
