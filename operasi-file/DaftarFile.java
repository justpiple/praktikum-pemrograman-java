
import java.io.File;

public class DaftarFile {

    public static void main(String[] args) {
        File direktori = new File(".");

        if (direktori.exists() && direktori.isDirectory()) {
            File[] daftarFile = direktori.listFiles();

            System.out.println("Daftar file dalam direktori:");

            for (File file : daftarFile) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("not found");
        }
    }
}
