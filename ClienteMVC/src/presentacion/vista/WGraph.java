/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.vista;

import java.awt.Graphics;
import javax.swing.JPanel;

class WGraph extends JPanel
{
    private String sShape;

    public WGraph(String shape) {
        this.sShape= "Line";
    }
   
    public void setShape(String shape)
    {
        sShape = shape;
        repaint();
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if ("Line".equalsIgnoreCase(sShape))
        {
            g.drawLine(10, 20, 100, 200);
        }
        else if ("Circle".equalsIgnoreCase(sShape))
        {
            g.drawOval(50, 100 , 200, 200);
        }
        else if ("Rectangle".equalsIgnoreCase(sShape))
        {
            g.drawRect(10, 20, 150, 200);
        }
    }
}