package com.rvumbra.frigorifico.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rvumbra.frigorifico.R;
import com.rvumbra.frigorifico.databinding.FragmentCongeladorAddEditBinding;

public class CongeladorAddEditFragment extends Fragment {
    private FragmentCongeladorAddEditBinding binding;

    //region Ciclo de vida
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCongeladorAddEditBinding.inflate(inflater);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setCongelador(requireArguments().getParcelable("congelador"));
        setMode();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        binding = null;
    }
    //endregion

    /**
     * Se establece si es añadir o editar.
     */
    private void setMode(){
        if (binding.getCongelador().getNombre() == null)
            add();
        else
            edit();
    }

    private void add(){
        setConfigComponents(true);
    }

    private void edit(){
        setConfigComponents(false);
    }

    /**
     * Ya sea añadir o editar, se bloquea o no la clave primaria, en este caso el EditText
     * de nombre para congelador.
     */
    private void setConfigComponents(boolean enabled){
        binding.edNombre.setEnabled(enabled);
    }
}