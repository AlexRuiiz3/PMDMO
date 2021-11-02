package com.example.pruebas;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
//ListViewHolder lista heterogenea
public class ListViewHolder2 extends AppCompatActivity {

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
        valores.add("Fila10");
        valores.add("Fila11");
        valores.add("Fila12");
        valores.add("Fila13");
        valores.add("Fila14");
        valores.add("Fila15");
        valores.add("Fila16");
        valores.add("Fila17");
        valores.add("Fila18");
        valores.add("Fila19");
        valores.add("Fila20");
        valores.add("Fila21");
        listaElementos = findViewById(R.id.listViewElementos);
        listaElementos.setAdapter(new ListAdapter<String>(this,R.layout.viewpersonalizada,valores));
    }

    class ListAdapter<T> extends ArrayAdapter<T>{

        public ListAdapter( Context context, int resource, List<T> objects) {
            super(context, resource, objects);
        }
        @Override
        public int getItemViewType(int position) {
            int numero;

            if (position % 2 == 0) {
                numero = 1;
            } else {
                numero = 0;
            }
            return numero;
        }

        @Override
        public int getViewTypeCount() {
            return 2;//Numero distinto de view que hay en la lista
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View viewRow = convertView;
            ViewHolder holder;

            TextView textView;
            ImageView imageView;

            if(viewRow == null) {
                LayoutInflater inflater = getLayoutInflater();

                if( getItemViewType(position) == 0 ){
                    viewRow = inflater.inflate(R.layout.viewpersonalizada,parent,false);
                    textView = viewRow.findViewById(R.id.textViewPersonalizada);
                    imageView = viewRow.findViewById(R.id.imageView);
                }else{
                    viewRow = inflater.inflate(R.layout.viewpersonalizada2,parent,false);
                    textView = viewRow.findViewById(R.id.textViewPersonalizada2);
                    imageView = viewRow.findViewById(R.id.imageView2);
                }
                holder = new ViewHolder(textView, imageView);
                viewRow.setTag(holder);
            }else{
                holder = (ViewHolder) viewRow.getTag();
            }

            holder.getTextView().setText(valores.get(position));

            if(valores.get(position).equals("Fila1")){
                holder.getImageView().setImageResource(android.R.drawable.ic_menu_agenda);
            }else if(valores.get(position).equals("Fila4")){
                holder.getImageView().setImageResource(android.R.drawable.ic_delete);
            }else{
                holder.getImageView().setImageResource(android.R.drawable.ic_input_add);
            }
            return viewRow;
        }
    }


    class ViewHolder{

        private TextView textView;
        private ImageView imageView;

        public ViewHolder(TextView textView, ImageView imageView){
            this.textView = textView;
            this.imageView = imageView;
        }

        public TextView getTextView(){return textView;}

        public ImageView getImageView(){return imageView;}
    }
}
