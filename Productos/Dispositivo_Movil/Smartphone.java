package Practica_7.Productos.Dispositivo_Movil;

public class Smartphone extends DispositivoMovil{

    // Atributos
    private String fast_charger;

    // Constructor
    public Smartphone(String id, String marca, double precio, String redes, String camara, String fast_charger){
        super(id, marca, precio, redes, camara);
        this.fast_charger = fast_charger;
    }

    // Getters
    public String getFastCharger(){
        return this.fast_charger;
    }

    // Métodos
    @Override
    public void imprimirDatos(){
        super.imprimirDatos();
        System.out.println("Carga Rapida de "+getFastCharger());
    }
}
