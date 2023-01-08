package Items;

import com.sun.tools.javac.Main;
import fame.FAME;
import fame.FAMECipherText;
import fame.FAMEMasterKey;

import javax.swing.JFileChooser;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Handler {

    FAME cpabe=new FAME();
    EncDecSoftware eds=new EncDecSoftware(cpabe);
    TrustedAuthority ta=new TrustedAuthority(cpabe);
    User us=new User();
    Datalist dl=new Datalist();
    FAMEMasterKey msk;
    public Handler(FAME cpabe,EncDecSoftware eds,TrustedAuthority ta,User us) {
        this.cpabe=cpabe;
        this.eds=eds;
        this.ta=ta;
        this.us=us;
        this.msk=ta.Setup();
    }

    public void menu() throws Exception {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Scanner in=new Scanner(System.in);
        System.out.println("Please Choice what do you want to do:");
        System.out.println("1.View the Patients");
        System.out.println("2.Upload new Patient Data");
        System.out.println("3.Exit");
        int choice=in.nextInt();
        switch (choice){
            case 1:
                view();
                break;
            case 2:
                upload();
                menu();
                break;
            case 3:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Please select right choise!!!!!");
                menu();
        }
    }

    private void view() throws Exception {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        for (Map.Entry<Integer,Data> entry:dl.dt.entrySet()) {
            Data tempd=entry.getValue();
            System.out.println("Patient_ID:"+tempd.getId()+"\t"+"Patient_Name:"+tempd.getName()+"\t"+"Patient_Surname:"+tempd.getSurname()+"\t"+"Sector:"+tempd.getSector()+"\t"+"Hospital:"+tempd.getHospital());

        }
        System.out.println("Which Patient do you want to visit (Select with ID), to go back press 0:");
        Scanner in=new Scanner(System.in);
        int choice=in.nextInt();
        if (choice==0){
            menu();
        } else if (dl.dt.containsKey(choice)) {
            download(choice);
        }
        else
        {
           System.out.println("Please Enter ID which exists");
           view();
        }
    }

    private void download(int choice) throws Exception {
        Data decd= dl.dt.get(choice);
        String decmess= eds.Decrypt(ta.SecretKey(msk,us.attrs.values().toArray(new String[0])), decd.cpt);
        System.out.println(decmess);
        menu();
    }

    private void upload() throws Exception {
        Data d=new Data();
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Patient's Name: ");
        String name=in.nextLine();
        d.setName(name);
        System.out.println("Enter Patient's Surname: ");
        String surname=in.nextLine();
        d.setSurname(surname);
        System.out.println("Enter Patient's Sector: ");
        String sector=in.nextLine();
        d.setSector(sector);
        System.out.println("Enter Patient's Hospital: ");
        String hospital=in.nextLine();
        d.setHospital(hospital);
        System.out.println("Upload XML File for XACML Policy: ");
        JFileChooser file = new JFileChooser();
        file.setMultiSelectionEnabled(true);
        file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        file.setFileHidingEnabled(false);
        String filepath="";
        if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            java.io.File f = file.getSelectedFile();
            filepath=f.getPath();
            d.setFilepath(filepath);
        }
        System.out.println("Enter what do you want to Encrypt: ");
        String mess=in.nextLine();
        d.setMess(mess);
        Random random=new Random();
        int id= random.nextInt(50000);
        d.setId(id);
        FAMECipherText cpt= eds.Encrypt(eds.AbacToAbe(filepath), mess);
        d.setCpt(cpt);
        dl.putData(id,d);
    }

}
