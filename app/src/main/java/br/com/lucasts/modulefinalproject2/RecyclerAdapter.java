package br.com.lucasts.modulefinalproject2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<AmigoHago> amigos;

    public RecyclerAdapter(ArrayList<AmigoHago> amigos) {
        this.amigos = amigos;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AmigoHago amigoHago = amigos.get(position);

        holder.nomeAmigo.setText("Nome: "+amigoHago.getName());

        holder.idadeAmigo.setText("Idade: "+amigoHago.getIdade());

        holder.sexoAmigo.setText(amigoHago.sexo);


    }

    @Override
    public int getItemCount() {
        return amigos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.nome_item)
        TextView nomeAmigo;

        @BindView(R.id.idade_item)
        TextView idadeAmigo;

        @BindView(R.id.sexo_item)
        TextView sexoAmigo;

        public ViewHolder(View itemView){
            super(itemView);

            ButterKnife.bind(this,itemView);

        }


    }
}
