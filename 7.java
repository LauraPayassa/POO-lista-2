import java.util.ArrayList;

public class Conjunto {
    private ArrayList<String> elementos = new ArrayList<>();


    public void adicionarElemento(String elemento) {
        if (!elementos.contains(elemento)) elementos.add(elemento);
    }

    
    public boolean contemElemento(String elemento) {
        return elementos.contains(elemento);
    }

    
    public Conjunto uniao(Conjunto outroConjunto) {
        Conjunto resultado = new Conjunto();
        resultado.elementos.addAll(elementos); 
        outroConjunto.elementos.forEach(e -> { if (!resultado.elementos.contains(e)) resultado.elementos.add(e); });
        return resultado;
    }


    public Conjunto inter(Conjunto outroConjunto) {
        Conjunto resultado = new Conjunto();
        elementos.stream().filter(outroConjunto.elementos::contains).forEach(resultado.elementos::add);
        return resultado;
    }


    public Conjunto menos(Conjunto outroConjunto) {
        Conjunto resultado = new Conjunto();
        elementos.stream().filter(e -> !outroConjunto.elementos.contains(e)).forEach(resultado.elementos::add);
        return resultado;
    }

    public void imprimir() {
        System.out.println(elementos);
    }
}
