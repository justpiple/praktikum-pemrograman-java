
class KueJadi extends Kue {

    double jumlah;

    public KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    @Override
    double hitungHarga() {
        return harga * jumlah * 2;
    }

    @Override
    public String toString() {
        return super.toString() + ", Jenis: KueJadi, Jumlah: " + jumlah + ", Total: " + hitungHarga();
    }
}
