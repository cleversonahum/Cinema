package controle;

import javax.swing.JOptionPane;

public class Funcionario {
    private String nome;
    
    //Método para pedir dados do vendedor devido sistema nao possuir cadastro de funcionario.
    public void pedeDados(){
        
        //Tratamento de Excessao para este Método.
        boolean sentinela = false;
        while(sentinela == false){
            this.nome = JOptionPane.showInputDialog("Entre com seu nome");
            if("".equals(this.nome)){
                sentinela =false;
            }
            else{
                char[] array = this.nome.toCharArray();
                for(int i=0;i<array.length;i++){
                    sentinela = !Character.isDigit(array[i]);
                }
           
            }
        }
        
//        do{
//        this.nome = JOptionPane.showInputDialog("Vendedor, Informe seu nome: ");
//        }while(this.nome.equals("")||this.nome==null);
//       
    }
    //Métodos Get dessa classe.
    
    public String getNome(){
        return this.nome;
    }
    
    //metodos set
    
    public void setNome(String Nome){
        this.nome = Nome;
    }
}
