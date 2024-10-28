import java.util.Arrays;

public class Matriz {
    private int[][] elementos;
    private int linhas, colunas;

    // Construtor
    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.elementos = new int[linhas][colunas];
    }

    // Métodos de acesso (get/set)
    public int getElemento(int linha, int coluna) { return elementos[linha][coluna]; }
    public void setElemento(int linha, int coluna, int valor) { elementos[linha][coluna] = valor; }

    // Adição e Subtração de matrizes
    public Matriz adicionar(Matriz outra) { return operar(outra, (a, b) -> a + b); }
    public Matriz subtrair(Matriz outra) { return operar(outra, (a, b) -> a - b); }

    // Multiplicação de matrizes
    public Matriz multiplicar(Matriz outra) {
        if (this.colunas != outra.linhas) throw new IllegalArgumentException("Dimensões incompatíveis");
        Matriz resultado = new Matriz(linhas, outra.colunas);
        for (int i = 0; i < linhas; i++)
            for (int j = 0; j < outra.colunas; j++)
                for (int k = 0; k < colunas; k++)
                    resultado.elementos[i][j] += this.elementos[i][k] * outra.elementos[k][j];
        return resultado;
    }

    // Operação para adição e subtração (interno)
    private Matriz operar(Matriz outra, Operacao op) {
        if (linhas != outra.linhas || colunas != outra.colunas)
            throw new IllegalArgumentException("Dimensões incompatíveis");
        Matriz resultado = new Matriz(linhas, colunas);
        for (int i = 0; i < linhas; i++)
            for (int j = 0; j < colunas; j++)
                resultado.elementos[i][j] = op.executar(this.elementos[i][j], outra.elementos[i][j]);
        return resultado;
    }

    // Transposta e Oposta
    public Matriz transposta() { return copiar((i, j) -> this.elementos[j][i]); }
    public Matriz oposta() { return copiar((i, j) -> -this.elementos[i][j]); }

    // Operações para verificar tipo de matriz
    public boolean isIgual(Matriz outra) { return Arrays.deepEquals(this.elementos, outra.elementos); }
    public boolean isIdentidade() { return verificar((i, j) -> i == j ? elementos[i][j] == 1 : elementos[i][j] == 0); }
    public boolean isDiagonal() { return verificar((i, j) -> i == j || elementos[i][j] == 0); }
    public boolean isSimetrica() { return isIgual(this.transposta()); }
    public boolean isAntiSimetrica() { return isIgual(this.oposta().transposta()); }

    // Funções auxiliares para copiar/verificar
    private Matriz copiar(Transformacao t) {
        Matriz copia = new Matriz(colunas, linhas);
        for (int i = 0; i < linhas; i++) for (int j = 0; j < colunas; j++) copia.elementos[i][j] = t.executar(i, j);
        return copia;
    }
    private boolean verificar(Condicao cond) {
        for (int i = 0; i < linhas; i++) for (int j = 0; j < colunas; j++) if (!cond.testar(i, j)) return false;
        return true;
    }

    // Imprimir matriz
    public void imprimir() { Arrays.stream(elementos).forEach(linha -> System.out.println(Arrays.toString(linha))); }

    // Interface funcional para operações
    interface Operacao { int executar(int a, int b); }
    interface Condicao { boolean testar(int i, int j); }
    interface Transformacao { int executar(int i, int j); }

    // Teste no método main
    public static void main(String[] args) {
        Matriz m1 = new Matriz(2, 2);
        m1.setElemento(0, 0, 1); m1.setElemento(0, 1, 2);
        m1.setElemento(1, 0, 3); m1.setElemento(1, 1, 4);

        Matriz m2 = new Matriz(2, 2);
        m2.setElemento(0, 0, 5); m2.setElemento(0, 1, 6);
        m2.setElemento(1, 0, 7); m2.setElemento(1, 1, 8);

        System.out.println("M1 + M2:");
        m1.adicionar(m2).imprimir();

        System.out.println("M1 - M2:");
        m1.subtrair(m2).imprimir();

        System.out.println("M1 * M2:");
        m1.multiplicar(m2).imprimir();

        System.out.println("Transposta de M1:");
        m1.transposta().imprimir();
    }
}
