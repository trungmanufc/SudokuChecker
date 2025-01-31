import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
String tooShort = "41736982563215894795872431682543716979158643234691275828964357157329168"; // 80 characters
String tooLong = "4173698256321589479587243168254371697915864323469127582896435715732916841648752931"; // 82 characters
String containsZero = "017369825632158947958724316825437169791586432346912758289643571573291684164875293";
String duplicateInSubgrid = "417369825632158947958724316825437169791586432346912758289643571573291684164875291"; // Modify subgrid to include duplicate
String duplicateInRow = "417369825632158947958724316825437169791586432346912758289643571573291684164875292"; // Modify row to include duplicate
String duplicateInColumn = "417369825632158947958724316825437169791586432346912758289643571573291684164875273"; // Modify column to include duplicate
String veryLongString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293" + 
                         "417369825632158947958724316825437169791586432346912758289643571573291684164875293"; // Over 81 characters
SudokuVerifier v = new SudokuVerifier();

		@Test
		public void testCorrectString() {
			int a = v.verify(c);
			assertEquals("correct string", a, 0);
		}
	
		@Test
		public void testIncorrectString() {
			int a = v.verify(i);
			assertEquals("incorrect string", a, -2);
			
		}
		
	    @Test
	    public void testTooShort() {
	        assertEquals("Too short input should return -1", -1, v.verify(tooShort));
	    }

	    @Test
	    public void testTooLong() {
	        assertEquals("Too long input should return -1", -1, v.verify(tooLong));
	    }

	    @Test
	    public void testContainsZero() {
	        assertEquals("Input containing zero should return -1", -1, v.verify(containsZero));
	    }

	    @Test
	    public void testDuplicateInSubgrid() {
	        assertEquals("Input with duplicate in subgrid should return -2", -2, v.verify(duplicateInSubgrid));
	    }

	    @Test
	    public void testDuplicateInRow() {
	        assertEquals("Input with duplicate in row should return -3", -3, v.verify(duplicateInRow));
	    }

	    @Test
	    public void testDuplicateInColumn() {
	        assertEquals("Input with duplicate in column should return -4", -4, v.verify(duplicateInColumn));
	    }

	    @Test
	    public void testVeryLongString() {
	        assertEquals("Very long input should return -1", -1, v.verify(veryLongString));
	    }	
	
	
}
