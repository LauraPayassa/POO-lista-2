public class Main {
    public static void main(String[] args) {
       Contador laura = new Contador();
    }
}

class Contador {
    public int N;

    public Contador(){
        this.N = 0;
    }

    public void incrementar(){
        this.N++;
    }
    public void zerar(){
        this.N = 0;
    }
    public int retornar(){
        return this.N;
    }
}
