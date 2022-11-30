package com.rvumbra.frigorifico.contratos;

public interface BaseContracts {
    /**
     * Esta interfaz es un contrato que debe implementar cualquier lista y adapter que quieran
     * vincularse para aplicar sus métodos.
     */
    interface IList{
        /**
         * SetNavigation y no ADD y EDIT por separado, ya que se va a navegar al mismo fragmento
         * ya sea añadir o editar.
         */
        boolean setNavigation(Object o);
        boolean delete(Object o);
    }
}
