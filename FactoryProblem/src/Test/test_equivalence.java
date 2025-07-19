package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.Income;

class test_equivalence {
	Income test;
	
	@BeforeEach
    void setup() {
        test = new Income();
    }
	
	@ParameterizedTest
	@CsvSource({
	"1000, 300, 500, 29000",
	"5000, 800, 3000, 134000"
	})
	void test_strong_robust_equivalence(int blade, int motor, int grille, int expected) {
		assertEquals(expected, test.calculateIncome(blade, motor, grille));
	}

}
