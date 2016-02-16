
package visao;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Sala1_ORegresso extends Sala_Cinema{
    private String filme = "O Regresso - Dublado";
    
    //Metedos Get e Set
    public String getFilme(){
        return this.filme;
    }
    
    public void setFilme(String Filme){
        this.filme = filme;
    }
    
    @Override
    public boolean info_cliente(){
        //Intancia a Classe Tela principal para pegar o que foi armazenado na variavel valor.
        TelaPrincipal novoComboBox = new TelaPrincipal();
        int Verifica = JOptionPane.showConfirmDialog(null, "Filme = "+getFilme()+" - "+"\nCliente: "+super.getNomeCliente()+
            "\nTelefone Para Contato: "+getTelefoneCliente()+"\nEmail: "+getEmailCliente()+"\nDeseja Emitir Este Ingresso ? ");
            if(Verifica == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Ingresso Emitido com Sucesso.");
                return true;
            }
            else{
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //fecha a janela de questionario de coonfirmação de emissao do ingresso.
                return false;
            }
    }
}
