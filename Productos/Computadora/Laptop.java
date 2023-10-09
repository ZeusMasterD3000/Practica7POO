package Practica_7.Productos.Computadora;

public class Laptop extends Computadora{
    
    // Atributos
    private String bateria;
    
    // Constructor
    public Laptop(String id, String marca, double precio, String sistema_opera, int ram, String bateria){
        super(id, marca, precio, sistema_opera, ram);
        this.bateria = bateria;
    }

    //Getters
    public String getBateria(){
        return this.bateria;
    }

    // Métodos
    @Override
    public void imprimirDatos(){
        super.imprimirDatos();
        System.out.println("Bateria de "+ getBateria());
    }
}
