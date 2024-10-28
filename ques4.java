public class Circulo {
    private double raio;
    private double centroX;
    private double centroY;

    //construtor1
    public Circulo(double raio, double centroX, double centroY) {
        if (raio < 0) {
            throw new IllegalArgumentException("O raio não pode ser negativo.");
        }
        this.raio = raio;
        this.centroX = centroX;
        this.centroY = centroY;
    }
    //2
    public Circulo(double raio) {
        this(raio, 0, 0); //chama o 1
    }

    public double getRaio() {
        return raio;
    }

    public void inflar(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor para inflar deve ser positivo.");
        }
        raio += valor;
    }

    public void desinflar(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor para desinflar deve ser positivo.");
        }
        raio = Math.max(0, raio - valor); 
    }

    //n sei geometria slg
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
//ariana what are you doing here
