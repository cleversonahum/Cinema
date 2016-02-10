/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.awt.Color;

/**
 *
 * @author cleversonahum
 */
public class Sala_Cinema extends javax.swing.JFrame {
    
    //Antiga Classe Cinema
    
    private String filme;
    private int sessao, num_fileiras=4, num_cadeiras_fileira=5, assentos_disponiveis = 20, total_assentos;
    private boolean estaReservada[] = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
    
    
    
    //Construtor da classe Sala_Cinema
    Sala_Cinema(String filme, int sessao) {
        this.filme = filme;
        this.sessao = sessao;
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
    
    int getAssentosDisponiveis() {
        return this.assentos_disponiveis;
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
    
    //Fim antiga classe cinema

    /**
     * Creates new form Sala_Cinema
     */
    public Sala_Cinema() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        a1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cxTxtTotalLugares = new javax.swing.JTextField();
        cxTxtLugaresDisponiveis = new javax.swing.JTextField();
        cxTxtLugaresReservados = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.gray);

        a1.setEditable(false);
        a1.setBackground(java.awt.Color.green);
        a1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        a1.setText("A1");
        a1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a1MouseClicked(evt);
            }
        });

        jLabel1.setText("Total de Lugares : ");

        jLabel2.setText("Lugares Disponíveis : ");

        jLabel3.setText("Lugares Reservados : ");

        cxTxtTotalLugares.setEditable(false);
        cxTxtTotalLugares.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cxTxtTotalLugares.setText("20");

        cxTxtLugaresDisponiveis.setEditable(false);
        cxTxtLugaresDisponiveis.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cxTxtLugaresDisponiveis.setText("20");

        cxTxtLugaresReservados.setEditable(false);
        cxTxtLugaresReservados.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cxTxtLugaresReservados.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cxTxtTotalLugares, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cxTxtLugaresDisponiveis, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                .addComponent(cxTxtLugaresReservados)))))
                .addContainerGap(448, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cxTxtTotalLugares, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cxTxtLugaresDisponiveis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cxTxtLugaresReservados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void a1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a1MouseClicked
        
        //Se a cadeira estiver reservada, desmarca a reserva
        if(this.estaReservada[0]) {
            a1.setBackground(Color.GREEN); //Deixa a cadeira disponivel (verde)
            this.estaReservada[0] = false; //Retira a reserva da matriz
            this.retirar_reserva(0,0); //Retira a reserva o assento escolhido
            this.mostra_cadeiras(); //Mostra a diposição das cadeiras no terminal
            System.out.println(this.assentos_disponiveis);
            System.out.println(this.total_assentos());
            
            //Atualizando valores das caixas de texto na Interface
            cxTxtTotalLugares.setText(Integer.toString(this.total_assentos()));
            cxTxtLugaresReservados.setText(Integer.toString(this.quant_pessoas_sala()));
            cxTxtLugaresDisponiveis.setText(Integer.toString(this.getAssentosDisponiveis()));
            
            
        }
        else {
            a1.setBackground(Color.red);//Deixa a cadeira indisponivel (vermelho)
            this.estaReservada[0] = true; //reserva o assento da matriz
            this.reservar_assento(0,0); //reserva o assento escolhido
            this.mostra_cadeiras(); //Mostra a diposição das cadeiras no terminal
            System.out.println(this.assentos_disponiveis);
            System.out.println(this.total_assentos());
            
            //Atualizando valores das caixas de texto na Interface
            cxTxtTotalLugares.setText(Integer.toString(this.total_assentos()));
            cxTxtLugaresReservados.setText(Integer.toString(this.quant_pessoas_sala()));
            cxTxtLugaresDisponiveis.setText(Integer.toString(this.getAssentosDisponiveis()));
        }
    }//GEN-LAST:event_a1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Sala_Cinema sala1 = new Sala_Cinema("Star Wars Episode VII",20);
        sala1.inicializar_sala();
        
        sala1.reservar_assento(0, 1);
        sala1.retirar_reserva(0, 1);
        System.out.println(sala1.assentos_disponiveis);
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sala_Cinema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sala_Cinema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sala_Cinema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sala_Cinema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sala_Cinema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a1;
    public static javax.swing.JTextField cxTxtLugaresDisponiveis;
    javax.swing.JTextField cxTxtLugaresReservados;
    javax.swing.JTextField cxTxtTotalLugares;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
