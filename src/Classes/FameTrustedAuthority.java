package Classes;
import fame.*;
import java.security.NoSuchAlgorithmException;

public class FameTrustedAuthority {
    private FAME cpabe;

    public FameTrustedAuthority(FAME cpabe) {
        this.cpabe=cpabe;
    }




    public FAMEMasterKey Setup(){
        FAMEMasterKey msk = cpabe.setup();
        System.out.println("~~~~ Setup Complete ~~~~");
        return msk;
    }

    public FAMESecretKey SecretKey(FAMEMasterKey msk, String [] attrs) throws NoSuchAlgorithmException {

        FAMESecretKey skey = cpabe.keygen(msk, attrs);
        System.out.println("~~~~ Keygen Complete ~~~~");
        return skey;

    }

}
