
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Perpustakaan {

    String namaPerpus;
    List<Kategori> daftarKategori;

    public Perpustakaan(String namaPerpus) {
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

    public void simpanFile(String namaFile) {
        List<String> lines = new ArrayList<>();

        for (Kategori kategori : daftarKategori) {
            for (Buku buku : kategori.daftarBuku) {
                lines.add("KATEGORI:" + kategori.namaKategori);
                lines.add("JUDUL:" + buku.judul);
                lines.add("TAHUN:" + buku.tahunTerbit);
                lines.add("ISBN:" + buku.isbn);
                lines.add("SINOPSIS:" + buku.sinopsis);

                for (Penulis p : buku.daftarPenulis) {
                    lines.add("PENULIS:" + p.nama + "::" + p.kebangsaan);
                }

                lines.add("---");
            }
        }

        try {
            Files.write(Path.of(namaFile), lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Data berhasil disimpan ke: " + namaFile);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan file: " + e.getMessage());
        }
    }

    public void bacaFile(String namaFile) {
        Map<String, Kategori> mapKategori = new LinkedHashMap<>();

        String namaKategori = null, judul = null, isbn = null, sinopsis = null;
        int tahun = 0;
        List<Penulis> penulisList = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(namaFile), StandardCharsets.UTF_8);

            for (String line : lines) {
                if (line.startsWith("KATEGORI:")) {
                    namaKategori = line.substring(9);
                } else if (line.startsWith("JUDUL:")) {
                    judul = line.substring(6);
                } else if (line.startsWith("TAHUN:")) {
                    tahun = Integer.parseInt(line.substring(6));
                } else if (line.startsWith("ISBN:")) {
                    isbn = line.substring(5);
                } else if (line.startsWith("SINOPSIS:")) {
                    sinopsis = line.substring(9);
                } else if (line.startsWith("PENULIS:")) {
                    String[] bagian = line.substring(8).split("::", 2);
                    String nama = bagian.length > 0 ? bagian[0] : "";
                    String kebangsaan = bagian.length > 1 ? bagian[1] : "";
                    penulisList.add(new Penulis(nama, kebangsaan));
                } else if (line.equals("---")) {
                    Kategori kategori = mapKategori.computeIfAbsent(
                            namaKategori, k -> new Kategori(k, "")
                    );
                    Buku buku = new Buku(judul, tahun, isbn, null, sinopsis);
                    for (Penulis p : penulisList) {
                        buku.tambahPenulis(p);
                    }
                    kategori.tambahBuku(buku);

                    namaKategori = judul = isbn = sinopsis = null;
                    tahun = 0;
                    penulisList = new ArrayList<>();
                }
            }

            this.daftarKategori = new ArrayList<>(mapKategori.values());
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Format tahun tidak valid: " + e.getMessage());
        }
    }

    public Perpustakaan copy() {
        return new Perpustakaan(this.namaPerpus);
    }
}
