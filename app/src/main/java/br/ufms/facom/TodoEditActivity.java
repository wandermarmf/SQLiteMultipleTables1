package br.ufms.facom;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.ufms.facom.helper.DatabaseHelper;
import br.ufms.facom.model.Status;
import br.ufms.facom.model.StatusList;
import br.ufms.facom.model.Tag;
import br.ufms.facom.model.Todo;
import br.ufms.facom.model.TransportTodo;
import br.ufms.facom.widget.MultiSelectSpinner;
/**
 * Created by wandermar on 02/03/2017.
 */

public class TodoEditActivity extends Activity {

    private DatabaseHelper db;

    private void setSpinnerValue(Spinner spinner, String value)
    {
        int index = 0;

        for (int i=0; i < spinner.getCount(); i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(value)){
                spinner.setVerticalScrollbarPosition(i);
                break;
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.todo_edit);
        Todo todo = (Todo) TransportTodo.getObjeto();

        // Se não há objeto ativo, cria um vazio
        if (todo == null) {
            todo = new Todo();
        }

        TextView todo_edit_note = (TextView) findViewById(R.id.todo_edit_note);

        //MultiSelectSpinner mySpin = (MultiSelectSpinner)findViewById(R.id.my_spin);
        MultiSelectSpinner todo_edit_tag = (MultiSelectSpinner)findViewById(R.id.todo_edit_tag);
        Spinner todo_edit_status = (Spinner) findViewById(R.id.todo_edit_status);

        // abre conexao com o banco
        db = new DatabaseHelper(getApplicationContext());

        // pega as categorias...
        String[] arrayStr = db.getAllTagsStrings();
        todo_edit_tag.setItems(arrayStr);

        ArrayList<Status> statuses = StatusList.getStatus();
        ArrayAdapter tagAdapter = new ArrayAdapter(this, R.layout.spinner, statuses);
        todo_edit_status.setAdapter(tagAdapter);

        todo_edit_note.setText(todo.getNote());

        //setSpinnerValue(todo_edit_tag, todo.getTagDesc());
        setSpinnerValue(todo_edit_status, todo.getStatusDesc());

    }

}
