package visao;

import javax.swing.JOptionPane;

public class Sala4_DeadPoolLeg extends Sala1_ORegresso{
    private String filme ="DeadPool - Legendado";
    @Override
    void info_cliente(){
        JOptionPane.showConfirmDialog(null, "Filme = "+filme+" - "+"\nSessao: "+Sessao+"\nCliente: "+super.getNomeCliente()+
            "\nTelefone Para Contato: "+getTelefoneCliente()+"\nEmail: "+getEmailCliente()+"\nDeseja Emitir Este Ingresso ? ");
            if(Verifica == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Ingresso Emitido com Sucesso.");
            }
    }
}
