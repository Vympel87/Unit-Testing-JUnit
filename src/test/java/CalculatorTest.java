import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {
    @BeforeAll
    void methodInisiasi(){
        Calculator calc = new Calculator(12,3);
        System.out.println("Before all dijalankan");
    }
    @BeforeEach
    void tambah()
    {

    }

    @Test
    void PenjumlahanNilaiNegative(){
        Calculator calc = new Calculator(-2, -3);
        int hasil = calc.Penjumlahan();
        assertEquals(-5, hasil);
        assertNotNull(hasil, "Passed");
    }

    @AfterEach
    void perkalian

    @AfterAll
}