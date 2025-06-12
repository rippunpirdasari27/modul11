import java.util.*;

class Sistempeminjaman extends Exception {
    public Sistempeminjaman(String pesan) { super(pesan); }
}

class KesalahanLamaPinjam extends Exception {
    public KesalahanLamaPinjam(String pesan) { super(pesan); }
}

class Peminjaman {
    String nama; 
    String idBuku;
    int lama;

    public Peminjaman(String nama, String idBuku, int lama) {
        this.nama = nama;
         this.idBuku = idBuku; 
         this.lama = lama;
    }

    public void tampilkan() {
        System.out.printf("Nama: %s\nID Buku: %s\nLama Pinjam: %d hari\n------------------------\n", nama, idBuku, lama);
    }
}

public class SistemPeminjamanArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> daftarBuku = new ArrayList<>(Arrays.asList("B001", "B002", "B003"));
        ArrayList<Peminjaman> histori = new ArrayList<>();

        try {
            System.out.print("Masukkan nama Anda: ");
            String nama = input.nextLine();
            System.out.print("Masukkan ID buku: ");
            String id = input.nextLine();

            if (!daftarBuku.contains(id)) throw new Sistempeminjaman("ID buku tidak ditemukan dalam sistem.");

            System.out.print("Masukkan lama peminjaman (hari): ");
            int lama = input.nextInt();

            if (lama < 1 || lama > 14) throw new KesalahanLamaPinjam("Lama peminjaman harus antara 1 - 14 hari.");

            Peminjaman pinjam = new Peminjaman(nama, id, lama);
            histori.add(pinjam);

            System.out.println("\nPeminjaman berhasil!");
            pinjam.tampilkan();

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            input.close();
            System.out.println("Program selesai.");
        }

        System.out.println("\nRiwayat Peminjaman:");
        for (Peminjaman p : histori) p.tampilkan();
    }
}
