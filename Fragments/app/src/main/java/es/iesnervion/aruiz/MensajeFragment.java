package es.iesnervion.aruiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MensajeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MensajeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mensaje;
    private String mParam2;

    public MensajeFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mensaje Parameter 1.
     * @return A new instance of fragment MensajeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MensajeFragment newInstance(String mensaje) {
        MensajeFragment fragment = new MensajeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mensaje);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mensaje = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_mensaje, container, false);
        TextView textMensaje = view.findViewById(R.id.textViewMensaje);
        textMensaje.setText(mensaje);
        return view;
    }
}