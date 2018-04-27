/**
 * Given a set of tasks each represented using a character, find the total
 * execution time. Each task completes in 1 unit of time and there is a 
 * cooldown period of N before the same task is repeated.
 * 
 * Similar to: https://leetcode.com/problems/task-scheduler/description/
 */
import java.util.*;

class TimeToRunTasks {
    private static int getTime(String taskString, int gap) {
        char[] tasks = taskString.toCharArray();

        if (tasks.length <= 1)
            return tasks.length;

        Set<Character> inWindow = new HashSet<>();
        Deque<Character> window = new ArrayDeque<>();

        for(int i=0; i<gap; i++)
            window.addLast('-');

        int currentPos = 0;

        for(int i=0; i<tasks.length; ) {
            char t = tasks[i];

            if(inWindow.contains(t)) {
                window.addLast('-');
                inWindow.remove(window.removeFirst());
            } else {
                window.addLast(t);
                inWindow.remove(window.removeFirst());
                inWindow.add(t);
                i++;
            }

            currentPos++;
        }

        return currentPos;
    }

    public static void main(String args[]) {
        System.out.println(getTime("ABCAABACCB", 3));
        System.out.println(getTime("ABCAABACCB", 4));
    }
}