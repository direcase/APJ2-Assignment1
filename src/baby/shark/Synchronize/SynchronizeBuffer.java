package baby.shark.Synchronize;

import java.util.concurrent.ArrayBlockingQueue;

public class SynchronizeBuffer implements Buffer{
    private final ArrayBlockingQueue<Integer> buffer; // shared buffer

    public SynchronizeBuffer() {
        buffer = new ArrayBlockingQueue<Integer>(1);
    }
    @Override
    public synchronized void blockingPut(int value) throws InterruptedException
    {
        buffer.put(value); // place value in buffer
        /*System.out.printf("%s%2d\t%s%d%n", "Producer writes ", value,
                "Buffer cells occupied: ", buffer.size());*/
    }
    // return value from buffer
    @Override
    public synchronized int blockingGet() throws InterruptedException {
        int readValue = buffer.take();
        /*System.out.printf("%s %2d\t%s%d%n", "Consumer reads ",
                readValue, "Buffer cells occupied: ", buffer.size());*/
        return readValue;
    }
}
