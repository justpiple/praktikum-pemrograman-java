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

    public Penulis copy() {
        return new Penulis(this.nama, this.kebangsaan);
    }
}
