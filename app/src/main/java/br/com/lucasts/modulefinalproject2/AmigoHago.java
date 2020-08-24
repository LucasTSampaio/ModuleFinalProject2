package br.com.lucasts.modulefinalproject2;

public class AmigoHago {

    String name;
    String sexo;
    String idade;

    public AmigoHago(String name, String sexo, String idade) {
        this.name = name;
        this.sexo = sexo;
        this.idade = idade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "AmigoHago{" +
                "name='" + name + '\'' +
                ", sexo='" + sexo + '\'' +
                ", idade='" + idade + '\'' +
                '}';
    }
}
