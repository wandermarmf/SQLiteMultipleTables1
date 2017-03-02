package br.ufms.facom.model;

import java.util.ArrayList;

/**
 * Created by wandermar on 02/03/2017.
 */

public class StatusList {

    public static ArrayList<Status> getStatus() {
        ArrayList<Status> listStatus = new ArrayList<Status>();

        listStatus.add(new Status(1, "Pendente"));
        listStatus.add(new Status(2, "Aguardando"));
        listStatus.add(new Status(3, "Concluído"));

        return listStatus;
    }

    public static String getStatusDesc(int id) {
        ArrayList<Status> listStatus = getStatus();

        for (Status st: listStatus) {
            if (st.getId() == id) {
                return st.getStatus();
            }
        }

        return "";
    }

    public static int getStatusDesc(String status) {
        ArrayList<Status> listStatus = getStatus();

        for (Status st: listStatus) {
            if (st.getStatus() == status) {
                return st.getId();
            }
        }

        return 0;
    }

    public static Status getStatus(String status) {
        ArrayList<Status> listStatus = getStatus();

        for (Status st: listStatus) {
            if (st.getStatus() == status) {
                return st;
            }
        }

        return null;
    }
}
