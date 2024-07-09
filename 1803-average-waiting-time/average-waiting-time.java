class Solution {
    public double averageWaitingTime(int[][] customers) {
        long totalWaitingTime = 0;
        int currentTime = 0;
        
        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int preparationTime = customer[1];
            
            currentTime = Math.max(currentTime, arrivalTime);
            
            int finishTime = currentTime + preparationTime;
            
            int waitingTime = finishTime - arrivalTime;
            
            totalWaitingTime += waitingTime;
            
            currentTime = finishTime;
        }
        
        return (double) totalWaitingTime / customers.length;
    }
}