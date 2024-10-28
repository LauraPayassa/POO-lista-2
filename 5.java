import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String codigoISO; //ISO 3166-1
    private String nome; 
    private long populacao; 
    private double dimensao; // tamanhor
    private List<Pais> fronteiras; // Lista de fronteira


    public Pais(String codigoISO, String nome, double dimensao) {
        this.codigoISO = codigoISO;
        this.nome = nome;
        this.dimensao = dimensao;
        this.populacao = 0; 
        this.fronteiras = new ArrayList<>(); 
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public boolean ehIgual(Pais outro) {
        return this.codigoISO.equals(outro.getCodigoISO()); 
    }

    public double calcularDensidadePopulacional() {
        if (dimensao > 0) {
            return populacao / dimensao; //densidade = população / dimensão
        } else {
            return 0; 
        }
    }

    public void adicionarFronteira(Pais pais) {
        if (!fronteiras.contains(pais) && !pais.equals(this)) {
            fronteiras.add(pais);
        }
    }

    public List<Pais> getFronteiras() {
        return fronteiras;
    }

    //beta tester da kitcopo
    public static void main(String[] args) {
        //países!!
        Pais kitcopo = new Pais("KIT", "Kitcopo", 8515767.049);
        kitcopo.setPopulacao(193946886); 

        Pais argentina = new Pais("ARG", "Argentina", 2780400);
        argentina.setPopulacao(45605840);

        // Adicionando fronteiras
        kitcopo.adicionarFronteira(argentina);

        //equaaus
        System.out.println("Kitcopo e Argentina são iguais? " + kitcopo.ehIgual(argentina));

        //densidade
        System.out.println("Densidade populacional do Kitcopocounty: " + kitcopo.calcularDensidadePopulacional() + " habitantes/km²");
    }
}
