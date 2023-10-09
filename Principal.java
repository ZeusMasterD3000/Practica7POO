import java.util.*;
import Comprador.*;
import Productos.DispositivoElectronico;
import Productos.Television.*;
import Productos.Dispositivo_Movil.*;
import Productos.Computadora.*;

public class Principal {
    public static void main(String[] args) {
        ArrayList<ArrayList<DispositivoElectronico>> productos = new ArrayList<>();
        ArrayList<DispositivoElectronico> carritoDeCompras = new ArrayList<>();
        ArrayList<DispositivoElectronico> celulares = new ArrayList<>();
        celulares.add(new Celular("1234", "nokia", 500.50, "3G", "1.3 megapixeles", true));
        celulares.add(new Celular("5234", "nokia 106", 437, "3G", "1.3 megapixeles", true));
        productos.add(celulares);
        ArrayList<DispositivoElectronico> smartphones = new ArrayList<>();
        smartphones.add(new Smartphone("5476", "motorola Moto G82", 3999.99, "5G", "25 MP", "12 WATS"));
        smartphones.add(new Smartphone("6923", "Apple iPhone 14 Pro MAX", 999.00, "5G", "48 MP", "25 WATS"));
        productos.add(smartphones);
        ArrayList<DispositivoElectronico> tabletas = new ArrayList<>();
        tabletas.add(new Tablet("2394", "Xiaomi RedMi Pad Tablet", 4372.00, "5G", "8 MP", false));
        tabletas.add(new Tablet("2038", "Samsung Galaxy Tab S6 Lite", 5666.00, "5G", "13 MP", true));
        productos.add(tabletas);
        ArrayList<DispositivoElectronico> televisiones = new ArrayList<>();
        televisiones.add(new Television("9128", "Samsung Crystal CU Series UHD", 6600, 50, true, "4K"));
        televisiones.add(new Television("1934", "TLC", 6600, 50, true, "4K"));
        televisiones.add(new Television("9128", "Samsung Crystal CU Series UHD", 6600, 50, true, "4K"));
        televisiones.add(new Television("1934", "TLC", 6600, 50, true, "4K"));
        ArrayList<DispositivoElectronico> laptops = new ArrayList<>();
        laptops.add(new Laptop("0122", "HUAVEI MateBook ", 13999.00, "Windows 11 home", 16, "90%"));
        laptops.add(new Laptop("5922", "HP Laptop 15-dw3500la ", 7199.00, "Windows 11", 8, "75%"));
        laptops.add(new Laptop("7829", "Dell Inspiton 15 3000 Series ", 13407.00, "Windows 11 home", 32, "85%"));
        laptops.add(new Laptop("4369", "Asus FX506HF-ES51 TUF Gaming F15 ", 15427.00, "Windows 11", 8, "90%"));
        productos.add(laptops);
        ArrayList<DispositivoElectronico> PCs = new ArrayList<>();
        PCs.add(new PC("1754", "Lenovo", 25_000, "Intel i7", 32, true));
        PCs.add(new PC("1798", "Toshiba", 19_000, "Nvidia 3500", 24, true));
        PCs.add(new PC("1850", "Asus", 45_000, "Nvidia Geo Force 5000", 64, true));
        productos.add(PCs);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inicia sesion: ");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Tomando en cuenta que el saldo establece tu categoria:\nEstudiante - Saldo < 10,000 \nSocio - 10,000, < saldo < 25,000 \nVIP - saldo > 25,000\nIngresa tu saldo: ");
        double saldo = scanner.nextDouble();

        if(saldo<0){
            System.out.println("Usted nos debe dinero, larguese de aqui");
            System.exit(0);
        }
        if(saldo<10000){
            System.out.print("Usted es un estudiante\nIngrese la escuela de procedencia: ");
            String escuela = scanner.nextLine();
            Estudiante comprador = new Estudiante(nombre, saldo, escuela);
        }else{
            if(saldo>10000 && saldo<25000){
                System.out.print("Usted es un socio\nIngrese su numero de membresia: ");
                String noMembresia = scanner.nextLine();
                Socio comprador = new Socio(nombre, saldo, noMembresia);
            }else{
                System.out.print("Usted es VIP\nIngrese su numero y categoria de la membresia: ");
                String noMembresia = scanner.nextLine();
                String categoriaMembresia = scanner.nextLine();
                VIP comprador = new VIP(nombre, saldo, noMembresia, categoriaMembresia);
            }
        }
    }
}