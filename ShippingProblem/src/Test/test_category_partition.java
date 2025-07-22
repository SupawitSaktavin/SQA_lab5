package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import sqa.main.ShippingVehicle;

import java.util.List;
import java.util.stream.Stream;

class test_category_partition {
	ShippingVehicle test;

	@BeforeEach
	void setup() {
		test = new ShippingVehicle();
	}

	@ParameterizedTest
	@MethodSource("shipping_vechicle_testCase")
	void test_category(int small, int medium, int large, List<Integer> expected) {
		assertEquals(expected, test.calculate(small, medium, large));
	}

	static Stream<Arguments> shipping_vechicle_testCase() {
		return Stream.of(
			//valid input
			//no input
			Arguments.of(0, 0, 0, List.of(0, 0, 0)),
			
			//one input
			Arguments.of(0, 0, 99, List.of(99, 0, 0)),
			Arguments.of(0, 199, 0, List.of(0, 199, 0)),
			Arguments.of(499, 0, 0, List.of(0, 0, 499)),
			
			//two input
			Arguments.of(0, 9, 5, List.of(5, 9, 0)),
			Arguments.of(24, 10, 0, List.of(0, 10, 24)),
			
			//three input
			Arguments.of(9, 8, 4, List.of(4, 8, 9)),
			
			//over weight
			//one input
			Arguments.of(0, 0, 101, List.of(-1)),
			Arguments.of(0, 201, 0, List.of(-1)),
			Arguments.of(501, 0, 0, List.of(-1)),
			
			//two input
			Arguments.of(0, 11, 6, List.of(-1)),
			Arguments.of(26, 10, 0, List.of(-1)),
			
			//three input
			Arguments.of(11, 9, 5, List.of(-1)),
			
			//invalid input
			//one input
			Arguments.of(0, 0, -1, List.of(-1)),
			Arguments.of(0, -1, 0, List.of(-1)),
			Arguments.of(-1, 0, 0, List.of(-1)),
			
			//two input
			Arguments.of(0, -1, -1, List.of(-1)),
			Arguments.of(-1, -1, 0, List.of(-1)),
			
			//three input
			Arguments.of(-1, -1, -1, List.of(-1))
		);
	}
}
