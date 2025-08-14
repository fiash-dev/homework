import java.util.ArrayList;
import java.util.List;

class Animals {
    abstract class Animal {
        private int age;
        private String name;

        public Animal(int age, String name) {
            this.age = Math.max(age, 0);
            this.name = name;
        }

        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = Math.max(age, 0);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void eat() {}
        public  void move() {}

    }

    class Spine {
        private int vertebraeNum;
        public Spine(int vertebraeNum) {
            this.vertebraeNum = vertebraeNum;
        }

    }

    class Fur {
        private String color;
        public Fur(String color) {
            this.color = color;
        }
    }

    class Mammal extends Animal {
        private Spine spine;
        public Mammal(Spine spine, int age, String name) {
            super(age, name);
            this.spine = spine;
        }

        public void drinkMilk () {
            System.out.println(this.getName() + " питается молоком в детстве");
        }
    }

    class Fish extends Animal {
        public Fish(int age, String name) {
            super(age, "Рыба");
        }

        @Override
        public void eat() {
            System.out.println("Питается водорослями");
        }

        @Override
        public void move() {
            System.out.println("Плавает в воде");
        }
    }

    class Cat extends Mammal {
        private Fur fur;

        public Cat(Fur fur, Spine spine, int age, String name) {
            super(spine, age, "Кошка");
            this.fur = fur;
        }

        @Override
        public void eat() {
            System.out.println("Питается мышками");
        }

        @Override
        public void move() {
            System.out.println("Ходит, прыгает и лазает");
        }
    }

    class Bear extends Mammal {
        private Fur fur;

        public Bear(Fur fur, Spine spine, int age, String name) {
            super(spine, age, "Медведь");
            this.fur = fur;
        }

        @Override
        public void eat() {
            System.out.println("Питается мёдом");
        }

        @Override
        public void move() {
            System.out.println("Ходит на четырех лапах");
        }
    }

    class Whale extends Mammal {
        public Whale(Spine spine, int age, String name) {
            super(spine, age, "Кит");
        }

        @Override
        public void eat() {
            System.out.println("Питается водорослями и мелкой рыбой");
        }

        @Override
        public void move() {
            System.out.println("Плавает в океане");
        }
    }

    class Water {

        List<Fish> fishes = new ArrayList<>();
        List<Whale> whales = new ArrayList<>();

        public Water (int fishesNum, int whalesNum) {
            for (int i = 0; i < fishesNum; i++) {
                this.fishes.add(new Fish(5, ("Рыба" + i)));
            }
            for (int i = 0; i < whalesNum; i++) {
                this.whales.add(new Whale(new Spine(55),5, ("Кит" + i)));
            }
        }

        public int countAnimals() {
            return this.fishes.size() + this.whales.size();
        }
    }
}