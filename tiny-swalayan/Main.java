
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Pelanggan p = new Pelanggan("5601234567", "Rina", 500_000, "1234");

            System.out.println("=== Swalayan Tiny ===");
            System.out.println("Selamat datang, " + p.getNama());
            System.out.println("Nomor: " + p.getNomorPelanggan() + " (" + p.getJenisRekening() + ")");
            System.out.println("Saldo: Rp " + p.getSaldo());
            System.out.println();

            boolean jalan = true;
            while (jalan) {
                if (p.isDiblokir()) {
                    System.out.println("Akun diblokir karena 3x salah PIN.");
                    break;
                }

                System.out.println("1) Beli");
                System.out.println("2) Top up");
                System.out.println("0) Keluar");
                System.out.print("Pilih: ");
                String pilih = sc.nextLine().trim();

                if (pilih.equals("0")) {
                    jalan = false;
                    continue;
                }
                if (pilih.equals("1") || pilih.equals("2")) {
                    System.out.print("Nomor pelanggan (10 digit): ");
                    String nomorStr = sc.nextLine().trim();
                    System.out.print("PIN: ");
                    String pin = sc.nextLine().trim();

                    if (!Pelanggan.nomorCocokFormat(nomorStr)) {
                        System.out.println("Nomor tidak valid (harus 10 digit angka, awalan 38/56/74).");
                        continue;
                    }

                    if (!nomorStr.trim().equals(p.getNomorPelanggan())) {
                        System.out.println("Pelanggan tidak ditemukan.");
                        continue;
                    }
                    if (!p.cekPin(pin)) {
                        if (p.isDiblokir()) {
                            System.out.println("Akun diblokir.");
                        } else {
                            System.out.println("PIN salah. Sisa percobaan sebelum blokir: " + (3 - p.getSalahAutentikasi()));
                        }
                        continue;
                    }

                    if (pilih.equals("1")) {
                        System.out.print("Total pembelian: ");
                        int harga = Integer.parseInt(sc.nextLine().trim());
                        if (p.beli(harga)) {
                            System.out.println("Transaksi berhasil. Saldo sekarang: Rp " + p.getSaldo());
                        } else {
                            System.out.println("Transaksi gagal: saldo pasca transaksi harus minimal Rp " + Pelanggan.SALDO_MINIMAL + ".");
                        }
                    } else {
                        System.out.print("Jumlah top up (Rp): ");
                        int jumlah = Integer.parseInt(sc.nextLine().trim());
                        if (p.topUp(jumlah)) {
                            System.out.println("Top up berhasil. Saldo: Rp " + p.getSaldo());
                        } else {
                            System.out.println("Top up gagal (jumlah tidak valid).");
                        }
                    }
                } else {
                    System.out.println("Pilihan tidak dikenal.");
                }
                System.out.println();
            }
        } finally {
            System.out.println("Terima kasih.");
        }
    }
}
