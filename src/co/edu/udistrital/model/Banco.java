package model;

/**
 * La clase Banco representa una colección de objetos de tipo Candidato.
 * Permite añadir, eliminar, buscar, mover y mostrar candidatos almacenados en un arreglo.
 * 
 * <p>
 * Características principales:
 * <ul>
 *   <li>Gestión de un arreglo de candidatos con tamaño fijo.</li>
 *   <li>Control de la cantidad de posiciones ocupadas.</li>
 *   <li>Métodos para añadir, eliminar, buscar y mover candidatos dentro del banco.</li>
 *   <li>Advertencia: algunos métodos pueden causar fugas de memoria si no se usan correctamente.</li>
 * </ul>
 * </p>
 * 
 * <p>
 * Uso típico:
 * <pre>
 *     Banco banco = new Banco(10);
 *     banco.añadir(new Candidato(...));
 *     banco.eliminar(0);
 *     banco.mover(1, 2);
 *     String lista = banco.mostrar();
 * </pre>
 * </p>
 * 
 * @author Juan Nicolas Diaz <jndiazs@udistrital.edu.co>
 * @version 1.0
 */

	public class Banco {

		/**
		 * La clase Banco representa una colección de objetos Candidato con un tamaño fijo.
		 * Permite añadir, eliminar, buscar, mover y mostrar candidatos dentro del banco.
		 */

		private Candidato[] candidatos;
		private int tamano;
		private int ocupados;
		
		/**
		 * Constructor de la clase Banco.
		 * 
		 * @param tamano el tamaño máximo del banco de candidatos.
		 */
		public Banco(int tamano) {
			this.tamano = tamano;
			this.ocupados = 0;
			candidatos = new Candidato[tamano];
		}

		/**
		 * Añade un candidato al banco si hay espacio disponible.
		 * 
		 * @param x el candidato a añadir.
		 * @return true si el candidato fue añadido exitosamente, false si el banco está lleno.
		 */
		public boolean añadir(Candidato x) {
			if( this.ocupados < this.tamano) {
				this.candidatos[this.ocupados] = x;
				this.ocupados++;
				return true;
			}
			return false;
		}

		/**
		 * Obtiene el tamaño máximo del banco.
		 * 
		 * @return el tamaño máximo del banco.
		 */
		public int getTamano() {
			return tamano;
		}

		/**
		 * Obtiene la cantidad de posiciones ocupadas en el banco.
		 * 
		 * @return el número de candidatos actualmente en el banco.
		 */
		public int getOcupados() {
			return this.ocupados;
		}

		/**
		 * Elimina el candidato en la posición especificada.
		 * 
		 * @param posicion la posición del candidato a eliminar.
		 * @deprecated Posible fuga de memoria, no usar.
		 */
		public void eliminar(int posicion) {
			if(posicion >= 0 && posicion <= this.ocupados) {
				this.candidatos[posicion] = null;
				this.ocupados--;
				for(int i = posicion; i < this.ocupados; i++) {
					this.candidatos[i] = this.candidatos[i+1];
				}
			}
		}

		public Candidato buscar(int posicion) {
			if(posicion >= 0 && posicion <= this.ocupados) {
				return this.candidatos[posicion];
			}
			return null;
		}

		public Candidato getById(int id) {
			Candidato candidato = null;
			for(int i = 0; i < this.ocupados; i++) {
				if(this.candidatos[i].getId() == id) {
					candidato = this.candidatos[i];
					break;
				}
			}
			return candidato;
		}

		/**
		 * Intercambia los candidatos entre dos posiciones especificadas.
		 * 
		 * @param posicionVieja la posición original del candidato.
		 * @param posicionNueva la nueva posición a la que se moverá el candidato.
		 */
		public void mover(int posicionVieja, int posicionNueva) {
			if(posicionVieja >= 0 && posicionVieja <= this.ocupados && posicionNueva >= 0 && posicionNueva <= this.ocupados) {
				Candidato temp = this.candidatos[posicionVieja];
				this.candidatos[posicionVieja] = this.candidatos[posicionNueva];
				this.candidatos[posicionNueva] = temp;
			}
		}

		/**
		 * Muestra una representación en cadena de los candidatos almacenados en el banco.
		 * 
		 * @return una cadena con la información de todos los candidatos en el banco.
		 */
		public String mostrar() {
			String acum = "";
			for (int i = 0; i < this.ocupados; i++) {
				acum += Integer.toString(i) + " " + this.candidatos[i] + "\n";
			}
			return acum;
		}
	}
