
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            GoDriveRentalSystem rental = new GoDriveRentalSystem();

            int pilih;

            do {
                System.out.println("\n====== MENU GO DRIVE RENTAL SYSTEM ======");
                System.out.println("1. Tambah Kendaraan");
                System.out.println("2. Tampilkan Daftar Armada");
                System.out.println("3. Sewa Kendaraan");
                System.out.println("4. Kembalikan Kendaraan");
                System.out.println("5. Keluar");
                System.out.print("Pilih menu : ");
                pilih = input.nextInt();
                input.nextLine();

                switch (pilih) {

                    case 1 -> {
                        System.out.println("\n1. Mobil");
                        System.out.println("2. Motor");
                        System.out.print("Pilih jenis kendaraan : ");
                        int jenis = input.nextInt();
                        input.nextLine();

                        System.out.print("Kode Kendaraan : ");
                        String kode = input.nextLine();

                        System.out.print("Nama Kendaraan : ");
                        String nama = input.nextLine();

                        System.out.print("Harga Sewa/Hari : ");
                        double harga = input.nextDouble();
                        input.nextLine();

                        if (jenis == 1) {
                            System.out.print("Jumlah Kursi : ");
                            int kursi = input.nextInt();

                            rental.tambahKendaraan(new Mobil(kode, nama, harga, kursi));
                        } else if (jenis == 2) {
                            input.nextLine();
                            System.out.print("Jenis Transmisi : ");
                            String transmisi = input.nextLine();

                            rental.tambahKendaraan(new Motor(kode, nama, harga, transmisi));
                        }

                        System.out.println("data kendaraan berhasil ditambahkan");
                    }

                    case 2 ->
                        rental.tampilkanDaftarKendaraan();

                    case 3 -> {
                        try {
                            System.out.print("masukkan kode kendaraan: ");
                            String kodeSewa = input.nextLine();

                            System.out.print("Lama sewa hari: ");
                            int lama = input.nextInt();
                            input.nextLine();

                            System.out.print("Apakah Anda member VIP (y/n): ");
                            String vipInput = input.nextLine().trim();
                            boolean memberVip = vipInput.equalsIgnoreCase("y");

                            rental.sewaKendaraan(kodeSewa, lama, memberVip);

                        } catch (KendaraanTidakTersediaException e) {
                            System.out.println("Error : " + e.getMessage());
                        }
                    }

                    case 4 -> {
                        System.out.print("masukkan kode kendaraan : ");
                        String kodeKembali = input.nextLine();

                        rental.kembalikanKendaraan(kodeKembali);
                    }

                    case 5 ->
                        System.out.println("selesai");

                    default ->
                        System.out.println("tidak ada");
                }

            } while (pilih != 5);
        }
    }
}
