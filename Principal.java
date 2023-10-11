import java.util.*;
import Comprador.*;
import Productos.DispositivoElectronico;
import Productos.Television.*;
import Productos.Dispositivo_Movil.*;
import Productos.Computadora.*;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<DispositivoElectronico> carritoDeCompras = new ArrayList<>();

        ArrayList<DispositivoElectronico> celulares = new ArrayList<>();
        celulares.add(new Celular("1234", "nokia", 500.50, "3G", "1.3 megapixeles", true));
        celulares.add(new Celular("5234", "nokia 106", 437, "3G", "1.3 megapixeles", true));
        
        ArrayList<DispositivoElectronico> smartphones = new ArrayList<>();
        smartphones.add(new Smartphone("5476", "motorola Moto G82", 3999.99, "5G", "25 MP", "12 WATS"));
        smartphones.add(new Smartphone("6923", "Apple iPhone 14 Pro MAX", 999.00, "5G", "48 MP", "25 WATS"));

        ArrayList<DispositivoElectronico> tabletas = new ArrayList<>();
        tabletas.add(new Tablet("2394", "Xiaomi RedMi Pad Tablet", 4372.00, "5G", "8 MP", false));
        tabletas.add(new Tablet("2038", "Samsung Galaxy Tab S6 Lite", 5666.00, "5G", "13 MP", true));

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

        ArrayList<DispositivoElectronico> PCs = new ArrayList<>();
        PCs.add(new PC("1754", "Lenovo", 25_000, "Intel i7", 32, true));
        PCs.add(new PC("1798", "Toshiba", 19_000, "Nvidia 3500", 24, true));
        PCs.add(new PC("1850", "Asus", 45_000, "Nvidia Geo Force 5000", 64, true));

        System.out.println("\n------------- Inicia sesion -------------\n");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Tomando en cuenta que el saldo establece tu categoria:\nEstudiante - Saldo < 10,000 \nSocio - 10,000, < saldo < 25,000 \nVIP - saldo > 25,000\nIngresa tu saldo: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();

        Estudiante estudiante = null;
        Socio socio = null;
        VIP vip = null;

        if(saldo<0){
            System.out.println("Usted nos debe dinero, larguese de aqui");
            System.exit(0);
        }
        if(saldo<10000){
            System.out.print("Usted es un estudiante\nIngrese la escuela de procedencia: ");
            String escuela = scanner.nextLine();
            estudiante = new Estudiante(nombre, saldo, escuela);
        }else{
            if(saldo>10000 && saldo<25000){
                System.out.print("Usted es un socio\nIngrese su numero de membresia: ");
                String noMembresia = scanner.nextLine();
                socio = new Socio(nombre, saldo, noMembresia);
            }else{
                System.out.print("Usted es VIP\nIngrese su numero y categoria de la membresia: ");
                String noMembresia = scanner.nextLine();
                String categoriaMembresia = scanner.nextLine();
                vip = new VIP(nombre, saldo, noMembresia, categoriaMembresia);
            }
        }

        int opcion, opcion2, seleccion;
        System.out.println("---------- Bienvenido a la tienda Coper-Brent ----------\n");
        do{
            System.out.println("--------------- Menu ---------------\n");
            System.out.println("1.Computadoras\n2.Dispositivos moviles\n3.Televisiones\n4.Salir");
            System.out.print("Que desea comprar?: ");
            opcion = scanner.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("---------- Computadoras ----------\n");
                    System.out.println("1.Laptop\n2.PC");
                    System.out.print("Que tipo de computadora desea comprar?: ");
                    opcion2 = scanner.nextInt();
                    switch(opcion2){
                        case 1:
                            seleccion = Submenu("Laptop", laptops);
                            if (seleccion == -1){
                                break;
                            }
                            carritoDeCompras.add(laptops.get(seleccion));
                            break;
                        case 2:
                            seleccion = Submenu("PC", PCs);
                            if (seleccion == -1){
                                break;
                            }
                            carritoDeCompras.add(PCs.get(seleccion));
                            break;
                        default:
                            System.out.println("... .... ... Opcion no valida ... .... ...");
                    }
                    break;
                case 2:
                    System.out.println("Que tipo de dispositivo movil desea comprar?");
                    System.out.println("1.Celular\n2.Smartphone\n3.Tablet");
                    opcion2 = scanner.nextInt();
                    switch(opcion2){
                        case 1:
                            seleccion = Submenu("Celular", celulares);
                            if (seleccion == -1){
                                break;
                            }
                            carritoDeCompras.add(celulares.get(seleccion));
                            break;
                        case 2:
                            seleccion = Submenu("Smartphone", smartphones);
                            if (seleccion == -1){
                                break;
                            }
                            carritoDeCompras.add(smartphones.get(seleccion));
                            break;
                        case 3:
                            seleccion = Submenu("Tablet", tabletas);
                            if (seleccion == -1){
                                break;
                            }
                            carritoDeCompras.add(tabletas.get(seleccion));
                            break;
                        default:
                            System.out.println("Opcion no valida");
                    }
                    break;
                case 3:
                    seleccion = Submenu("Television", televisiones);
                    if (seleccion == -1){
                        break;
                    }
                    carritoDeCompras.add(televisiones.get(seleccion));
                    break;
                case 4:
                    scanner.close();
                    System.out.println("Gracias por sus selecciones, ahora pase a la zona de cobro");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }while(opcion!= 4);
        
        for(DispositivoElectronico producto : carritoDeCompras){
            if(estudiante != null){
                estudiante.descuento(producto.getPrecio());
            }else{
                if(socio != null){
                    socio.promocion(producto.getPrecio());
                }else{
                    vip.promocion(producto.getPrecio());
                    vip.cashback(producto.getPrecio());
                }
            }
        }

    }
    public static int Submenu(String nombre, ArrayList<DispositivoElectronico> tipo){
        if(tipo.isEmpty()){
            System.out.println("Lo siento, no contamos con " + nombre + "s por el momento");
            return -1;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Las " + nombre + "s que tenemos son:");
        int i=1;
        for(DispositivoElectronico lista: tipo){
            System.out.println("---------- " + nombre + " #" + i + " ----------");
            i++;
            lista.imprimirDatos();
        }
        System.out.print("Eliga el numero del producto: ");
        return (sc.nextInt() -1);
    }
}
