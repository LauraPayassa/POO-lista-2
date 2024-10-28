public class Main{
    public static void main(String[] args) {

    }
}
class Pessoa{
    private String nome;
    private Pessoa pai;
    private Pessoa mae;

    public Pessoa(String nome, Pessoa pai, Pessoa mae){
        this.nome = nome;
        this.pai = pai;
        this.mae = mae;
    }

    public Pessoa(String nome){
        this.nome = nome;
        this.pai = null;
        this.mae = null;
    }

    public boolean equals(Pessoa outra){
        return this.nome.equals(outra.nome) && this.mae.equals(outra.mae);
    }
}
