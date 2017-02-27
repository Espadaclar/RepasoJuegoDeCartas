
/**
 * Write a description of class Carta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carta
{

    private int valor;
    private Palo palo;

    public Carta(int valor, Palo palo) {
        this.valor = valor;
        this.palo = palo;
    }

    /**
     * mt devuelven el valor de los atributos
     */
    public int getValor(){
        return valor;
    }
    public Palo getPalo(){
        return palo;
    }
    
    /**
     * devuelve el nombre de la carta
     */
    public String toString(){
        
        String cadena = String.valueOf(valor);
         
        if(valor == 1){
            cadena = "as ";
        }
        else if(valor == 10){
            cadena = "sota ";
        }
        else if(valor == 11){
            cadena = "caballo ";
        }
        else if(valor == 12){
            cadena = "rey ";
        }
        
        return  cadena+ " de " +palo.toString().toLowerCase();
    }
}





















