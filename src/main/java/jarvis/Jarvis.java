package jarvis;

import jarvis.commands.Command;
import jarvis.exceptions.JarvisException;
import jarvis.gui.Ui;
import jarvis.parser.Parser;
import jarvis.reminder.Reminder;
import jarvis.storage.Storage;
import jarvis.tasks.TaskList;

/**
 * The main class for Jarvis application, a CLI chat-bot.
 * It initialises and manages the core components of the application.
 * Namely: ui, storage, taskList, and commands.
 */
public class Jarvis {

    private TaskList taskList;
    private Ui ui;
    private Storage storage;
    private Reminder reminder;

    /**
     * Constructor for Jarvis class.
     */
    public Jarvis() {
        this.taskList = new TaskList();
        this.ui = new Ui();
        this.storage = new Storage();
        taskList.setTasks(storage.loadTasks());
        this.reminder = new Reminder(taskList);
    }

    /**
     * Responds to user input by parsing and executing commands.
     *
     * @param userInput The input provided by the user through CLI.
     */
    public String respond(final String userInput) {
        try {
            Command command = Parser.parseCommand(userInput);
            return command.execute(taskList, ui, storage);
        } catch (JarvisException e) {
            return ui.printError(e.getMessage());
        }
    }
}

