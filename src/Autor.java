import java.util.Date;

public class Autor {
    int id;
    String nome;
    Date dataNascimento;

    public Autor(int id, String nome, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public int GetId() {
        return id;
    }

    public String GetNome() {
        return nome;
    }

    public Date GetDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString()
    {
        return "ID: " + id
        + "\nNome: " + nome
        + "\nData de nascimento: " + dataNascimento;
    }
}
