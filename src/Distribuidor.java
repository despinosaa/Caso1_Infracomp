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
        return "" + tipo + "";
    }

    @Override
    public void run() {
        consumirProductos();
    }

    private void consumirProductos() {
        boolean continuar = true;
        while(continuar){
            Producto producto = depDist.agarrarProducto(this);
            if(producto != null){
                System.out.println("El Distribuidor " + tipo + " ha retirado: " + producto);
                if((producto.getTipo() == Producto.TipoProducto.FIN_A) || (producto.getTipo() == Producto.TipoProducto.FIN_B)){
                    continuar = false;
                    Producto.TipoProducto tipoproducto = producto.getTipo();
                    System.out.println("El Distribuidor " + tipo + " ha encontrado " + tipoproducto + "y ha terminado.");
                }
            }
            Thread.yield();
        }
    }
    
}
