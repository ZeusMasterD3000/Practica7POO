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
        System.out.print("\nTomando en cuenta que el saldo establece tu categoria:\nEstudiante: Saldo menor a 10,000\nSocio: Saldo mayor a 10,000 pero menor a 25,000\nVIP: Saldo mayor a 25,000\n\nIngresa tu saldo: ");
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
            System.out.println("\n--------------- ESTUDIANTE ---------------");
            System.out.print("Ingrese la escuela de procedencia: ");
            String escuela = scanner.nextLine();
            estudiante = new Estudiante(nombre, saldo, escuela);
        }else{
            if(saldo>10000 && saldo<25000){
                System.out.println("\n--------------- SOCIO ---------------");
                System.out.print("Ingrese su numero de membresia: ");
                String noMembresia = scanner.nextLine();
                socio = new Socio(nombre, saldo, noMembresia);
            }else{
                System.out.println("\n--------------- VIP ---------------");
                System.out.print("Ingrese su numero: ");
                String noMembresia = scanner.nextLine();
                System.out.print("Categoria de la membresia: ");
                String categoriaMembresia = scanner.nextLine();
                vip = new VIP(nombre, saldo, noMembresia, categoriaMembresia);
            }
        }
        if(estudiante!= null){
            PCs = limitarCompra(estudiante.getSaldo(), PCs);
            laptops = limitarCompra(estudiante.getSaldo(), laptops);
            televisiones = limitarCompra(estudiante.getSaldo(), televisiones);
            tabletas = limitarCompra(estudiante.getSaldo(), tabletas);
            smartphones = limitarCompra(estudiante.getSaldo(), smartphones);
            celulares = limitarCompra(estudiante.getSaldo(), celulares);
        }else{
            if(socio != null){
                PCs = limitarCompra(socio.getSaldo(), PCs);
                laptops = limitarCompra(socio.getSaldo(), laptops);
                televisiones = limitarCompra(socio.getSaldo(), televisiones);
                tabletas = limitarCompra(socio.getSaldo(), tabletas);
                smartphones = limitarCompra(socio.getSaldo(), smartphones);
                celulares = limitarCompra(socio.getSaldo(), celulares);
            }else{
                PCs = limitarCompra(vip.getSaldo(), PCs);
                laptops = limitarCompra(vip.getSaldo(), laptops);
                televisiones = limitarCompra(vip.getSaldo(), televisiones);
                tabletas = limitarCompra(vip.getSaldo(), tabletas);
                smartphones = limitarCompra(vip.getSaldo(), smartphones);
                celulares = limitarCompra(vip.getSaldo(), celulares);
            }
        }
        
        int opcion, opcion2, seleccion;
        System.out.println("\n---------- Bienvenido a la tienda Coper-Brent ----------");
        do{
            System.out.println("\n--------------- Menu ---------------");
            System.out.println("1.Comprar computadoras\n2.Comprar Dispositivos moviles\n3.Comprar Televisiones\n4.Pagar\n5.Salir");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("\n--------------- Computadoras ---------------");
                    System.out.println("1.Laptop\n2.PC");
                    System.out.print("Tipo de computadora a comprar: ");
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
                            System.out.println("\n... .... ... Opcion no valida ... .... ...");
                    }
                    break;
                case 2:
                    System.out.println("\n---------- Dispositivo Movil ----------");
                    System.out.println("1.Celular\n2.Smartphone\n3.Tablet");
                    System.out.print("Opcion: ");
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
                            System.out.println("\n... .... ... Opcion no valida ... .... ...");
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
                    if(estudiante != null){
                        estudiante.setCargo(0);
                    }else{
                        if(socio != null){
                            socio.setCargo(0);
                        }else{
                            vip.setCargo(0);
                        }
                    }
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
                    System.out.println("\n--------------- Caja de Cobro ---------------\n");
                    if(estudiante != null){
                        if(estudiante.getSaldo() >= estudiante.getCargo()){
                            System.out.println("Usted va a pagar "+estudiante.getCargo()+" por lo que su saldo queda con "+(estudiante.getSaldo()-estudiante.getCargo()));
                            estudiante.setCargo(0);
                            estudiante.setSaldo((estudiante.getSaldo()-estudiante.getCargo()));
                        }else{
                            System.out.println("Usted va a pagar "+estudiante.getCargo()+" pero su saldo es insuficiente");
                            System.out.println("Desea dejar algun producto? (1.SI / 2.NO)");
                            System.out.print("Opcion: ");
                            int dp = scanner.nextInt();
                            if(dp == 1){
                                int indice_producto = quitarProductos(dp, carritoDeCompras);
                                carritoDeCompras.remove(indice_producto);
                            }else{
                                System.out.println("\n... .... ... Usted no podra irse hasta que nos pague ... .... ...");
                            }
                        }
                    }else{
                        if(socio != null){
                            if(socio.getSaldo() >= socio.getCargo()){
                                System.out.println("Usted va a pagar "+socio.getCargo()+" por lo que su saldo queda con "+(socio.getSaldo()-socio.getCargo()));
                                socio.setCargo(0);
                                socio.setSaldo((socio.getSaldo()-socio.getCargo()));
                            }else{
                                System.out.println("Usted va a pagar "+socio.getCargo()+" pero su saldo es insuficiente");
                                System.out.println("Desea dejar algun producto? (1.SI / 2.NO)");
                                System.out.print("Opcion: ");
                                int dp = scanner.nextInt();
                                if(dp == 1){
                                    int indice_producto = quitarProductos(dp, carritoDeCompras);
                                    carritoDeCompras.remove(indice_producto);
                                }else{
                                    System.out.println("\n... .... ... Usted no podra irse hasta que nos pague ... .... ...");
                                }
                            }
                        }else{
                            if(vip.getSaldo() >= vip.getCargo()){
                                System.out.println("Usted va a pagar "+vip.getCargo()+" por lo que su saldo queda con "+(vip.getSaldo()-vip.getCargo()));
                                vip.setCargo(0);
                                vip.setSaldo((vip.getSaldo()-vip.getCargo()));
                            }else{
                                System.out.println("Usted va a pagar "+vip.getCargo()+" pero su saldo es insuficiente");
                                System.out.println("Desea dejar algun producto? (1.SI / 2.NO)");
                                System.out.print("Opcion: ");
                                int dp = scanner.nextInt();
                                if(dp == 1){
                                    int indice_producto = quitarProductos(dp, carritoDeCompras);
                                    carritoDeCompras.remove(indice_producto);
                                }else{
                                    System.out.println("\n... .... ... Usted no podra irse hasta que nos pague ... .... ...");
                                }
                            }
                        }
                    }
                    break;

                case 5:
                    if(estudiante != null){
                        if(estudiante.getCargo() == 0){
                            scanner.close();
                            System.out.println("... .... ... Tenga un bonito dia ... .... ...");
                            return;
                        }
                    }else{
                        if(socio != null){
                            if(socio.getCargo() == 0){
                                scanner.close();
                                System.out.println("... .... ... Tenga un bonito dia ... .... ...");
                                return;
                            }
                        }else{
                            if(vip.getCargo() == 0){
                                scanner.close();
                                System.out.println("... .... ... Tenga un bonito dia ... .... ...");
                                return;
                            }
                        }
                    }
                    opcion = -1;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }while(opcion != 5);

    }

    public static int Submenu(String nombre, ArrayList<DispositivoElectronico> tipo){
        if(tipo.isEmpty()){
            System.out.println("\nLo siento, no contamos con " + nombre + "s por el momento");
            return -1;
        }
        Scanner sc = new Scanner(System.in);
        int i=1;
        for(DispositivoElectronico lista: tipo){
            System.out.println("\n--------------- " + nombre + " #" + i + " ---------------");
            i++;
            lista.imprimirDatos();
        }
        System.out.print("\nEliga el numero del producto: ");
        return (sc.nextInt() -1);
    }

    public static int quitarProductos(int dp, ArrayList<DispositivoElectronico> carritoDeCompras){
        Scanner sc = new Scanner(System.in);
        for(DispositivoElectronico producto : carritoDeCompras){
            System.out.println("\n--------------- PRODUCTO " + dp + " ---------------");
            producto.imprimirDatos();
            dp ++;
        }
        System.out.print("\nProducto a retirar de su carrito de compras: ");
        int pp = sc.nextInt();
        return pp;
    }

    public static ArrayList<DispositivoElectronico> limitarCompra(double saldo, ArrayList<DispositivoElectronico> lista){
        ArrayList<DispositivoElectronico> copia = new ArrayList<>(lista);
        if(saldo<10000){
            for(DispositivoElectronico iterar: lista){
                if(!(iterar.getPrecio()<10000)){
                    copia.remove(iterar);
                }
            }
            return copia;
        }else{
            if(saldo>10000 && saldo<25000){
                for(DispositivoElectronico iterar: lista){
                    if(!(iterar.getPrecio()<25000)){
                        copia.remove(iterar);
                    }
                }
                return copia;
            }else{
                for(DispositivoElectronico iterar: lista){
                    if(!(iterar.getPrecio()>15000)){
                        copia.remove(iterar);
                    }
                }
                return copia;
            }
        }
    }
}