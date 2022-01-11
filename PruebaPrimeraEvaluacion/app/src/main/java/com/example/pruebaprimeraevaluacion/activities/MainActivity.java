package com.example.pruebaprimeraevaluacion.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.pruebaprimeraevaluacion.R;
import com.example.pruebaprimeraevaluacion.clasesBasicas.Empresa;
import com.example.pruebaprimeraevaluacion.clasesBasicas.EmpresaNoTecnologica;
import com.example.pruebaprimeraevaluacion.clasesBasicas.EmpresaTecnologica;
import com.example.pruebaprimeraevaluacion.clasesBasicas.Persona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TextWatcher,AdapterView.OnItemClickListener {

    private ListView listViewEmpresas;
    private AutoCompleteTextView autoCompleteText;
    private ArrayList<Empresa> listaEmpresas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llenarListaEmpresas();

        listViewEmpresas = findViewById(R.id.listViewListaEmpresas);
        listViewEmpresas.setAdapter(new ListViewEmpresasAdapter(listaEmpresas));
        listViewEmpresas.setOnItemClickListener(this);

        autoCompleteText = findViewById(R.id.autoCompleteTextView);
        autoCompleteText.addTextChangedListener(this);
        autoCompleteText.setAdapter(new AutoCompleteTexAdapter(this,listaEmpresas));
    }

    /*
     * Cabecera: private void llenarListaEmpresas()
     * Comentario: Este metodo se encarga de añadir a la lista de objetos empresa un cierto numero de objetos empresa.
     * Entradas: Ninguna
     * Salidas: Ninguna
     * Precondiciones: Ninguna
     * Postcondicones: La lista de objetos empresa contendra un cierto numeros objetos empresa.
     */
    private void llenarListaEmpresas(){
        ArrayList<Persona> personasContacto = new ArrayList<>();
        personasContacto.add(new Persona("Juan","Torres","987456123","Becario","tubecariofavorito@gmail.com"));
        personasContacto.add(new Persona("Ana","Lopez","987456123","Limpiador","notengoCorreo@gmail.com"));
        personasContacto.add(new Persona("Carlos","Rodriguez","987456123","Jefe","ensalada@gmail.com"));
        personasContacto.add(new Persona("Juan2","Torres","987456123","Becario","tubecariofavorito@gmail.com"));
        personasContacto.add(new Persona("Ana2","Lopez","987456123","Limpiador","notengoCorreo@gmail.com"));
        personasContacto.add(new Persona("Carlos2","Rodriguez","987456123","Jefe","ensalada@gmail.com"));

        listaEmpresas.add(new EmpresaTecnologica(R.drawable.logo_ayesa,"Ayesa","https://www.ayesa.com/es/","37.405670254372204, -6.00576255836253","ayesa@gmail.com","Calle Ayesa Nº12","987451234",personasContacto));
        listaEmpresas.add(new EmpresaTecnologica(R.drawable.logo_accenture,"Accenture","https://www.accenture.com/es-es","37.40925192610155, -6.0051052","accenture@gmail.com","Calle Accenture Nº10","987451234",personasContacto));
        listaEmpresas.add(new EmpresaTecnologica(R.drawable.logo_deloitte,"Deloitte","https://www2.deloitte.com/es/es.html","37.39219427031523, -6.010424399999999","deloitte@gmail.com","Direccion Deloitte Nº21","987451234",personasContacto));
        listaEmpresas.add(new EmpresaNoTecnologica(R.drawable.logo_adidas,"Adidas","Ropa","152"));
        listaEmpresas.add(new EmpresaNoTecnologica(R.drawable.logo_cruzcampo,"Cruzcampo","Alimentacion","829"));
        listaEmpresas.add(new EmpresaNoTecnologica(R.drawable.logo_apple,"Apple","Dispositivos moviles","478"));
        listaEmpresas.add(new EmpresaTecnologica(R.drawable.logo_ayesa,"Ayesa","https://www.ayesa.com/es/","37.405670254372204, -6.00576255836253","ayesa@gmail.com","Calle Ayesa Nº12","987451234",personasContacto));
        listaEmpresas.add(new EmpresaTecnologica(R.drawable.logo_accenture,"Accenture","https://www.accenture.com/es-es","37.40925192610155, -6.0051052","accenture@gmail.com","Calle Accenture Nº10","987451234",personasContacto));
        listaEmpresas.add(new EmpresaTecnologica(R.drawable.logo_deloitte,"Deloitte","https://www2.deloitte.com/es/es.html","37.39219427031523, -6.010424399999999","deloitte@gmail.com","Direccion Deloitte Nº21","987451234",personasContacto));
        listaEmpresas.add(new EmpresaNoTecnologica(R.drawable.logo_adidas,"Adidas","Ropa","152"));
        listaEmpresas.add(new EmpresaNoTecnologica(R.drawable.logo_cruzcampo,"Cruzcampo","Alimentacion","829"));
        listaEmpresas.add(new EmpresaNoTecnologica(R.drawable.logo_apple,"Apple","Dispositivos moviles","478"));
        listaEmpresas.add(new EmpresaTecnologica(R.drawable.logo_ayesa,"Ayesa","https://www.ayesa.com/es/","37.405670254372204, -6.00576255836253","ayesa@gmail.com","Calle Ayesa Nº12","987451234",personasContacto));
        listaEmpresas.add(new EmpresaTecnologica(R.drawable.logo_accenture,"Accenture","https://www.accenture.com/es-es","37.40925192610155, -6.0051052","accenture@gmail.com","Calle Accenture Nº10","987451234",personasContacto));
        listaEmpresas.add(new EmpresaTecnologica(R.drawable.logo_deloitte,"Deloitte","https://www2.deloitte.com/es/es.html","37.39219427031523, -6.010424399999999","deloitte@gmail.com","Direccion Deloitte Nº21","987451234",personasContacto));
        listaEmpresas.add(new EmpresaNoTecnologica(R.drawable.logo_adidas,"Adidas","Ropa","152"));
        listaEmpresas.add(new EmpresaNoTecnologica(R.drawable.logo_cruzcampo,"Cruzcampo","Alimentacion","829"));
        listaEmpresas.add(new EmpresaNoTecnologica(R.drawable.logo_apple,"Apple","Dispositivos moviles","478"));
    }

    /*
     * Cabecera:  public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
     * Comentario: Este metodo se encarga de realizar una tarea cuando un elemento es clicado.
     *             En este caso al seleccionar un elemento de una lista se iniciara otra actividad.
     * Entradas: AdapterView<?> adapterView, View view, int position, long l
     * Salidas: Ninguna
     * Precondiciones: Ninguna
     * Postcondicones: Se iniciara otra activida siempre que el elemento clicado sea un objeto de tipo
     *                 EmpresaTecnologica.
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Object objeto = listaEmpresas.get(position);
        if(objeto instanceof EmpresaTecnologica){
            Intent intent = new Intent(this,EmpresaTecnologicaActivity.class);
            intent.putExtra("EmpresaTecnologica",(EmpresaTecnologica)objeto);
            startActivity(intent);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    //Adapter ListViewEmpresas
    class ListViewEmpresasAdapter extends BaseAdapter {
        private ArrayList<Empresa> empresasListView;

        public ListViewEmpresasAdapter(ArrayList<Empresa> empresasListView) {
            this.empresasListView = empresasListView;
        }

        @Override
        public int getCount() {
            return empresasListView.size();
        }

        @Override
        public Object getItem(int position) {
            return empresasListView.get(position);
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
            return (getItem(position) instanceof EmpresaTecnologica) ? 1 : 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            View viewRow = view;
            ImageView imageViewLogo;
            TextView textViewNombre;
            TextView textViewWeb;
            TextView textViewLocalizacion;
            TextView textViewEmail;
            TextView textViewActividadCnae;

            ViewHolderEmpresaTecnologica holderEmpresaTecnologica = null;
            ViewHolderEmpresaNoTecnologica holderEmpresaNoTecnologica = null;

            int identificadorObjeto = getItemViewType(position);//Se almacena con que numero se va a identificar las empresas. De esta manera se llama solo una vez a getItemViewType

            if(viewRow == null){
                if(identificadorObjeto == 1){ //Si es una empresaTecnologica
                    viewRow = getLayoutInflater().inflate(R.layout.empresa_tecnologica,viewGroup,false);
                    imageViewLogo = viewRow.findViewById(R.id.imageViewLogoTecnologica);
                    textViewNombre = viewRow.findViewById(R.id.textViewNombreTecnologica);
                    textViewWeb = viewRow.findViewById(R.id.textViewWebTecnologica);
                    textViewLocalizacion = viewRow.findViewById(R.id.textViewLocalizacionTecnologica);
                    textViewEmail = viewRow.findViewById(R.id.textViewEmailTecnologica);
                    holderEmpresaTecnologica = new ViewHolderEmpresaTecnologica(imageViewLogo,textViewNombre,textViewWeb,textViewLocalizacion,textViewEmail);
                    viewRow.setTag(holderEmpresaTecnologica);
                }else{
                    viewRow = getLayoutInflater().inflate(R.layout.empresa_no_tecnologica,viewGroup,false);
                    imageViewLogo = viewRow.findViewById(R.id.imageViewLogoNoTecnologica);
                    textViewNombre = viewRow.findViewById(R.id.textViewNombreNoTecnologica);
                    textViewActividadCnae = viewRow.findViewById(R.id.textViewActividadNoTecnologica);
                    holderEmpresaNoTecnologica = new ViewHolderEmpresaNoTecnologica(imageViewLogo,textViewNombre,textViewActividadCnae);
                    viewRow.setTag(holderEmpresaNoTecnologica);
                }
            }else{
                if(identificadorObjeto == 1){
                   holderEmpresaTecnologica = (ViewHolderEmpresaTecnologica) viewRow.getTag();

                }else{
                    holderEmpresaNoTecnologica = (ViewHolderEmpresaNoTecnologica) viewRow.getTag();
                }
            }

            if(identificadorObjeto == 1){
                EmpresaTecnologica empresaTecnologica = (EmpresaTecnologica) getItem(position);
                holderEmpresaTecnologica.getImageViewLogo().setImageResource(empresaTecnologica.getLogo());
                holderEmpresaTecnologica.getTextViewNombre().setText(empresaTecnologica.getNombre());
                holderEmpresaTecnologica.getTextViewWeb().setText(empresaTecnologica.getWeb());
                holderEmpresaTecnologica.getTextViewLocalizacion().setText(empresaTecnologica.getLocalizacion());
                holderEmpresaTecnologica.getTextViewEmail().setText(empresaTecnologica.getEmail());
            }else{
                EmpresaNoTecnologica empresaNoTecnologica = (EmpresaNoTecnologica) getItem(position);
                holderEmpresaNoTecnologica.getImageViewLogo().setImageResource(empresaNoTecnologica.getLogo());
                holderEmpresaNoTecnologica.getTextViewNombre().setText(empresaNoTecnologica.getNombre());
                holderEmpresaNoTecnologica.getTextViewActividadCnae().setText(empresaNoTecnologica.getActividad()+"(Nº"+empresaNoTecnologica.getCnae()+")");
            }
            return viewRow;
        }
    }
    //View Holder para empresasTecnologicas
    class ViewHolderEmpresaTecnologica {
        private ImageView imageViewLogo;
        private TextView textViewNombre;
        private TextView textViewWeb;
        private TextView textViewLocalizacion;
        private TextView textViewEmail;

        public ViewHolderEmpresaTecnologica(ImageView imageViewLogo, TextView textViewNombre, TextView textViewWeb, TextView textViewLocalizacion, TextView textViewEmail) {
            this.imageViewLogo = imageViewLogo;
            this.textViewNombre = textViewNombre;
            this.textViewWeb = textViewWeb;
            this.textViewLocalizacion = textViewLocalizacion;
            this.textViewEmail = textViewEmail;
        }

        public ImageView getImageViewLogo() {
            return imageViewLogo;
        }

        public TextView getTextViewNombre() {
            return textViewNombre;
        }
        public TextView getTextViewWeb() {
            return textViewWeb;
        }

        public TextView getTextViewLocalizacion() {
            return textViewLocalizacion;
        }

        public TextView getTextViewEmail() {
            return textViewEmail;
        }
    }

    //View Holder para empresasNoTecnologicas
    class ViewHolderEmpresaNoTecnologica {
        private ImageView imageViewLogo;
        private TextView textViewNombre;
        private TextView textViewActividadCnae;

        public ViewHolderEmpresaNoTecnologica(ImageView imageViewLogo, TextView textViewNombre, TextView textViewActividadCnae) {
            this.imageViewLogo = imageViewLogo;
            this.textViewNombre = textViewNombre;
            this.textViewActividadCnae = textViewActividadCnae;
        }

        public ImageView getImageViewLogo() {
            return imageViewLogo;
        }

        public TextView getTextViewNombre() {
            return textViewNombre;
        }

        public TextView getTextViewActividadCnae() {
            return textViewActividadCnae;
        }
    }

    //Adapter del autocompleteTex
    class AutoCompleteTexAdapter<T> extends ArrayAdapter<T>{

        private ArrayList<Empresa> empresasAux;

        public AutoCompleteTexAdapter(Context context,ArrayList<Empresa> empresas){
            super(context,0);
            empresasAux = new ArrayList<>(empresas);
        }

        public Filter getFilter(){
            return filter;
        }
        Filter filter = new Filter(){

            //Metodo para filtrar la lista de empresas segun los caracteres ingresados
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = null;
                EmpresaTecnologica empresaTecnologica;
                EmpresaNoTecnologica empresaNoTecnologica;
                if(charSequence != null){
                    filterResults = new FilterResults();
                    listaEmpresas.clear();
                    for(Empresa empresa : empresasAux){
                        if(empresa instanceof EmpresaTecnologica){
                           empresaTecnologica = (EmpresaTecnologica) empresa;
                           if(empresaTecnologica.getNombre().toLowerCase().contains(charSequence.toString().toLowerCase())
                              || empresaTecnologica.getLocalizacion().toLowerCase().contains(charSequence.toString().toLowerCase())
                              || empresaTecnologica.getWeb().toLowerCase().contains(charSequence.toString().toLowerCase())
                              || empresaTecnologica.getEmail().toLowerCase().contains(charSequence.toString().toLowerCase())){
                               listaEmpresas.add(empresa);
                           }
                        }else if(empresa instanceof EmpresaNoTecnologica){
                            empresaNoTecnologica = (EmpresaNoTecnologica) empresa;
                            if(empresaNoTecnologica.getNombre().toLowerCase().contains(charSequence.toString().toLowerCase())
                                    || empresaNoTecnologica.getActividad().toLowerCase().contains(charSequence.toString().toLowerCase())
                                    || empresaNoTecnologica.getCnae().toLowerCase().contains(charSequence.toString().toLowerCase())){
                                listaEmpresas.add(empresa);
                            }
                        }
                    }//Fin for
                    filterResults.values = listaEmpresas;
                    filterResults.count = listaEmpresas.size();
                }
                return filterResults;
            }

            //Metodo para publicar/Actualizar la lista de empresas.Para que se vean los cambios en el listView se le asigna otra vez un adapter, pero esta vez con la lista de empresas que se hayan filtrado
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                if(filterResults == null){//Cuando filterResults sea null, sera cuando no se ingrese ningun caracter, entonces se modifica la lista de empresas con todas las empresas
                    listaEmpresas = new ArrayList<>(empresasAux);
                }
                //Cuando filterResults no sea  null en performFiltering la listaEmpresas se va incluir como minimo una empresa dentro
                listViewEmpresas.setAdapter(new ListViewEmpresasAdapter(listaEmpresas));
            }
        };
    }
}