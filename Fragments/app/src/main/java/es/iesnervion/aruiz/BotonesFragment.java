package es.iesnervion.aruiz;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BotonesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BotonesFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private InteracionFragment interacionFragment; //Es una interfaz

    public BotonesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BotonesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BotonesFragment newInstance(String param1, String param2) {
        BotonesFragment fragment = new BotonesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_botones, container, false);
        Button botonMensaje1 = view.findViewById(R.id.buttonPrimerMensaje),
                botonMensaje2 = view.findViewById(R.id.buttonSegundoMensaje);

        botonMensaje1.setOnClickListener(this);
        botonMensaje2.setOnClickListener(this);
        return view;
    }

    //Se llama cuando cuando el fragmento ha sido adjuntado a la Actividad. Se hace aqui por que sera cuando el fragmnets se va a mostrar en pantalla
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        /*
         * Context es el lugar donde esta fragment en este caso MainActivity, como se hace que MainActivity implemente la
         * interfaz InteracionFragment, entonces por eso se hace el casteo, teniendo de esta manera en el atributo de este
         * fragment el metodo implementado en MainActivity.
         */
        interacionFragment = (InteracionFragment) context;
    }

    @Override
    public void onClick(View v) {
        interacionFragment.interacionFragment(v);
    }

    public interface InteracionFragment{
        void interacionFragment(View view);
    }
}