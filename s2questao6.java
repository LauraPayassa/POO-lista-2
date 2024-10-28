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
    if (outra == null) return false;
    if (this.mae == null && outra.mae == null) {
        return this.nome.equals(outra.nome);
    }
    if (this.mae == null || outra.mae == null) {
        return false;
    }
    return this.nome.equals(outra.nome) && this.mae.equals(outra.mae);}
} 
