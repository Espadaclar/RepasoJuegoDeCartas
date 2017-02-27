import java.util.Random;
/**
 * 
 */
public class Juego
{
    private int numJugadores;
    private Mazo mazo;
    private Jugador[] jugador;
    private String jugadorHumano;
    //
    private Carta cartaDeTriunfo;

    private static final int CARTAS_POR_JUGADOR = 5;
    private static String[] NAME_JUGADORES = {"Luis", "Raquel","Juán", "Francisco Javier", "Lorenzo", "Israel", "Cristian", "Ricardo", "Emilio", "José Ricardo",
            "Luis Enrique", "Luis Federico", "Mario", "Nasrrudín", "José Manuel", "Aquiles", "Merquiades", "Francisco José",
            "Narciso", "Gregorio", "Isidoro", "Raquel", "María", "Milagros", "Eva Carmina", "Jacinta", "Blas", "Fulgencio",
            "Salusitano", "Elena", "Gemma", "Fermín", "Amancio", "Esther", "Ángela"};
    /**
     * Class Juego crea entre 3 y 5 jugadores, por defecto creará 4 
     * - El constructor admita como segundo parametro el nombre del jugador humano. Además debe mostrar por pantalla
     * un mensaje de bienvenida y el nombre de cada uno de los jugadores de la partida (incluyendo el humano) .
     */
    public Juego(int numJugadores, String jugadorHumano)
    {
        this.numJugadores = (numJugadores < 3 || numJugadores > 5) ? 4 : numJugadores;
        this.jugadorHumano = jugadorHumano;
        mazo = new Mazo();
        jugador = new Jugador[numJugadores];
        cartaDeTriunfo = null;

        for(int i = 1; i < numJugadores; i ++){
            Random ale = new Random();
            int nombreA = ale.nextInt(NAME_JUGADORES.length);
            if(NAME_JUGADORES[nombreA] != null && NAME_JUGADORES[nombreA] != jugadorHumano){
                //en la 1º posición del Array se coloca al jugadorHumano.
                jugador[0] = new Jugador(jugadorHumano);
                jugador[i] = new Jugador(NAME_JUGADORES[nombreA]);
                NAME_JUGADORES[nombreA] = null;
            }
        }

        darBienVenida();
    }

    /**
     * reparte para cada jugador el nº de cartas señalado en la constate CARTAS_POR_JUGADOR:
     * 
     * que coja el mazo y de 5 cartas a los jugadores creados. La entrega de cartas debe ser al estilo del 
     * reparto que se hace en la realidad, es decir, primero se baraja y luego se entrega una carta a cada jugador.
     * La última carta entregada indica el palo que pinta, que debe registrarse de alguna foma.
     * 
     * El metodo repartir debe mostrar por pantalla el palo que pinta con un mensaje del tipo "Pintan bastos"
     * o "Pintan oros" y debe devolver el número asociado con el palo que pinta. Además debe mostrar por pantalla 
     * las cartas que recibe el jugador humano. );
     */
    public void repartir(){
        mazo.barajar();
        for(int i = 0; i < CARTAS_POR_JUGADOR; i ++){
            for(int pi = 0; pi < jugador.length; pi ++){
                Carta carta =  mazo.sacarCarta();
                jugador[pi].recibirCarta(carta);
                cartaDeTriunfo = carta; //almacena la última carta repartida, de ella sacamos el palo que pinta.
            }
        }
        System.out.println("Cartas de " + jugador[0].getNameJugador());
        jugador[0].zzVerCartas();
        System.out.println("");
        System.out.println("Pintan " +cartaDeTriunfo.getPalo().toString().toLowerCase());
        System.out.println("");
    }

    /**
     * muestra las cartas del jugador pasando su nombre en el parámetro
     */
    public void hacerTrampasYVerCartasDeJugador(String nameJugador){
        int cont = 0;
        boolean encontrado = false;
        while(cont < numJugadores && !encontrado){
            if(jugador[cont].getNameJugador().equals(nameJugador)){
                jugador[cont].verCartasJugador();
                encontrado = true;
            }
        }
    }

    /**
     * muestra las cartas de todos los jugador es.
     */
    public void zzzVerCartasTodosLosJugadores(){  
        int cont = 0;
        while(cont < numJugadores){
            String nameJ = jugador[cont].getNameJugador();
            System.out.println("\nCartas de:_ " +nameJ+ ".");
            jugador[cont].zzVerCartas();                
            cont ++;
        }
    }

    ////////////////////////////////////// ******************************** MT. PRIVADOS.
    //////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * muestra nombre de jugadores
     */
    private void mostrarNombreJugadores(){
        for(Jugador jugadores: jugador){
            if(jugadores != null){
                System.out.println(jugadores.getNameJugador());
            }
        }
    }

    /**
     * muestra en el constructor un mensaje de bienVendida junto con el nombre de los jugadores.
     */
    private void darBienVenida(){
        System.out.println("Bien venidos a la partida.");
        System.out.println("Nombre del jugador Humano.- " +jugadorHumano+ ".");
        System.out.println("-----------Nombre de todos los jugadores.- ");
        mostrarNombreJugadores();  
        System.out.println("");
    }

}










