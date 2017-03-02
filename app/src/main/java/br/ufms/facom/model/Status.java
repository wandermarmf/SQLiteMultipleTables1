package br.ufms.facom.model;

/**
 * Created by wandermar on 02/03/2017.
 */

public class Status {

    private int id;
    private String status;

    public Status(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

}
