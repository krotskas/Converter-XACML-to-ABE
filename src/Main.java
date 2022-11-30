import fame.*;
import java.time.Duration;
import java.time.Instant;



public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        FAME cpabe = new FAME();
        Instant start_init = Instant.now();
        FAMEMasterKey msk = cpabe.setup();
        Instant end_init = Instant.now();
        System.out.println("~~~~ Setup Complete ~~~~");
        System.out.println("elapsed time:" + Duration.between(start_init, end_init) + "\n");
    }


}