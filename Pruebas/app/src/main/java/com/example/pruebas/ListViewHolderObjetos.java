package com.example.pruebas;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListViewHolderObjetos extends AppCompatActivity {

    private List<Jugador> jugadores = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
    }



    class ListAdapter<T> extends ArrayAdapter<T>{

        public ListAdapter(Context context, int resource, int textViewResourceId,List<T> objects) {
            super(context, resource, textViewResourceId, objects);
        }

        @Override
        public View getView(int position,View convertView,ViewGroup parent) {
            return super.getView(position, convertView, parent);
        }
    }
}
