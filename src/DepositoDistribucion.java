import java.util.LinkedList;
import java.util.Queue;

public class DepositoDistribucion {
    
    // Atributos
    private int capDepDist;
    private Queue<Producto> productos = new LinkedList<>();

    // Constructor
    public DepositoDistribucion(int capDepDist) {
        this.capDepDist = capDepDist;
    }

    // Getters y Setters
    public int getCapDepDist() {
        return capDepDist;
    }

    public void setCapDepDist(int capDepDist) {
        this.capDepDist = capDepDist;
    }

    @Override
    public String toString() {
        return "DepositoDistribucion [capDepDist=" + capDepDist + "]";
    }
    
    public synchronized void agregarProducto(Producto producto){
        while (capDepDist == productos.size()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        productos.add(producto);
        System.out.println("Al DEPÓSITO DE DISTRIBUCIÓN se ha agregado: " + producto);
        notifyAll();
    }

    public synchronized Producto agarrarProducto(Distribuidor distribuidor){
        while(productos.size() == 0) {  
            try {
                wait();  
            } catch (InterruptedException e) {
                e.printStackTrace();
                }
        }
        
        if((productos.peek().getTipo() == Producto.TipoProducto.A || productos.peek().getTipo() == Producto.TipoProducto.FIN_A)
            && (distribuidor.getTipo() == Distribuidor.TipoDistribuidor.A)){
                Producto producto = productos.poll();
                System.out.println("Del DEPÓSITO DE DISTRIBUCIÓN se ha agarrado: " + producto);
                notifyAll();
                return producto;
        }
        
        if((productos.peek().getTipo() == Producto.TipoProducto.B || productos.peek().getTipo() == Producto.TipoProducto.FIN_B)
            && (distribuidor.getTipo() == Distribuidor.TipoDistribuidor.B)){
                Producto producto = productos.poll();
                System.out.println("Del DEPÓSITO DE DISTRIBUCIÓN se ha agarrado: " + producto);
                notifyAll();
                return producto;
        }
        return null;
    }

}
