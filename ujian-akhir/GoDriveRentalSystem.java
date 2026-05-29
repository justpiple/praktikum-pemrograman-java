
import java.util.ArrayList;

class GoDriveRentalSystem {

    private final ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();

    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
    }

    public void tampilkanDaftarKendaraan() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada kendaraan.");
            return;
        }

        for (Kendaraan k : daftarKendaraan) {
            System.out.println("------------------------");
            k.tampilInfo();
        }
    }

    public void sewaKendaraan(String kode, int lamaSewa) throws KendaraanTidakTersediaException {
        sewaKendaraan(kode, lamaSewa, false);
    }

    public void sewaKendaraan(String kode, int lamaSewa, boolean memberVip) throws KendaraanTidakTersediaException {

        for (Kendaraan k : daftarKendaraan) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {

                if (!k.isTersedia()) {
                    throw new KendaraanTidakTersediaException("Kendaraan sedang tidak tersedia.");
                }

                double biayaDasar = k.hitungBiayaDasar(lamaSewa);
                double totalDiskon = 0;

                if (memberVip) {
                    totalDiskon += biayaDasar * 0.10;
                }

                if (lamaSewa > 7) {
                    totalDiskon += biayaDasar * 0.10;
                }

                double biayaAkhir = biayaDasar - totalDiskon;

                k.setTersedia(false);

                System.out.println("\n=== DETAIL PENYEWAAN ===");
                System.out.printf("%-15s : %s%n", "Nama Kendaraan", k.getNamaKendaraan());
                System.out.printf("%-15s : %d hari%n", "Lama Sewa", lamaSewa);
                System.out.printf("%-15s : %s%n", "Member VIP", memberVip ? "Ya" : "Tidak");
                System.out.printf("%-15s : Rp%,.0f%n", "Biaya Dasar", biayaDasar);

                if (memberVip) {
                    System.out.printf("%-15s : -Rp%,.0f%n", "Diskon VIP", biayaDasar * 0.10);
                }

                if (lamaSewa > 7) {
                    System.out.printf("%-15s : -Rp%,.0f%n", "Diskon >7 Hari", biayaDasar * 0.10);
                }

                System.out.printf("%-15s : -Rp%,.0f%n", "Total Diskon", totalDiskon);
                System.out.printf("%-15s : Rp%,.0f%n", "Total Biaya", biayaAkhir);

                return;
            }
        }

        throw new KendaraanTidakTersediaException("Kode kendaraan tidak ditemukan.");
    }

    public void kembalikanKendaraan(String kode) {
        for (Kendaraan k : daftarKendaraan) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                k.setTersedia(true);
                System.out.println("Kendaraan berhasil dikembalikan.");
                return;
            }
        }

        System.out.println("Kode kendaraan tidak ditemukan.");
    }
}
