import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import net.bytebuddy.asm.Advice.Argument;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;


class TestDemoTest {
	private TestDemo testDemo;

	@BeforeEach
	void setUp() {
	testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
			
	if(!expectException) {
//		     int actual = testDemo.addPositive(a, b);
//		     assertThat(actual).isEqualTo(expected);
			  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
	}  else {
		assertThatThrownBy(() -> 
	    testDemo.addPositive(a, b))
	        .isInstanceOf(IllegalArgumentException.class);
	}
}
	static Stream<Arguments> argumentsForAddPositive(){
		return (Stream.of(
		arguments(2, 4, 6, false),
		arguments(0, 5, 1, true),
		arguments(0, 0, 0, true),
		arguments(2, 0, 6, true)
	));
	}
	
	
	@Test
    void assertThatNumberSquaredIsCorrect() {
    	// Given: two random numbers
//		int a = 2;
//		int b = 8;
//		int expected = 10;
	
		
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		
		// When:
		int fiveSquared = mockDemo.randomNumberSquared();
		
		// Then:
		assertThat(fiveSquared).isEqualTo(25);
    }

}
