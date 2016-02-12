package visao;

import javax.swing.JOptionPane;

public class Sala5_Snoopy extends Sala1_ORegresso{
    private String filme = "Snoopy & Charlie Brown-Dublado";
    
    @Override
    void info_cliente(){
        JOptionPane.showConfirmDialog(null, "Filme = "+filme+" - "+"\nSessao: "+Sessao+"\nCliente: "+super.getNomeCliente()+
            "\nTelefone Para Contato: "+getTelefoneCliente()+"\nEmail: "+getEmailCliente()+"\nDeseja Emitir Este Ingresso ? ");
            if(Verifica == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Ingresso Emitido com Sucesso.");
            }
    }
}
