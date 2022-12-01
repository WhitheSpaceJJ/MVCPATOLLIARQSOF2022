/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.vista;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class MyFrame extends JFrame implements ActionListener
{
    private JComboBox jcbShape;
    private WGraph jpGraph;
    public MyFrame()
    {
        super("GridFrame");
    }
    public void prepareGUI()
    {
        Object[] items= {"Line","Rectangle","Circle"};
        jcbShape = new JComboBox(items);
        jpGraph = new WGraph("Line");
        Container container = getContentPane();
        container.add(jpGraph);
        container.add(jcbShape,BorderLayout.NORTH);
        jcbShape.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,400);
    }
    @Override
    public void actionPerformed(ActionEvent evt)
    {
        String sShape = (String)jcbShape.getSelectedItem();
        jpGraph.setShape(sShape);
    }
    public static void main(String[] st)
    {
        SwingUtilities.invokeLater( new Runnable()
        {
            @Override
            public void run()
            {
                MyFrame myFrame = new MyFrame();
                myFrame.prepareGUI();
                myFrame.setVisible(true);
            }
        });
    }
}