/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.dibujo;

import java.util.ArrayList;

/**
 * Clase que representa el compuesto de figuras.
 * @author Equipo1
 */
public class CompositorCasilla extends Figura {

    private java.util.List< Figura> lista = new ArrayList<>();

    public CompositorCasilla(String posicion) {
        super(posicion);
    }

    @Override
    public void dibujar() {
        for (int i = 0; i < lista.size(); i++) {
            Figura get = lista.get(i);
            get.dibujar();
        }
    }

    public void addElemento(Figura figura) {
        this.lista.add(figura);
    }

    public void removeElemento(Figura figura) {
        this.lista.remove(figura);
    }

    public java.util.List<Figura> getLista() {
        return lista;
    }

    public void setLista(java.util.List<Figura> lista) {
        this.lista = lista;
    }

}
