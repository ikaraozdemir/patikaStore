import java.util.*;

public class PatikaStore {
   private List<Brand> brands;
   private List<CellPhone> cellPhones;
   private List<NoteBook> noteBooks;
   private Scanner input = new Scanner(System.in);
   private int selection;


   public PatikaStore() {
       this.brands = new ArrayList<>();
       this.cellPhones = new ArrayList<>();
       this.noteBooks = new ArrayList<>();

       brands.add(new Brand(1,"Samsung"));
       brands.add(new Brand(2,"Lenovo"));
       brands.add(new Brand(3,"Apple"));
       brands.add(new Brand(4,"Huawei"));
       brands.add(new Brand(5,"Casper"));
       brands.add(new Brand(6,"Asus"));
       brands.add(new Brand(7,"HP"));
       brands.add(new Brand(8,"Xiaomi"));
       brands.add(new Brand(9,"Monster"));
       Collections.sort(brands);
   }

    public boolean showMenu (){
       do{
           System.out.println("###### PatikaStore Ürün Yönetim Paneli ######");
           System.out.println("1 - Notebook Ekle");
           System.out.println("2 - Cep Telefonu Ekle");
           System.out.println("3 - Ürün Sil");
           System.out.println("4 - Marka Listele");
           System.out.println("0 - Çıkış Yap");
           System.out.print("Yapmak istediğiniz işlemi seçiniz: ");
           selection = input.nextInt();
           switch (selection){
               case 0:
                   System.out.print("Çıkış yapılıyor.");
                   break;
               case 1:
                   System.out.println("Notebook Ekleme");
                   addProduct();
                   listProducts();
                   break;
               case 2:
                   System.out.println("Cep Telefonu Ekleme");
                   addProduct();
                   listProducts();
                   break;
               case 3:
                   System.out.println("Ürün Silme");
                   System.out.print("Silmek istediğiniz ürünü seçiniz: ");
                   int removeId = input.nextInt();
                   deleteProduct(removeId);
                   listProducts();
                   break;
               case 4:
                   System.out.println("Markalar");
                   listBrands();
                   break;
               default:
                   System.out.println("Yanlış giriş yaptınız.");
                   break;
           }
       }while (selection != 0 );
       return false;
    }

    public void listBrands(){
       for(Brand brand : brands){
            System.out.println(brand.getName());
        }
    }

    public void addProduct() {
        input.nextLine();
        System.out.print("Ürün Adı: ");
        String name = input.nextLine();
        System.out.print("Birim Fiyat: ");
        double price = input.nextDouble();
        System.out.print("İndirim Oranı: ");
        double discount = input.nextDouble();
        System.out.print("Stok: ");
        int stock = input.nextInt();
        input.nextLine();
        System.out.print("Ürün Rengi: ");
        String color = input.nextLine();
        System.out.print("Marka ID:");
        int Prodid = input.nextInt();
        Brand brand = getBrandById(Prodid);
        if (brand != null) {
            if (selection == 1) {
                System.out.print("Ekran Boyutu: ");
                double screenSize = input.nextDouble();
                System.out.print("RAM: ");
                int ram = input.nextInt();
                System.out.print("Depolama: ");
                int storageCapacity = input.nextInt();
                input.nextLine();
                NoteBook noteBook = new NoteBook(name, price, discount, stock, brand, color, screenSize, ram, storageCapacity);
                addNoteBook(noteBook);
            } else if (selection == 2) {
                System.out.print("Hafıza: ");
                int memory = input.nextInt();
                System.out.print("Ekran Boyutu: ");
                double screenSize = input.nextDouble();
                System.out.print("Pil Gücü: ");
                int batteryCapacity = input.nextInt();
                System.out.print("RAM: ");
                int ram = input.nextInt();
                input.nextLine();
                CellPhone cellPhone = new CellPhone(name, price, discount, stock, brand, color, memory, screenSize, batteryCapacity, ram);
                addCellPhone(cellPhone);
            }
        } else {
            System.out.println("Geçersiz ID");
        }
    }

    public Brand getBrandById (int id){

        for (Brand brand: brands){
            if(brand.getId() == id){
                return brand;
            }
        }
        return null;
    }

    public void addNoteBook (NoteBook noteBook){
       if(noteBook != null){
           for(Brand brand: brands){
               if (noteBook.getBrand().getName().equals(brand.getName())){
                       this.noteBooks.add(noteBook);
                       break;
               }
           }
       }
    }

    public void addCellPhone (CellPhone cellPhone){
        if(cellPhone != null){
            for(Brand brand: brands){
                if (cellPhone.getBrand().getName().equals(brand.getName()) ){
                    this.cellPhones.add(cellPhone);
                    break;
                }
            }
        }
    }

    public void deleteProduct(int ProdId){

        noteBooks.removeIf(noteBook -> noteBook.getId() == ProdId );
        cellPhones.removeIf(cellPhone -> cellPhone.getId() == ProdId );
    }

    public void listProducts(){

       System.out.println("NoteBook Listesi");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-3s | %-20s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |%n",
                "ID", "Ürün Adı", "Fiyat", "İndirim", "Stok",
                "Marka", "Renk", "Ekran", "RAM", "Depolama");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        for(NoteBook noteBook1: noteBooks){
           System.out.format("| %-3d | %-20s | %-10.1f | %-10.1f | %-10d | %-10s | %-10s | %-10.1f | %-10d | %-10d |%n",
                   noteBook1.getId(), noteBook1.getName(), noteBook1.getPrice(), noteBook1.getDiscount(), noteBook1.getStock(),
                   noteBook1.getBrand().getName(), noteBook1.getColor(), noteBook1.getScreenSize(), noteBook1.getRam(), noteBook1.getStorageCapacity());
                   System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
       }
        System.out.println("Cep Telefonu Listesi");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-3s | %-20s | %-10s | %-10s | %-10s | %-10s | %-10s  | %-10s | %-10s | %-10s |%n\"",
                "ID", "Ürün Adı", "Fiyat", "İndirim", "Stok",
                "Marka", "Renk", "Ekran", "RAM", "Pil Gücü");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        for(CellPhone cellPhone: cellPhones){
            System.out.format("| %-3d | %-20s | %-10.1f | %-10.1f | %-10d | %-10s | %-10s | %-10.1f | %-10d | %-10d |%n",
                    cellPhone.getId(), cellPhone.getName(), cellPhone.getPrice(), cellPhone.getDiscount(), cellPhone.getStock(),
                    cellPhone.getBrand().getName(), cellPhone.getColor(), cellPhone.getScreenSize(), cellPhone.getRam(), cellPhone.getBatteryCapacity());
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}
