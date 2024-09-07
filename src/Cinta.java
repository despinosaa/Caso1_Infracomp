import java.util.ArrayList;

public class Cinta {
    
    // Constante
    private static final int capacidad = 4; // regresar a 1 para funcionamiento normal !!!
    private ArrayList<Producto> productos = new ArrayList();

    @Override
    public String toString() {
        return "Cinta []";
    }

    public synchronized Producto agarrarProducto() {
        Producto producto;

        if (0 == productos.size()) {
            return null;
        }
        producto = productos.get(0);
        productos.remove(0);
        System.out.println("De la CINTA se ha agarrado: "+producto);
        notifyAll();
        return producto;
    }

    public synchronized void agregarProducto(Producto producto) {
        while (capacidad == productos.size()) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        productos.add(producto);
        System.out.println("De la CINTA se ha agregado: "+producto);
        notifyAll();
    }
}
