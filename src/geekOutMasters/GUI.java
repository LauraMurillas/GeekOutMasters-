package geekOutMasters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.io.StringWriter;

/**
 * This class is used as a view craps class.
 * @autor Laura Murillas, laura.murillas@correounivalle.edu.co
 * @version v.1.0.0 date:06/12/2021
 */
public class GUI extends JFrame {

    //Esta es la sintaxis de una constante, se usa el 'final'
    private static final String MENSAJE_INICIO= "Bienvenido a Geek Out Masters \n"
                + "Oprime el botón lanzar para iniciar el juego y lanzar 7 de los 10 dados"
                + "\nTu objetivo es hacer una estrategia que te permita ganar puntos con las acciones de tus dados"
                + "\nLos Dados tienen las siguientes caras con sus respectivas acciones:"
                + "\nMeeples: Puedes volver a lanzar un dado de la zona de dados activos"
                + "\nCohetes: Elimina uno de tus dados activos"
                + "\nSuperheroe: voltea un dado activo a su cara contraria"
                + "\nCorazon: Puedes lanzar un dado de la zona de dados inactivos y volverlo uno activo"
                + "\nDragones: Elimina TODOS tus puntos, incluso los acumulados </3"
                + "\nCara 42: Suma 1 punto! trata de que estos sean tus últimos dados ;)";


    private Header headerProject;
    private JLabel dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
    private JButton lanzar, botonDado1, botonDado2, botonDado3, botonDado4, botonDado5,botonDado6, botonDado7;
    private JPanel panelDados, panelResultados, panelDadosUtilizados, panelDadosInactivos;
    private ImageIcon imageInicio;
    private JTextArea mensajesSalida, resultadosDados;
    private JSeparator separador; //Este es el separador entre los dos paneles de texto


    private javax.swing.JPanel JPanel;
    private javax.swing.JPanel panelMouse;

    private Escucha escucha;
    private ModelGOM modelGOM; //La vista (el GUI) utiliza un objeto de tipo modelGOM



    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();


        //Default JFrame configuration
        this.setTitle("Geek Out Masters by Laura");
        this.setSize(1200,690);
        //this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object or Control Object

        escucha = new Escucha();
        modelGOM = new ModelGOM();

        //Set up JComponents
        headerProject = new Header("Mesa del juego Craps Por Laura :D", Color.BLACK);

        this.add(headerProject,BorderLayout.NORTH); //Este es el titulo de la ventana

        imageInicio =  new ImageIcon(getClass().getResource("/recursos/fondoGOM.png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
        dado1 =  new JLabel(imageInicio);
        dado2 = new JLabel(imageInicio);
        dado3 = new JLabel(imageInicio);
        dado4 = new JLabel(imageInicio);
        dado5 = new JLabel(imageInicio);
        dado6 = new JLabel(imageInicio);
        dado7 = new JLabel(imageInicio);
        dado8 = new JLabel(imageInicio);
        dado9 = new JLabel(imageInicio);
        dado10 = new JLabel(imageInicio);

        lanzar = new JButton("Lanzar Dados");
        lanzar.addActionListener(escucha);

        botonDado1 = new JButton("Dado 1");
        botonDado1.addActionListener(escucha);

        botonDado2 = new JButton("Dado 2");
        botonDado2.addActionListener(escucha);

        botonDado3 = new JButton("Dado 3");
        botonDado3.addActionListener(escucha);

        botonDado4 = new JButton("Dado 4");
        botonDado4.addActionListener(escucha);

        botonDado5 = new JButton("Dado 5");
        botonDado5.addActionListener(escucha);

        botonDado6 = new JButton("Dado 6");
        botonDado6.addActionListener(escucha);

        botonDado7 = new JButton("Dado 7");
        botonDado7.addActionListener(escucha);





        panelDados = new JPanel();
        panelDados.setPreferredSize(new Dimension(300, 280)); //Esto define el tamaño al panel
        panelDados.setBorder(BorderFactory.createTitledBorder("Tus dados activos"));

        panelDados.add(dado1);
        //panelDados.add(dado2);
        panelDados.add(lanzar);

        this.add(panelDados,BorderLayout.CENTER); //Esto hace que se vea lo que agregamos a la pantalla


        mensajesSalida = new JTextArea(7, 31);
        mensajesSalida.setText(MENSAJE_INICIO);
        //mensajesSalida.setBorder(BorderFactory.createTitledBorder("Qué debes hacer..."));
        JScrollPane scroll = new JScrollPane(mensajesSalida); //hace que se vea el texto



        panelResultados = new JPanel();
        panelResultados.setBorder(BorderFactory.createTitledBorder("Qué debes hacer..."));
        panelResultados.add(scroll);
        panelResultados.setPreferredSize(new Dimension(400, 100));

        this.add(panelResultados,BorderLayout.EAST);

        resultadosDados = new JTextArea(10,50);

        separador = new JSeparator();
        separador.setPreferredSize(new Dimension(420, 7));
        separador.setBackground(Color.pink);

        panelDados.add(botonDado1);
        panelDados.add(botonDado2);
        panelDados.add(botonDado3);
        panelDados.add(botonDado4);
        panelDados.add(botonDado5);
        panelDados.add(botonDado6);
        panelDados.add(botonDado7);

        //panelMouse = new JPanel();
        //panelMouse.addMouseListener(escucha);
        //panelMouse.addMouseMotionListener(escucha);
        //panelMouse.setFocusable(true);
        //panelMouse.setBackground(Color.BLUE);
        //panelMouse.setPreferredSize(new Dimension(300, 250));

    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }


    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e){

            modelGOM.calcularLanzamiento();
            int [] caras = modelGOM.getCaras();

            imageInicio =  new ImageIcon(getClass().getResource("/recursos/"+caras[0]+".png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
            dado1.setIcon(imageInicio);

            imageInicio =  new ImageIcon(getClass().getResource("/recursos/"+caras[1]+".png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
            dado2.setIcon(imageInicio);

            imageInicio =  new ImageIcon(getClass().getResource("/recursos/"+caras[2]+".png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
            dado3.setIcon(imageInicio);

            imageInicio =  new ImageIcon(getClass().getResource("/recursos/"+caras[3]+".png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
            dado4.setIcon(imageInicio);

            imageInicio =  new ImageIcon(getClass().getResource("/recursos/"+caras[4]+".png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
            dado5.setIcon(imageInicio);

            imageInicio =  new ImageIcon(getClass().getResource("/recursos/"+caras[5]+".png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
            dado6.setIcon(imageInicio);

            imageInicio =  new ImageIcon(getClass().getResource("/recursos/"+caras[6]+".png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
            dado7.setIcon(imageInicio);

            imageInicio =  new ImageIcon(getClass().getResource("/recursos/"+caras[7]+".png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
            dado8.setIcon(imageInicio);

            imageInicio =  new ImageIcon(getClass().getResource("/recursos/"+caras[8]+".png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
            dado9.setIcon(imageInicio);

            imageInicio =  new ImageIcon(getClass().getResource("/recursos/"+caras[9]+".png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
            dado10.setIcon(imageInicio);



            modelGOM.determinarJuego();

            panelResultados.removeAll();
            panelResultados.setBorder(BorderFactory.createTitledBorder("RESULTADOS"));
            panelResultados.setPreferredSize(new Dimension(180, 100));
            panelResultados.add(resultadosDados);
            panelResultados.add(separador);
            panelResultados.add(mensajesSalida);
            resultadosDados.setText(modelGOM.getEstadoToString()[0]);
            mensajesSalida.setRows(4); //Esto achica la caja de texto inicial
            mensajesSalida.setText(modelGOM.getEstadoToString()[1]);


            revalidate();
            repaint();

            //mensajesSalida.setText(modelCraps.getEstadoToString()); //Trae le resultado que dio



        }


        /**
        @Override
        public void mouseClicked(MouseEvent e) {
            panelMouse.setBackground(Color.CYAN);
            StringWriter mensajes;
            mensajes.append("mouseClicked was detected");
            if(e.getButton()==MouseEvent.BUTTON3){
                JOptionPane.showMessageDialog(null,"Click derecho mouse");
            }else{

            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            panelMouse.setBackground(Color.BLACK);

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
        */
    }

}
