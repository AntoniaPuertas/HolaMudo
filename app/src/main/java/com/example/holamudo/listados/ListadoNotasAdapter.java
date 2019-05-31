package com.example.holamudo.listados;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.holamudo.R;
import com.example.holamudo.dates.Nota;

import java.util.ArrayList;

public class ListadoNotasAdapter extends ArrayAdapter<Nota> {

    private ArrayList<Nota> listaNotas;
    private Context mContext;

    private String[] categorias;
    private String categoria;

    /**
     * Constructor
     * @param context contexto de la aplicación dónde se va a mostrar el listado
     * @param listaNotas datos que se van a mostrar
     */
    public ListadoNotasAdapter(Context context, ArrayList<Nota> listaNotas) {
        super(context, R.layout.activity_listado_notas,listaNotas);

        this.listaNotas = listaNotas;
        this.mContext = context;
        categorias = Nota.getCategorias();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Recojo los datos para este item
        Nota nota = getItem(position);
        // si el view no está creado lo crea
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_nota, parent, false);
        }
        // Crea las referencias para los elementos del item
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgCategoria);
        TextView txtFecha = (TextView) convertView.findViewById(R.id.txtFecha);
        TextView txtTexto = (TextView) convertView.findViewById(R.id.txtTexto);


        //compruebo la categoria de la nota para mostrar una imagen u otra
        categoria = nota.getCategoria();

        if(categoria.equalsIgnoreCase(categorias[0])){
            imageView.setImageResource(R.drawable.ic_nota_urgente);
        }else if(categoria.equalsIgnoreCase(categorias[1])){
            imageView.setImageResource(R.drawable.ic_nota_amarillo);
        }else{
            imageView.setImageResource(R.drawable.ic_nota_verde);
        }

        //muestro la fecha y el texto correspondientes a esta nota
        txtFecha.setText(nota.getFechaToString());
        txtTexto.setText(nota.getTexto());
        // devuelve el item con todos los datos
        return convertView;
    }

}
