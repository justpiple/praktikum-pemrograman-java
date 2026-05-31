
import java.io.File;

public class HapusDir {

    public static void main(String[] args) {
        File direktori = new File("bin");

        if (direktori.exists() && direktori.isDirectory()) {

            File[] daftarFile = direktori.listFiles();

            for (File file : daftarFile) {
                if (file.isFile()) {
                    if (file.delete()) {
                        System.out.println("Berhasil hapus file: " + file.getName());
                    } else {
                        System.out.println("Gagal hapus file: " + file.getName());
                    }
                }
            }

            if (direktori.delete()) {
                System.out.println("Direktori berhasil dihapus");
            } else {
                System.out.println("Direktori gagal dihapus");
            }

        } else {
            System.out.println("Direktori tidak ada");
        }
    }
}
