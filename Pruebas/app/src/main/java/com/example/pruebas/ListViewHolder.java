package com.example.pruebas;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ListViewHolder extends AppCompatActivity {

    private TextView texto;
    private ListView listaElementos;
    private ArrayList<String> valores = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        valores.add("Fila1");
        valores.add("Fila2");
        valores.add("Fila3");
        valores.add("Fila4");
        valores.add("Fila5");
        valores.add("Fila6");
        valores.add("Fila7");
        valores.add("Fila8");
        valores.add("Fila9");
        texto = findViewById(R.id.textView);
        listaElementos = findViewById(R.id.listViewElementos);
        listaElementos.setAdapter(new ListViewAdapter<String>(this,R.layout.viewpersonalizada,R.id.textViewPersonalizada,valores));
    }

    class ListViewAdapter<T> extends ArrayAdapter<T> {

        public ListViewAdapter(Context context, int resource, int textViewResourceId,ArrayList<T> objects) {
            super(context, resource, textViewResourceId, objects);
        }

        @Override
        public View getView(int position, View convertView,ViewGroup parent){

            View viewRow = convertView;
            ViewHolder holder;

            TextView textView;
            ImageView imageView;

            if(viewRow == null){
                LayoutInflater inflater = getLayoutInflater();
                viewRow = inflater.inflate(R.layout.viewpersonalizada,parent,false);

                textView = viewRow.findViewById(R.id.textViewPersonalizada);
                imageView = viewRow.findViewById(R.id.imageView);
                holder = new ViewHolder(textView,imageView);
                viewRow.setTag(holder);
            }else{
                holder = (ViewHolder) viewRow.getTag();
            }

            holder.getNombre().setText(valores.get(position));

            if(valores.get(position).equals("Fila1")){
                holder.getCodigoImagen().setImageResource(android.R.drawable.ic_menu_agenda);
            }else if(valores.get(position).equals("Fila4")){
                holder.getCodigoImagen().setImageResource(android.R.drawable.ic_delete);
            }else{
                holder.getCodigoImagen().setImageResource(android.R.drawable.ic_input_add);
            }
            return viewRow;
        }
    }

    class ViewHolder{

        private TextView nombre;
        private ImageView codigoImagen;

        public ViewHolder(TextView nombre, ImageView codigoImagen) {
            this.nombre = nombre;
            this.codigoImagen = codigoImagen;
        }

        public TextView getNombre(){return nombre;}

        public ImageView getCodigoImagen(){return codigoImagen;}
    }
}
