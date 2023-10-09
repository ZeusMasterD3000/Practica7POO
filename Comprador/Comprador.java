package Practica_7.Comprador;

public class Comprador {

    // Atributos
    String nombre;
    double saldo;
    double cargo = 0; //Cargo de dinero

    // Constructor
    public Comprador(String nombre, double saldo){
        this.nombre = nombre;
        this.saldo = saldo;
    }

    // Setters y Getters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setCargo(double cargo){
        this.cargo = cargo;
    }
    public double getCargo(){
        return cargo;
    }

    // Métodos
    public void imprimirDatos(){
        System.out.println("-------Comprador-------");
        System.out.println("Nombre: " + nombre);
        System.out.println("Saldo: " + saldo);
    }
}
