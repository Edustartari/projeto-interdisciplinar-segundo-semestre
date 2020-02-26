import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Pedido implements Manipulacao {
    private Data data;
    private Cliente cliente;
    private float totalpedido;
    private ArrayList <CaixaLapis> cxlapis = new ArrayList();
    private ArrayList <Papel> papel = new ArrayList();
    private ArrayList <Caderno> caderno = new ArrayList();

    public Pedido() {
    }

    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public float getTotalpedido() {
        return totalpedido;
    }
    public void setTotalpedido(float totalpedido) {
        this.totalpedido = totalpedido;
    }
    public ArrayList<CaixaLapis> getCxlapis() {
        return cxlapis;
    }
    public void setCxlapis(ArrayList<CaixaLapis> cxlapis) {
        this.cxlapis = cxlapis;
    }
    public ArrayList<Papel> getPapel() {
        return papel;
    }
    public void setPapel(ArrayList<Papel> papel) {
        this.papel = papel;
    }
    public ArrayList<Caderno> getCaderno() {
        return caderno;
    }
    public void setCaderno(ArrayList<Caderno> caderno) {
        this.caderno = caderno;
    }
    
    public void calculaTotalPedido(){
        float imposto = 18/100f;
        float result = 0;    
        for(int cont = 0 ; cont < this.getCxlapis().size(); cont++){
            result += (this.getCxlapis()).get(cont).getValor();
        }
        for(int cont = 0 ; cont < this.getPapel().size(); cont++){
            result += (this.getPapel()).get(cont).getValor();
        }
        for(int cont = 0 ; cont < this.getCaderno().size(); cont++){
            result += (this.getCaderno()).get(cont).getValor();
        }
        setTotalpedido(result + (result*imposto));
    }

    @Override
    public boolean cadastro() {
        int dia, mes, ano;
        dia = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia: "));
        mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês: "));
        ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano: "));
        Data d = new Data(dia, mes, ano);
        setData(d);
        
        String nome, cpf, tel;
        nome = JOptionPane.showInputDialog("Informe o nome: ");
        cpf = JOptionPane.showInputDialog("Informe o CPF: ");
        tel = JOptionPane.showInputDialog("Informe o telefone: ");
        Cliente cli = new Cliente(nome,cpf,tel);
        setCliente(cli);
        
        while(true){
            String rescaixa = JOptionPane.showInputDialog("Deseja adicionar Caixa de lápis? [S]/[N]").toUpperCase();
            if("S".equals(rescaixa)){
                CaixaLapis caixa = new CaixaLapis();
                caixa.cadastro();
                this.cxlapis.add(caixa);
            }
            String respapel = JOptionPane.showInputDialog("Deseja adicionar Papel? [S]/[N]").toUpperCase();
            if("S".equals(respapel)){
                Papel pap = new Papel();
                pap.cadastro();
                this.papel.add(pap);
            }
            String rescaderno = JOptionPane.showInputDialog("Deseja adicionar Caderno? [S]/[N]").toUpperCase();
            if("S".equals(rescaderno)){
                Caderno cad = new Caderno();
                cad.cadastro();
                this.caderno.add(cad);
            }
            String resposta = JOptionPane.showInputDialog("Deseja adicionar mais itens? [S]/[N]").toUpperCase();
            if ("N".equals(resposta)){
                break;
            }
        } 
        this.calculaTotalPedido();
        return true;
    }

    @Override
    public String consulta() {
        String txt;
        String totcxlapis = "";
        String totpapel = "";
        String totcaderno = "";
        float valortotal;
        
        for(int cont = 0; cont < (this.getCxlapis()).size(); cont++){
            totcxlapis += (this.getCxlapis().get(cont)).consulta(); 
        }
        
        for(int cont = 0; cont < (this.getPapel()).size(); cont++){
            totpapel += (this.getPapel().get(cont)).consulta();
        }
        
        for(int cont = 0; cont < (this.getCaderno()).size(); cont++){
            totcaderno += (this.getCaderno().get(cont)).consulta();
        }

        txt = "***INFORMAÇÕES DO PEDIDO***" + 
                "\nDATA: " + this.getData().getDia() + "/" + this.getData().getMes() + "/" + this.getData().getAno() +
                "\nCLIENTE: " +
                "\n Nome: " + this.getCliente().getNome() +
                "\n CPF: " + this.getCliente().getCpf()+
                "\n Telefone: " + this.getCliente().getTelefone() +
                "\nCAIXA LÁPIS: " + totcxlapis +
                "\nPAPEL: " + totpapel + 
                "\nCADERNO: " + totcaderno + 
                "\nTOTAL PEDIDO: " + this.totalpedido +
                "\n***************************";  
        return txt;
    }
}
