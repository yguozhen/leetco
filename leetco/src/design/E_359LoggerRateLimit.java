package design;

import java.util.HashMap;
import java.util.Map;

public class E_359LoggerRateLimit {
    Map<String, Integer> map = new HashMap<>();
    /** Initialize your data structure here. */
    public Logger() {

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            int temp = map.get(message);
            if(timestamp - temp >= 10){
                map.put(message, timestamp);
                return true;
            }else{
                return false;
            }
        }else{
            map.put(message, timestamp);
            return true;
        }
    }
}
