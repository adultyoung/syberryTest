import java.util.List;

public class ISchedulerImpl implements IScheduler {

    private TasksComparator tasksComparator = new TasksComparator();

    @Override
    public List<Task> schedule(List<Task> tasks) {
        tasks.sort(tasksComparator);
        return tasks;
    }
}
