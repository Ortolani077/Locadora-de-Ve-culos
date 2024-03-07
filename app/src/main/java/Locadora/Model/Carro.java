package Locadora.Model;

public class Carro {

    private Long id;
    private Long fabricanteId;
    private Long modeloId;
    private String placa;
    private String cor;
    private Boolean disponivel;
    private Integer ano;
    private Double valorLocacao;

    public Carro(Long id, Long fabricanteId, Long modeloId, String placa, String cor, Boolean disponivel, Integer ano, Double valorLocacao) {
        this.id = id;
        this.fabricanteId = fabricanteId;
        this.modeloId = modeloId;
        this.placa = placa;
        this.cor = cor;
        this.disponivel = disponivel;
        this.ano = ano;
        this.valorLocacao = valorLocacao;
    }

    public Carro() {
    }
public Carro(long carroId, String fabricante, String modelo, String placa, String cor, int parseInt, double parseDouble, boolean disponivel) {
    this.id = carroId;
    // Aqui você pode definir os valores para fabricanteId e modeloId com base nos parâmetros fabricante e modelo
    // Este trecho deve ser ajustado para buscar os IDs apropriados do banco de dados ou de onde quer que esses valores venham
    this.placa = placa;
    this.cor = cor;
    this.disponivel = disponivel;
    this.ano = parseInt;
    this.valorLocacao = parseDouble;
}

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFabricanteId() {
        return fabricanteId;
    }

    public void setFabricanteId(Long fabricanteId) {
        this.fabricanteId = fabricanteId;
    }

    public Long getModeloId() {
        return modeloId;
    }

    public void setModeloId(Long modeloId) {
        this.modeloId = modeloId;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(Double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public long getIdModelo() {
        return modeloId != null ? modeloId : -1;
    }

    public long getIdFabricante() {
        return fabricanteId != null ? fabricanteId : -1;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", fabricanteId=" + fabricanteId +
                ", modeloId=" + modeloId +
                ", placa='" + placa + '\'' +
                ", cor='" + cor + '\'' +
                ", disponivel=" + disponivel +
                ", ano=" + ano +
                ", valorLocacao=" + valorLocacao +
                '}';
    }
}
