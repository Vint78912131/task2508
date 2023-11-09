public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        while (!thread.interrupted()) {
            System.out.println(thread.getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }

        }
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this,threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}