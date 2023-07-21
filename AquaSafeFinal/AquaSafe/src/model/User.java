package model;

public class User {
    private String fullname;
    private String email;
    private String kartuanggota;
    private String password;
    private String tanggalLahir;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKartuanggota() {
        return kartuanggota;
    }

    public void setKartuanggota(String kartuanggota) {
        this.kartuanggota = kartuanggota;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public User(String fullName, String email, String kartuAnggota, String password, String tanggalLahir) {
        this.fullname = fullName;
        this.email = email;
        this.kartuanggota = kartuAnggota;
        this.password = password;
        this.tanggalLahir = tanggalLahir;
    }

    


}
