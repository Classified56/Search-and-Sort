import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SearchQuizzer implements Comparator<Integer>
	{
		private static ArrayList<Integer> numbers = new ArrayList<Integer>();
		private static Scanner userInput = new Scanner(System.in);
		public static void main(String[] args)
			{
				createArray();
				int mark = chooseNumber();
				System.out.println("\nThe number we are looking for is " + mark);
				test(mark);
				userInput.close();
			}
		
		private static void createArray()
			{
				while(true)
					{
						System.out.print("Input a number between 1-20 ");
						int next = userInput.nextInt();
						if(next <= 20 && next >= 0)
							numbers.add(next);
						else if(next == -1)
							break;
						else
							System.out.println("That number is invalid");
					}
				Collections.sort(numbers, new SearchQuizzer());
			}
		
		private static int chooseNumber()
			{
				int random = (int)(Math.random()*numbers.size());
				return numbers.get(random);
			}
		
		private static void test(long mark)
			{
				System.out.println("The list is " + numbers);
				int left = 0, right = numbers.size() - 1, markSpot = 0, score = 0, counter = 0;
				while(left <= right)
					{
						int middle = (left + right) / 2;
						System.out.print("What is the left? ");
						score += ask(left);
						counter++;
						System.out.print("What is the right? ");
						score += ask(right);
						counter++;
						System.out.print("What is the middle? ");
						score += ask(middle);
						counter++;
						System.out.print("What is the value of the middle? ");
						score += ask(numbers.get(middle));
						counter++;
						if(mark < numbers.get(middle))
							{
								right = middle - 1;
								System.out.println("The values have changed. \n");
							}
						else if(mark > numbers.get(middle))
							{
								left = middle + 1;
								System.out.println("The values have changed. \n");
							}
						else
							{
								markSpot = middle;
								break;
							}
					}
				System.out.println("After finding the mark(" + markSpot + "), your score is " + score + " out of " + counter);
			}
		private static int ask(int num)
			{
				int guess = userInput.nextInt();
				if(guess == num)
					{
						System.out.println("Correct. ");
						return 1;
					}
				else
					{
						System.out.println("The correct answer was " + num);
						return 0;
					}
			}

		@Override
		public int compare(Integer o1, Integer o2)
			{
				if(o1 > o2)
					return 1;
				else if(o1 < o2)
					return -1;
				else
					return 0;
			}

		

	}
