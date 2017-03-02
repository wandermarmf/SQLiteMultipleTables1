package br.ufms.facom.model;

/**
 * Created by wandermar on 02/03/2017.
 */

public class TransportTodo {

    private static Object objeto = null;

    public static void setObjeto(Object newObjeto) {
            objeto = newObjeto;
    }

    public static Object getObjeto() {
            return objeto;
    }

}
