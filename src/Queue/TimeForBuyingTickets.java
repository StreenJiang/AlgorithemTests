package Queue;

public class TimeForBuyingTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int targetTickets = tickets[k];

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                // 在k前面或就是k，最多买 min(tickets[i], targetTickets) 张
                time += Math.min(tickets[i], targetTickets);
            } else {
                // 在k后面，最多买 min(tickets[i], targetTickets - 1) 张
                // 因为当k买完最后一张时，他还没轮到
                time += Math.min(tickets[i], targetTickets - 1);
            }
        }

        return time;
    }
}
