package jarvis.commands;
import jarvis.exceptions.InvalidIndexException;
import jarvis.exceptions.InvalidTaskFormatException;
import jarvis.gui.Ui;
import jarvis.storage.Storage;
import jarvis.tasks.TaskList;

/**
 *
 */
public class SortCommand implements Command {
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage)
            throws InvalidIndexException, InvalidTaskFormatException {
        taskList.sortTasks();
        return ui.printTasks(taskList.getTaskList());
    }
}
