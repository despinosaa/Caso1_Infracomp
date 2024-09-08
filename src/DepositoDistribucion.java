import java.util.ArrayList;

public class DepositoDistribucion {
    
    // Atributos
    private int capDepDist;
    private ArrayList<Producto> productosA = new ArrayList();
    private ArrayList<Producto> productosB = new ArrayList<>();

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
        while (capDepDist == (productosA.size() + productosB.size())) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (producto.getTipo() == Producto.TipoProducto.A || producto.getTipo() == Producto.TipoProducto.FIN_A) {
            productosA.add(producto);
        } else if (producto.getTipo() == Producto.TipoProducto.B || producto.getTipo() == Producto.TipoProducto.FIN_B) {
            productosB.add(producto);
        }
        System.out.println("Al DEPÓSITO DE DISTRIBUCIÓN se ha agregado: " + producto);
        notifyAll();
    }

    public synchronized Producto agarrarProducto(Distribuidor distribuidor){
        if (distribuidor.getTipo() == Distribuidor.TipoDistribuidor.A) {
            while (productosA.size() == 0) {  
                try {
                    wait();  
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Producto producto = productosA.get(0);
            productosA.remove(0);
            System.out.println("Del DEPÓSITO DE DISTRIBUCIÓN se ha agarrado: " + producto);
            notifyAll();  
            return producto;
        }
    
        if (distribuidor.getTipo() == Distribuidor.TipoDistribuidor.B) {
            while (productosB.size() == 0) {  
                try {
                    wait();  
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Producto producto = productosB.get(0);
            productosB.remove(0);
            System.out.println("Del DEPÓSITO DE DISTRIBUCIÓN se ha agarrado: " + producto);
            notifyAll();  
            return producto;
        }
        
        return null;
    }
}
