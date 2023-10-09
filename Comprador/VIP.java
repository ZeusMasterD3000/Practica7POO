package Comprador;

public class VIP extends Socio{

    // Atributos
    String categoriaMembresia;
    double puntos;

    // Constructor
    public VIP(String nombre, double saldo, String noMembresia, String categoriaMembresia){
        super(nombre, saldo, noMembresia);
        this.categoriaMembresia = categoriaMembresia;
    }

    // Setters y Getters
    public void setCategoriaMembresia(String categoriaMembresia){
        this.categoriaMembresia = categoriaMembresia;
    }
    public String getCategoriaMembresia(){
        return categoriaMembresia;
    }
    public void setPuntos(double puntos){
        this.puntos = puntos;
    }
    public double getPuntos(){
        return puntos;
    }

    // Métodos
    @Override
    public void imprimirDatos(){
        super.imprimirDatos();
        System.out.println("Ademas eres un socio VIP");
        System.out.println("Categoria de Membresia: " + categoriaMembresia);
    }

    public void cashback(double cargo){
        this.puntos = cargo*0.02;
    }
}
