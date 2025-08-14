class Transports {
    abstract class Transport {
        private String model;

        public Transport(String model) {
            this.model = model;
        }

        public void move() {}
    }

    class Wheel {
        public void inflare(int psi) {
        }
    }

    class Screw {
        public void turnover(int rpm) {}
    }

    class Wings {
        public int wingLength;

        public void Wing(int wingLength) {
            this.wingLength = wingLength;
        }
    }

    @FunctionalInterface
    interface CarryCargo {
        void carryCargo();
    }

    class Airplane extends Transport implements CarryCargo{
        public Wheel[] wheel = new Wheel[6];
        public Wings wings = new Wings();
        public Screw[] screws = new Screw[2];

        public Airplane(String model) {
            super(model);

            for(int i = 0; i<6; i++) {
                wheel[i]= new Wheel();
            }

            for(int i = 0; i<6; i++) {
                screws[i]= new Screw();
            }
        }

        @Override
        public void carryCargo() {
            System.out.println("Возит грузы над землей");
        }

        @Override
        public void move () {
            System.out.println("Куда-то движется по воздуху");
        }
    }

    class Helicopter extends Transport implements CarryCargo {
        public Wheel[] wheels = new Wheel[3];
        public Screw screw = new Screw();


        public Helicopter(String model) {
            super(model);

            for (int i = 0; i < 3; i++) {
                wheels[i] = new Wheel();
            }
        }

        @Override
        public void carryCargo() {
            System.out.println("Возит грузы над землей");
        }

        @Override
        public void move() {
            System.out.println("Куда-то движется по воздуху");
        }
    }

    class Boat extends Transport implements CarryCargo {
        public Screw screw = new Screw();

        public Boat(String model) {
            super(model);
        }

        @Override
        public void carryCargo() {
            System.out.println("Возит грузы по воде");
        }

        @Override
        public void move() {
            System.out.println("Куда-то движется по воде");
        }
    }

    class Tanker extends Transport implements CarryCargo {

        public Tanker(String model) {
            super(model);
        }

        public Screw screw = new Screw();

        @Override
        public void carryCargo() {
            System.out.println("Возит грузы по воде");
        }

        @Override
        public void move() {
            System.out.println("Куда-то движется по воде");
        }
    }

    class Truck extends Transport implements CarryCargo {
        Wheel[] wheels = new Wheel[10];

        public Truck(String model) {
            super(model);

            for (int i = 0; i < 10; i++) {
                wheels[i] = new Wheel();
            }
        }

        @Override
        public void carryCargo() {
            System.out.println("Возит тяжелые грузы по дорогам");
        }

        @Override
        public void move() {
            System.out.println("Куда-то едет");
        }
    }

    class Taxi extends Transport {
        Wheel[] wheels = new Wheel[4];

        public Taxi(String model) {
            super(model);

            for (int i = 0; i < 4; i++) {
                wheels[i] = new Wheel();
            }
        }

        @Override
        public void move() {
            System.out.println("Куда-то едет");
        }

        private void carryPassengers() {
            System.out.println("Возит пассажиров по дорогам");
        }

    }
}