import java.util.Comparator;
import java.util.List;

public class TasksComparator implements Comparator<Task> {


    @Override
    public int compare(Task task1, Task task2) {
        String task1Name = task1.getName();
        String task2Name = task2.getName();
        List<String> task1Predecessors = task1.getPredecessors();
        List<String> task2Predecessors = task2.getPredecessors();

        boolean isTask2PredecessorsEmptyOrNull = isListEmptyOrNull(task2Predecessors);
        boolean isTask1PredecessorsEmptyOrNull = isListEmptyOrNull(task1Predecessors);

        if (isTask1PredecessorsEmptyOrNull) {
            if (isTask2PredecessorsEmptyOrNull) {
                return 0;
            }
            return -1;
        } else if (isTask2PredecessorsEmptyOrNull) return 1;

        for (String predecessor : task1Predecessors) {
            if (predecessor != null && predecessor.equalsIgnoreCase(task2Name)) {
                return 1;
            }
        }
        for (String predecessor : task2Predecessors) {
            if (predecessor != null && predecessor.equalsIgnoreCase(task1Name)) {
                return -1;
            }
        }

        return 0;
    }

    private boolean isListEmptyOrNull(List<String> list) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        for (String str : list) {
            if (str != null && str.matches("\\S+")) return false;
        }
        return true;
    }

}
