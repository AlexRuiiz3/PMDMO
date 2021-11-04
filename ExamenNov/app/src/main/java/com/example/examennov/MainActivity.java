package com.example.examennov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    private ListView listViewVehiculos;
    private ArrayList<Object> listaVehiculos = new ArrayList<>();
    private CheckBox checkBoxCoches;
    private CheckBox checkBoxMotos;
    private int layoutCoches = 0;
    private int layoutMotos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxCoches = findViewById(R.id.checkBoxCoches);
        checkBoxMotos = findViewById(R.id.checkBoxMotos);

        checkBoxCoches.setOnCheckedChangeListener(this);
        checkBoxMotos.setOnCheckedChangeListener(this);

        RadioGroup radioGroupCoches = findViewById(R.id.radioGroupCoches),
                   radioGroupMotos = findViewById(R.id.radioGroupMotos);

        radioGroupCoches.setOnCheckedChangeListener(this);
        radioGroupMotos.setOnCheckedChangeListener(this);

        listViewVehiculos = findViewById(R.id.listViewVehiculos);

    }
    //Para los radio buttons
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(group.getId() == R.id.radioGroupCoches){
            switch (checkedId){
                case R.id.radioButtonCocheDerc:
                    layoutCoches = R.layout.car_row_right;
                    break;
                case R.id.radioButtonCocheIzq:
                    layoutCoches = R.layout.car_row_left;
                    break;
                case R.id.radioButtonCocheDoble:
                    layoutCoches = R.layout.car_row_double;
                    break;
            }
        }else if(group.getId() == R.id.radioGroupMotos){
            switch (checkedId){
                case R.id.radioButtonMotoDerc:
                    layoutMotos = R.layout.bike_row_right;
                    break;
                case R.id.radioButtonMotoIzq:
                    layoutMotos = R.layout.bike_row_left;
                    break;
                case R.id.radioButtonMotoDoble:
                    layoutMotos = R.layout.bike_row_double;
                    break;
            }
        }
        //Esta condicion es para que no de Nullpointer nada mas empezar la app y no haya ningun radioButtonSeleccionado y el layout del checkbox que se pulso este a 0
        if((layoutMotos != 0 && (checkBoxMotos.isChecked())) || (layoutCoches != 0 && checkBoxCoches.isChecked())) {
            listViewVehiculos.setAdapter(new ListViewAdapter(this, layoutCoches, layoutMotos));
        }
    }

    //Para los CheckBox
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        listaVehiculos.clear();
        if (checkBoxCoches.isChecked() && checkBoxMotos.isChecked()){ //Ambos CheckBox estan seleccionados
            llenarListaConCochesYMotos();
        }else if(checkBoxCoches.isChecked()){//Si el CheckBox de las coches esta seleccionado
                llenarListaConCoches();
        }else if(checkBoxMotos.isChecked()){//Si el CheckBox de las motos esta seleccionado
                llenarListaConMotos();
        }
    }
    private void llenarListaConCoches(){
        listaVehiculos.add(new Car("Audi A8", R.drawable.audi_a8));
        listaVehiculos.add(new Car("BMW M3", R.drawable.bmw_m3));
        listaVehiculos.add(new Car("Citroen C3", R.drawable.citroen_c3));
        listaVehiculos.add(new Car("Opel Astra", R.drawable.opel_astra));
        listaVehiculos.add(new Car("Renault Captur", R.drawable.renault_captur));
        listaVehiculos.add(new Car("Seat Ibiza", R.drawable.seat_ibiza));
        listaVehiculos.add(new Car("Volkswagen Golf", R.drawable.vw_golf));
    }
    private void llenarListaConMotos(){
        listaVehiculos.add(new Bike("H-D SuperLow", R.drawable.harley_davidson_superlow));
        listaVehiculos.add(new Bike("Honda CBR600 RR", R.drawable.honda_cbr600_rr));
        listaVehiculos.add(new Bike("Suzuki GSX R600", R.drawable.suzuki_gsx_r600));
        listaVehiculos.add(new Bike("Yamaha R6", R.drawable.yamaha_r6));
    }
    private void llenarListaConCochesYMotos(){
        listaVehiculos.add(new Bike("H-D SuperLow", R.drawable.harley_davidson_superlow));
        listaVehiculos.add(new Car("Audi A8", R.drawable.audi_a8));
        listaVehiculos.add(new Car("BMW M3", R.drawable.bmw_m3));
        listaVehiculos.add(new Car("Citroen C3", R.drawable.citroen_c3));
        listaVehiculos.add(new Car("Opel Astra", R.drawable.opel_astra));
        listaVehiculos.add(new Bike("Honda CBR600 RR", R.drawable.honda_cbr600_rr));
        listaVehiculos.add(new Car("Renault Captur", R.drawable.renault_captur));
        listaVehiculos.add(new Bike("Suzuki GSX R600", R.drawable.suzuki_gsx_r600));
        listaVehiculos.add(new Car("Seat Ibiza", R.drawable.seat_ibiza));
        listaVehiculos.add(new Car("Volkswagen Golf", R.drawable.vw_golf));
        listaVehiculos.add(new Bike("Yamaha R6", R.drawable.yamaha_r6));
    }

    //Adapter
    class ListViewAdapter extends BaseAdapter {

        private Context context;
        private int resourceCoche;
        private int resourceMotos;

        public ListViewAdapter(Context context, int resourceCoche, int resourceMotos) {
            this.context = context;
            this.resourceCoche = resourceCoche;
            this.resourceMotos = resourceMotos;
        }

        @Override
        public int getCount() {
            return listaVehiculos.size();
        }

        @Override
        public Object getItem(int position) {
            return listaVehiculos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            return (getItem(position) instanceof Car) ? 1 : 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View viewRow = convertView;
            TextView textNombre;
            ImageView imageView;
            ImageView imageView2;

            ViewHolderDoubleImage holderDoubleImage;

                if(viewRow == null){
                    if(getItemViewType(position) == 1){ //Si es un coche
                        viewRow = getLayoutInflater().inflate(resourceCoche,parent,false);
                        textNombre = viewRow.findViewById(R.id.name);
                        imageView = viewRow.findViewById(R.id.image);
                        imageView2 = viewRow.findViewById(R.id.image2);
                    }else{ //Si es una moto
                        viewRow = getLayoutInflater().inflate(resourceMotos,parent,false);
                        textNombre = viewRow.findViewById(R.id.bike_name);
                        imageView = viewRow.findViewById(R.id.bike_image);
                        imageView2 = viewRow.findViewById(R.id.bike_image2);
                    }
                    holderDoubleImage = new ViewHolderDoubleImage(imageView,textNombre,imageView2);
                    viewRow.setTag(holderDoubleImage);
                }else{
                    holderDoubleImage = (ViewHolderDoubleImage) viewRow.getTag();
                }

                if(getItemViewType(position) == 1){
                    Car car = (Car) listaVehiculos.get(position);
                    holderDoubleImage.getTextNombre().setText(car.getCarName());
                    holderDoubleImage.getImageView().setImageResource(car.getCarImage());
                    if(holderDoubleImage.getImageView2() != null){ //Para los layouts que no tienen 2 imagenes
                        holderDoubleImage.getImageView2().setImageResource(car.getCarImage());
                    }
                }else{
                    Bike bike = (Bike) listaVehiculos.get(position);
                    holderDoubleImage.getTextNombre().setText(bike.getBikeName());
                    holderDoubleImage.getImageView().setImageResource(bike.getBikeImage());
                    if(holderDoubleImage.getImageView2() != null){ //Para los layouts que no tienen 2 imagenes
                        holderDoubleImage.getImageView2().setImageResource(bike.getBikeImage());
                    }
                }
            return viewRow;
        }
    }

    //ViewHolder
    class ViewHolderDoubleImage {
        private ImageView imageView;
        private TextView textNombre;
        private ImageView imageView2;

        public ViewHolderDoubleImage(ImageView imageView, TextView textNombre, ImageView imageView2){
            this.imageView = imageView;
            this.textNombre = textNombre;
            this.imageView2 = imageView2;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextNombre() {
            return textNombre;
        }

        public ImageView getImageView2() {
            return imageView2;
        }
    }
}