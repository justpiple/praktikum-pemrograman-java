
public class Main {

    public static void main(String[] args) {
        Perpustakaan perpus = new Perpustakaan("Perpustakaan Pusat UB");

        perpus.bacaFile("data_buku.txt");
        perpus.tampilInfo();

        perpus.simpanFile("data_buku_output.txt");
    }
}
