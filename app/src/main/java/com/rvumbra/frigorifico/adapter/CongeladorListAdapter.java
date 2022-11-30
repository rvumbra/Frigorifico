package com.rvumbra.frigorifico.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rvumbra.frigorifico.contratos.BaseContracts;
import com.rvumbra.frigorifico.data.model.Congelador;
import com.rvumbra.frigorifico.data.repository.CongeladorRepository;
import com.rvumbra.frigorifico.databinding.ItemCongeladorBinding;

import java.util.ArrayList;

public class CongeladorListAdapter extends RecyclerView.Adapter<CongeladorListAdapter.CongeladorViewHolder> {
    private ArrayList<Congelador> list;
    private ItemCongeladorBinding binding;
    private BaseContracts.IList listener;

    public CongeladorListAdapter(BaseContracts.IList listener){
        list = CongeladorRepository.getSingleton().getCongeladorArrayList();
        this.listener = listener;
    }

    /**
     * Se infla el binding del item para reconocer el item, y se retorna el holder con el binding
     * asignado
     */
    @NonNull
    @Override
    public CongeladorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemCongeladorBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CongeladorViewHolder(binding);
    }

    /**
     * Se ejecuta el código del holder de cada item.
     */
    @Override
    public void onBindViewHolder(@NonNull CongeladorViewHolder holder, int position) {
        holder.bind(list.get(position), listener);
    }

    /**
     * Se devuelve la lista completa.
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CongeladorViewHolder extends RecyclerView.ViewHolder {
        private ItemCongeladorBinding binding;

        /**
         * Se pasa el binding para tener todo el item directamente desde el DataBinding.
         */
        public CongeladorViewHolder(ItemCongeladorBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        /**
         * Se crea este método, para desde onBindViewHolder, ejecutar dicho código.
         */
        public void bind(Congelador congelador, BaseContracts.IList listener){
            binding.setCongelador(congelador);
            binding.item.setOnClickListener(v->listener.setNavigation(congelador));
            binding.item.setOnLongClickListener(v->{
                listener.delete(congelador);
                return true;
            });
        }
    }
}
