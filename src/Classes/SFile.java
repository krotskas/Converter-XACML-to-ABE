package Classes;

import java.io.File;

public class SFile {

    String pathname;
    File policy=new File(pathname);
    int file_id;
    String patient_name,mess;

    public SFile(String pathname, File policy, int file_id, String patient_name, String mess) {
        this.pathname = pathname;
        this.policy = policy;
        this.file_id = file_id;
        this.patient_name = patient_name;
        this.mess = mess;
    }

    public String getPathname() {
        return pathname;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    public File getPolicy() {
        return policy;
    }

    public void setPolicy(File policy) {
        this.policy = policy;
    }

    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
}
