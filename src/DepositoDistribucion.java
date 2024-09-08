import java.util.ArrayList;

public class DepositoDistribucion {
    
    // Atributos
    private int capDepDist;
    private ArrayList<Producto> productos = new ArrayList();

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
        System.out.println("Al DEPÓSITO DE DISTRIBUCION se ha agregado: "+producto);
        notifyAll();
    }

    public synchronized Producto agarrarProducto(Distribuidor distribuidor) {
        if (0 == productos.size()) {
            return null;
        }
        for (int i = 0; i < productos.size(); i++){
            Producto producto = productos.get(i);
            if (producto.toString() == distribuidor.toString() && (producto.toString().contains(distribuidor.toString()))) {
                productos.remove(i);
                System.out.println("Del DEPÓSITO DE DISTRIBUCION se ha agarrado: "+producto);
                notifyAll();
                return producto;
            }   
        }
        return null;
    }

}
