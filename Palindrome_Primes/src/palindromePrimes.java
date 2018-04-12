public class palindromePrimes {

	static final int TOTAL_PRIMES_TO_FIND = 100;	
	static final int PRIMES_SHOWN_PER_LINE = 10;		
	
	public static void main(String[] args) 
	{
		int lastPrimeFound;				
		int count;						
		
		System.out.println("Here are the first 100 palindrome prime numbers:  ");
		System.out.printf("%8d%8d", 2,3);	
		lastPrimeFound = 3;						
		
		for (count = 2; count < TOTAL_PRIMES_TO_FIND; )
		{
			++count;											
			lastPrimeFound = getNextPrime(lastPrimeFound);		
			System.out.printf("%8d", lastPrimeFound);			
			if (count % PRIMES_SHOWN_PER_LINE == 0)
				System.out.printf("\n");	
		}
	}

	
	
	private static int getNextPrime(int primeJustFound)
	{
		int candidate;		
		
		candidate = primeJustFound + 2;
		while (!isPrime(candidate) || !isPalindrome(candidate)) 
		{
			candidate += 2;
		}
		
		return candidate;
	}
	
		
	private static boolean isPrime(int possiblePrime)
	{
		boolean factorFound = false;						
		double limit = Math.sqrt(possiblePrime);		
		int possibleFactor;									
		possibleFactor = 3;										while (possibleFactor <= limit && !factorFound)	
		{
			if (possiblePrime % possibleFactor == 0)					  
                                                factorFound = true;
			else
				possibleFactor+=2;}
		return !factorFound;
		}
		
		private static boolean isPalindrome(int testValue)
		{
			int reversedNumber;				
			int generatorForReversedNumber;	
			int nextDigit;					
			
			reversedNumber = 0;				
			generatorForReversedNumber = testValue;
			while (generatorForReversedNumber > 0)
			{
				nextDigit = generatorForReversedNumber % 10;
				reversedNumber = 10 * reversedNumber + nextDigit;
				generatorForReversedNumber /= 10;
			}
			
			return testValue == reversedNumber;
		}
		
}
