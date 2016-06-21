import java.util.ArrayList;
import java.util.List;

public class DesignHitCounter {
    private List<Integer> hitCounter;

    /** Initialize your data structure here. */
    public DesignHitCounter() {
        this.hitCounter = new ArrayList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(timestamp > 0) this.hitCounter.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if(timestamp < 0) return -1;
        int lowerLimit = timestamp - 5;
        int upperLimit = timestamp;
        int numHits = 0;
        for(int n : this.hitCounter) {
            if(n >= lowerLimit && n <= upperLimit) ++numHits;
        }
        return numHits;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */