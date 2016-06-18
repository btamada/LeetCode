import java.util.HashMap;
import java.util.Map;

/**

 Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.

 Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.

 It is possible that several messages arrive roughly at the same time.

 Example:

 Logger logger = new Logger();

 // logging string "foo" at timestamp 1
 logger.shouldPrintMessage(1, "foo"); returns true;

 // logging string "bar" at timestamp 2
 logger.shouldPrintMessage(2,"bar"); returns true;

 // logging string "foo" at timestamp 3
 logger.shouldPrintMessage(3,"foo"); returns false;

 // logging string "bar" at timestamp 8
 logger.shouldPrintMessage(8,"bar"); returns false;

 // logging string "foo" at timestamp 10
 logger.shouldPrintMessage(10,"foo"); returns false;

 // logging string "foo" at timestamp 11
 logger.shouldPrintMessage(11,"foo"); returns true;

 Credits:
 Special thanks to @memoryless for adding this problem and creating all test cases.

 */
public class LoggerRateLimiter {

    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(9,"foobar"));
    }

    private static class Logger {

        private final int timeLimit = 10;

        private Map<String,Integer> map;

        public Logger() {
            this.map  = new HashMap<>();
        }

        boolean shouldPrintMessage(int timestamp, String msg) {
            if(timestamp <= 0 || msg == null || msg.length() == 0) return false;
            if(map.containsKey(msg) && (timestamp - map.get(msg)) < timeLimit) return false;
            map.put(msg, timestamp);
            return true;
        }
    }

}
