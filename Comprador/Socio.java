package Practica_7.Comprador;

public class Socio extends Comprador{

    // Atributos
    String noMembresia;

    // Constructor
    public Socio(String nombre, double saldo, String noMembresia){
        super(nombre, saldo);
        this.noMembresia = noMembresia;
    }

    // Setters y Getters
    public void setNoMembresia(String noMembresia){
        this.noMembresia = noMembresia;
    }
    public String getNoMembresia(){
        return noMembresia;
    }

    // Métodos
    @Override
    public void imprimirDatos(){
        super.imprimirDatos();
        System.out.println("Categoria: Socio");
        System.out.println("Numero de membresia: " + noMembresia);
    }

    public double promocion(double cargo){
        return cargo * (0.1);
    }
}   

