package Practica_7.Productos.Television;

import Practica_7.Productos.DispositivoElectronico;

public class Television extends DispositivoElectronico{
    
    // Atributos
    private int tamaño;
    private boolean sisInt;
    private String calidad_imag;

    // Constructor
    public Television(String id, String marca, double precio ,int tamaño, boolean sisInt, String calidad_imag){
        super(calidad_imag, marca, precio);
        this.tamaño = tamaño;
        this.sisInt = sisInt;
        this.calidad_imag = calidad_imag;
    }

    // Getters
    public int getTamaño(){
        return this.tamaño;
    }
    public boolean getSisInt(){
        return this.sisInt;
    }
    public String getCalidadImga(){
        return this.calidad_imag;
    }

    // Métodos
    public void imprimirDatos(){
        System.out.println("\n--------------- Caracteristicas ---------------\n");
        System.out.println("Tamaño: "+getTamaño());
        System.out.println("Calidad: "+getCalidadImga());
        System.out.println("Sistema Inteligente: "+getSisInt());
    }
}
