//4.
// Tag: Hashtable

//Design a logger system that receive stream of messages 
//along with its timestamps, each message should be printed 
//if and only if it is not printed in the last 10 seconds.


// Logger logger = new Logger();

// // logging string "foo" at timestamp 1
// logger.shouldPrintMessage(1, "foo"); returns true; 

// // logging string "bar" at timestamp 2
// logger.shouldPrintMessage(2,"bar"); returns true;

// // logging string "foo" at timestamp 3
// logger.shouldPrintMessage(3,"foo"); returns false;

// // logging string "bar" at timestamp 8
// logger.shouldPrintMessage(8,"bar"); returns false;

// // logging string "foo" at timestamp 10
// logger.shouldPrintMessage(10,"foo"); returns false;

// // logging string "foo" at timestamp 11
// logger.shouldPrintMessage(11,"foo"); returns true;

//https://tenderleo.gitbooks.io/leetcode-solutions-/content/GoogleEasy/359.html
//https://aaronice.gitbook.io/lintcode/hash-table/logger-rate-limiter

package com.program.LeetCodeDesign;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter_4 {
    public static void main(String[] args){
        LoggerLimiter obj = new LoggerLimiter();
        System.out.println(obj.shouldPrintMessage(1, "foo"));
        System.out.println(obj.shouldPrintMessage(2,"bar"));
        System.out.println(obj.shouldPrintMessage(3,"foo"));
        System.out.println(obj.shouldPrintMessage(8,"bar"));
        System.out.println(obj.shouldPrintMessage(11,"foo"));
    }
}

class LoggerLimiter{
    Map<String, Integer> map = new HashMap<>();
    int limiter = 10;

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timeStamp, String message){
            if(!map.containsKey(message))
            {
                map.put(message, timeStamp);
                return true;
            }
            else
            {
                if(timeStamp - map.get(message) >= limiter){
                    map.put(message, timeStamp);
                    return true;
                }
            }

            return false;
        }
}
