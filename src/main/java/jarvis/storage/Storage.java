package jarvis.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import jarvis.exceptions.InvalidTaskFormatException;
import jarvis.parser.Parser;
import jarvis.tasks.Task;

/**
 * Storage class is responsible for storing and loading tasks from file destination.
 */
public class Storage {
    private static final String FILE_DIR = "jarvis/data";
    private static final String FILE_PATH = "jarvis/data/jarvis.txt";

    /**
     * Initializes a new instance of the Storage class and creates necessary directories and files.
     */
    public Storage() {
        File fileDir = new File(FILE_DIR);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
            assert fileDir.exists() : "File Dir creation was not successful";
        }
        File file = new File(FILE_PATH);
        assert file.exists() : "File creation was not successful";
    }

    /**
     * Saves a list of tasks to the file destination.
     *
     * @param tasks An ArrayList of task to be saved.
     */
    public void saveTasks(ArrayList<Task> tasks) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            for (Task task : tasks) {
                writer.write(task.toString());
                writer.newLine();
            }
            // assert new File(FILE_PATH).length() > 0 : "Data was not written to output file";
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Loads tasks from the file destination.
     *
     * @return An ArrayList of tasks loaded from the storage file.
     */
    public ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String nextLine;
            while ((nextLine = reader.readLine()) != null) {
                Task task = Parser.parseStringToTask(nextLine);
                tasks.add(task);
                assert tasks.contains(task);
            }
        } catch (IOException e) {
            System.err.println("Unable to load tasks");
        } catch (InvalidTaskFormatException e) {
            System.err.println("Invalid Task Format when loading tasks");
        }
        return tasks;
    }
}
