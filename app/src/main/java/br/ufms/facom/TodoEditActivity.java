package br.ufms.facom;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

import br.ufms.facom.helper.DatabaseHelper;
import br.ufms.facom.model.Tag;
import br.ufms.facom.model.Todo;
import br.ufms.facom.model.TransportTodo;

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
        Spinner todo_edit_tag = (Spinner) findViewById(R.id.todo_edit_tag);
        Spinner todo_edit_status = (Spinner) findViewById(R.id.todo_edit_status);

        // abre conexao com o banco
        db = new DatabaseHelper(getApplicationContext());

        // pega as categorias...
        List<Tag> tags = db.getAllTags();

        ArrayAdapter tagAdapter = new ArrayAdapter(this, R.layout.spinner, tags);

        Spinner tagSpinner = (Spinner) findViewById(R.id.todo_edit_tag);
        tagSpinner.setAdapter(tagAdapter);


        todo_edit_note.setText(todo.getNote());

        setSpinnerValue(todo_edit_tag, todo.getTagDesc());
        setSpinnerValue(todo_edit_status, todo.getStatusDesc());

    }

}
