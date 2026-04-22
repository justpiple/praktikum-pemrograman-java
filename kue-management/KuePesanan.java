
public class KuePesanan extends Kue {

    double berat;

    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    @Override
    double hitungHarga() {
        return harga * berat;
    }

    @Override
    public String toString() {
        return super.toString() + ", Jenis: KuePesanan, Berat: " + berat + ", Total: " + hitungHarga();
    }
}
