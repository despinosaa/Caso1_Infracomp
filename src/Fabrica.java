import java.util.Scanner;

public class Fabrica {
    public static void main(String[] args) throws Exception {

        // Input parámetros
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce el número de productos que va a crear cada operario: ");
        System.out.println("Introduce la capacidad del deposito de producción: ");
        System.out.println("Introduce la capacidad del deposito de distribución: ");
        
        int numProductos = scanner.nextInt();
        int capDepProd = scanner.nextInt();
        int capDepDist = scanner.nextInt();
        
        Productor productorA1 = new Productor(Productor.TipoProductor.A, numProductos);
        Productor productorA2 = new Productor(Productor.TipoProductor.A, numProductos);
        Productor productorB1 = new Productor(Productor.TipoProductor.B, numProductos);
        Productor productorB2 = new Productor(Productor.TipoProductor.B, numProductos);
         
        Distribuidor distribuidorA1 = new Distribuidor(Distribuidor.TipoDistribuidor.A);
        Distribuidor distribuidorA2 = new Distribuidor(Distribuidor.TipoDistribuidor.A);
        Distribuidor distribuidorB1 = new Distribuidor(Distribuidor.TipoDistribuidor.B);
        Distribuidor distribuidorB2 = new Distribuidor(Distribuidor.TipoDistribuidor.B);

        Interno interno1 = new Interno(Interno.TipoInterno.I1);
        Interno interno2 = new Interno(Interno.TipoInterno.I2);

        DepositoProduccion depProd = new DepositoProduccion(capDepProd);
        DepositoDistribucion depDist = new DepositoDistribucion(capDepDist);
        Cinta cinta = new Cinta();
        
    }
}

