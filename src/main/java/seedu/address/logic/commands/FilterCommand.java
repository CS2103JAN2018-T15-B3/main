package seedu.address.logic.commands;

import seedu.address.model.tag.*;

//@@author {clarissayong}

/**
 * Finds and lists all persons in address book who is tagged with the provided keyword.
 * Keyword matching is case sensitive.
 */

public class FilterCommand extends Command {

    public static final String COMMAND_WORD = "filter";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Filters all users with the specified tag "
            + "(case-sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: TAG\n"
            + "Example: " + COMMAND_WORD + " diabetes";

    private final Tag tag;

    public FilterCommand(Tag tag) {
        this.tag = tag;
    }

    @Override
    public CommandResult execute() {
        model.setFilteredPersonList(model.getAddressBook().filter(tag));
        return new CommandResult(getMessageForPersonListShownSummary(model.getFilteredPersonList().size()));
    }

}
