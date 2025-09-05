package controller.ordenamiento;

public class Burbuja extends IOrdenador {
    public Burbuja(model.Banco banco) {
        super(banco);
    }

    @Override
    public void ordenar(String atributo) 
    {
    	comparaciones = 0;
        intercambios = 0;
        tiempoMs = 0;
        tiempoCpuMs = 0;

        this.elementos = this.banco.getAtributos(atributo);
        
        long inicioWall = System.nanoTime();
        long inicioCpu = threadMXBean.getCurrentThreadCpuTime();
        
    	
       long valor1, valor2, swap;
       int swapped;

        while(true) 
        {
        	swapped = 0;
        	for (int i = 0; i+1 < this.banco.getOcupados(); i++) 
        	{
        		comparaciones++;
        	
        		valor1 = this.elementos[i];
        		valor2 = this.elementos[i+1];

        		if(valor1 > valor2) {
        			swap = this.elementos[i];
        			this.elementos[i] = this.elementos[i+1];
        			this.banco.mover(i, i+1);
        			this.elementos[i+1] = swap;

        			this.setIntercambios(this.getIntercambios() + 1);
        			swapped++;
        		}
            
        	}
            if (swapped == 0) break;
        }
        
        long finWall = System.nanoTime();
        long finCpu = threadMXBean.getCurrentThreadCpuTime();

        tiempoMs = (finWall - inicioWall) / 1_000_000;
        tiempoCpuMs = (finCpu - inicioCpu) / 1_000_000;
    }
    
}
