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

    //kitcopos test area >:(
    public static void main(String[] args) {
        // Criando retas para testes
        Reta reta1 = new Reta(2, 3); //y = 2x + 3
        Reta reta2 = new Reta(1, 2, 3, 8); //(1, 2)  (3, 8)

        // Testando se um ponto pertence à reta
        System.out.println("Ponto (1, 5) pertence à reta1? " + reta1.pertenceAReta(1, 5));

        // Encontrando o ponto de interseção
        double[] intersecao = reta1.pontoDeIntersecao(reta2);
        if (intersecao != null) {
            System.out.println("Ponto de interseção: (" + intersecao[0] + ", " + intersecao[1] + ")");
        } else {
            System.out.println("As retas são paralelas.");
        }
    }
}
