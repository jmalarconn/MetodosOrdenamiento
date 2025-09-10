import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Proyecto2_20_08_25 {

    public static void main(String[] args) {
        Marco miMarco = new Marco();
        miMarco.setTitle("OPERACIONES CON ARREGLOS");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Marco extends JFrame{
    public Marco(){
        setBounds(200,200,800,400);
        Lamina miLamina = new Lamina();
        add(miLamina);
        setVisible(true);
    }
}
class Lamina extends JPanel{
    int x;
    MetodosOrdenamineto objeto;
    JButton boton1, boton2, boton3, boton4, boton5, boton6;

    public Lamina(){
        setLayout(new AdminComponentes());
        objeto = new MetodosOrdenamineto();
        boton1 = new JButton("Suma Elementos");
        boton2 = new JButton("Contar pares");
        boton3 = new JButton("BuscarElemento");
        boton4 = new JButton("Contar Mayores");
        boton5 = new JButton("Sumar Menores"); // Nuevo botón
        boton6 = new JButton("Sumar Impares"); // Nuevo botón

        boton1.addActionListener(new GestionEventos());
        boton2.addActionListener(new GestionEventos());
        boton3.addActionListener(new GestionEventos());
        boton4.addActionListener(new GestionEventos());
        boton5.addActionListener(new GestionEventos()); // Evento para nuevo botón
        boton6.addActionListener(new GestionEventos()); // Evento para nuevo botón

        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(boton5); // Agregar nuevo botón
        add(boton6); // Agregar nuevo botón
    }

    private class GestionEventos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==boton1){
                objeto.crearArreglo();
                JOptionPane.showMessageDialog(null,
                        "Arreglo:\n"+objeto.mostrarArreglo(objeto.MAX-1)
                                +"\n La suma de elementos es: "+objeto.sumaElementos(objeto.MAX-1));
            } else if(e.getSource()==boton2){
                objeto.crearArreglo();
                JOptionPane.showMessageDialog(null,
                        "Arreglo:\n"+objeto.mostrarArreglo(objeto.MAX-1)
                                +"\n El numero de elementos pares es: "+objeto.contarPares(objeto.MAX-1));
            }else if(e.getSource()==boton3){
                objeto.crearArreglo();
                JOptionPane.showMessageDialog(null,
                        "Arreglo:\n"+objeto.mostrarArreglo(objeto.MAX-1));
                x = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingrese valor a buscar:"));
                JOptionPane.showMessageDialog(null,
                        "Arreglo:\n"+objeto.mostrarArreglo(objeto.MAX-1)
                                +"\n El elemento "+x+" esta en la posicion "+
                                objeto.buscarElemento(objeto.MAX-1, x));
            }else if(e.getSource()==boton4){
                objeto.crearArreglo();
                JOptionPane.showMessageDialog(null,
                        "Arreglo:\n"+objeto.mostrarArreglo(objeto.MAX-1));
                x = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingrese valor a comparar:"));
                JOptionPane.showMessageDialog(null,
                        "Arreglo:\n"+objeto.mostrarArreglo(objeto.MAX-1)
                                +"\n El numero de elementos mayores a "+x+" es: "+
                                objeto.contarMayores(objeto.MAX-1, x));
            }else if(e.getSource()==boton5){
                // Nuevo evento para Sumar Menores
                objeto.crearArreglo();
                JOptionPane.showMessageDialog(null,
                        "Arreglo:\n"+objeto.mostrarArreglo(objeto.MAX-1));
                x = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingrese valor límite:"));
                JOptionPane.showMessageDialog(null,
                        "Arreglo:\n"+objeto.mostrarArreglo(objeto.MAX-1)
                                +"\n La suma de elementos menores a "+x+" es: "+
                                objeto.sumarMenores(objeto.MAX-1, x));
            }else if(e.getSource()==boton6){
                // Nuevo evento para Sumar Impares
                objeto.crearArreglo();
                JOptionPane.showMessageDialog(null,
                        "Arreglo:\n"+objeto.mostrarArreglo(objeto.MAX-1)
                                +"\n La suma de elementos impares es: "+
                                objeto.sumarImpares(objeto.MAX-1));
            }
        }
    }
}
class AdminComponentes implements LayoutManager{
    int x,y=20;
    @Override
    public void addLayoutComponent(String name, Component comp) {
        throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void layoutContainer(Container miContenedor) {
        int d = miContenedor.getWidth();
        x = d/2;
        int contador = 0;
        int n = miContenedor.getComponentCount();
        for(int i=0;i<n;i++){
            contador++;
            Component c=miContenedor.getComponent(i);
            c.setBounds(x-280, y, 170,35);
            x+=200;
            if(contador%3==0){
                x=d/2;
                y+=65;
            }
        }
    }
}

