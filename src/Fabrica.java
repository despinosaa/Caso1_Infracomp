import java.util.Scanner;

public class Fabrica {
    public static void main(String[] args) throws Exception {

        // Input parámetros
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce el número de productos que va a crear cada operario: ");
        int numProductos = scanner.nextInt();

        System.out.println("Introduce la capacidad del deposito de producción: ");
        int capDepProd = scanner.nextInt();
        
        System.out.println("Introduce la capacidad del deposito de distribución: ");
        int capDepDist = scanner.nextInt();

        scanner.close();

        DepositoProduccion depProd = new DepositoProduccion(capDepProd);
        DepositoDistribucion depDist = new DepositoDistribucion(capDepDist);

        Productor productorA1 = new Productor(Productor.TipoProductor.A, numProductos, depProd);
        Productor productorA2 = new Productor(Productor.TipoProductor.A, numProductos,depProd);
        Productor productorB1 = new Productor(Productor.TipoProductor.B, numProductos,depProd);
        Productor productorB2 = new Productor(Productor.TipoProductor.B, numProductos,depProd);
         
        Distribuidor distribuidorA1 = new Distribuidor(Distribuidor.TipoDistribuidor.A);
        Distribuidor distribuidorA2 = new Distribuidor(Distribuidor.TipoDistribuidor.A);
        Distribuidor distribuidorB1 = new Distribuidor(Distribuidor.TipoDistribuidor.B);
        Distribuidor distribuidorB2 = new Distribuidor(Distribuidor.TipoDistribuidor.B);

        Cinta cinta = new Cinta();

        Interno1 interno1 = new Interno1(depProd, cinta);
        Interno interno2 = new Interno(Interno.TipoInterno.I2);



        productorA1.start();
        productorA2.start();
        productorB1.start();
        productorB2.start();
        interno1.start();
        // for (int i = 0; i < numProductos; i++) {
        //     depProd.agarrarProducto();
        // }

        // while (true) {
        //     depProd.agarrarProducto();
        //     Thread.yield();
        // }

    }
}

