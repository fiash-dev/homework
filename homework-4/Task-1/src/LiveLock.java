public class LiveLock {
    static class Person {
        final private String name;
        private boolean isPassing;

        public Person(String name, boolean isPassing) {
            this.name = name;
            this.isPassing = isPassing;
        }

        public String getName() { return name; }

        public boolean isPassing() { return isPassing; }

        public void setPassing(boolean passing) { isPassing = passing; }

        public synchronized void pass(Person other) {
            while (isPassing) {
                if (other.isPassing()) {
                    System.out.println(name + ": " + other.getName() + ", проходи ты первый!");
                    setPassing(false);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    continue;
                }

                System.out.println(name + ": Прохожу...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                setPassing(false);
            }
        }
    }

    public static void main(String[] args) {
        Person Alex = new Person("Алексей", true);
        Person Maria = new Person("Мария", true);

        Thread thread1 = new Thread(() -> {
            while (true) {
                Alex.pass(Maria);
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                Maria.pass(Alex);
            }
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt();
        thread2.interrupt();
        System.out.println("Программа завершена (но потоки так и не прошли через дверь)");
    }
}
