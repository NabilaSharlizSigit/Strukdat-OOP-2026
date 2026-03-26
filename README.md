# Strukdat-OOP-2026

Struktur data adalah cara khusus untuk mengorganisasi, mengelola, dan menyimpan data di dalam memori komputer agar dapat diakses dan digunakan secara efisien. Ini merupakan fondasi pemrograman yang mengatur data—seperti angka, teks, atau objek—dalam format terstruktur (linier atau non-linier) untuk memaksimalkan kinerja algoritma.

Pada OOP terdapat 4 pilar utama yang menjadi dasar konsepnya, yaitu :
1. **Abstraction** : Penyembunyian detail implementasi yang rumit dan hanya menampilkan fungsionalitas penting kepada pengguna 
2. **Encapsulation** : Proses membungkus data (atribut) dan metode (fungsi) menjadi satu kesatuan (class) serta membatasi akses langsung dari luar (menggunakan private/protected) untuk menjaga integritas data.
3. **Inheritance** : Kemampuan suatu kelas (subclass) untuk mewarisi sifat dan perilaku dari kelas lain (superclass), memungkinkan reusability kode.
4. **Polymorphism** : Kemampuan satu antarmuka (method) untuk merespons dalam berbagai bentuk atau cara, biasanya diimplementasikan melalui Override 

Detail Code :
[Abstraction](./Character.java)
[Encapsulation](./Character.java)
[Inheritance1](./Medic.java) 
[Inheritance2](./Soldier.java)
[Polymorphism](./Main.java)

----------------------------------------------------------------------------------------------------------------------------# Class Diagram

```mermaid
classDiagram
    class User {
        -nama: String
        -balance: Double
        +tambahBudgetPlan()
        +tampilkanBudgetPlan()
        +hapusBudgetPlan()
    }

    class BudgetPlan {
        -plan: String
        -budget: Double
        -prioritas: String
        -status: boolean
        +tampilkan()
        +updateStatus()
        +updateBudget()
    }

    User 1 -- * BudgetPlan
```**

Disini saya mengambil kasus Personal Budget Management untuk mengatur keuangan pribadi spesialisasi mencatat pengeluaran seperti budget planning. Disertai fitur tambah, hapus, update status, tampilkan Plan Budget dan juga tampilkan Info User.

class User{
    private String name;
    private double balance;
    private BudgetPlan[] budgetPlans;
    private int jumlahPlan;

    public User (String name, double balance){
        this.name=name;
        this.balance=balance;
        this.budgetPlans = new BudgetPlan[100];
        this.jumlahPlan=0;
    }

    public void tampilkanInfoUser(){
        System.out.println("Name: " + name + "Balance: " + balance);
    }

    public void tambahBudgetPlan(BudgetPlan plan){
        if(jumlahPlan < budgetPlans.length){
            budgetPlans[jumlahPlan]=plan;
            jumlahPlan++;
        } else{
            System.out.println("Kapasitas penuh, tidak bisa menambah Budget Plan lagi!");
        }
    }

    public void hapusBudgetPlan(int j){
        for(int i=j; i<jumlahPlan-1; i++){
            budgetPlans[i]=budgetPlans[i+1];
        }
        budgetPlans[jumlahPlan-1]=null;
        jumlahPlan--;
    }

    public void tampilkanBudgetPlan(){
        for(int i=0; i<jumlahPlan; i++){
            budgetPlans[i].tampilkan();
        }
    }
}

class BudgetPlan{
    private String plan;
    private Double budget;
    private String prioritas;
    private boolean status;

    public BudgetPlan(String plan, double budget, String prioritas){
        this.plan=plan;
        this.budget=budget;
        this.prioritas=prioritas;
        this.status=false;
    }

    public void tampilkan(){
        if(status){
            System.out.println("Plan: " + plan + "\nBudget: " + budget + "Prioritas: " + prioritas + "Status : Done");
        } else {
            System.out.println("Plan: " + plan + "\nBudget: " + budget + "Prioritas: " + prioritas + "Status: X ");
        }
    }

    public void updateStatus(){
        status = !status;
    }

    public void updateBudget(double newBudget){
        this.budget = newBudget;
    }
}


public class PersonalBudget{
    public static void main(String args[]) throws Exception{
        User user = new User("Sharurizuu", 500000);

        BudgetPlan bp1 = new BudgetPlan("Buku MBTI", 900000, "Keinginan");
        BudgetPlan bp2 = new BudgetPlan("Hampers", 150000, "Must");

        user.tambahBudgetPlan(bp1);
        user.tambahBudgetPlan(bp2);

        bp2.updateStatus();
        bp1.updateBudget(105000);

        user.tampilkanBudgetPlan();

        user.hapusBudgetPlan(1);
        user.tampilkanBudgetPlan();
    }
}
