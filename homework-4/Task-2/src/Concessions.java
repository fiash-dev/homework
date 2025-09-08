class Concessions {
    public static class Task {
        private boolean shouldPrint;
        private final String number;

        public Task(boolean shouldPrint, String number) {
            this.shouldPrint = shouldPrint;
            this.number = number;
        }

        public boolean isPassing() {return shouldPrint;}

        public void setPassing(boolean passing) {shouldPrint = passing;}

        public void shouldPrintNow(Task other) {
            while (true) {
                while (!isPassing()) {
                    Thread.yield();
                }

                System.out.print(number + " ");

                setPassing(false);
                other.setPassing(true);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Task print1 = new Task(true, "1");
        Task print2 = new Task(false, "2");

        Thread thread1 = new Thread (() -> print1.shouldPrintNow(print2));
        Thread thread2 = new Thread (() -> print2.shouldPrintNow(print1));

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt();
        thread2.interrupt();

        System.out.println("\nПрограмма завершена");
    }
}
