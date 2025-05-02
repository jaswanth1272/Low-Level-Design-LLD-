package RidePool;

public class Main {

    public static void run() {
        Rider r1 = new Rider("R1",1,"1111111111",VehicleType.BIKE, 1,
                             new Place("Raidurg", 0, 0), new Place("Banjarahills", 3, 3), 9);
        Rider r2 = new Rider("R2",2,"2222222222",VehicleType.BIKE,1, new Place("Madhapur", 1, 1), new Place("Jubilee hills", 5, 5),11);
        Rider r3 = new Rider("R3",3,"3333333333",VehicleType.CAR,2, new Place("Madhapur", 1, 1), new Place("L.B.Nagar", 7, 7),8);

        Vehicle v1 = VehicleFactory.createVehicle("bike","KA01AB1234");
        Vehicle v2 = VehicleFactory.createVehicle("bike","TS02XY5678");
        Vehicle v3 = VehicleFactory.createVehicle("car","AP03MN9876");

        Pooler p1 = new Pooler("P1", 1, "9876543210", v1, 1,
            new Place("Manikonda", -1, 0),
            new Place("Banjarahills", 3, 3),
            8);

        Pooler p2 = new Pooler("P2", 2, "9123456780", v2, 1,
            new Place("Raidurg", 0, 0),
            new Place("Ameerpet", 6, 6),
            10);

        Pooler p3 = new Pooler("P3", 3, "9000000001", v3, 2,
            new Place("Madhapur", 1, 1),
            new Place("L.B.Nagar", 7, 7),
            7);
            
        RideController controller = RideController.getInstance();

        controller.addRider(r1);
        controller.addRider(r2);
        controller.addRider(r3);

        controller.addPooler(p1);
        controller.addPooler(p2);
        controller.addPooler(p3);

        while(true);
    }
    public static void main(String[] args) {
        run();
    }
}
