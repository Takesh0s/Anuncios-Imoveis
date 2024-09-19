package System;

import java.sql.Date;

public class Contrato {
    private int id;
    private String tipoContrato;
    private Date dataContrato;
    private double valor;
    private int idImovel;
    private int idProprietario;
    private int idInteressado;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipoContrato() { return tipoContrato; }
    public void setTipoContrato(String tipoContrato) { this.tipoContrato = tipoContrato; }

    public Date getDataContrato() { return dataContrato; }
    public void setDataContrato(Date dataContrato) { this.dataContrato = dataContrato; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public int getIdImovel() { return idImovel; }
    public void setIdImovel(int idImovel) { this.idImovel = idImovel; }

    public int getIdProprietario() { return idProprietario; }
    public void setIdProprietario(int idProprietario) { this.idProprietario = idProprietario; }

    public int getIdInteressado() { return idInteressado; }
    public void setIdInteressado(int idInteressado) { this.idInteressado = idInteressado; }
}