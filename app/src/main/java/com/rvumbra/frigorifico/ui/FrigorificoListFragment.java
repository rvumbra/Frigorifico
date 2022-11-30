package com.rvumbra.frigorifico.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rvumbra.frigorifico.R;
import com.rvumbra.frigorifico.databinding.FragmentFrigorificoListBinding;

public class FrigorificoListFragment extends Fragment {
    private FragmentFrigorificoListBinding binding;

    //region Ciclo de vida
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFrigorificoListBinding.inflate(inflater);
        requireActivity().setTitle("Lista de frigorifico");

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    //endregion
}