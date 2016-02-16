package visao;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import controle.Cliente;
import controle.Funcionario;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author cleversonahum
 */
public class Sala_Cinema extends javax.swing.JFrame implements Cliente{
    
    //Antiga Classe Cinema
    Object Sessao ;
    int Verifica;
    private String nomeCliente,Email,telefoneCliente;
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
    public void setFilme(String filme) { //definir filme
        this.filme = filme;
    }
    
    public void setSessao(int sessao) { //definir Sessao
        this.sessao = sessao;
    }
    
    public void setNumFileiras(int num_fileiras) { //Definir numero de fileiras
        this.num_fileiras = num_fileiras;
    }
    
    public void setNumCadeirasFileira(int num_cadeiras_fileira) {
        this.num_cadeiras_fileira = num_cadeiras_fileira;
    }
    public void setNomeCliente(String NomeCliente){
        this.nomeCliente = NomeCliente;
    }
    public void setTelefone(String telefone){
        this.telefoneCliente = telefone;
    }
    public void setemailCliente(String email){
        this.Email = email;
    }
    //Fim metodos Set
    
    //Metodos Get
    public String getFilme(){ //Acessar filme
        return this.filme;
    }
    
    public int getSessao() {
        return this.sessao;
    }
    
    public int getNumFileiras() {
        return this.num_fileiras;
    }
    
    public int getNumCadeirasFileira() {
        return this.num_cadeiras_fileira;
    }
    
    public int getAssentosDisponiveis() {
        return this.assentos_disponiveis;
    }
    public String getNomeCliente(){
        return this.nomeCliente;
    }
    public String getEmailCliente(){
        return this.Email;
    }
    public String getTelefoneCliente(){
        return this.telefoneCliente;
    }
    
    //Fim métodos Get
    
    //Declarando Matrizes dos Assentos e Clientes
    int assentos[][] = new int[this.num_fileiras][this.num_cadeiras_fileira];
    String cliente_assento[][] = new String[this.num_fileiras][this.num_cadeiras_fileira];
    
    //Inicializando as cadeiras do cinema como vazias
    public void inicializar_sala() {
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
    public void mostra_cadeiras() {
        for(int i = 0; i<num_fileiras;i++) { //Laço que percorre as fileiras
            for(int j = 0; j<num_cadeiras_fileira; j++) { //Laço que percorre as cadeiras da fileira
                System.out.print(assentos[i][j]+" ");
            } //Fim for j
            System.out.println();
        } //Fim for i
    }
    //fim mostra_cadeiras()
    
    //Reservar um assento
    public void reservar_assento(int fileira, int cadeira_fileira) {
        if(this.assentos[fileira][cadeira_fileira] != 1) {
            this.assentos[fileira][cadeira_fileira] = 1;
            this.assentos_disponiveis--;
        }
        else
            System.out.println("O assento já está ocupado");
    }
    //Fim reservar_assento()
    
    //Retirar a reserva de um assento
    public void retirar_reserva(int fileira, int cadeira_fileira) {
        if(this.assentos[fileira][cadeira_fileira] != 0) {
            this.assentos[fileira][cadeira_fileira] = 0;
            this.assentos_disponiveis++;
        }
        else
            System.out.println("O assento não estava reservado");
    }
    //Fim retirar_reserva()
    
    //Total de assentos da Sala de cinema
    public int total_assentos() {
        return this.num_cadeiras_fileira*this.num_fileiras;
    }
    //Fim total_assentos()
    
    //Quantidade de acentos reservados
    public int quant_pessoas_sala() {
        return (total_assentos() - this.assentos_disponiveis);
    }
    //Fim quant_pessoas_sala
    
    //Informaçoes da Sala de Cinema
    public void info_sala() {
        System.out.println("Filme : "+this.filme+"\nSessão : "+this.sessao+"\nTotal de Assentos : "+total_assentos()+"\nAssentos Ocupados : "+ quant_pessoas_sala()+"\nAssentos Vazios : "+this.assentos_disponiveis);
    }
    
    
    public void reservar_desmarcar_assento(javax.swing.JTextField x, int num_assento, int num_fila, int num_fila_assento) {
        //Se a cadeira estiver reservada, desmarca a reserva
        
        if(this.estaReservada[num_assento]) {
            x.setBackground(Color.GREEN); //Deixa a cadeira disponivel (verde)
            this.estaReservada[num_assento] = false; //Retira a reserva da matriz
            this.retirar_reserva(num_fila,num_fila_assento); //Retira a reserva o assento escolhido
            this.mostra_cadeiras(); //Mostra a diposição das cadeiras no terminal
            System.out.println(this.assentos_disponiveis);
            System.out.println(this.total_assentos());
            //Atualizando valores das caixas de texto na Interface
            cxTxtTotalLugares.setText(Integer.toString(this.total_assentos()));
            cxTxtLugaresReservados.setText(Integer.toString(this.quant_pessoas_sala()));
            cxTxtLugaresDisponiveis.setText(Integer.toString(this.getAssentosDisponiveis()));

        }
        else {
            x.setBackground(Color.red);//Deixa a cadeira indisponivel (vermelho)
            this.estaReservada[num_assento] = true; //reserva o assento da matriz
            //Pede Informações do Cliente ao Solicitar assento.
            //Chama o método pegaDadosCliente Para Solicitar seus Dados.
            pegaDadosCliene();
            //exibe informanções
            info_cliente();
            this.reservar_assento(num_fila,num_fila_assento); //reserva o assento escolhido
            this.mostra_cadeiras(); //Mostra a diposição das cadeiras no terminal
            System.out.println(this.assentos_disponiveis);
            System.out.println(this.total_assentos());
            
            //Atualizando valores das caixas de texto na Interface
            cxTxtTotalLugares.setText(Integer.toString(this.total_assentos()));
            cxTxtLugaresReservados.setText(Integer.toString(this.quant_pessoas_sala()));
            cxTxtLugaresDisponiveis.setText(Integer.toString(this.getAssentosDisponiveis()));  
    }
    }
    // Implementando O Método pegaDadosCliente.
    @Override
    public void pegaDadosCliene() {
        do{
        nomeCliente = JOptionPane.showInputDialog("Informe o Nome do Cliente: ");
        }while((nomeCliente==null||nomeCliente.equals("")));
        Email= JOptionPane.showInputDialog("Informe o Email do Cliente: ");
        telefoneCliente = JOptionPane.showInputDialog("Informe um Telefone Para Contato: ");
        
    }
    //Fim da Implementação do Método pegaDadosCliente.
    
    //Exibe as Informações para verificar se está tudo correto
    public void info_cliente(){
        //Intancia a Classe Tela principal para pegar o que foi armazenado na variavel valor.
        TelaPrincipal novoComboBox = new TelaPrincipal();        

        Verifica = JOptionPane.showConfirmDialog(null, "Filme = "+this.filme+" - "+"\nSessao: "+novoComboBox.getSessao1_Sala1()+"\nCliente: "+nomeCliente+"\nTelefone Para Contato: "+telefoneCliente+
            "\nEmail: "+Email+"\nDeseja Emitir Este Ingresso ? ");
            if(Verifica == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Ingresso Emitido com Sucesso.");
            }else{
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                //fecha a janela de questionario de coonfirmação de emissao do ingresso.
            }
    }
    //Fim antiga classe cinema

    //Criação da Interce(JFrama)
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
        a2 = new javax.swing.JTextField();
        a3 = new javax.swing.JTextField();
        a4 = new javax.swing.JTextField();
        a5 = new javax.swing.JTextField();
        b1 = new javax.swing.JTextField();
        b2 = new javax.swing.JTextField();
        b3 = new javax.swing.JTextField();
        b4 = new javax.swing.JTextField();
        b5 = new javax.swing.JTextField();
        c1 = new javax.swing.JTextField();
        c2 = new javax.swing.JTextField();
        c3 = new javax.swing.JTextField();
        c4 = new javax.swing.JTextField();
        c5 = new javax.swing.JTextField();
        d1 = new javax.swing.JTextField();
        d2 = new javax.swing.JTextField();
        d3 = new javax.swing.JTextField();
        d4 = new javax.swing.JTextField();
        d5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        a2.setEditable(false);
        a2.setBackground(java.awt.Color.green);
        a2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        a2.setText("A2");
        a2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a2MouseClicked(evt);
            }
        });

        a3.setEditable(false);
        a3.setBackground(java.awt.Color.green);
        a3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        a3.setText("A3");
        a3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a3MouseClicked(evt);
            }
        });

        a4.setEditable(false);
        a4.setBackground(java.awt.Color.green);
        a4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        a4.setText("A4");
        a4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a4MouseClicked(evt);
            }
        });

        a5.setEditable(false);
        a5.setBackground(java.awt.Color.green);
        a5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        a5.setText("A5");
        a5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a5MouseClicked(evt);
            }
        });

        b1.setEditable(false);
        b1.setBackground(java.awt.Color.green);
        b1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        b1.setText("B1");
        b1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b1MouseClicked(evt);
            }
        });

        b2.setEditable(false);
        b2.setBackground(java.awt.Color.green);
        b2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        b2.setText("B2");
        b2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b2MouseClicked(evt);
            }
        });

        b3.setEditable(false);
        b3.setBackground(java.awt.Color.green);
        b3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        b3.setText("B3");
        b3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b3MouseClicked(evt);
            }
        });

        b4.setEditable(false);
        b4.setBackground(java.awt.Color.green);
        b4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        b4.setText("B4");
        b4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b4MouseClicked(evt);
            }
        });

        b5.setEditable(false);
        b5.setBackground(java.awt.Color.green);
        b5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        b5.setText("B5");
        b5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b5MouseClicked(evt);
            }
        });

        c1.setEditable(false);
        c1.setBackground(java.awt.Color.green);
        c1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c1.setText("C1");
        c1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c1MouseClicked(evt);
            }
        });

        c2.setEditable(false);
        c2.setBackground(java.awt.Color.green);
        c2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c2.setText("C2");
        c2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c2MouseClicked(evt);
            }
        });

        c3.setEditable(false);
        c3.setBackground(java.awt.Color.green);
        c3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c3.setText("C3");
        c3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c3MouseClicked(evt);
            }
        });

        c4.setEditable(false);
        c4.setBackground(java.awt.Color.green);
        c4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c4.setText("C4");
        c4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c4MouseClicked(evt);
            }
        });

        c5.setEditable(false);
        c5.setBackground(java.awt.Color.green);
        c5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        c5.setText("C5");
        c5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c5MouseClicked(evt);
            }
        });

        d1.setEditable(false);
        d1.setBackground(java.awt.Color.green);
        d1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        d1.setText("D1");
        d1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d1MouseClicked(evt);
            }
        });

        d2.setEditable(false);
        d2.setBackground(java.awt.Color.green);
        d2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        d2.setText("D1");
        d2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d2MouseClicked(evt);
            }
        });

        d3.setEditable(false);
        d3.setBackground(java.awt.Color.green);
        d3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        d3.setText("D1");
        d3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d3MouseClicked(evt);
            }
        });

        d4.setEditable(false);
        d4.setBackground(java.awt.Color.green);
        d4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        d4.setText("D1");
        d4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d4MouseClicked(evt);
            }
        });

        d5.setEditable(false);
        d5.setBackground(java.awt.Color.green);
        d5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        d5.setText("D1");
        d5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                d5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cxTxtTotalLugares, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                            .addComponent(cxTxtLugaresDisponiveis, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cxTxtLugaresReservados, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(d5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
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
    
    
    //Assento A1 (0)
    private void a1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a1MouseClicked
        this.reservar_desmarcar_assento(a1, 1, 0, 0);
        
    }//GEN-LAST:event_a1MouseClicked

    
    //Assento A2 (1)
    private void a2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a2MouseClicked
        this.reservar_desmarcar_assento(a2, 0, 0, 1); 
    }//GEN-LAST:event_a2MouseClicked

    
    //Assento A3 (2)
    private void a3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a3MouseClicked
        this.reservar_desmarcar_assento(a3, 2, 0, 2); 
    }//GEN-LAST:event_a3MouseClicked

    
    //Assento A4 (3)
    private void a4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a4MouseClicked
        this.reservar_desmarcar_assento(a4, 3, 0, 3); 
    }//GEN-LAST:event_a4MouseClicked

    
    //Assento A5 (4)
    private void a5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a5MouseClicked
        this.reservar_desmarcar_assento(a5, 4, 0, 4); 
    }//GEN-LAST:event_a5MouseClicked

    
    //Assento B1 (5)
    private void b1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseClicked
        this.reservar_desmarcar_assento(b1, 5, 1, 0); 
    }//GEN-LAST:event_b1MouseClicked
    
    
    //Assento B2 (6)
    private void b2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b2MouseClicked
        this.reservar_desmarcar_assento(b2, 6, 1, 1); 
    }//GEN-LAST:event_b2MouseClicked
    
    
    //Assento B3 (7)
    private void b3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b3MouseClicked
        this.reservar_desmarcar_assento(b3, 7, 1, 2); 
    }//GEN-LAST:event_b3MouseClicked
    
    
    //Assento B4 (8)
    private void b4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b4MouseClicked
        this.reservar_desmarcar_assento(b4, 8, 1, 3); 
    }//GEN-LAST:event_b4MouseClicked
    
    
    //Assento B5 (9)
    private void b5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b5MouseClicked
        this.reservar_desmarcar_assento(b5, 9, 1, 4); 
    }//GEN-LAST:event_b5MouseClicked
    
    
    //Assento C1 (10)
    private void c1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c1MouseClicked
        this.reservar_desmarcar_assento(c1, 10, 2, 0); 
    }//GEN-LAST:event_c1MouseClicked
    
    
    //Assento C2 (11)
    private void c2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c2MouseClicked
        this.reservar_desmarcar_assento(c2, 11, 2, 1); 
    }//GEN-LAST:event_c2MouseClicked
    
    
    //Assento C3 (12)
    private void c3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c3MouseClicked
        this.reservar_desmarcar_assento(c3, 12, 2, 2); 
    }//GEN-LAST:event_c3MouseClicked
    
    
    //Assento C4 (13)
    private void c4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c4MouseClicked
        this.reservar_desmarcar_assento(c4, 13, 2, 3); 
    }//GEN-LAST:event_c4MouseClicked
    
    
    //Assento C5 (14)
    private void c5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c5MouseClicked
        this.reservar_desmarcar_assento(c5, 14, 2, 4); 
    }//GEN-LAST:event_c5MouseClicked

    
    //Assento D1
    private void d1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d1MouseClicked
        this.reservar_desmarcar_assento(d1, 15, 3, 0); 
    }//GEN-LAST:event_d1MouseClicked

    
    //Assento D2
    private void d2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d2MouseClicked
        this.reservar_desmarcar_assento(d2, 16, 3, 1); 
    }//GEN-LAST:event_d2MouseClicked

    
    //Assento D3
    private void d3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d3MouseClicked
        this.reservar_desmarcar_assento(d3, 17, 3, 2); 
    }//GEN-LAST:event_d3MouseClicked

    
    //Assento D4
    private void d4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d4MouseClicked
        this.reservar_desmarcar_assento(d4, 18, 3, 3); 
    }//GEN-LAST:event_d4MouseClicked

    
    //Assento D5
    private void d5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_d5MouseClicked
        this.reservar_desmarcar_assento(d5, 19, 3, 4); 
    }//GEN-LAST:event_d5MouseClicked

    
   //Método Main da Classe Sala1_Oregresso
    public static void main(String args[]) {

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
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JTextField a2;
    private javax.swing.JTextField a3;
    private javax.swing.JTextField a4;
    private javax.swing.JTextField a5;
    private javax.swing.JTextField b1;
    private javax.swing.JTextField b2;
    private javax.swing.JTextField b3;
    private javax.swing.JTextField b4;
    private javax.swing.JTextField b5;
    private javax.swing.JTextField c1;
    private javax.swing.JTextField c2;
    private javax.swing.JTextField c3;
    private javax.swing.JTextField c4;
    private javax.swing.JTextField c5;
    public static javax.swing.JTextField cxTxtLugaresDisponiveis;
    javax.swing.JTextField cxTxtLugaresReservados;
    javax.swing.JTextField cxTxtTotalLugares;
    private javax.swing.JTextField d1;
    private javax.swing.JTextField d2;
    private javax.swing.JTextField d3;
    private javax.swing.JTextField d4;
    private javax.swing.JTextField d5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    
}