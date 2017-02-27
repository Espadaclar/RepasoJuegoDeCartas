

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class JugadorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class JugadorTest
{
    private Carta carta1_1copas;
    private Carta carta1_3oros;
    private Carta carta1_5bastos;
    private Carta carta1_3espadas;
    private Carta carta1_1espadas;

    /**
     * Default constructor for test class JugadorTest
     */
    public JugadorTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        carta1_1copas = new Carta(1, Palo.COPAS);
        carta1_3oros = new Carta(3, Palo.OROS);
        carta1_5bastos = new Carta(5, Palo.BASTOS);
        carta1_3espadas = new Carta(3, Palo.ESPADAS);
        carta1_1espadas = new Carta(1, Palo.ESPADAS);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
