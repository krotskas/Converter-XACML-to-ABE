package Classes;

public class DocAttributes extends Doctor {

    String sector,hospital;
    int id;


    public DocAttributes(int id, String username, String password, String email, String firstName, String surname, String sector, String hospital) {
        super(username, password, email, firstName, surname);
        this.id=id;
        this.sector=sector;
        this.hospital=hospital;
    }


    public String [] getAttributes(){
        String id=Integer.toString(getId());
        String [] attrs={id,getSector(),getHospital()};
        return attrs;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
