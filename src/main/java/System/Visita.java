package System;

import java.sql.Date;

public class Visita {
    private int id;
    private Date dataVisita;
    private int idImovel;
    private int idInteressado;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getDataVisita() { return dataVisita; }
    public void setDataVisita(Date dataVisita) { this.dataVisita = dataVisita; }

    public int getIdImovel() { return idImovel; }
    public void setIdImovel(int idImovel) { this.idImovel = idImovel; }

    public int getIdInteressado() { return idInteressado; }
    public void setIdInteressado(int idInteressado) { this.idInteressado = idInteressado; }
}