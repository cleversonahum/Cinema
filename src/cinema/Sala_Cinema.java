/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

/**
 *
 * @author cleversonahum
 */
public class Sala_Cinema {
    private String filme;
    private int sessao, num_fileiras=5, num_cadeiras_fileira=5, assentos_disponiveis, total_assentos;
    
    //Construtor da classe Sala_Cinema
    Sala_Cinema(String filme, int sessao, int num_fileiras, int num_cadeiras_fileira) {
        this.filme = filme;
        this.sessao = sessao;
        this.num_fileiras = num_fileiras;
        this.num_cadeiras_fileira = num_cadeiras_fileira;
    }
    //Fim Construtor
    
    //Métodos Set
    void setFilme(String filme) { //definir filme
        this.filme = filme;
    }
    
    void setSessao(int sessao) { //definir Sessao
        this.sessao = sessao;
    }
    
    void setNumFileiras(int num_fileiras) { //Definir numero de fileiras
        this.num_fileiras = num_fileiras;
    }
    
    void setNumCadeirasFileira(int num_cadeiras_fileira) {
        this.num_cadeiras_fileira = num_cadeiras_fileira;
    }
    //Fim metodos Set
    
    //Metodos Get
    String getFilme(){ //Acessar filme
        return this.filme;
    }
    
    int getSessao() {
        return this.sessao;
    }
    
    int getNumFileiras() {
        return this.num_fileiras;
    }
    
    int getNumCadeirasFileira() {
        return this.num_cadeiras_fileira;
    }
    //Fim métodos Get
    
    //Declarando Matrizes dos Assentos e Clientes
    int assentos[][] = new int[this.num_fileiras][this.num_cadeiras_fileira];
    String cliente_assento[][] = new String[this.num_fileiras][this.num_cadeiras_fileira];
    
    //Inicializando as cadeiras do cinema como vazias
    void inicializar_sala() {
        if(this.num_fileiras>0 && this.num_cadeiras_fileira>0) { //Verifica se a quantidade de fileiras e cadeiras são coerentes
            for(int i = 0; i<this.num_fileiras;i++) { //Laço que percorre as fileiras
                for(int j = 0; j<this.num_cadeiras_fileira; j++) { //Laço que percorre as cadeiras da fileira
                    this.assentos[i][j] = 0;
                } //Fim for j
            } //Fim for i
            this.assentos_disponiveis = this.num_fileiras*this.num_cadeiras_fileira; //Quantidade de cadeiras disponiveis
        } //Fim If
       else
            System.out.println("A quantidade de fileiras e cadeiras estão erradas");
    } 
    //fim inicializar sala()
    
    //Mostrar a matriz de cadeiras (assento reservado = 1 e assento vazio = 0)
    void mostra_cadeiras() {
        for(int i = 0; i<num_fileiras;i++) { //Laço que percorre as fileiras
            for(int j = 0; j<num_cadeiras_fileira; j++) { //Laço que percorre as cadeiras da fileira
                System.out.print(assentos[i][j]+" ");
            } //Fim for j
            System.out.println();
        } //Fim for i
    }
    //fim mostra_cadeiras()
    
    //Reservar um assento
    void reservar_assento(int fileira, int cadeira_fileira) {
        if(this.assentos[fileira][cadeira_fileira] != 1) {
            this.assentos[fileira][cadeira_fileira] = 1;
            this.assentos_disponiveis--;
        }
        else
            System.out.println("O assento já está ocupado");
    }
    //Fim reservar_assento()
    
    //Retirar a reserva de um assento
    void retirar_reserva(int fileira, int cadeira_fileira) {
        if(this.assentos[fileira][cadeira_fileira] != 0) {
            this.assentos[fileira][cadeira_fileira] = 0;
            this.assentos_disponiveis++;
        }
        else
            System.out.println("O assento não estava reservado");
    }
    //Fim retirar_reserva()
    
    //Total de assentos da Sala de cinema
    int total_assentos() {
        return this.num_cadeiras_fileira*this.num_fileiras;
    }
    //Fim total_assentos()
    
    //Quantidade de acentos reservados
    int quant_pessoas_sala() {
        return (total_assentos() - this.assentos_disponiveis);
    }
    //Fim quant_pessoas_sala
    
    //Informaçoes da Sala de Cinema
    void info_sala() {
        System.out.println("Filme : "+this.filme+"\nSessão : "+this.sessao+"\nTotal de Assentos : "+total_assentos()+"\nAssentos Ocupados : "+ quant_pessoas_sala()+"\nAssentos Vazios : "+this.assentos_disponiveis);
    }
}
