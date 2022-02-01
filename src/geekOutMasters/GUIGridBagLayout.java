package geekOutMasters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUIGridBagLayout extends JFrame {


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
    private JButton lanzar, ayuda, salir, botonDado1, botonDado2, botonDado3, botonDado4, botonDado5,botonDado6, botonDado7;
    private JPanel panelDados, panelDadosUtilizados, panelDadosInactivos, panelElijeDado;
    private ImageIcon imageDado, imageDado1, imageDado2,imageDado3, imageDado4, imageDado5, imageDado6,imageDado7;
    private JTextArea mensajesSalida, resultadosDados;
    private Escucha escucha;
    private ModelGOM modelGOM; //La vista (el GUI) utiliza un objeto de tipo modelGOM

    public GUIGridBagLayout(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Geek Out Masters by Laura");
        this.setUndecorated(true); //esto el marco de la ventana, como el boton de minimizar y etc
        //this.setSize(1200,790);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initGUI() {

        //Set up JFrame Container's Layout - utilizo el gridbaglayout AQUI
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();


        //Create Listener Object or Control Object
        escucha = new Escucha();
        modelGOM = new ModelGOM();

        //Set up JComponents
        headerProject = new Header("Geek Out Masters by Laura :D", Color.BLACK);

        //configuracion del GridBagLayout
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=3;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(headerProject,constraints); //Este es el titulo de la ventana

        //Boton AYUDA
        ayuda = new JButton("  ?  ");
        ayuda.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;
        this.add(ayuda,constraints);

        //BOTON SALIR
        salir = new JButton("  EXIT  ");
        salir.addActionListener(escucha);
        constraints.gridx=2;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_END;
        this.add(salir,constraints);


        //Panel de los dados
        imageDado1 =  new ImageIcon(getClass().getResource("/recursos/4.png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
        imageDado2 =  new ImageIcon(getClass().getResource("/recursos/4.png"));
        imageDado3 =  new ImageIcon(getClass().getResource("/recursos/4.png"));
        imageDado4 =  new ImageIcon(getClass().getResource("/recursos/4.png"));
        imageDado5 =  new ImageIcon(getClass().getResource("/recursos/4.png"));
        imageDado6 =  new ImageIcon(getClass().getResource("/recursos/4.png"));
        imageDado7 =  new ImageIcon(getClass().getResource("/recursos/4.png"));

        dado1 =  new JLabel(imageDado1);
        dado2 = new JLabel(imageDado2);
        dado3 = new JLabel(imageDado3);
        dado4 = new JLabel(imageDado4);
        dado5 = new JLabel(imageDado5);
        dado6 = new JLabel(imageDado6);
        dado7 = new JLabel(imageDado7);

        panelDados = new JPanel();
        panelDados.setPreferredSize(new Dimension(600, 180)); //Esto define el tamaño al panel
        panelDados.setBorder(BorderFactory.createTitledBorder("Tus dados activos"));

        panelDados.add(dado1);
        panelDados.add(dado2);
        panelDados.add(dado3);
        panelDados.add(dado4);
        panelDados.add(dado5);
        panelDados.add(dado6);
        panelDados.add(dado7);

        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(panelDados,constraints);

        //Panel de los resultados
        resultadosDados = new JTextArea(10,50);
        resultadosDados.setBorder(BorderFactory.createTitledBorder("RESULTADOS"));
        resultadosDados.setText("Debes lanzar los dados");
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(resultadosDados,constraints);


        //Boton LANZAR
        lanzar = new JButton("Lanzar");
        lanzar.addActionListener(escucha);
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(lanzar,constraints);


        //Panel dados utilizados
        imageDado =  new ImageIcon(getClass().getResource("/recursos/4.png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
        dado1 =  new JLabel(imageDado);
        dado2 = new JLabel(imageDado);

        panelDadosUtilizados = new JPanel();
        panelDadosUtilizados.setPreferredSize(new Dimension(300, 180)); //Esto define el tamaño al panel
        panelDadosUtilizados.setBorder(BorderFactory.createTitledBorder("Tus dados utilizados"));

        //panelDadosUtilizados.add(dado1);
        //panelDadosUtilizados.add(dado2);
        constraints.gridx=2;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(panelDadosUtilizados,constraints);


        //Panel dados inactivos
        imageDado =  new ImageIcon(getClass().getResource("/recursos/4.png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
        dado7 =  new JLabel(imageDado);
        dado8 = new JLabel(imageDado);
        dado9 = new JLabel(imageDado);

        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setPreferredSize(new Dimension(300, 180)); //Esto define el tamaño al panel
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder("Tus dados inactivos"));

        panelDadosInactivos.add(dado7);
        panelDadosInactivos.add(dado8);
        panelDadosInactivos.add(dado9);
        constraints.gridx=1;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(panelDadosInactivos,constraints);


        //Panel del mensaje salida
        mensajesSalida = new JTextArea(7, 31);
        mensajesSalida.setText("Usa el botón ayuda (?) para leer las reglas");
        mensajesSalida.setBorder(BorderFactory.createTitledBorder("Mensajes"));
        constraints.gridx=2;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(mensajesSalida,constraints);


        //Panel dados a elegir
        imageDado =  new ImageIcon(getClass().getResource("/recursos/4.png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
        dado1 =  new JLabel(imageDado);
        dado2 = new JLabel(imageDado);

        panelElijeDado = new JPanel();
        panelElijeDado.setPreferredSize(new Dimension(200, 100)); //Esto define el tamaño al panel
        panelElijeDado.setBorder(BorderFactory.createTitledBorder("Tus dados a elegir"));

        panelElijeDado.add(dado1);
        panelElijeDado.add(dado2);
        constraints.gridx=1;
        constraints.gridy=4;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(panelElijeDado,constraints);


        // BOTONES PARA ELEGIR QUE DADO USAR

        //Boton Elije accionar dado 1
        botonDado1 = new JButton("Dado 1");
        botonDado1.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=1;
        //constraints.gridheight=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(botonDado1,constraints);

        //Boton Elije accionar dado 2
        botonDado2 = new JButton("Dado 2");
        botonDado2.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(botonDado2,constraints);


        //Boton Elije accionar dado 3
        botonDado3 = new JButton("Dado 3");
        botonDado3.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(botonDado3,constraints);

        //Boton Elije accionar dado 4
        botonDado4 = new JButton("Dado 4");
        botonDado4.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(botonDado4,constraints);

        //Boton Elije accionar dado 5
        botonDado5 = new JButton("Dado 5");
        botonDado5.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(botonDado5,constraints);

        //Boton Elije accionar dado 6
        botonDado6 = new JButton("Dado 6");
        botonDado6.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(botonDado6,constraints);

        //Boton Elije accionar dado 7
        botonDado7 = new JButton("Dado 7");
        botonDado7.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(botonDado7,constraints);


    }


    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIGridBagLayout miProjectGUI = new GUIGridBagLayout();
        });
    }



    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e){

            if(e.getSource()==lanzar){

                //modelGOM.calcularLanzamiento();
                int [] caras = modelGOM.getCaras();
                //System.out.println(caras);
                imageDado1 = new ImageIcon(getClass().getResource("recursos/1.png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivoSystem
                dado1.setIcon(imageDado1);
                /*
                imageDado2 =  new ImageIcon(getClass().getResource("recursos/" + caras[1] + ".png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
                dado2.setIcon(imageDado2);

                imageDado3 =  new ImageIcon(getClass().getResource("recursos/" + caras[2] + ".png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
                dado3.setIcon(imageDado3);

                imageDado4 =  new ImageIcon(getClass().getResource("recursos/" + caras[3] + ".png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
                dado4.setIcon(imageDado4);

                imageDado5 =  new ImageIcon(getClass().getResource("recursos/" + caras[4] + ".png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
                dado5.setIcon(imageDado5);

                imageDado6 =  new ImageIcon(getClass().getResource("recursos/" + caras[5] + ".png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
                dado6.setIcon(imageDado6);

                imageDado7 =  new ImageIcon(getClass().getResource("recursos/" + caras[6] + ".png")); //Es un puntero a nivel de src, o sea, entra a cualquier archivo
                dado7.setIcon(imageDado7);


                modelGOM.determinarJuego();


                resultadosDados.setText(modelGOM.getEstadoToString()[0]);
                mensajesSalida.setText(modelGOM.getEstadoToString()[1]);//Trae le resultado que dio
                */
            }else{
                if(e.getSource()==botonDado1){
                    int [] caras = modelGOM.getCaras();



                }
                if(e.getSource()==ayuda){
                    JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
                }else{
                    System.exit(0); //Esto es lo que cierra la ventana
                }
            }


        }
    }

}
