
public class Main {

    public static void main(String[] args) {
        Perpustakaan perpus = new Perpustakaan("Perpustakaan Pusat UB");

        perpus.bacaFile("data_buku.txt");
        perpus.tampilInfo();

        perpus.simpanFile("data_buku_output.txt");

        Penulis penulis = new Penulis("Tere Liye", "Indonesia");
        double royalti = penulis.hitungRoyalti(100_000);
        System.out.println("Harga royalti: " + royalti);

        double customPercentage = penulis.hitungRoyalti(100_000, 15);
        System.out.println("Harga royalti: " + customPercentage);
    }
}
