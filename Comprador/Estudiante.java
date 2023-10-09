package Comprador;

public class Estudiante extends Comprador{

    // Atributos
    String escuela;

    // Constructor
    public Estudiante(String nombre, double saldo, String escuela){
        super(nombre, saldo);
        this.escuela = escuela;
    }

    // Setters y Getters
    public void setEscuela(String escuela){
        this.escuela = escuela;
    }
    public String getEscuelta(){
        return escuela;
    }

    // Métodos
    @Override
    public void imprimirDatos(){
        super.imprimirDatos();
        System.out.println("Categoria: Estudiante");
        System.out.println("Escuela: " + escuela);
    }

    public double descuento(double cargo){
        return (cargo * 0.05);
    }
}
