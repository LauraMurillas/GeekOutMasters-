package geekOutMasters;

//Esta clase pone todas las reglas del juego

import javax.swing.*;
import java.awt.*;
/**
 * ModelCraps apply craps rules
 * estado 1= natural winner
 * estado 2= craps looser
 * estado 3= Establish Punto
 * estado 4= Punto winner
 * estado 5= punto looser
 * Autor: Laura Murillas
 * Version: v.1.0.0 Date: 30/11/2021
 */
public class ModelGOM {

    private Dado dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;

    private int caraDado1, caraDado2, caraDado3, caraDado4, caraDado5, caraDado6,caraDado7;
    private int tiro;
    private int punto;
    private int estado;
    private int flag;
    private int dadosActivos;

    //flag es como un contador para saber donde estoy en el codigo

    //Esta variable retorna el mensaje en pantalla
    private String[] estadoToString;

    //Esta es la sintaxis para decir que ese objeto es de tipo arreglo o vector
    private int[] caras;


    /**
     * Class Constructor
     */
    //Este es el contructor. Establece los valores por defectos que quiero que tengan los atributos.
    //Crea las instancias y los datos de los atributos
    public ModelGOM(){
        dado1 = new Dado();
        dado2 = new Dado();
        dado3 = new Dado();
        dado4 = new Dado();
        dado5 = new Dado();
        dado6 = new Dado();
        dado7 = new Dado();
        dado8 = new Dado();
        dado9 = new Dado();
        dado10 = new Dado();
        flag=0;
        estadoToString = new String [9];



        //Esto dice "El objeto caras es un arreglo de tipo entero de 10 elementos
        caras = new int[9];
    }

    /**
     * Establish the tiro value according to each dado
     */
    //Esta clase calcula y almacena el valor de los dados

    public void calcularLanzamiento(){
        caras[0]=dado1.getCara();
        caraDado1 = dado1.getCara();
        //dados = new ImageIcon(getClass().getResource("/recursos/"+ caras[0]+".png"));

        caras[1]=dado2.getCara();
        caraDado2 = dado2.getCara();

        caras[2]=dado3.getCara();
        caraDado3 = dado3.getCara();

        caras[3]=dado4.getCara();
        caraDado4 = dado4.getCara();

        caras[4]=dado5.getCara();
        caraDado5 = dado5.getCara();

        caras[5]=dado6.getCara();
        caraDado6 = dado6.getCara();

        caras[6]=dado7.getCara();
        caraDado7 = dado7.getCara();


       //  new dadosActivos=(caras[0], caras[1], caras[2], caras[3], caras[4], caras[5], caras[6]);
    }


    /**
     * Establish game state according to Estado atribute value. If is 1,2,3.
     */
    public void determinarJuego() {
        //el flag nos ayuda a saber si es el tiro de salida o si esta en ronda de puntos
        if (flag==0) {

            if (tiro == 7 || tiro == 11) {
                estado = 1;
                //Gano con natural
            } else {
                if (tiro == 2 || tiro == 3 || tiro == 12) {
                    estado = 2;
                    //Perdio con craps
                } else {
                    estado = 3;
                    punto = tiro;
                    //Se le asigna el puntaje de su tiro
                    flag=1;
                }
            }
        }else{
            //Esta es la ronda de puntos
            rondaPunto();
        }
    }

    /**
     * Establish game state according to state  atribute value (If is 4 or 5)
     */
    //Es  un metodo
    private void rondaPunto() {
        //estas son las reglas del juego para la ronda punto
        if(tiro==punto){
            estado=4;
            flag=0;

        }else {
            if (tiro == 7) {
                estado = 5;
                flag = 0;
            } else {
                estado=6;

            }
        }
    }



    //Generamos estos metodos por el TIP anterior (Getter)

   // public getMeeple() {
     //   if
      //  return tiro;
    //}

    public int getPunto() {

        return punto;
    }

    /**
     * Establish message gome state according to estado atribute value
     * @return message for the view class
     */
    public String[] getEstadoToString() {
        //El switch es un condicional, es una estructura que funciona con enteros y que verifica varios if
        // Case 1 significa que "en caso de que el entero que se introduce es 1"
        //El break siempre debe ir porque sino ejecuta todo de corrido

        switch (estado){
            case 1: estadoToString[0]= "Tiro de Salida= "+tiro;
                    estadoToString[1]="Sacaste Natural ??GANASTE!";
                    break;

            case 2: estadoToString[0]= "Tiro de Salida= "+tiro;
                    estadoToString[1]="Sacaste CRAPS, ??PERDISTE!";
                    break;

            case 3: estadoToString[0]= "Tiro de Salida= "+tiro+
                                        "\nTus puntos="+punto;
                    estadoToString[1]="Estableciste "+punto+
                                    "??Debes seguir lanzando!"+
                                    "\n pero si sacas 7 antes que"+punto+" vas a perder :(";
                    break;

            case 4: estadoToString[0]= "Tiro de Salida= "+punto+
                                        "\nTus Puntos="+punto
                                        +"\nValor del nuevo tiro="+tiro;
                    estadoToString[1]="volviste a sacar" +punto+", ??GANASTE!";
                    break;

            case 5: estadoToString[0]= "Tiro de Salida= "+punto+
                                        "\nTus Puntos="+punto
                                        +"\nValor del nuevo tiro="+tiro;
                    estadoToString[1]="Sacaste 7 antes que "+punto+", ??PERDISTE!";
                    break;

            case 6: estadoToString[0]= "Tiro de Salida= "+punto+
                                        "\nTus Puntos="+punto
                                        +"\nValor del nuevo tiro="+tiro;
                    estadoToString[1]="??Estas en Punto, sigue lanzando!"+
                                        "\n pero si sacas 7 antes que"+punto+" vas a perder :(";
                    break;


        }
        return estadoToString;
    }

    public int[] getCaras() {

      return caras;
    }
}
