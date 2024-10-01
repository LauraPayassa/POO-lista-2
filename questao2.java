public class Main{
    public static void main(String[] args) {
        Ponto2d laura = new Ponto2d(4.0, 7.0);
    }
}

class Ponto2d{
    private double x;
    private double y;

    public Ponto2d(){
        this.x = 0.0;
        this.y = 0.0;
    }

    public Ponto2d(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Ponto2d(Ponto2d outroponto){
        this.x = outroponto.x;
        this.y = outroponto.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ponto2d) {
            Ponto2d outroPonto = (Ponto2d) obj;
            return this.x == outroPonto.x && this.y == outroPonto.y;
        }
        return false;
    }

    public double calcularDistancia(Ponto2d outroponto){
        double distanciax = outroponto.x - this.x;
        double distanciay = outroponto.y - this.y;
        return Math.sqrt(distanciax * distanciax + distanciay * distanciay);
    }
}
