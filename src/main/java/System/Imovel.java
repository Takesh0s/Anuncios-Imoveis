package System;

public class Imovel {
    private int id;
    private String endereco;
    private String tipo;
    private double preco;
    private double area;
    private int idProprietario;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public double getArea() { return area; }
    public void setArea(double area) { this.area = area; }

    public int getIdProprietario() { return idProprietario; }
    public void setIdProprietario(int idProprietario) { this.idProprietario = idProprietario; }
}