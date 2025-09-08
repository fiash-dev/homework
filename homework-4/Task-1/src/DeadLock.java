public class DeadLock {
    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();

        Thread threadA = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            synchronized (lockA) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lockB){
                }
            }
            System.out.println(Thread.currentThread().getName() + " end");
        },"ThreadA" );

        Thread threadB = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            synchronized (lockB) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lockA){

                }
            }
            System.out.println(Thread.currentThread().getName() + " end");
        },"ThreadB" );

        threadB.start();
        threadA.start();
    }
}
