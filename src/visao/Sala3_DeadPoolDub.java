package visao;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Sala3_DeadPoolDub extends Sala_Cinema{
    private String filme = "DeadPool - Dublado";
    
    //Metedos Get e Set
    public String getFilme(){
        return this.filme;
    }
    
    public void setFilme(String Filme){
        this.filme = filme;
    }

    public boolean info_cliente(){
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
