public class DepositoProduccion {

    // Atributos
    private int capDepProd;

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
    
}
