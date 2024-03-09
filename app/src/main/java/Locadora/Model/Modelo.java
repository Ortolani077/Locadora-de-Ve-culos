package Locadora.Model;

/**
 * Represents a car model.
 */
public class Modelo {
    
    private Long id;
    private String nome;
    private Long fabricanteId; 
    private String nomeFabricante; // New field to store the manufacturer's name

    public Modelo() {
    }

    /**
     * Constructor for Modelo class.
     * @param id The ID of the model.
     * @param nome The name of the model.
     * @param fabricanteId The ID of the manufacturer associated with this model.
     */
    public Modelo(Long id, String nome, Long fabricanteId) {
        this.id = id;
        this.nome = nome;
        this.fabricanteId = fabricanteId;
    }

    /**
     * Getter for the ID of the model.
     * @return The ID of the model.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for the ID of the model.
     * @param id The ID of the model.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for the name of the model.
     * @return The name of the model.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter for the name of the model.
     * @param nome The name of the model.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter for the ID of the manufacturer associated with this model.
     * @return The ID of the manufacturer.
     */
    public Long getFabricanteId() {
        return fabricanteId;
    }

    /**
     * Setter for the ID of the manufacturer associated with this model.
     * @param fabricanteId The ID of the manufacturer.
     */
    public void setFabricanteId(Long fabricanteId) {
        this.fabricanteId = fabricanteId;
    }

    /**
     * Getter for the name of the manufacturer associated with this model.
     * @return The name of the manufacturer.
     */
    public String getNomeFabricante() {
        return nomeFabricante;
    }

    /**
     * Setter for the name of the manufacturer associated with this model.
     * @param nomeFabricante The name of the manufacturer.
     */
    public void setNomeFabricante(String nomeFabricante) {
        this.nomeFabricante = nomeFabricante;
    }

    /**
     * Returns a string representation of the model.
     * @return A string representation of the model.
     */
    @Override
    public String toString() {
        return id + " - " + nome + " (Fabricante: " + nomeFabricante + ")";
    }
}
