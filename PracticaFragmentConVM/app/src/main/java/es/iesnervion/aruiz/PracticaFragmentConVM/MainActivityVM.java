package es.iesnervion.aruiz.PracticaFragmentConVM;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityVM extends ViewModel {

    private MutableLiveData<Contacto> contactoSeleccionado;

    public MutableLiveData<Contacto> getContactoSeleccionado(){
        if(contactoSeleccionado == null){
            contactoSeleccionado = new MutableLiveData<>();
        }
        return contactoSeleccionado;
    }
}
