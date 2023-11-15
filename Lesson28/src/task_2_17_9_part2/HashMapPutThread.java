package task_2_17_9_part2;

/**
 * Перепишіть ту саму програму, але тепер використовуючи HashMap замість ConcurrentHashMap.
 * Виконайте програму кілька разів і спостерігайте результат.
 * <p>
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class HashMapPutThread extends Thread {
    private final Integer key;
    private final Character value;
    private final Map<Integer, Character> map;

    public HashMapPutThread(Integer key, Character value, Map<Integer, Character> map) {
        this.key = key;
        this.value = value;
        this.map = map;
    }

    @Override
    public void run() {
        synchronized (map) {
            map.put(key, value);
            System.out.println("Thread " + Thread.currentThread().getId() +
                    " added key: " + key + ", value: " + value);
        }
    }
}

class HashMapGetThread extends Thread {
    private final Map<Integer, Character> map;

    public HashMapGetThread(Map<Integer, Character> map) {
        this.map = map;
    }

    @Override
    public void run() {
        synchronized (map) {
            for (Map.Entry<Integer, Character> entry : map.entrySet()) {
                System.out.println("Thread " + Thread.currentThread().getId() +
                        " retrieved key: " + entry.getKey() + ", value: " + entry.getValue());
            }
        }
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer, Character> synchronizedHashMap = Collections.synchronizedMap(new HashMap<>());

        Thread[] putThreads = new Thread[10];
        Thread[] getThreads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            final int index = i;
            putThreads[i] = new HashMapPutThread(i, (char) ('A' + i), synchronizedHashMap);
            getThreads[i] = new HashMapGetThread(synchronizedHashMap);

            putThreads[i].start();
            getThreads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            putThreads[i].join();
            getThreads[i].join();
        }

        System.out.println("Final elements in the map:");
        synchronized (synchronizedHashMap) {
            for (Map.Entry<Integer, Character> entry : synchronizedHashMap.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
        }
    }
}




