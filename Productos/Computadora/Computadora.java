package Productos.Computadora;

import Productos.DispositivoElectronico;

public class Computadora extends DispositivoElectronico{

    // Atributos
    private String sistema_opera;
    private int ram;

    // Constructor
    public Computadora(String id, String marca, double precio, String sistema_opera, int ram){
        super(id, marca, precio);
        this.sistema_opera = sistema_opera;
        this.ram = ram;
    }

    //Getters
    public String getSisOpera(){
        return this.sistema_opera;
    }
    public int getRam(){
        return this.ram;
    }

    // Métodos
    @Override
    public void imprimirDatos(){
        System.out.println("\n--------------- Caracteristicas ---------------\n");
        System.out.println("Sistema Operativo: "+getSisOpera());
        System.out.println("Memoria RAM de "+getRam()+" Gb");
    }
}
