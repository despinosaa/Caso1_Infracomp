public class Interno1 extends Thread {

    private int contadorFin = 0;
    private DepositoProduccion depProd;

    
    // Constructor
    public Interno1(DepositoProduccion depProd) {
        System.out.println("Interno1 se ha creado");
        this.depProd = depProd;
    }

    @Override
    public void run() {
        while(contadorFin < 4) {
            agarrarDepProd();
            if (contadorFin == 4) {
                System.out.println("******************************");
                System.out.println("Interno1 ha encontrado los 4 FIN");
                System.out.println("******************************");
            }
            yield();
        }
    }
    
    private void agarrarDepProd() {

        Producto producto = depProd.agarrarProducto();
        if (producto != null && (producto.getTipo() == Producto.TipoProducto.FIN_A || producto.getTipo() == Producto.TipoProducto.FIN_B)) {
            contadorFin++;
        }
    }




}
