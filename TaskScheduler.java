/**
 * https://leetcode.com/problems/task-scheduler/description/
 * 
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z
 * where different letters represent different tasks.Tasks could be done without original order.
 * Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * 
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be
 * at least n intervals that CPU are doing different tasks or just be idle.
 * 
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * 
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 */
class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        
        for(int i=0; i<tasks.length; i++)
            freq.put(tasks[i], freq.getOrDefault(tasks[i],0) + 1);
        
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a,b) -> b-a);
        maxQ.addAll(freq.values());
        
        int totalTime = 0;
        int slotSize = 0;
        List<Integer> usedItems = new ArrayList<>();
        
        while(!maxQ.isEmpty()) {
            slotSize = n+1;
            
            usedItems.clear();
            
            while(slotSize > 0 && !maxQ.isEmpty()) {
                usedItems.add(maxQ.poll()-1);
                totalTime++;
                slotSize--;
            }
            
            for(Integer item : usedItems) {
                if (item > 0)
                    maxQ.add(item);
            }
            
            if (!maxQ.isEmpty())
                totalTime += slotSize;
        }
        
        return totalTime;
    }
}