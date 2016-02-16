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
public class Cinema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sala_Cinema sala1 = new Sala_Cinema("Star Wars Episode VII",20,4,4);
        sala1.inicializar_sala();
        //System.out.println(sala1.num_fileiras+" "+sala1.num_cadeiras_fileira);
        sala1.reservar_assento(2, 3);
        sala1.mostra_cadeiras();
        sala1.reservar_assento(2, 3);
        //sala1.retirar_reserva(2,3);
        sala1.mostra_cadeiras();
        sala1.info_sala();
    }
    
}
