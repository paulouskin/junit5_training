package by.paulouskin.todolist.implementations;

import by.paulouskin.todolist.abstractions.TodoListItem;

public class TodoListItemImpl extends TodoListItem {

    private String title;
    private boolean completed;

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public TodoListItemImpl(String title) {
        this.title = title;
        this.completed = false;
    }

    @Override
    public boolean complete() {
        if (completed == true) throw new IllegalStateException("Item is already completed");
        return completed = true;
    }

    @Override
    public boolean uncomplete() {
        if (completed == false) throw new IllegalStateException("Item is not completed yet");
        return completed = false;
    }
}
