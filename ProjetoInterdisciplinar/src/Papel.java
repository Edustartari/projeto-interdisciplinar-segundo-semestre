import javax.swing.JOptionPane;

public class Papel extends Produto implements Manipulacao{
    private String cor;
    private String tipo;
    private float largura;
    private float altura;
    private int gramatura;
    private boolean paltado;
    
    public Papel(){}
    public Papel(String cor, String tipo, float largura, float altura, int gramatura, boolean paltado, String marca, float valor) {
        super(marca, valor);
        this.cor = cor;
        this.tipo = tipo;
        this.largura = largura;
        this.altura = altura;
        this.gramatura = gramatura;
        this.paltado = paltado;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public float getLargura() {
        return largura;
    }
    public void setLargura(float largura) {
        this.largura = largura;
    }
    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
    public int getGramatura() {
        return gramatura;
    }
    public void setGramatura(int gramatura) {
        this.gramatura = gramatura;
    }
    public boolean getPaltado() {
        return paltado;
    }
    public void setPaltado(boolean paltado) {
        this.paltado = paltado;
    }

    @Override
    public boolean cadastro() {
        setMarca(JOptionPane.showInputDialog("Marca: "));
        setValor(Float.parseFloat(JOptionPane.showInputDialog("Valor: ")));
        setCor(JOptionPane.showInputDialog("Cor: "));
        setTipo(JOptionPane.showInputDialog("Tipo: "));
        setLargura(Float.parseFloat(JOptionPane.showInputDialog("Largura: ")));
        setAltura(Float.parseFloat(JOptionPane.showInputDialog("Altura: ")));
        setGramatura(Integer.parseInt(JOptionPane.showInputDialog("Gramatura: ")));
        String resp = JOptionPane.showInputDialog("Paltado? [S]/[N]").toUpperCase();
        if ("S".equals(resp)){
            setPaltado(true);
        }
        return true;
    }

    @Override
    public String consulta() {
        String txt;
        txt = "\n Marca: " + super.getMarca() +
                "\n Valor: " + super.getValor() +
                "\n Cor: " + this.getCor() +
                "\n Tipo: " + this.getTipo() +
                "\n Largura: " + this.getLargura() +
                "\n Altura: " + this.getAltura() + 
                "\n Gramatura: " + this.getGramatura() +
                "\n Paltado: " + this.getPaltado();
        return txt;
    }
    
}
