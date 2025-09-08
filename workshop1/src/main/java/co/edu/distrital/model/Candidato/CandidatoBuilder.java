package co.edu.distrital.model.Candidato;

import co.edu.distrital.model.BaseDatos;
import co.edu.distrital.model.Fabrica.*;

public class CandidatoBuilder {

    private BaseDatos baseDatos;
    private FabricaActoCorrupcion fabricaActoCorrupcion;
    private FabricaClase fabricaClase;
    private FabricaMarcha fabricaMarcha;
    private FabricaPrebenda fabricaPrebenda;
    private FabricaSoborno fabricaSoborno;

    public CandidatoBuilder(int semilla) {
        this.baseDatos = BaseDatos.getInstance(semilla);
        this.fabricaActoCorrupcion = new FabricaActoCorrupcion(semilla);
        this.fabricaClase = new FabricaClase(semilla);
        this.fabricaMarcha = new FabricaMarcha(semilla);
        this.fabricaPrebenda = new FabricaPrebenda(semilla);
        this.fabricaSoborno = new FabricaSoborno(semilla);
    }

    public String getNombre() {
        return this.baseDatos.getNombre() + " " + this.baseDatos.getApellido();
    }

    public String getPartido() {
        return this.baseDatos.getPartido();
    }

    private Candidato builCandidato(int id) {
        int cantidad = this.baseDatos.getInt();
        return new Candidato(id, this.getNombre(), this.getPartido(),
                this.fabricaSoborno.crearDato(cantidad),
                this.fabricaActoCorrupcion.crearDato(cantidad),
                this.fabricaPrebenda.crearDato(cantidad),
                this.fabricaClase.crearDato(cantidad),
                this.fabricaMarcha.crearDato(cantidad));
    }

    public Candidato[] buildCandidatos(int cantidadCandidatos) {
        Candidato[] candidatos = new Candidato[cantidadCandidatos];
        for (int i = 0; i < cantidadCandidatos; i++) {
            candidatos[i] = this.builCandidato(i);
        }
        return candidatos;
    }
    
}
