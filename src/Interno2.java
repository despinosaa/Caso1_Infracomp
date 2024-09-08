public class Interno2 extends Thread{

    private int contadorFin = 0;
    private DepositoDistribucion depDist;
    private Cinta cinta;

    public Interno2(DepositoDistribucion depDist, Cinta cinta) {
        System.out.println("Interno2 se ha creado");
        this.depDist = depDist;
        this.cinta = cinta;
    }

    @Override
    public void run(){
        while(contadorFin < 4) {
            agarrarCinta();
            if (contadorFin == 4) {
                System.out.println("******************************");
                System.out.println("Interno2 ha encontrado los 4 FIN");
                System.out.println("******************************");
            }
            Thread.yield();
        }
    }

    private void agarrarCinta() {
        Producto producto = cinta.agarrarProducto();
        if (producto != null){
            depDist.agregarProducto(producto);
            if (producto.getTipo() == Producto.TipoProducto.FIN_A || producto.getTipo() == Producto.TipoProducto.FIN_B) {
            contadorFin++;
            }
        }
    }
}
