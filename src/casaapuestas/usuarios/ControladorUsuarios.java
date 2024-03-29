package casaapuestas.usuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import casaapuestas.cuentas.ExcepcionCuenta;


/**
 * Clase controladora que recibe los m�todos provenientes de la UI relacionados con la gesti�n de usuarios
 * 
 * @author Eduardo G�mez S�nchez, ETSIT UVa.
 */
public class ControladorUsuarios {
	/**
	 * Lista de los jugadores existentes en el sistema, indexada por su login o identificador de usuario (que por lo tanto debe ser �nico)
	 */
	private Map<String, Jugador> listaJugadores;
	private Map<String, Administrador> listaAdministradores;

	/**
	 * Constructor que inicializa las colecciones
	 */
	public ControladorUsuarios() {
		super();
		// Inicializa las colecciones
		listaJugadores = new HashMap<String, Jugador>();
		listaAdministradores = new HashMap<String, Administrador>();
	}

	/**
	 * M�todo que crea una nueva instancia de <code>Jugador</code> y la colecciona, indexada por el <code>login</code>
	 * 
	 * @param login el login, o identificador �nico de usuario
	 * @param clave la clave del usuario (en claro)
	 * @param nombre el nombre del usuario
	 * @param apellidos los apellidos del usuario
	 * @param nif el NIF del usuario
	 * @param movil el n�mero de tel�fono del usuario
	 * @param correo la direcci�n de correo del usuario
	 * @param metodo el m�todo de mensajer�a preferido por el usuario
	 * @throws ExcepcionUsuario si ya existe un usuario con este <code>login</code>
	 */
	public void crearJugador(String login, String clave, String nombre, String apellidos, String nif, String movil, String correo, MetodoMensajeria metodo)
			throws ExcepcionUsuario {
		// Comprueba si ya existe un jugador con este login
		if (!listaJugadores.containsKey(login)) {
			// Si no existe, crea la instancia
			Jugador nuevoJugador = new Jugador(login, clave, nombre, apellidos, nif, movil, correo, metodo);
			// Y la colecciona
			listaJugadores.put(login, nuevoJugador);
		} else {
			// Pero si ya exist�a lanza una excepci�n
			throw new ExcepcionUsuario(CausaExcepcionUsuario.YA_EXISTE, login);
		}
	}
	
	public void crearAdministrador(String login, String clave, String nombre, String apellidos, String nif, String movil, String correo, MetodoMensajeria metodo)
			throws ExcepcionUsuario {
		// Comprueba si ya existe un jugador con este login
		if (!listaAdministradores.containsKey(login)) {
			// Si no existe, crea la instancia
			Administrador nuevoAdministrador = new Administrador(login, clave, nombre, apellidos, nif, movil, correo, metodo);
			// Y la colecciona
			listaAdministradores.put(login, nuevoAdministrador);
		} else {
			// Pero si ya exist�a lanza una excepci�n
			throw new ExcepcionUsuario(CausaExcepcionUsuario.YA_EXISTE, login);
		}
	}



	/**
	 * M�todo que permite mostrar toda la informaci�n de una instancia de <code>Jugador</code> dada por un determinado <code>login</code>
	 * 
	 * @param login login el login, o identificador �nico de usuario
	 * @return una cadena con toda la informaci�n del usuario buscado
	 * @throws ExcepcionUsuario si no existe un usuario con este <code>login</code>
	 */

	
	public String mostrarJugador(String login) throws ExcepcionUsuario {
		// Recupera la instancia de la colecci�n
		Jugador esteJugador = listaJugadores.get(login);
		// Si este jugador exist�a, no es null
		if (esteJugador != null) {
			// Le pide al jugador que muestre su informaci�n completa
			return esteJugador.verFichaCompleta();
		} else {
			// Pero si no exist�a lanza una excepci�n
			throw new ExcepcionUsuario(CausaExcepcionUsuario.NO_EXISTE, login);
		}
	}
	
	public String mostrarAdministrador(String login) throws ExcepcionUsuario {
		// Recupera la instancia de la colecci�n
		Administrador esteAdministrador = listaAdministradores.get(login);
		// Si este jugador exist�a, no es null
		if (esteAdministrador != null) {
			// Le pide al jugador que muestre su informaci�n completa
			return esteAdministrador.verFichaCompleta();
		} else {
			// Pero si no exist�a lanza una excepci�n
			throw new ExcepcionUsuario(CausaExcepcionUsuario.NO_EXISTE, login);
		}
	}
	/**
	 * M�todo que modifica una instancia de <code>Jugador</code> dada por un determinado <code>login</code>
	 * 
	 * @param login el login, o identificador �nico de usuario (no se puede modificar)
	 * @param clave la clave del usuario (en claro)
	 * @param nombre el nombre del usuario
	 * @param apellidos los apellidos del usuario
	 * @param nif el NIF del usuario
	 * @param movil el n�mero de tel�fono del usuario
	 * @param correo la direcci�n de correo del usuario
	 * @param metodo el m�todo de mensajer�a preferido por el usuario
	 * @throws ExcepcionUsuario si no existe un usuario con este <code>login</code>
	 */
	public void modificarJugador(String login, String clave, String nombre, String apellidos, String nif, String movil, String correo, MetodoMensajeria metodo)
			throws ExcepcionUsuario {
		// Recupera la instancia de la colecci�n
		Jugador esteJugador = listaJugadores.get(login);
		// Si este jugador exist�a, no es null
		if (esteJugador != null) {
			// Modifica uno a uno los otros atributos
			esteJugador.setClave(clave);
			esteJugador.setNombre(nombre);
			esteJugador.setApellidos(apellidos);
			esteJugador.setNif(nif);
			esteJugador.setMovil(movil);
			esteJugador.setCorreo(correo);
			esteJugador.setMetodo(metodo);
		} else {
			// Pero si no exist�a lanza una excepci�n
			throw new ExcepcionUsuario(CausaExcepcionUsuario.NO_EXISTE, login);
		}
	}
	
	public void modificarAdministrador(String login, String clave, String nombre, String apellidos, String nif, String movil, String correo, MetodoMensajeria metodo)
			throws ExcepcionUsuario {
		// Recupera la instancia de la colecci�n
		Administrador esteAdministrador = listaAdministradores.get(login);
		// Si este jugador exist�a, no es null
		if (esteAdministrador != null) {
			// Modifica uno a uno los otros atributos
			esteAdministrador.setClave(clave);
			esteAdministrador.setNombre(nombre);
			esteAdministrador.setApellidos(apellidos);
			esteAdministrador.setNif(nif);
			esteAdministrador.setMovil(movil);
			esteAdministrador.setCorreo(correo);
			esteAdministrador.setMetodo(metodo);
		} else {
			// Pero si no exist�a lanza una excepci�n
			throw new ExcepcionUsuario(CausaExcepcionUsuario.NO_EXISTE, login);
		}
	}

	/**
	 * M�todo que permite borrar una instancia de <code>Jugador</code> dada por un determinado <code>login</code>
	 * 
	 * @param login el login, o identificador �nico de usuario
	 * @throws ExcepcionUsuario si no existe un usuario con este <code>login</code>
	 */
	public void eliminarJugador(String login) throws ExcepcionUsuario {
		// Borra la instancia de la colecci�n
		Jugador esteJugador = listaJugadores.remove(login);
		// Si este jugador es null es que no exist�a, as� que podemos informar de que no lo hemos borrado (porque no exist�a)
		if (esteJugador == null) {
			throw new ExcepcionUsuario(CausaExcepcionUsuario.NO_EXISTE, login);
		}
	}
	
	public void eliminarAdministrador(String login) throws ExcepcionUsuario {
		// Borra la instancia de la colecci�n
		Administrador esteAdministrador = listaAdministradores.remove(login);
		// Si este jugador es null es que no exist�a, as� que podemos informar de que no lo hemos borrado (porque no exist�a)
		if (esteAdministrador == null) {
			throw new ExcepcionUsuario(CausaExcepcionUsuario.NO_EXISTE, login);
		}
	}

	/**
	 * M�todo que permite obtener una lista de cadenas, cada una con informaci�n breve de cada instancia de <code>Jugador</code> coleccionada por este
	 * controlador.
	 * 
	 * @return Una lista de cadenas
	 */

	
	public List<String> listarJugadores() {
		// Inicializa la lista
		List<String> listado = new ArrayList<String>();

		// Recorre la colecci�n de jugadores
		for (Jugador j : listaJugadores.values()) {
			// A cada jugador le pide informaci�n breve
			String ficha = j.verFichaBreve();
			// Y la a�ade al listado
			listado.add(ficha);
		}

		// Al terminar retorna el listado
		return listado;
	}
	
	public List<String> listarAdministrador() {
		// Inicializa la lista
		List<String> listado = new ArrayList<String>();

		// Recorre la colecci�n de jugadores
		for (Administrador ad : listaAdministradores.values()) {
			// A cada jugador le pide informaci�n breve
			String ficha = ad.verFichaBreve();
			// Y la a�ade al listado
			listado.add(ficha);
		}

		// Al terminar retorna el listado
		return listado;
	}
	
	/**
	 * M�todo que permite realizar un ingreso de una <code>cantidad</code> de dinero en la cuenta del jugador identificado por el <code>login</code>
	 * 
	 * @param login el login, o identificador �nico de usuario
	 * @param cantidad la cantidad a ingresar en la cuenta (positiva)
	 * @throws ExcepcionUsuario si el usuario no existe
	 */
	public void realizarIngresoEnCuentaJugador(String login, float importe) throws ExcepcionUsuario	{
		// Recupera la instancia de la colecci�n
		Jugador esteJugador = listaJugadores.get(login);
		// Si este jugador exist�a, no es null
		if (esteJugador != null) {
			// As� que delegamos en �l que realice el ingreso
			esteJugador.realizarIngreso("Ingreso en efectivo por el usuario " + login, importe);
			
		} else {
			// Pero si no exist�a lanza una excepci�n
			throw new ExcepcionUsuario(CausaExcepcionUsuario.NO_EXISTE, login);
		}
		
	}
	
	/**
	 * M�todo que permite realizar un ingreso de una <code>cantidad</code> de dinero en la cuenta de la casa de apuestas identificado por el <code>login</code>
	 * 
	 * @param login el login, o identificador �nico de usuario
	 * @param cantidad la cantidad a ingresar en la cuenta (positiva)
	 * @throws ExcepcionUsuario si el usuario no existe
	 */
	public void realizarIngresoEnCasaApuestas(String login, float cantidad) throws ExcepcionUsuario {
		// Recupera la instancia de la colecci�n
		Administrador esteAdministrador = listaAdministradores.get(login);
		CasaApuestas casaApuestas=CasaApuestas.getInstance();
		// Si este jugador exist�a, no es null
		if (esteAdministrador != null) {
			// As� que delegamos en �l que realice el ingreso
			casaApuestas.realizarIngreso("Ingreso en efectivo por el usuario " + login, cantidad);
		} else {			
			// Pero si no exist�a lanza una excepci�n
			throw new ExcepcionUsuario(CausaExcepcionUsuario.NO_EXISTE, login);
		}
	}


	/**
	 * M�todo que permite realizar un reintegro de una <code>cantidad</code> de dinero en la cuenta de la casa de apuestas identificado por el <code>login</code>
	 * 
	 * @param login el login, o identificador �nico de usuario
	 * @param cantidad la cantidad a ingresar en la cuenta (positiva)
	 * @throws ExcepcionUsuario si el usuario no existe
	 */
	public void realizarReintegroDesdeCuentaCasaApuestas(String login, float cantidad)  throws ExcepcionUsuario, ExcepcionCuenta {
		// Recupera la instancia de la colecci�n
		Administrador esteAdministrador = listaAdministradores.get(login);
		CasaApuestas casaApuestas=CasaApuestas.getInstance();
		// Si este jugador exist�a, no es null
		if (esteAdministrador != null) {
			//Nos aseguramos de que nadie que no sea el administrador puede modificar la cuenta de la casa de apuestas

				// As� que delegamos en �l que realice el ingreso (ojo, este m�todo lanza una excepci�n)
			casaApuestas.realizarReintegro("Reintegro en efectivo por el usuario " + login, cantidad);
		
			
		} else {
			// Pero si no exist�a lanza una excepci�n
			throw new ExcepcionUsuario(CausaExcepcionUsuario.NO_EXISTE, login);
		}
	}


	/**
	 * M�todo que permite realizar un reintegro de una <code>cantidad</code> de dinero desde la cuenta del jugador identificado por el <code>login</code>
	 * 
	 * @param login el login, o identificador �nico de usuario
	 * @param cantidad la cantidad a reintegrar desde la cuenta (positiva)
	 * @throws ExcepcionUsuario si el usuario no existe
	 * @throws ExcepcionCuenta si la cuenta no tiene saldo suficiente para reintegrar dicha cantidad
	 */
	public void realizarReintegroDesdeCuentaJugador(String login, float cantidad) throws ExcepcionUsuario, ExcepcionCuenta 
	{
		// Recupera la instancia de la colecci�n
		Jugador esteJugador = listaJugadores.get(login);
		// Si este jugador exist�a, no es null
		if (esteJugador != null) {
			// As� que delegamos en �l que realice el ingreso (ojo, este m�todo lanza una excepci�n)
			esteJugador.realizarReintegro("Reintegro en efectivo por el usuario " + login, cantidad);
		} else {
			// Pero si no exist�a lanza una excepci�n
			throw new ExcepcionUsuario(CausaExcepcionUsuario.NO_EXISTE, login);
		}
	}
	
	/**
	 * M�todo que permite ver el saldo en la cuenta del jugador identificado por el <code>login</code>
	 * @param login el login, o identificador �nico de usuario
	 * @return el saldo en la cuenta del jugador
	 * @throws ExcepcionUsuario si el usuario no existe
	 */
	public float verSaldoJugador(String login) throws ExcepcionUsuario 	{
		// Recupera la instancia de la colecci�n
		Jugador esteJugador = listaJugadores.get(login);
		// Si este jugador exist�a, no es null
		if (esteJugador != null) {
			// As� que delegamos en �l que nos informe de su saldo
			return esteJugador.verSaldo();
		} else {
			// Pero si no exist�a lanza una excepci�n
			throw new ExcepcionUsuario(CausaExcepcionUsuario.NO_EXISTE, login);
		}
	}
	
	public float verSaldoCasaApuestas(String login) throws ExcepcionUsuario 
	{
		// Recupera la instancia de la colecci�n
		Administrador esteAdministrador = listaAdministradores.get(login);
		CasaApuestas casaApuestas=CasaApuestas.getInstance();
		// Si este jugador exist�a, no es null
		if (esteAdministrador != null) {
			//System.out.println(esteJugador.getLogin());
			// As� que delegamos en �l que nos informe de su saldo
			return casaApuestas.verSaldo();
		} else {
			// Pero si no exist�a lanza una excepci�n
			throw new ExcepcionUsuario(CausaExcepcionUsuario.NO_EXISTE, login);
		}		

	}
	
	/**
	 * M�todo que permite obtener un listado de los movimientos de cuenta del jugador identificador por el  <code>login</code>
	 * @param login el login, o identificador �nico de usuario
	 * @return una lista de cadenas, donde cada elemento corresponde a un movimiento
	 * @throws ExcepcionUsuario si el usuario no existe
	 */
	public List<String> listarMovimientosCuentaJugador(String login) throws ExcepcionUsuario {
		// Recupera la instancia de la colecci�n
		Jugador esteJugador = listaJugadores.get(login);
		// Si este jugador exist�a, no es null
		if (esteJugador != null) {
			// As� que delegamos en �l que nos informe de sus movimientos
			return esteJugador.listarMovimientosCuenta();
		} else {
			// Pero si no exist�a lanza una excepci�n
			throw new ExcepcionUsuario(CausaExcepcionUsuario.NO_EXISTE, login);
		}
	}
	
	public List<String> listarMovimientosCasaApuestas(String login) throws ExcepcionUsuario 
	{
		// Recupera la instancia de la colecci�n
		Administrador esteAdministrador = listaAdministradores.get(login);
		CasaApuestas casaApuestas=CasaApuestas.getInstance();
		// Si este jugador exist�a, no es null
		if (esteAdministrador != null) {
			// As� que delegamos en �l que nos informe de sus movimientos
			return casaApuestas.listarMovimientosCuenta();
		} else {
			// Pero si no exist�a lanza una excepci�n
			throw new ExcepcionUsuario(CausaExcepcionUsuario.NO_EXISTE, login);
		}
	}
	
	/**
	 * M�todo que permite obtener todos los datos sobre un equipo <code>Equipo</code> coleccionada por este
	 * controlador.
	 * 
	 * @return variable tipo Equipo
	 */	
	public Jugador obtenerJugador(String login) {
		//Devuelve todos los datos de un equipo
		return listaJugadores.get(login);
		
	}
	
}
