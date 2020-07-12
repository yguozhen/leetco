package design;

import java.util.HashSet;
import java.util.Queue;

public class M_379DesignPhoneDirectionary {
    class PhoneDirectory {
        HashSet<Integer> used = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int maxNumbers;
        /** Initialize your data structure here
         @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
        public PhoneDirectory(int maxNumbers) {
            this.maxNumbers = maxNumbers;
            for(int i = 0; i < maxNumbers; i ++){
                queue.offer(i);
            }
        }

        /** Provide a number which is not assigned to anyone.
         @return - Return an available number. Return -1 if none is available. */
        public int get() {
            Integer res = queue.poll();
            if(res == null){
                return -1;
            }
            used.add(res);
            return res;
        }

        /** Check if a number is available or not. */
        public boolean check(int number) {
            if(number >= maxNumbers || number < 0){
                return false;
            }
            return !used.contains(number);
        }

        /** Recycle or release a number. */
        public void release(int number) {
            if(used.remove(number)){
                queue.offer(number);
            }
        }
    }
}
