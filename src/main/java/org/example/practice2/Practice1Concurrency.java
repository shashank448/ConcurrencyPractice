package org.example.practice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Practice1Concurrency {
    //public static AtomicLong sum = new AtomicLong();
    public static long sum = 0;
    public static AtomicInteger cnt = new AtomicInteger();
    public static void main(String args[]){
        List<Integer> nums = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<10000000;i++)
            nums.add(random.nextInt());

        long start2 = System.currentTimeMillis();
        seqSum(nums);
        long end2 = System.currentTimeMillis();
        System.out.println(end2-start2);

        long start1 = System.currentTimeMillis();
        concurrentSum(nums);
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);

    }
    public static void seqSum(List<Integer> nums){
        long sum = 0;
        for(Integer i : nums)
            sum+=i;
        System.out.println(sum);
    }
    public static void concurrentSum(List<Integer> nums){
        int size = 10000000/4;
        Thread t1 = new Thread(new Worker(nums, 0, size-1));
        Thread t2 = new Thread(new Worker(nums, size, 2*size-1));
        Thread t3 = new Thread(new Worker(nums, 2*size, 3*size-1));
        Thread t4 = new Thread(new Worker(nums, 3*size, 4*size-1));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        // The below code depicts busy waiting - 
        while(cnt.get()<4){
        }
        //System.out.println(sum.get());
        System.out.println(sum);

    }
}
