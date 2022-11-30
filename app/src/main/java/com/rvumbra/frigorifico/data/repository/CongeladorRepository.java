package com.rvumbra.frigorifico.data.repository;

import com.rvumbra.frigorifico.data.model.Congelador;

import java.util.ArrayList;

public class CongeladorRepository {
    private ArrayList<Congelador> congeladorArrayList;
    /**
     * Esta instancia se crea para aplicar el patrón singletón, siendo esta instancia la única
     * de esta clase, teniendo solo un repositorio al que acceder.
     */
    private static CongeladorRepository singleton;

    private CongeladorRepository(){
        congeladorArrayList = new ArrayList<>();
        init();
    }

    public static CongeladorRepository getSingleton() {
        if (singleton == null)
            singleton = new CongeladorRepository();
        return singleton;
    }

    /**
     * Inicializa la lista con unos datos de ejemplo.
     */
    private void init(){
        for (int i = 1; i<=10; i++){
            congeladorArrayList.add(new Congelador("Congelador nº->"+i, String.valueOf(i)));
        }
    }

    public ArrayList<Congelador> getCongeladorArrayList() {
        return congeladorArrayList;
    }
}
