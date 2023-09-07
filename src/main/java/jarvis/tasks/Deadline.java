package jarvis.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jarvis.Ui;

/**
 * Represents the "Deadline" task in Jarvis app.
 */
public class Deadline extends Task {

    private LocalDateTime dueDateTime;

    public Deadline(String title, LocalDateTime dueDate, boolean isCompleted) {
        super(title, isCompleted);
        this.dueDate = dueDate;
    }
    
     /**
     * Overrides the toString method to provide a custom string representation of the Deadline task.
     *
     * @return A string representation of the Deadline task.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Ui.DATE_TIME_FORMAT);
        String formattedDueDate = dueDate.format(formatter);
        return "D | " + super.toString() + " | " + formattedDueDate;
    }
}
