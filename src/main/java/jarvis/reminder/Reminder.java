package jarvis.reminder;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import jarvis.gui.MainWindow;
import jarvis.tasks.Task;
import jarvis.tasks.TaskList;

/**
 *
 */
public class Reminder {
    private Timer reminderTimer;
    private TaskList tasks;

    /**
     *
     */
    public Reminder(TaskList tasks) {
        this.reminderTimer = new Timer();
        this.tasks = tasks;
        startReminderScheduler();
    }

    private void startReminderScheduler() {
        reminderTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkAndPushReminder();
            }
        }, 0, 60000);
    }

    private void checkAndPushReminder() {
        LocalDateTime currentTime = LocalDateTime.now();
        for (Task task : tasks.getTaskList()) {
            LocalDateTime remindDateTime = task.getDueDate();
            boolean isDue = currentTime.isEqual(remindDateTime) || currentTime.isAfter(remindDateTime);
            if (isDue) {
                String reminderMessage = "Reminder: " + task.getTitle() + " is due now!";
                MainWindow.setReminderMessage(reminderMessage);
            }
        }
    }
}

