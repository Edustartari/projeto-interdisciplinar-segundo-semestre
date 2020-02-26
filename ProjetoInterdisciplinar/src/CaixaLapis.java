import javax.swing.JOptionPane;

public class CaixaLapis extends Produto implements Manipulacao {
    private int quantidade;
    private boolean colorido;

    public CaixaLapis() {
    }
    public CaixaLapis(int quantidade, boolean colorido, String marca, float valor) {
        super(marca, valor);
        this.quantidade = quantidade;
        this.colorido = colorido;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public boolean getColorido() {
        return colorido;
    }
    public void setColorido(boolean colorido) {
        this.colorido = colorido;
    }
        
    @Override
    public boolean cadastro() {
        setMarca(JOptionPane.showInputDialog("Marca: "));
        setValor(Float.parseFloat(JOptionPane.showInputDialog("Valor: ")));
        setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Quantidade: ")));
        String resp = JOptionPane.showInputDialog("Colorido? Escolha [S] ou [N]").toUpperCase();
        if("S".equals(resp)){
            setColorido(true);
        }
        return true;
    }

    @Override
    public String consulta() {
        String txt;
        txt = "\n Marca: " + super.getMarca() +
                "\n Valor: " + super.getValor() + 
                "\n Quantidade: " + this.getQuantidade() + 
                "\n Colorido: " + this.getColorido();
        return txt;
    }
    
}
