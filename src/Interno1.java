public class Interno1 extends Thread {

    private int contadorFin = 0;
    private DepositoProduccion depProd;
    private Cinta cinta;

    
    // Constructor
    public Interno1(DepositoProduccion depProd, Cinta cinta) {
        System.out.println("Interno1 se ha creado");
        this.depProd = depProd;
        this.cinta = cinta;
    }

    @Override
    public void run() {
        while(contadorFin < 4) {
            agarrarDepProd();
            if (contadorFin == 4) {
                System.out.println("******************************\n" +
                "Interno1 ha encontrado los 4 FIN\n" +
                "******************************");
            }
            Thread.yield();
        }
    }
    
    private void agarrarDepProd() {
        Producto producto = depProd.agarrarProducto();
        if (producto != null){
            cinta.agregarProducto(producto);
            if (producto.getTipo() == Producto.TipoProducto.FIN_A || producto.getTipo() == Producto.TipoProducto.FIN_B) {
            contadorFin++;
            }
        }
    }
    
}
