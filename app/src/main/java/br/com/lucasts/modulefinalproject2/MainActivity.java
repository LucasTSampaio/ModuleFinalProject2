package br.com.lucasts.modulefinalproject2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.spinner_sexo)
    Spinner spinnerSexo;

    @BindView(R.id.btn_salvar)
    Button btnSalvar;

    @BindView(R.id.et_nome)
    EditText etNome;

    @BindView(R.id.et_idade)
    EditText etIdade;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    String sexo;

    ArrayList<AmigoHago> amigos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        spinner();
        salvar();

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(amigos);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);


        spinnerSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sexo = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void spinner(){
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this,
                R.array.sexo_array, android.R.layout.simple_spinner_dropdown_item);

        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerSexo.setAdapter(adapterSpinner);



    }


    public void salvar(){
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = etNome.getText().toString();
                String idade = etIdade.getText().toString();


                AmigoHago amigoHago = new AmigoHago(nome, sexo, idade);

                amigos.add(amigoHago);
                Toast.makeText(MainActivity.this, "Contato salvo!", Toast.LENGTH_LONG).show();
            }
        });
    }


}