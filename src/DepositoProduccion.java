import java.util.ArrayList;

public class DepositoProduccion {

    // Atributos
    private int capDepProd;
    private ArrayList<Producto> productos = new ArrayList();

    // Constructor
    public DepositoProduccion(int capDepProd) {
        this.capDepProd = capDepProd;
        
    }

    // Getters y Setters
    public int getCapDepProd() {
        return capDepProd;
    }

    public void setCapDepProd(int capDepProd) {
        this.capDepProd = capDepProd;
    }

    @Override
    public String toString() {
        return "DepositoProduccion [capDepProd=" + capDepProd + "]";
    }
    
    public synchronized void agregarProducto(Producto producto) {
        while (capDepProd == productos.size()) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        productos.add(producto);
        System.out.println("Al deposito de producción se ha agregado: "+producto);
        notifyAll();
    }

    // public synchronized Producto agarrarProducto() throws InterruptedException {
    //     Producto producto;

    //     while (0 == productos.size()) {
    //         Thread.yield();
            
    //     }
    //     producto = productos.get(0);
    //     productos.remove(0);
    //     System.out.println("Del deposito de producción se ha agarrado: "+producto);
    //     notifyAll();
    //     return producto;
    // }
    public synchronized Producto agarrarProducto() {
        Producto producto;

        if (0 == productos.size()) {
            return null;
        }
        producto = productos.get(0);
        productos.remove(0);
        System.out.println("Del deposito de producción se ha agarrado: "+producto);
        notifyAll();
        return producto;
    }

}
