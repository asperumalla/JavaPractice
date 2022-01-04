import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample {

    /**
     * We need to initialize the ThreadLocal value, if not will run into NullPointer Exceptions
     * There is a static method available to initilize.
     */
    private ThreadLocal<Integer> seqCounter = ThreadLocal.withInitial( () -> 1  );

    // perform a task
    public void run(){

        for( int i = 0; i < 5; i ++){
            System.out.println( "Thread Name:" + Thread.currentThread().getName() + " --> val:" + seqCounter.get()  );
            seqCounter.set(  seqCounter.get() + 1);
            sleep();
        }

        /**
         *  The very important step to clear the ThreadLocal variables, to reset the state when the Thread is re-used
         */
        seqCounter.remove();
    }

    private void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void printdifferent(){
        System.out.println("Different :"+ Thread.currentThread().getName());
    }


    public static void main (String[] args) {
        ThreadLocalExample example = new ThreadLocalExample();

        /**
         *  Observe the behaviour of the threads when they are re-used.
         *  They tend to re-use the ThreadLocal state, if the values are not cleared
         *  as done in line 24
         */
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.submit(  example::run);
        service.submit( example::printdifferent );
        service.submit(example::run);

        service.shutdown();


    }
}
