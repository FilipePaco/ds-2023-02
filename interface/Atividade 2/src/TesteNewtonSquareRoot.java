import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestNewtonSquareRoot {

    private static NewtonSquareRoot newton;

    @BeforeAll
    static void setUp() {
        // Inicialize a instância de NewtonSquareRoot antes de executar os testes
        newton = new NewtonSquareRoot();
    }

    @Test
    void testRaizQuadradaPositiva() {
        double resultado = newton.apply(16.0);
        assertEquals(4.0, resultado, 1e-6); // Esperado: 4.0
    }

    @Test
    void testRaizQuadradaNegativa() {
        assertThrows(IllegalArgumentException.class, () -> newton.apply(-16.0));
    }
}
