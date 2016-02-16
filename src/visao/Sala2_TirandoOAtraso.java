package visao;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Sala2_TirandoOAtraso extends Sala_Cinema{
    private String filme = "Tirando o Atraso";
    
    //Metedos Get e Set
    public String getFilme(){
        return this.filme;
    }
    
    public void setFilme(String Filme){
        this.filme = filme;
    }
    
    @Override
    public void info_cliente(){
        TelaPrincipal novoComboBox = new TelaPrincipal();
        Verifica = JOptionPane.showConfirmDialog(null, "Filme = "+getFilme()+" - "+"\nSessao: "+novoComboBox.getSessao1_Sala2()+"\nCliente: "+super.getNomeCliente()+
            "\nTelefone Para Contato: "+getTelefoneCliente()+"\nEmail: "+getEmailCliente()+"\nDeseja Emitir Este Ingresso ? ");
            if(Verifica == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Ingresso Emitido com Sucesso.");
            }else{
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //fecha a janela de questionario de coonfirmação de emissao do ingresso.
            }
    }
}
