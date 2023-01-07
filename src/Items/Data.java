package Items;

import fame.FAMECipherText;

public class Data {

    String name,surname,sector,hospital,mess,filepath;
    FAMECipherText cpt;

    public FAMECipherText getCpt() {
        return cpt;
    }

    public void setCpt(FAMECipherText cpt) {
        this.cpt = cpt;
    }

    int id;


    public String getSurname() {
        return surname;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }



    public Data() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
