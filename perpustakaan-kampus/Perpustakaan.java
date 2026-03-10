
import java.util.ArrayList;
import java.util.List;

public class Perpustakaan {

    String namaPerpus;
    List<Kategori> daftarKategori;

    public Perpustakaan(String namaPerpus, String lokasiKampus) {
        this.namaPerpus = namaPerpus;
        this.daftarKategori = new ArrayList<>();
    }

    public void tambahKategori(Kategori k) {
        daftarKategori.add(k);
    }

    public int totalBuku() {
        int total = 0;
        for (Kategori k : daftarKategori) {
            total += k.daftarBuku.size();
        }
        return total;
    }

    public void tampilInfo() {
        System.out.println("#".repeat(30));
        System.out.println("  PERPUSTAKAAN : " + namaPerpus);
        System.out.println("  Total Kategori: " + daftarKategori.size());
        System.out.println("  Total Buku    : " + totalBuku());
        System.out.println("#".repeat(30));

        for (Kategori k : daftarKategori) {
            k.tampilInfo();
        }
    }
}
