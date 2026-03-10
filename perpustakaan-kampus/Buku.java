
import java.util.ArrayList;
import java.util.List;

public class Buku {

    String judul;
    int tahunTerbit;
    String isbn;
    List<Penulis> daftarPenulis;

    public Buku(String judul, int tahunTerbit, String isbn) {
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.isbn = isbn;
        this.daftarPenulis = new ArrayList<>();
    }

    public void tambahPenulis(Penulis p) {
        daftarPenulis.add(p);
    }

    public void tampilInfo() {
        System.out.println("    - Judul     : " + judul);
        System.out.println("      ISBN      : " + isbn);
        System.out.println("      Terbit    : " + tahunTerbit);
        for (Penulis p : daftarPenulis) {
            p.tampilInfo();
        }
        System.out.println();
    }
}
