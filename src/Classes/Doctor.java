package Classes;

public class Doctor {


    String username,password,email,firstName,surname;

    public Doctor(String username, String password, String email, String firstName, String surname) {
        this.username=username;
        this.password=password;
        this.email=email;
        this.firstName=firstName;
        this.surname=surname;

    }


    public void upload(){

    }

    public void download(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
