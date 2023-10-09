package Practica_7.Productos.Dispositivo_Movil;

public class Tablet extends DispositivoMovil{
    
    // Atributos
    private boolean pencil;

    // Constructor
    public Tablet(String id, String marca, double precio, String redes, String camara, boolean pencil){
        super(id, marca, precio, redes, camara);
        this.pencil = pencil;
    }

    // Getters
    public boolean getPencil(){
        return this.pencil;
    }

    // Métodos
    @Override
    public void imprimirDatos(){
        super.imprimirDatos();
        if(getPencil() == true){
            System.out.println("Cuenta con pencil");   
        }else{
            System.out.println("No cuenta con pencil");   
        }
    }
}
