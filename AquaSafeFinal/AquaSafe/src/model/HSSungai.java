package model;

public class HSSungai {
   String namaSungai;
   String alamatSungai;
   String namaPeneliti;
   String tanggalPenelitian;
   
   double PH;
   double Do;
   double BOD;
   double TSS;
   double COD;
    public String getNamaSungai() {
    return namaSungai;
}
public void setNamaSungai(String namaSungai) {
    this.namaSungai = namaSungai;
}
public String getAlamatSungai() {
    return alamatSungai;
}
public void setAlamatSungai(String alamatSungai) {
    this.alamatSungai = alamatSungai;
}
public String getNamaPeneliti() {
    return namaPeneliti;
}
public void setNamaPeneliti(String namaPeneliti) {
    this.namaPeneliti = namaPeneliti;
}
public String getTanggalPenelitian() {
    return tanggalPenelitian;
}
public void setTanggalPenelitian(String tanggalPenelitian) {
    this.tanggalPenelitian = tanggalPenelitian;
}
public double getPH() {
    return PH;
}
public void setPH(double pH) {
    PH = pH;
}
public double getDo() {
    return Do;
}
public void setDo(double do1) {
    Do = do1;
}
public double getBOD() {
    return BOD;
}
public void setBOD(double bOD) {
    BOD = bOD;
}
public double getTSS() {
    return TSS;
}
public void setTSS(double tSS) {
    TSS = tSS;
}
public double getCOD() {
    return COD;
}
public void setCOD(double cOD) {
    COD = cOD;
}
    public HSSungai(String namaSungai, String alamatSungai, String namaPeneliti, String tanggalPenelitian, double pH,
        double do1, double bOD, double tSS, double cOD) {
    this.namaSungai = namaSungai;
    this.alamatSungai = alamatSungai;
    this.namaPeneliti = namaPeneliti;
    this.tanggalPenelitian = tanggalPenelitian;
    PH = pH;
    Do = do1;
    BOD = bOD;
    TSS = tSS;
    COD = cOD;
}
   
}