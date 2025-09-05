package controller.ordenamiento;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

import model.Banco;
import model.Candidato;

public abstract class IOrdenador {

    public Banco banco;
    protected long intercambios;
    public long[] elementos;

    protected long comparaciones;
    protected long tiempoMs;
    protected long tiempoCpuMs;
    
    protected static final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    public long getTiempoCpuMs() {
		return tiempoCpuMs;
	}

	public void setTiempoCpuMs(long tiempoCpuMs) {
		this.tiempoCpuMs = tiempoCpuMs;
	}


    public IOrdenador(Banco banco) {
        this.banco = banco;
    }
    //TODO: posible memoty leak y revisar funcionalidad
    public long[] getAtributos(String atributo) {

        int acumTamano = 0;

        for(int i = 0; i < this.banco.getOcupados(); i++) {
            acumTamano += (int) this.banco.buscar(i).getAtributos(atributo).length;
        } 

        long[] acum = new long[acumTamano];
        int pos = 0;
        for (int i = 0; i < this.banco.getOcupados(); i++) {
            Candidato candidato = this.banco.buscar(i);
            System.arraycopy(candidato.getAtributos(atributo), 0 , acum, pos, candidato.getAtributos(atributo).length);
            pos += candidato.getAtributos(atributo).length;
        }
        return acum;
    }

    //TODO: posible memory leak
    public long verficarData(long[] data) {
        long anterior = data[0];
        long contador = 0;

        for (int i = 1; i < data.length; i++) {
            long actual = data[i];
            if (actual < anterior) {
                contador++;
            }
            anterior = actual; 
        }
        return contador; 
    }

    public long getIntercambios() {
		return intercambios;
	}

	public void setIntercambios(int intercambios) {
		this.intercambios = intercambios;
	}

    public abstract void ordenar(String atributo);

	public long getComparaciones() {
		return comparaciones;
	}

	public void setComparaciones(long comparaciones) {
		this.comparaciones = comparaciones;
	}

	public long getTiempoMs() {
		return tiempoMs;
	}

	public void setTiempoMs(long tiempoMs) {
		this.tiempoMs = tiempoMs;
	}
    
}
