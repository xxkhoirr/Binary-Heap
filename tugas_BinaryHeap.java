package praktikum5;
import java.util.Scanner;

//kelompok :
//1. Khoirunnisa
//2. M Nibrassuddin A Z
//3. M Reza Abidin
//4. M Bin Idrus (tidak aktif)

class BinHeap {
    public String[] nama;
    public int capasity;
    public int size = 0;
    
    BinHeap (int capasity) {
        this.capasity = capasity;
        this.nama = new String[capasity];
    }
    
    public boolean inputheap(String nama) {
        if (this.size >= this.capasity)
            return false;
        this.nama[this.size] = nama;
        this.PercolateUp(this.size ++);
        return true;
    }
    
    public void PercolateUp(int key) {
        if (key == 0)
            return;
        if (convert(this.nama[key]) < convert(this.nama[key / 2])) {
            String temp = this.nama[key];
            this.nama[key] = this.nama[key/2];
            this.nama[key/2] = temp;
            this.PercolateUp(key / 2);
        }
    }
    
    public String clearMin() {
        if (this.size == 0)
            return null;
        String namaMin = this.nama[0];
        this.nama[0] = this.nama[-- this.size];
        this.PercolateDown(0);
        return namaMin;
    }
     
    public void PercolateDown(int key) {
        int Left = 2 * key + 1;
        int Right = 2 * key + 2;
        if (2 * key + 1 >= this.size)
            return;
        if (2 * key + 2 == this.size && convert(this.nama[key]) > convert(this.nama[Left ])) {
            String temp = this.nama[key];
            this.nama[key] = this.nama[Left ];
            this.nama[Left ] = temp;
        } else if(convert(this.nama[key]) > convert(this.nama[Left ]) ||
        		convert(this.nama[key]) > convert(this.nama[Right ])) {
            if (convert(this.nama[Left ]) < convert(this.nama[Right ])) {
                String temp = this.nama[key];
            this.nama[key] = this.nama[Left ];
            this.nama[Left ] = temp;
            this.PercolateDown(Left );
            } else{
            String temp = this.nama[key];
            this.nama[key] = this.nama[Right];
            this.nama[Right] = temp;  
            this.PercolateDown(Right);
            }
        }
    }
    
     public static int convert(String nama) {
         int ascii = 0;
      for (int i = 0; i < nama.split("").length; i++) {
          ascii += (int) nama.charAt(i);
      }
       
      for (char c : nama.toCharArray())
          ascii += (int) c;
      
      return ascii;
    }
}

public class tugas_BinaryHeap {

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        int cap = user.nextInt();
        BinHeap  heap = new BinHeap (cap);
        System.out.println("Kapasitas Heap: "+ cap );
        System.out.println("\nSilahkan pilih :\n1. Input Data\n2. Delete Data\n3. Keluar");
        while (true) {
            // input pertama adalah input kapasitas heap yang merupakan indeks dari array 
        	// pilihan :
        	// 1. input nama
        	// 2. delete (smallest)
        	// 3. quit
            int pil = user.nextInt(); user.nextLine();
            if (pil == 1) {
                String nama = user.nextLine();
                if (heap.inputheap(nama)) {
                    System.out.println("yey.. u succeeded add friends");
                } else {
                    System.out.println("that is enough");
                }
            } else if (pil == 2) {
                if (heap.size == 0) {
                    System.out.println("I haven't no friend");
                } else {
                    System.out.println(heap.clearMin());
                }
            } else if (pil == 3) {
                break;
            } else {
                System.out.println("sorry, u only can choose 1 - 3");
            }
        }
    }
}
         


 

