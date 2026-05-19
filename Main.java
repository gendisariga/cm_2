
    import java.util.Scanner;

// class utama program
public class Main {

    // menampilkan menu utama
    static void menu() {
        System.out.println("======================================");
        System.out.println("SISTEM ANTRIAN ROYAL DELISH");
        System.out.println("======================================");

        System.out.println("1. Tambah Antrian");
        System.out.println("2. Cetak Antrian");
        System.out.println("3. Hapus Antrian dan Pesan");
        System.out.println("4. Laporan Pesanan");
        System.out.println("0. Keluar");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // objek antrian pembeli
        DoubleLinkedListPembeli antrian =
                new DoubleLinkedListPembeli();

        // objek list pesanan
        DoubleLinkedListPesanan pesananList =
                new DoubleLinkedListPesanan();

        int pilih;

        do {
            menu();

            System.out.print("Pilih menu : ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {

                // tambah antrian
                case 1:
                    System.out.println();

                    System.out.print("Nama Pembeli : ");
                    String nama = sc.nextLine();

                    System.out.print("No HP        : ");
                    String hp = sc.nextLine();

                    Pembeli p = new Pembeli(nama, hp);

                    antrian.tambahAntrian(p);
                    break;

                // cetak antrian
                case 2:
                    System.out.println();
                    antrian.cetakAntrian();
                    break;

                // ambil antrian + buat pesanan
                case 3:
                    System.out.println();

                    Pembeli pembeli = antrian.hapusAntrian();

                    if (pembeli == null) {
                        System.out.println("Antrian kosong");
                    } else {

                        System.out.print("Kode Pesanan : ");
                        int kode = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nama Pesanan : ");
                        String namaPesanan = sc.nextLine();

                        System.out.print("Harga        : ");
                        int harga = sc.nextInt();
                        sc.nextLine();

                        Pesanan pesanan =
                                new Pesanan(kode, namaPesanan, harga);

                        pesananList.tambahPesanan(pesanan);

                        System.out.println();
                        System.out.println(
                                pembeli.namaPembeli
                                + " telah memesan "
                                + namaPesanan);
                    }
                    break;

                // laporan pesanan
                case 4:
                    System.out.println();
                    pesananList.laporanPesanan();
                    break;

                case 0:
                    System.out.println();
                    System.out.println("Program selesai");
                    break;

                default:
                    System.out.println("Menu tidak tersedia");
            }

            System.out.println();

        } while (pilih != 0);
    }
}
    

