public class Distribuidor extends Thread{
    
    // Tipo productor
    public enum TipoDistribuidor {
        A, B
    } 

    // Atributos
    private TipoDistribuidor tipo;
    private DepositoDistribucion depDist;


    // Constructor
    public Distribuidor(TipoDistribuidor tipo, DepositoDistribucion depDist) {
        this.tipo = tipo;
        this.depDist = depDist;
    }
    
    // Getters y Setters
    public TipoDistribuidor getTipo() {
        return tipo;
    }

    public void setTipo(TipoDistribuidor tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Distribuidor [tipo=" + tipo + "]";
    }

    private void agarrarDepPDist() {

        boolean continuar = true;
        while(continuar){
            Producto producto = depDist.agarrarProducto(this);
            if(producto != null){
                System.out.println("Distribuidor " + tipo + " ha retirado: " + producto);
                if((producto.toString().contains("FIN"))){
                    continuar = false;
                    System.out.println("Distribuidor " + tipo + " ha encontrado FIN" + tipo + "y ha terminado.");
                }
            }
            Thread.yield();
        }
    }
    
}
