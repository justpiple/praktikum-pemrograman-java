
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kategori {

    String namaKategori;
    String deskripsi;
    List<Buku> daftarBuku;

    public Kategori(String namaKategori, String deskripsi) {
        this.namaKategori = namaKategori;
        this.deskripsi = deskripsi;
        this.daftarBuku = new ArrayList<>();
    }

    public void tambahBuku(Buku... buku) {
        daftarBuku.addAll(Arrays.asList(buku));
    }

    public void tampilInfo() {
        System.out.println("=".repeat(30));
        System.out.println("  KATEGORI : " + namaKategori.toUpperCase());
        System.out.println("  Deskripsi: " + deskripsi);
        System.out.println("  Jumlah Buku: " + daftarBuku.size());
        System.out.println("-".repeat(30));
        for (Buku b : daftarBuku) {
            b.tampilInfo();
        }
    }
}
