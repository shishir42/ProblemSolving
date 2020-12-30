//3.
// Tag: Design

//Given a stream of integers and a window size, 
//calculate the moving average of all integers in the sliding window.
// MovingAverage m = new MovingAverage(3);
// m.next(1) = 1
// m.next(10) = (1 + 10) / 2
// m.next(3) = (1 + 10 + 3) / 3
// m.next(5) = (10 + 3 + 5) / 3


//https://nifannn.github.io/2018/10/01/Algorithm-Notes-Leetcode-346-Moving-Average-from-Data-Stream/
//https://github.com/varunu28/LeetCode-Java-Solutions/blob/master/Easy/Moving%20Average%20from%20Data%20Stream.java

package com.program.LeetCodeDesign;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream_3 {
    public static void main(String[] args){
        MovingAverage sol = new MovingAverage(3);
        System.out.println(sol.next(1));
        System.out.println(sol.next(10));
        System.out.println(sol.next(3));
        System.out.println(sol.next(5));
    }
}

class MovingAverage{
    Queue<Integer> queue;
    int size;
    double sum;

    //private ArrayList<Integer> array;

    public MovingAverage(int size) {
       sum = 0;
       this.size = size;
       this.queue = new LinkedList<>();
    }

    public double next(int val){
        queue.add(val);
        sum += val;

        if(queue.size() > size){
            Integer rem = this.queue.remove();
            sum -= rem;

            //this.sum -= this.array.remove(0);
        }

        ////return (1.0 * this.sum) / this.array.size();
        return sum/this.queue.size();
    }
}
