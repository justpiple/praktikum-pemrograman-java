
public class Main {

    public static void main(String[] args) {
        Kue[] daftarKue = new Kue[20];

        daftarKue[0] = new KuePesanan("Brownies", 50000, 1.5);
        daftarKue[1] = new KueJadi("Donat", 3000, 10);
        daftarKue[2] = new KuePesanan("Lapis", 45000, 2);
        daftarKue[3] = new KueJadi("Kue Cubit", 2000, 15);
        daftarKue[4] = new KuePesanan("Bolu", 40000, 1.2);
        daftarKue[5] = new KueJadi("Risoles", 2500, 20);
        daftarKue[6] = new KuePesanan("Tart", 100000, 1);
        daftarKue[7] = new KueJadi("Pastel", 3000, 12);
        daftarKue[8] = new KuePesanan("Klepon", 20000, 2.5);
        daftarKue[9] = new KueJadi("Lemper", 3500, 8);
        daftarKue[10] = new KuePesanan("Putu", 15000, 1.8);
        daftarKue[11] = new KueJadi("Onde-onde", 2500, 14);
        daftarKue[12] = new KuePesanan("Serabi", 18000, 2);
        daftarKue[13] = new KueJadi("Nagasari", 2000, 16);
        daftarKue[14] = new KuePesanan("Apem", 22000, 1.3);
        daftarKue[15] = new KueJadi("Bakpia", 4000, 9);
        daftarKue[16] = new KuePesanan("Dadar Gulung", 17000, 2.1);
        daftarKue[17] = new KueJadi("Kastengel", 5000, 7);
        daftarKue[18] = new KuePesanan("Martabak", 60000, 1.4);
        daftarKue[19] = new KueJadi("Pukis", 3000, 11);

        double totalHarga = 0;
        double totalHargaPesanan = 0;
        double totalBerat = 0;

        double totalHargaJadi = 0;
        double totalJumlah = 0;

        Kue kueTermahal = daftarKue[0];

        for (Kue daftarKue1 : daftarKue) {
            System.out.println(daftarKue1);
            double h = daftarKue1.hitungHarga();
            totalHarga += h;
            if (daftarKue1 instanceof KuePesanan kp) {
                totalHargaPesanan += kp.hitungHarga();
                totalBerat += kp.berat;
            } else if (daftarKue1 instanceof KueJadi kj) {
                totalHargaJadi += kj.hitungHarga();
                totalJumlah += kj.jumlah;
            }
            if (h > kueTermahal.hitungHarga()) {
                kueTermahal = daftarKue1;
            }
        }

        System.out.println("\nTotal harga semua kue: " + totalHarga);

        System.out.println("Total harga KuePesanan: " + totalHargaPesanan);
        System.out.println("Total berat KuePesanan: " + totalBerat);

        double TotalJumlahJadi = totalJumlah;
        System.out.println("Total harga KueJadi: " + totalHargaJadi);
        System.out.println("Total jumlah KueJadi: " + TotalJumlahJadi);

        System.out.println("\nKue dengan harga terbesar:");
        System.out.println(kueTermahal);
    }
}
