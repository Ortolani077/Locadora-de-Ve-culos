package Locadora.Model;

public class Fabricante {

    private Long id;
    private String nome;
    private String novoNome; // Novo campo para armazenar o novo nome do fabricante
    
    
    public Long getId() {
    return id != null ? id : -1L; // Retorna -1 se o ID for nulo
}


     public Fabricante(String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Fabricante() {
    }

   
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e setter para o novo nome do fabricante
    public String getNovoNome() {
        return novoNome;
    }

    public void setNovoNome(String novoNome) {
        this.novoNome = novoNome;
    }

    @Override
    public String toString() {
        return "Fabricante{" + "id=" + id + ", nome=" + nome + '}';
    }
}
