package Productos;

public class DispositivoElectronico {
    
    // Atributos
    private String id;
    private double precio;
    private String marca;

    // Constructor
    public DispositivoElectronico(String id, String marca, double precio){
        this.id = id;
        this.marca = marca;
        this.precio = precio;
    }

    // Getters
    public String getID(){
        return this.id;
    }
    public String getMarca(){
        return this.marca;
    }
    public double getPrecio(){
        return this.precio;
    }

    // Métodos
    public void imprimirDatos(){
        System.out.println("------------------ Productos ------------------");
        System.out.println("---- Marca ---- ---- ID ---- ---- Precio ----\n");
        System.out.print(getMarca());
        System.out.print(" ("+getID()+")");
        System.out.print(" $"+getPrecio());
    }
    
}
