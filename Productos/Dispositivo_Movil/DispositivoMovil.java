package Productos.Dispositivo_Movil;

import Productos.DispositivoElectronico;

public class DispositivoMovil extends DispositivoElectronico{

    // Atributos
    private String redes;
    private String camara;

    // Constructor
    public DispositivoMovil(String id, String marca, double precio, String redes, String camara){
        super(id, marca, precio);
        this.redes = redes;
        this.camara = camara;
    }

    // Getters
    public String getRedes(){
        return this.redes;
    }
    public String getCamara(){
        return this.camara;
    }

    // Métodos
    @Override
    public void imprimirDatos(){
        System.out.println("\n--------------- Caracteristicas ---------------\n");
        System.out.println("Camara: "+getCamara());
        System.out.println("Red "+getRedes());
    }

}