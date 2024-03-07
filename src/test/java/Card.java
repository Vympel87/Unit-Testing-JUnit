import java.time.LocalDate;

public class Card {
    String namaPemilik;
    Integer noRek;
    String namaBank;

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    LocalDate masaAktif;

//    public Card(String namaPemilik, Integer noRek) {
//        this.namaPemilik = namaPemilik;
//        this.noRek = noRek;
//    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public Integer getNoRek() {
        return noRek;
    }

    public void setNoRek(Integer noRek) {
        this.noRek = noRek;
    }

    public LocalDate getMasaAktif() {
        return masaAktif;
    }

    public void setMasaAktif(LocalDate masaAktif) {
        this.masaAktif = masaAktif;
    }
}
