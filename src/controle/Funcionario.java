package controle;

import javax.swing.JOptionPane;

public class Funcionario {
    private String nome, CPF;
    int Qt_ingressos_Vendidos;
    
    //Método para pedir dados do vendedor devido sistema nao possuir cadastro de funcionario.
    public void pedeDados(){
        do{
        this.nome = JOptionPane.showInputDialog("Vendedor, Informe seu nome: ");
        this.CPF = JOptionPane.showInputDialog("Informe seu CPF: ");
        }while(this.nome.equals("")||this.nome==null);
        
    }
    
    //Métodos Get dessa classe.
    public String getCPF(){
        return this.CPF;
    }
    public String getNome(){
        return this.nome;
    }
    
    //metodos set
    public void setCPF(String cpf){
        this.CPF = cpf;
    }
    public void setNome(String Nome){
        this.nome = Nome;
    }
}
