import javax.swing.JOptionPane;

public class Caderno extends Produto implements Manipulacao {
    private int qtdefolhas;
    private String tamanho;
    private String tipo;
    private boolean capadura;

    public Caderno() {
    }
    public Caderno(int qtdefolhas, String tamanho, String tipo, boolean capadura, String marca, float valor) {
        super(marca, valor);
        this.qtdefolhas = qtdefolhas;
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.capadura = capadura;
    }

    public int getQtdefolhas() {
        return qtdefolhas;
    }
    public void setQtdefolhas(int qtdefolhas) {
        this.qtdefolhas = qtdefolhas;
    }
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public boolean getCapadura() {
        return capadura;
    }
    public void setCapadura(boolean capadura) {
        this.capadura = capadura;
    }
    
    @Override
    public boolean cadastro() {
        setMarca(JOptionPane.showInputDialog("Marca: "));
        setValor(Float.parseFloat(JOptionPane.showInputDialog("Valor: ")));
        setQtdefolhas(Integer.parseInt(JOptionPane.showInputDialog("Quantidade de folhas: ")));
        setTamanho(JOptionPane.showInputDialog("Tamanho: "));
        setTipo(JOptionPane.showInputDialog("Tipo: "));
        String res = JOptionPane.showInputDialog("Capadura? [S]/[N]").toUpperCase();
        if("S".equals(res)){
            setCapadura(true);
        }
        return true;
    }

    @Override
    public String consulta() {
        String txt;
        txt = "\n Marca: " + super.getMarca() + 
                "\n Valor: " + super.getValor() +
                "\n Quantidade de folhas: " + this.getQtdefolhas() +
                "\n Tamanho: " + this.getTamanho() +
                "\n Tipo: " + this.getTipo() + 
                "\n Capadura: " + this.getCapadura();
        return txt;
    }
    
}
