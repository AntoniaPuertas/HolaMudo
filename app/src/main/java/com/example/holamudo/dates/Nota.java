package com.example.holamudo.dates;

import java.util.Calendar;

/**
 * Clase Nota que vamos a utilizar para mostrar un listado de notas
 * en un listview
 */
public class Nota {
    private Calendar fecha;
    private String texto;
    private String categoria;
    private static String[] categorias = {"Urgente", "Importante", "Normal"};

    public Nota(String texto, String categoria){
        this.fecha = Calendar.getInstance();
        this.texto = texto;
        this.categoria = comprobarCategoria(categoria);
    }

    private String comprobarCategoria(String cat){
        String categoriaAux = "Normal";
        for(int i = 0 ; i < categorias.length ; i++){
            if(cat.equalsIgnoreCase(categorias[i])){
                categoriaAux = categorias[i];
            }
        }
        return categoriaAux;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = comprobarCategoria(categoria);
    }

    public static String[] getCategorias() {
        return categorias;
    }

    public String getFechaToString(){
        return this.fecha.get(Calendar.DAY_OF_MONTH) +
                " / " +
                this.fecha.get(Calendar.MONTH) +
                " / " +
                this.fecha.get(Calendar.YEAR);
    }
}
