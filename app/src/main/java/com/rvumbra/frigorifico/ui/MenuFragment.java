package com.rvumbra.frigorifico.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rvumbra.frigorifico.R;
import com.rvumbra.frigorifico.databinding.FragmentMenuBinding;

public class MenuFragment extends Fragment {
    private FragmentMenuBinding binding;

    //region Ciclo de vida
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navegar();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    //endregion

    private void navegar(){
        binding.btnCongelador.setOnClickListener(v-> NavHostFragment.findNavController(this).navigate(R.id.action_menuFragment_to_congeladorListFragment));
        binding.btnFrigorifico.setOnClickListener(v-> NavHostFragment.findNavController(this).navigate(R.id.action_menuFragment_to_frigorificoListFragment));
    }
}