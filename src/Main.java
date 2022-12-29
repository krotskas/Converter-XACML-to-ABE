import Classes.DocAttributes;
import Classes.EncDecSoftware;
import Classes.TrustedAuthority;
import fame.*;


public class Main {
    public static void main(String[] args) throws Exception {

        FAME cpabe=new FAME();

        DocAttributes doctor=new DocAttributes(12345,"kwstas","1234567890","kwstas@gmail.com","kwstas","rotskas","Wrilas","GN Lamias");
        EncDecSoftware system=new EncDecSoftware(cpabe);

        String message = "Ο ασθενης πασχει απο ωτιτιδα";

        TrustedAuthority TA=new TrustedAuthority(cpabe);
        FAMEMasterKey mskey=TA.Setup();
        FAMESecretKey sk= TA.SecretKey(mskey, doctor.getAttributes());
        FAMECipherText cpt= system.Encrypt(system.AbacToAbe("Policies/policy.xml"),message);
        String decrypted_mess= system.Decrypt(sk,cpt);
        System.out.println(decrypted_mess);

    }


}