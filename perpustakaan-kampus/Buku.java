import java.util.ArrayList;
import java.util.List;

public class Buku {

    String judul;
    int tahunTerbit;
    String isbn;
    List<Penulis> daftarPenulis;
    String sinopsis;

    public Buku(String judul, int tahunTerbit, String isbn, List<Penulis> daftarPenulis, String sinopsis) {
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.isbn = isbn;
        this.daftarPenulis = daftarPenulis != null ? new ArrayList<>(daftarPenulis) : new ArrayList<>();
        this.sinopsis = sinopsis;
        validasiSinopsisMinimal10Kata();
    }

    public Buku(String judul, int tahunTerbit, String isbn) {
        this(judul, tahunTerbit, isbn, null, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec aliquet.");
    }

    public void tambahPenulis(Penulis p) {
        daftarPenulis.add(p);
    }

    public int hitungJumlahKataSinopsis() {
        if (sinopsis == null || sinopsis.isBlank())
            return 0;
        String[] kata = sinopsis.trim().split(" ");
        return kata.length;
    }

    public double cekTingkatKesamaan(Buku lain) {
        if (lain == null)
            return 0;
        int total = 4;
        int skor = 0;

        if (this.judul != null && this.judul.equalsIgnoreCase(lain.judul))
            skor++;
        if (this.tahunTerbit == lain.tahunTerbit)
            skor++;
        if (this.isbn != null && this.isbn.equals(lain.isbn))
            skor++;
        if (this.sinopsis != null && this.sinopsis.equalsIgnoreCase(lain.sinopsis))
            skor++;

        return (double) skor / total * 100;
    }

    private void validasiSinopsisMinimal10Kata() {
        if (hitungJumlahKataSinopsis() < 10) {
            System.out.println("kurang dari 10 kata");
        }
    }

    public void tampilInfo() {
        System.out.println("    Judul     : " + judul);
        System.out.println("    ISBN      : " + isbn);
        System.out.println("    Terbit    : " + tahunTerbit);
        System.out.println("    Sinopsis  : " + sinopsis);
        for (Penulis p : daftarPenulis) {
            p.tampilInfo();
        }
        System.out.println();
    }

    public Buku copy() {
        return new Buku(this.judul, this.tahunTerbit, this.isbn, this.daftarPenulis, this.sinopsis);
    }
}
