package Practica_7.Productos.Dispositivo_Movil;

public class Celular extends DispositivoMovil{

    // Atributos
    private boolean bat_remove;

    // Constructor
    public Celular(String id, String marca, double precio, String redes, String camara, boolean bat_remove){
        super(id, marca, precio, redes, camara);
        this.bat_remove = bat_remove;
    }

    // Getters
    public boolean getBatRemove(){
        return this.bat_remove;
    }

    // Métodos
    @Override
    public void imprimirDatos(){
        super.imprimirDatos();
        if (this.bat_remove == true){
            System.out.println("Batería Removible");
        }else{
            System.out.println("Batería No Removible");
        }
    }
}
