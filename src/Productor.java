public class Productor {
    
    // Tipo productor
    public enum TipoProductor {
        A, B
    } 

    // Atributos
    private TipoProductor tipo;
    private int numProductos;
    private DepositoProduccion depProd;

    // Constructor
    public Productor (TipoProductor tipo, int numProductos, DepositoProduccion depProd) {
        this.tipo = tipo;
        this.numProductos = numProductos;
        this.depProd = depProd;
        toString();
        crearProductos();
    }

    @Override
    public String toString() {
        return "Productor [tipo=" + tipo + ", numProductos=" + numProductos + "] se ha creado";
    }
    
    private void crearProductos() {
        for (int i = 0; i < numProductos-1; i++) {
            Producto producto = new Producto(Producto.TipoProducto.valueOf(tipo.toString()));
            System.out.println("Se ha creado: "+producto);
            this.depProd.agregarProducto(producto);
        }
        Producto producto = new Producto(Producto.TipoProducto.valueOf("FIN_"+tipo.toString()));
        System.out.println("Se ha creado: "+producto);
        this.depProd.agregarProducto(producto);


    }

    private void agregarProducto(DepositoProduccion depProd) {
    }

}
