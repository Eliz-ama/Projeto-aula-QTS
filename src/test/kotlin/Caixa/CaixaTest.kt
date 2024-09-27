import kotlin.test.*
import com.example.Caixa.ContaBancaria

class CaixaTest {

    @Test
    fun testCriarConta() {
        val conta = ContaBancaria(12345, 100.0)
        assertEquals(12345, conta.numeroConta)
        assertEquals(100.0, conta.consultarSaldo())
    }

    @Test
    fun testConsultarSaldo() {
        val conta = ContaBancaria(12345, 200.0)
        assertEquals(200.0, conta.consultarSaldo())
    }

    @Test
    fun testDepositar() {
        val conta = ContaBancaria(12345, 100.0)
        conta.depositar(50.0)
        assertEquals(150.0, conta.consultarSaldo())
    }

    @Test
    fun testSacarComSucesso() {
        val conta = ContaBancaria(12345, 100.0)
        val resultado = conta.sacar(50.0)
        assertEquals(50.0, conta.consultarSaldo())
        assertEquals(50.0, resultado) // Saque bem-sucedido
    }

    @Test
    fun testSacarSaldoInsuficiente() {
        val conta = ContaBancaria(12345, 50.0)
        val resultado = conta.sacar(100.0)
        assertEquals(50.0, conta.consultarSaldo()) // Saldo não mudou
        assertEquals(0.0, resultado) // Saque falhou
    }
}
