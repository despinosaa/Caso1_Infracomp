public class DepositoDistribucion {
    
    // Atributos
    private int capDepDist;

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
    
}
