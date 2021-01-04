package baby.shark.Synchronize;

import java.util.concurrent.ArrayBlockingQueue;

public class SynchronizeBuffer implements Buffer{
    private final ArrayBlockingQueue<Integer> buffer; // shared buffer
    private boolean occupied = false;

    public SynchronizeBuffer() {
        buffer = new ArrayBlockingQueue<Integer>(1);
    }
    @Override
    public synchronized void blockingPut(int value) throws InterruptedException
    {
        while (occupied) {
            wait();
        }
        buffer.put(value);
        occupied = true;
        notifyAll();
        /*System.out.printf("%s%2d\t%s%d%n", "Producer writes ", value,
                "Buffer cells occupied: ", buffer.size());*/
    }
    // return value from buffer
    @Override
    public synchronized int blockingGet() throws InterruptedException {
        while (!occupied)
        {
            wait();
        }
        occupied = false;
        int readValue = buffer.take();
        notify();
        /*System.out.printf("%s %2d\t%s%d%n", "Consumer reads ",
                readValue, "Buffer cells occupied: ", buffer.size());*/
        return readValue;
    }
}
