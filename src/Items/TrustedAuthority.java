package Items;
import fame.*;
import java.security.NoSuchAlgorithmException;

public class TrustedAuthority {
    private FAME cpabe;

    public TrustedAuthority(FAME cpabe) {
        this.cpabe=cpabe;
    }




    public FAMEMasterKey Setup(){
        FAMEMasterKey msk = cpabe.setup();
        return msk;
    }

    public FAMESecretKey SecretKey(FAMEMasterKey msk, String [] attrs) throws NoSuchAlgorithmException {

        FAMESecretKey skey = cpabe.keygen(msk, attrs);
        return skey;

    }

}
