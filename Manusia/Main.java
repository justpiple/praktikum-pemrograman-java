
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        System.out.println("Manusia");
        Manusia m1 = new Manusia("Budi", true, "123456789", true);
        Manusia m2 = new Manusia("Sinta", false, "987654321", true);
        Manusia m3 = new Manusia("Rina", false, "456789123", false);

        System.out.println(m1);
        System.out.println();
        System.out.println(m2);
        System.out.println();
        System.out.println(m3);

        System.out.println("\nFilkom");
        MahasiswaFILKOM mh1 = new MahasiswaFILKOM("Andi", true, "111111", false, "225150400111001", 2.8);
        MahasiswaFILKOM mh2 = new MahasiswaFILKOM("Dina", false, "222222", false, "225150400111002", 3.3);
        MahasiswaFILKOM mh3 = new MahasiswaFILKOM("Rafi", true, "333333", false, "225150400111003", 3.8);

        System.out.println(mh1);
        System.out.println();
        System.out.println(mh2);
        System.out.println();
        System.out.println(mh3);

        System.out.println("\nPekerja");
        Pekerja p1 = new Pekerja("Joko", true, "444444", true, 3000, LocalDate.now().minusYears(2), 2);

        Pekerja p2 = new Pekerja("Ayu", false, "555555", true, 4000, LocalDate.now().minusYears(9), 0);

        Pekerja p3 = new Pekerja("Surya", true, "666666", true, 5000, LocalDate.now().minusYears(20), 10);

        System.out.println(p1);
        System.out.println();
        System.out.println(p2);
        System.out.println();
        System.out.println(p3);

        System.out.println("\nManager");
        Manager manajer1 = new Manager("Karina", false, "777777", true, 7500, LocalDate.now().minusYears(15), 0, "IT");

        System.out.println(manajer1);
    }
}
