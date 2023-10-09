package Productos.Computadora;

public class PC extends Computadora{
    
    // Atributos
    private boolean all_for_one;

    // Constructor
    public PC(String id, String marca, double precio, String sistema_opera, int ram, boolean all_for_one){
        super(id, marca, precio, sistema_opera, ram);
        this.all_for_one = all_for_one;
    }

    //Getters
    public boolean getAllForOne(){
        return this.all_for_one;
    }

    // Métodos
    @Override
    public void imprimirDatos(){
        super.imprimirDatos();
        if(getAllForOne() == true){
            System.out.println("Cuenta con mouse, teclado y monitor");
        }else{
            System.out.println("Cuenta solo con el monitor");
        }
    }
}
