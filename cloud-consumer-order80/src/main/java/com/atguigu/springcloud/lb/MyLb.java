package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * date: 2020-12-7
 *
 * @author xumu
 */
@Component
public class MyLb implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
            System.out.println("****next*****" + next+"\t thread name"+Thread.currentThread().getName());
        } while (!this.atomicInteger.compareAndSet(current, next));
        return next;
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(100);
        MyLb myLb = new MyLb();
        for (int i = 0; i < 100; i++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    myLb.getAndIncrement();
                }
            });
        }

    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
