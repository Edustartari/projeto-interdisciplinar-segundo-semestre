import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Menu {
    public static void main(String[] args) {
        int op;
        ArrayList <Pedido> totalPedidos = new ArrayList();
        
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção do MENU"
                    + "\n(1) Cadastrar"
                    + "\n(2) Consultar"
                    + "\n(3) Listar todos"
                    + "\n(4) Sair"));
            switch(op){
                    case 1:
                        Pedido ped = new Pedido();
                        ped.cadastro();
                        totalPedidos.add(ped);
                        break;
                    case 2:
                        int indice = Integer.parseInt(JOptionPane.showInputDialog("Informe o número do pedido: "));
                        indice -= 1;
                        if (indice >= totalPedidos.size() || indice < 0){
                            JOptionPane.showMessageDialog(null,"Pedido não existe!");
                        } else {
                            System.out.println("--> PEDIDO nº" + (indice+1));
                            System.out.println((totalPedidos.get(indice)).consulta());
                        }
                        break;
                    case 3:
                        if(totalPedidos.size() <= 0){
                            JOptionPane.showMessageDialog(null,"Não há nenhum pedido cadastrado!");
                        } else{
                            for(int cont = 0; cont < totalPedidos.size(); cont++){
                                System.out.println("--> PEDIDO nº" + (cont+1));
                                System.out.println((totalPedidos.get(cont)).consulta());
                            }
                        }
                        break;
            }
        } while(op!=4); 
        JOptionPane.showMessageDialog(null, "Obrigado por usar nosso programa."
                + "\nVOLTE SEMPRE!");
    }
}
