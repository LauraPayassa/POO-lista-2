public class Reta {
    private double a; //linear
    private double b; //angular
    
    public Reta(double a, double b) {  // construtor reta ab
        this.a = a;
        this.b = b;
    }

    public Reta(double x1, double y1, double x2, double y2) {  //dois pontos
        if (x1 == x2) {
            throw new IllegalArgumentException("Os pontos não podem ter a mesma coordenada x (reta vertical).");
        }
        this.a = (y2 - y1) / (x2 - x1); //angular
        this.b = y1 - this.a * x1; //linear
    }

    public double getCoeficienteAngular() {
        return a;
    }

    public double getCoeficienteLinear() {
        return b;
    }

    public boolean pertenceAReta(double x, double y) {
        return y == (a * x + b);
    }

    public double[] pontoDeIntersecao(Reta outra) {
        if (this.a == outra.a) {
            return null; 
        }
       
        double xIntersecao = (outra.b - this.b) / (this.a - outra.a);
        
        double yIntersecao = this.a * xIntersecao + this.b;
        return new double[]{xIntersecao, yIntersecao}; 
    }
