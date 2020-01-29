package by.paulouskin.junit5.features;

import by.paulouskin.todolist.implementations.TodoListItemImpl;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

public class TodoItemArgumentsAggregator implements ArgumentsAggregator {
    @Override
    public TodoListItemImpl aggregateArguments(ArgumentsAccessor arguments, ParameterContext context)
            throws ArgumentsAggregationException {
        return new TodoListItemImpl(arguments.getString(0));
    }
}
