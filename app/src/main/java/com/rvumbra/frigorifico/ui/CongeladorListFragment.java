package com.rvumbra.frigorifico.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rvumbra.frigorifico.R;
import com.rvumbra.frigorifico.adapter.CongeladorListAdapter;
import com.rvumbra.frigorifico.contratos.BaseContracts;
import com.rvumbra.frigorifico.data.model.Congelador;
import com.rvumbra.frigorifico.databinding.FragmentCongeladorListBinding;

public class CongeladorListFragment extends Fragment implements BaseContracts.IList {
    private FragmentCongeladorListBinding binding;
    private CongeladorListAdapter adapter;

    //region Ciclo de vida
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCongeladorListBinding.inflate(inflater);
        requireActivity().setTitle("Lista de congelador");

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setRecyclerView();
        binding.fabCongeladorAdd.setOnClickListener(v->setNavigation(new Congelador()));
    }

    /**
     * Se sobreescribe el destroyView para anular el valor del binding y no crear nuevas copias,
     * evitando la fuga de memoria en el ciclo de vida de la ejecución de nuestra aplicación
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();

        binding = null;
    }
    //endregion

    //region BaseContrats.IList
    @Override
    public boolean setNavigation(Object o) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("congelador" , (Congelador) o);
        NavHostFragment.findNavController(this).navigate(R.id.action_congeladorListFragment_to_congeladorAddEditFragment, bundle);
        return true;
    }

    @Override
    public boolean delete(Object o) {
        Toast.makeText(requireContext(), "Se quiere borrar el objeto: "+((Congelador)o).getNombre(), Toast.LENGTH_SHORT).show();
        return true;
    }
    //endregion

    /**
     * Establece el recyclerView con su adapter y establece el viewModel a esta vista
     */
    private void listaConViewModel(){
        /*
         * 1.- INICIAR RECICLER VIEW
         */
        setRecyclerView();
        /*
         * 2.- Establecer el viewModel y avisar a los observadores y al adapter
         */
        setViewModel();
    }

    /**
     * Crea el recyclerView y lo vincula con su adapter en 3 pasos:
     *
     * 1.- Se declara en la clase el adapter y aquí se inicializa.
     *
     * 2.- Se declara un layout manager para el recyclerView,
     * este layout manager es necesario para que el adapter gestione la lista.
     *
     * 3.- Se asigna el adapter al recyclerView inflado ya con un layout manager.
     */
    private void setRecyclerView() {
        adapter = new CongeladorListAdapter(this);
        binding.rvCongelador.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.rvCongelador.setAdapter(adapter);
    }

    private void setViewModel() {

    }
}