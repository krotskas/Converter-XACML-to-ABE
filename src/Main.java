import Items.EncDecSoftware;
import Items.Handler;
import Items.TrustedAuthority;
import Items.User;
import fame.*;
import javax.swing.JFileChooser;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {



    public static void main(String[] args) throws Exception {

        FAME cpabe=new FAME();
        User us=new User();
        Map<String,String> user1=us.attrs;
        TrustedAuthority TA=new TrustedAuthority(cpabe);
        EncDecSoftware EDS=new EncDecSoftware(cpabe);
        Handler hnd=new Handler(cpabe,EDS,TA,us);

        System.out.println("~~~~WELCOME TO THE ED SOFTWARE~~~~");


        System.out.println("Your Attributes are: ");
        user1.put("id","12345");
        user1.put("username","krotskas");
        user1.put("email","kostasrotskas@gmail.com");
        user1.put("sector","wrilas");
        user1.put("hospital","lamias");
        for (Map.Entry<String, String> me : user1.entrySet()) {
            System.out.print(me.getKey() + ":");
            System.out.println(me.getValue());
        }
        hnd.menu();


    }
}