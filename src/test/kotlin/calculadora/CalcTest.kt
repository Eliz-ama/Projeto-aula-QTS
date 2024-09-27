import com.example.Calculadora.divide
import com.example.Calculadora.multiply
import com.example.Calculadora.subtract
import com.example.Calculadora.sum
import kotlin.test.*

class CalcTest {

    @Test
    fun testSum(){
        assertEquals(4.0, sum(1.0,3.0))
    }

    @Test
    fun testSub(){
        assertEquals(2.0, subtract(4.0,2.0))
    }

    @Test
    fun testDiv(){
        assertEquals(5.0, divide(10.0,2.0))
    }

    @Test
    fun testMult(){
        assertEquals(10.0, multiply(5.0,2.0))
    }
}