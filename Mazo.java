import java.util.ArrayList;
import java.util.Random;
/**
 *
 */
public class Mazo
{
    // instance variables - replace the example below with your own
    private ArrayList<Carta> cartasBaraja;
    private Palo palo;

    public static final int CARTAS_BARAJA = 40;
    /**
     * Constructor for objects of class Mazo
     */
    public Mazo()
    {
        cartasBaraja = new ArrayList<>();
        for(Palo paloActual: Palo.values()){           
            String palo = paloActual.toString().toLowerCase();
            for(int i = 1; i < 13; i ++){

                if(i > 7 && i < 10){
                    i = 10;
                }
                Carta carta =  new Carta(i, paloActual);
                cartasBaraja.add(carta);
            }
        }
    }

    /**
     *muestra linea a linea todas los nombres de las cartas existentes en el mazo
     */
    public void  verCartasDelMazo(){
        for(Carta carta: cartasBaraja){
            System.out.println(carta);
        }
    }

    /**
     *no devuelva nada y consiga mezclar las cartas existentes en ese momento en el mazo.
     */
    public void barajar(){
        Random ale = new Random();
        if(CARTAS_BARAJA == getNumCartas()){
            for(int i = 0; i < 777; i ++){
                int valor = ale.nextInt(40);
                Carta carta = cartasBaraja.get(valor);
                cartasBaraja.set(valor, cartasBaraja.get(0));
                cartasBaraja.set(0, carta);
            }
        }
    }

    /**
     *devuelva un objeto Carta. Concretamente debe devolver la primera carta del mazo, eliminando esta del mazo.
     */
    public Carta sacarCarta(){
        Carta nuevaCarta = null;
        nuevaCarta = cartasBaraja.remove(0);
        return nuevaCarta;
    }

    /**
     * retorna el nº de cartas que quedan en la  baraja.
     */
    public int getNumCartas(){
        return cartasBaraja.size();
    }
}




