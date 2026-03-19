
public class Penulis {

    String nama;
    String kebangsaan;

    public Penulis(String nama, String kebangsaan) {
        this.nama = nama;
        this.kebangsaan = kebangsaan;
    }

    public void tampilInfo() {
        System.out.println("    Penulis   : " + nama + " (" + kebangsaan + ")");
    }

    public double hitungRoyalti(double hargaSatuBuku) {
        return hargaSatuBuku * 0.10;
    }

    public double hitungRoyalti(double hargaSatuBuku, double persenRoyalti) {
        return hargaSatuBuku * (persenRoyalti / 100);
    }

    public Penulis copy() {
        return new Penulis(this.nama, this.kebangsaan);
    }
}
