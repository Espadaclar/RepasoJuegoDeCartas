
/**
 *)
 */
public class Jugador
{
    // instance variables - replace the example below with your own
    private String name;
    private Carta[] cartasDelJugador;
    
    private static final int NUM_CARTAS = 5;
    /**
     * structor debe admitir el nombre del jugador como parámetro. 
     */
    public Jugador(String name){
        this.name = name;
    }
    
    public void recibirCarta(Carta nuevaCarta){
        boolean encontrado = false;
        int cont = 0;
        while(cont < NUM_CARTAS && !encontrado){
            if(cartasDelJugador[cont] == null){
                cartasDelJugador[cont] = nuevaCarta;
                encontrado = true;
            }
            cont ++;
        }
    }

    /**
     * - Exista un nuevo método que sea tirarCarta. Admite un parámetro String que indica el nombre de la carta a tirar.
     * El método muestra por pantalla el nombre del jugador que ha tirado la carta y la carta tirada. Devuelve la carta
     * tirada. En caso de que el jugador no tenga cartas o de que el nombre especificado como parámetro no coincida con
     * ninguna carta, devuelve null.
     */
    public Carta tirarCarta(String nameCarta){
        Carta cartaTirada = null;
        int cont = 0;
        boolean encontrada = false;
        while(cont < cartasDelJugador.length && !encontrada){
            if( cartasDelJugador[cont] != null && cartasDelJugador[cont].toString().equals(nameCarta) ){
                cartaTirada = cartasDelJugador[cont];
                cartasDelJugador[cont] = null;
                encontrada = true;
            }
            cont ++;
        }
        if(cartaTirada != null){
            System.out.print( name+ " ha jugado " +cartaTirada);
        }
        return cartaTirada;
    }
    
    public String getNameJugador(){
        return name;
    }

    public void verCartasJugador(){
        for(Carta carta: cartasDelJugador){
            if(carta != null){
                System.out.println(carta);
            }            
        }
    }

    public void zzVerCartas(){
        for(Carta carta: cartasDelJugador){
            if(carta != null){
                System.out.print(" " +carta+ ",");
            }
        }
    }

}


