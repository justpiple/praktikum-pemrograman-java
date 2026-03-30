
public class Pelanggan {

    public static final int SALDO_MINIMAL = 10_000;
    private static final int BATAS_CASHBACK = 1_000_000;
    public static final String PREFIX_SILVER = "38";
    public static final String PREFIX_GOLD = "56";
    public static final String PREFIX_PLATINUM = "74";

    private final String nomorPelanggan;
    private final String nama;
    private int saldo;
    private String pin;

    private int salahAutentikasi;
    private boolean diblokir;

    public Pelanggan(String nomorPelanggan, String nama, int saldoAwal, String pin) {
        if (!nomorValid(nomorPelanggan)) {
            throw new IllegalArgumentException("Nomor harus 10 digit dan diawali 38, 56, atau 74.");
        }
        if (saldoAwal < SALDO_MINIMAL) {
            throw new IllegalArgumentException("Saldo awal minimal Rp " + SALDO_MINIMAL);
        }
        this.nomorPelanggan = nomorPelanggan.trim();
        this.nama = nama;
        this.saldo = saldoAwal;
        this.pin = pin;
    }

    public static boolean nomorCocokFormat(String nomor) {
        return nomorValid(nomor);
    }

    private static boolean nomorValid(String nomor) {
        if (nomor == null) {
            return false;
        }
        String n = nomor.trim();
        if (!n.matches("\\d{10}")) {
            return false;
        }
        String prefix = n.substring(0, 2);
        return prefix.equals(PREFIX_SILVER) || prefix.equals(PREFIX_PLATINUM) || prefix.equals(PREFIX_GOLD);
    }

    public int getSaldo() {
        return saldo;
    }

    public String getNama() {
        return nama;
    }

    public String getNomorPelanggan() {
        return nomorPelanggan;
    }

    public boolean isDiblokir() {
        return diblokir;
    }

    public int getSalahAutentikasi() {
        return salahAutentikasi;
    }

    public String getJenisRekening() {
        String prefix = nomorPelanggan.substring(0, 2);
        return switch (prefix) {
            case PREFIX_SILVER ->
                "Silver";
            case PREFIX_GOLD ->
                "Gold";
            case PREFIX_PLATINUM ->
                "Platinum";
            default ->
                "Tidak diketahui";
        };
    }

    public boolean topUp(int jumlah) {
        if (diblokir) {
            return false;
        }
        if (jumlah <= 0) {
            return false;
        }
        saldo += jumlah;
        return true;
    }

    public boolean beli(int harga) {
        if (diblokir) {
            return false;
        }
        if (harga <= 0) {
            return false;
        }

        int cashback = hitungCashback(harga);
        int saldoSetelah = saldo - harga + cashback;
        if (saldoSetelah < SALDO_MINIMAL) {
            return false;
        }
        saldo = saldoSetelah;
        return true;
    }

    private int hitungCashback(int harga) {
        String jenisRekening = getJenisRekening();
        int persen = 0;

        switch (jenisRekening) {
            case "Silver" -> {
                if (harga > BATAS_CASHBACK) {
                    persen = 5;
                }
            }
            case "Gold" -> {
                if (harga > BATAS_CASHBACK) {
                    persen = 7;
                } else {
                    persen = 2;
                }
            }
            case "Platinum" -> {
                if (harga > BATAS_CASHBACK) {
                    persen = 10;
                } else {
                    persen = 5;
                }
            }
        }

        return (harga * persen) / 100;
    }

    public boolean cekPin(String pinMasukan) {
        if (diblokir) {
            return false;
        }

        if (pin.equals(pinMasukan)) {
            salahAutentikasi = 0;
            return true;
        }

        catatGagal();
        return false;
    }

    private void catatGagal() {
        salahAutentikasi++;
        if (salahAutentikasi >= 3) {
            diblokir = true;
        }
    }
}
