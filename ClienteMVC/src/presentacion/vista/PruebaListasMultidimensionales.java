/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion.vista;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Judi
 */
public class PruebaListasMultidimensionales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<List<Integer>> listaX14Normales = new ArrayList<List<Integer>>();
        //1-14
        listaX14Normales.add(Arrays.asList(300, 340, 368, 328));
        listaX14Normales.add(Arrays.asList(328, 368, 396, 356));
        listaX14Normales.add(Arrays.asList(356, 396, 424, 384));
        listaX14Normales.add(Arrays.asList(384, 424, 452, 412));
        listaX14Normales.add(Arrays.asList(412, 452, 480, 440));
        listaX14Normales.add(Arrays.asList(440, 480, 508, 468));
        listaX14Normales.add(Arrays.asList(468, 508, 560, 496));
        
        listaX14Normales.add(Arrays.asList(508, 548, 576, 560));
        listaX14Normales.add(Arrays.asList(480, 520, 548, 508));
        listaX14Normales.add(Arrays.asList(452, 492, 520, 480));
        listaX14Normales.add(Arrays.asList(424, 464, 492, 452));
        listaX14Normales.add(Arrays.asList(396, 436, 464, 424));
        listaX14Normales.add(Arrays.asList(368, 408, 436, 396));
        listaX14Normales.add(Arrays.asList(340, 380, 408, 368));

        List<List<Integer>> listay14Normales = new ArrayList<List<Integer>>();
        //1-14
        listay14Normales.add(Arrays.asList(220, 260, 232, 192));
        listay14Normales.add(Arrays.asList(192, 232, 204, 164));
        listay14Normales.add(Arrays.asList(164, 204, 176, 136));
        listay14Normales.add(Arrays.asList(136, 176, 148, 108));
        listay14Normales.add(Arrays.asList(108, 148, 120, 80));
        listay14Normales.add(Arrays.asList(80, 120, 92, 52));
        listay14Normales.add(Arrays.asList(52, 92, 40, 24));
        
        listay14Normales.add(Arrays.asList(92, 132, 104, 40));
        listay14Normales.add(Arrays.asList(120, 160, 132, 92));
        listay14Normales.add(Arrays.asList(148, 188, 160, 120));
        listay14Normales.add(Arrays.asList(176, 216, 188, 148));
        listay14Normales.add(Arrays.asList(204, 244, 216, 176));
        listay14Normales.add(Arrays.asList(232, 272, 244, 204));
        listay14Normales.add(Arrays.asList(260, 300, 272, 232));

        List<Polygon> triangulos = new ArrayList<>();
        Polygon p1 = new Polygon();
        p1.addPoint(440, 80);
        p1.addPoint(480, 120);
        p1.addPoint(433, 87);

        triangulos.add(p1);

        Polygon p2 = new Polygon();
        p2.addPoint(480, 120);
        p2.addPoint(440, 80);
        p2.addPoint(447, 73);
        triangulos.add(p2);

        Polygon p3 = new Polygon();
        p3.addPoint(480, 120);
        p3.addPoint(513, 167);
        p3.addPoint(520, 160);
        triangulos.add(p3);

        Polygon p4 = new Polygon();
        p4.addPoint(480, 120);
        p4.addPoint(520, 160);
        p4.addPoint(527, 153);
        triangulos.add(p4);
        
      
    }

}
