package jarvis.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jarvis.gui.Ui;

/**
 * Represents the "Event" task in Jarvis app.
 */
public class Event extends Task {

    private LocalDateTime fromDateTime;
    private LocalDateTime toDateTime;
    
    public Event(String title, LocalDateTime fromDateTime, LocalDateTime toDateTime, boolean isCompleted) {
        super(title, isCompleted);
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
    }
    
    /**
     * Overrides the toString method to provide a custom string representation of the Event task.
     *
     * @return A string representation of the Event task.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Ui.DATE_TIME_FORMAT);
        String formattedFromDateTime = fromDateTime.format(formatter);
        String formattedToDateTime = toDateTime.format(formatter);
        return "E | " + super.toString() + " | " + formattedFromDateTime + " | " + formattedToDateTime;
    }
}
