
import java.util.Scanner;

public class uts_daspro_23 {

    public static void main(String[] args) {

        int senjata, senjataAK = 30, senjataFamas = 20, penyembuh = 3, poinPenyembuh = 25, seranganMusuh = 15, ronde = 0, aksi;
        double menghindar = 0.1, nyawaPemain = 0, nyawaMusuh = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("===Nilai Awal Permainan===");
        System.out.print("Nyawa Pemain : ");
        nyawaPemain = sc.nextDouble();
        System.out.print("Nyawa Musuh : ");
        nyawaMusuh = sc.nextDouble();

        System.out.println("\n===Pertarungan Free Fire dimulai!\n");

        do {
            ronde++;
            System.out.println("\n>> Ronde " + ronde + " <<");

            System.out.println("Musuh Menyerang! Kamu kehilangan " + seranganMusuh + " HP.");
            nyawaPemain -= seranganMusuh;
            System.out.println("Nyawa kamu sekarang: " + (int) nyawaPemain);

            if (nyawaPemain <= 0) {
                break;
            }

            // Aksi pemain
            System.out.println("Giliran kamu! Pilih aksi:");
            System.out.println("1. Serang Musuh");
            System.out.println("2. Gunakan item penyembuh (sisa " + penyembuh + ")");
            System.out.println("3. Menghindar (tidak menyerang musuh)");
            aksi = sc.nextInt();

            if (aksi == 1) {
                System.out.println("Pilih senjata:");
                System.out.println("1. AK");
                System.out.println("2. Famas");
                senjata = sc.nextInt();

                if (senjata == 1) {
                    System.out.println("Kamu menyerang musuh menggunakan AK! Musuh kehilangan " + senjataAK + " HP.");
                    nyawaMusuh -= senjataAK;
                } else if (senjata == 2) {
                    System.out.println("Kamu menyerang musuh menggunakan Famas! Musuh kehilangan " + senjataFamas + " HP.");
                    nyawaMusuh -= senjataFamas;
                } else {
                    System.out.println("Masukkan senjata dengan benar!");
                    continue;  // Kembali ke pilihan aksi jika input salah
                }
                System.out.println("Nyawa musuh sekarang: " + (int) nyawaMusuh);

            } else if (aksi == 2) {
                if (penyembuh > 0) {
                    System.out.println("Kamu menggunakan item penyembuh. Nyawa kamu bertambah " + poinPenyembuh + " HP.");
                    nyawaPemain += poinPenyembuh;
                    penyembuh--;
                } else {
                    System.out.println("Penyembuh kamu habis! Pilih aksi yang lain.");
                }
                System.out.println("Nyawa kamu sekarang: " + (int) nyawaPemain);

            } else if (aksi == 3) {
                System.out.println("Kamu memilih untuk menghindar, sayang sekali!");
                double nyawaTambah = nyawaMusuh * menghindar;
                nyawaMusuh += nyawaTambah;
                System.out.println("Nyawa musuh bertambah 10% yaitu: " + (int) nyawaTambah);
                System.out.println("Nyawa musuh sekarang: " + (int) nyawaMusuh);

            } else {
                System.out.println("Masukkan aksi dengan benar!");
            }

        } while (nyawaPemain > 0 && nyawaMusuh > 0);  // Loop berhenti jika salah satu nyawa <= 0

        // Pesan akhir permainan
        if (nyawaPemain <= 0) {
            System.out.println("\nKamu Kalah! Musuh telah Menang.");
        } else {
            System.out.println("\nKamu Menang! Musuh telah Kalah.");
        }
    }
}
