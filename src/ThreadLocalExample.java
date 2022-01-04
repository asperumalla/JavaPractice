public class ThreadLocalExample implements Runnable {

    //Create Threalocal for the element to be shared accross Threads - to avoid concurrency issue
    private ThreadLocal<Integer> seqCounter = new ThreadLocal<>();

    // perform a task
    public void run(){

        if( seqCounter.get() == null ){
            seqCounter.set(1);
        }

        for( int i = 0; i < 5; i ++){
            System.out.println( "Thread Name:" + Thread.currentThread().getName() + " --> val:" + seqCounter.get()  );
            seqCounter.set(  seqCounter.get() + 1);
            sleep();
        }
    }

    private void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main (String[] args) {
        ThreadLocalExample example = new ThreadLocalExample();
        Thread t1 =  new Thread(example);
        Thread t2 =  new Thread(example);

        t1.start();
        t2.start();


    }
}
