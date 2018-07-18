/*!
 *  \author Kendall Haworth
 *	\version 1.0
 *  \date 5/30/2018
 *
 *	\mainpage A Program for Big Numbers
 *	\section intro_section Introduction
 *
 *	A class that can add, subtract, multiply, divide,
 *	and modulus numbers up to 10,000 digits long using vectors.
 *	
 *	If the number ever exceeds 10,000 digits, an exception
 *	is thrown. Exceptions are also thrown for negative numbers,
 *	attempting to modulus by 0, and attempting to divide by 0.
 *
 *	\subsection notes Additional Notes
 *
 *	The BigNumbers class cannot handle negative numbers. Input validation
 *  is not performed within the class, so it is the responsibility of the
 *	user to ensure that they have not inserted negative parameters into
 *	any of the operator overloads or methods.
 *
 *  However, checks are performed to ensure that any operator overload
 *	or method does not return a negative number, return a number over 10,000
 *	digits, or attempt an operation that is impossible (such as divide by 0).
*/

#include <vector>
#include <string>
#include <iostream>
#include <math.h>
using namespace std;

/*!
 * \class BigNumbers
 * \brief A class that can hold and perform operations on numbers up to 10,000 digits.
*/
class BigNumbers
{
	private:
		vector<int> numbers; //!< A private vector to hold the class's numbers.
		
	public:
		
		/*!
		 * \brief A class to throw an exception if the number of digits ever exceeds 10,000.
		 */
		class NumberOverflowException{};
		
		/*!
		 * \brief A class to throw an exception if the result would leave the number negative.
		 * \details A negative number can occur only by subtracting BigNumbers. Input checking is not performed,
					so if negative numbers are used to call the minus operator overload, this class will not
					be thrown and an error will likely occur.
		 */
		class NegativeNumberException{};
		
		/*!
		 * \brief A class to throw an exception if the second modulus argument is 0.
		 * \details A modulus operation cannot be performed if the second argument is 0 (for example, 10 % 0).
					This class is thrown if the second modulus argument is ever 0.
		 */
		class ModulusByZeroException{};
		
		/*!
		 * \brief A class to throw an exception if the user attempts to divide by 0.
		 * \details A division operation cannot be performed if the second argument is 0 (for example, 10/0).
					This class is therefore thrown to indicate this problem has occured.
		 */
		class DivideByZeroException{};
		
		/*!
		 * \brief A default constructor with no parameters or arguments.
		 * \details The default or overloaded constructor must be invoked upon all BigNumbers objects.
					If the user wishes to create an object with the value of zero, rather than calling
					the overloaded constructor like "BigNumbers example("0");", the default constructor
					should be called.
		 */
		BigNumbers(){}
		
		/*!
		 * \brief An overloaded constructor to initialize an object.
		 * \details To create and initialize a BigNumbers object, the overloaded constructor must be called
					with a string argument consisting only of numbers 0 to 9. Checking is not performed on
					this method to ensure input validation. The string can be any size, but if it is larger
					than 10,000 digits, the constructor will throw a NumberOverflowException.
		 * \param stringNumber The string consisting of numbers 0 to 9 to intialize the BigNumbers object with.
		 */
		BigNumbers(string stringNumber)
		{
			for (int i = 0; i < stringNumber.length(); i++)
			{
				int converted = (int)stringNumber.at(i) - '0';
				numbers.push_back(converted);
				
				if (int(numbers.size()) > 10000)
				{
					throw NumberOverflowException();
				}
			}
		}
		
		/*!
		 * \brief An addition (+) operator overload to perform addition on big numbers.
		 * \details This addition implementation is performed by adding the smaller number
					to the larger number starting from the least significant digit and carrying
					any numbers necessary.
		 * \param otherNumber The object to add to the existing object.
		 */
		BigNumbers operator + (BigNumbers otherNumber)
		{
			BigNumbers temp;
			
			//the answer should at least be the size of the larger number
			if (otherNumber.numbers.size() > numbers.size())
			{
				temp.numbers.resize(int(otherNumber.numbers.size()));
			}
			else //(otherNumber.numbers.size() < numbers.size()) OR they are the same size
			{
				temp.numbers.resize(int(numbers.size()));
			}
			
			int index1 = int(numbers.size()) - 1;
			int index2 = int(otherNumber.numbers.size()) - 1;
			int index3 = int(temp.numbers.size()) - 1;
			bool carry = false;
			bool finishedAdding = false;
			int addition;
			
			//loop until all digits have been added from each vector; if the smaller vector ever gets out
			//of range, add with 0's. Carry numbers over and begin from the least significant digit, which
			//is at the end of the vectors
			while (!finishedAdding)
			{
				if (index1 < 0)
				{
					addition = otherNumber.numbers[index2--];
				}
				else if (index2 < 0)
				{
					addition = numbers[index1--];
				}
				else
				{
					addition = numbers[index1--] + otherNumber.numbers[index2--];	
				}
								
				if (carry)
				{
					addition++;
					carry = false;
				}
				
				if (addition >= 10)
				{
					carry = true;
					addition -= 10;
				}
				
				temp.numbers[index3--] = addition;
				
				//sorting is complete
				if (index1 < 0 && index2 < 0)
				{
					if (carry)
					{
						//insert an extra 1 at the beginning of the vector if there is a carry
						vector<int>::iterator it = temp.numbers.begin();
						temp.numbers.insert(it, 1);
					}
					
					finishedAdding = true;
				}
				
				if (int(temp.numbers.size()) > 10000)
				{
					throw NumberOverflowException();
				}
			}
			
			return temp;
		}
		
		/*!
		 * \brief A subtraction (-) operator overload to perform subtraction on big numbers.
		 * \details This subtraction implementation is requires that the number being subtracted
					from the current object is smaller than the current object. If the current
					object is smaller, the result would be negative and a NegativeNumberException
					is thrown. This operator overload method is performed by subtracting from the
					least significant digit first, keeping track of any carry-overs. After subtraction,
					any leading 0's are removed from the answer.
		 * \param otherNumber The object to subtract to the existing object (must not be smaller than the existing object)
		 */
		BigNumbers operator - (BigNumbers otherNumber)
		{
			BigNumbers temp;
			
			//if number to subtract from is smaller, throw a NegativeNumberException
			if (otherNumber.numbers.size() >= numbers.size())
			{
				bool canSubtract = true;
				
				if (otherNumber.numbers.size() > numbers.size())
				{
					canSubtract = false;
				}
				else //otherNumber.numbers.size() == numbers.size()
				{
					for (int i = 0; i < int(numbers.size()); i++)
					{
						if (otherNumber.numbers[i] > numbers[i])
						{
							canSubtract = false;
							break;
						}
						else if (otherNumber.numbers[i] < numbers[i])
						{
							break;
						}
					}
				}
				
				if (!canSubtract)
				{
					throw NegativeNumberException(); //throw exception	
				}
			}
			
			//answer vector will be at least as large as largest number
			temp.numbers.resize(int(numbers.size()));
			
			int index1 = int(numbers.size()) - 1;
			int index2 = int(otherNumber.numbers.size()) - 1;
			int index3 = int(temp.numbers.size()) - 1;
			bool carry = false;
			bool finishedSubtracting = false;
			int subtraction;
			
			while (!finishedSubtracting)
			{
				if (carry)
				{
					if (numbers[index1] == 0)
					{
						numbers[index1] = 9;
					}
					else
					{
						numbers[index1] -= 1;
						carry = false;
					}
				}
				
				if (index2 < 0)
				{
					subtraction = numbers[index1--];
				}
				else
				{	
					if (numbers[index1] < otherNumber.numbers[index2])
					{
						numbers[index1] += 10;
						carry = true;
					}
					
					subtraction = numbers[index1--] - otherNumber.numbers[index2--];
				}
				
				temp.numbers[index3--] = subtraction;
				
				if(index1 < 0 && index2 < 0)
				{
					finishedSubtracting = true;
				}
			}
			
			int loopCondition = int(temp.numbers.size());
			
			//remove leading zeroes from the answer
			for (int i = 0; i < loopCondition; i++)
			{
				if (temp.numbers[0] == 0)
				{
					temp.numbers.erase(temp.numbers.begin());
				}
				else
				{
					break;
				}
			}
			
			return temp;
		}
		
		/*!
		 * \brief A multiplication (*) operator overload to perform multiplication on big numbers.
		 * \details This multiplication method performs by using the "school" multiplication method.
					Each digit of the smaller number is multiplied by all the digits in the larger
					number starting from the end of the smaller number. The result of each of these
					multiplications is added together to return the final answer.
		 * \note This method is very efficient, and will work for very, very, very large numbers with
				 little to no delay. I encourage you to test it!
		 * \param otherNumber The object to multiply with the existing object.
		 */
		BigNumbers operator * (BigNumbers otherNumber)
		{
			//find the larger number. multiply the last digit
			//of the smaller number by each digit in the larger
			//number starting from the back, keeping track of carries.
			//add this number to the answer. for each added number, tack
			//on a 0
			
			int largerNumber;
			
			if (otherNumber.numbers.size() > numbers.size())
			{
				largerNumber = 0;
			}
			else //otherNumber.numbers.size() <= numbers.size())
			{
				largerNumber = 1;
			}
			
			bool carry = false;
			int remainder;
			int loopCondition;
			
			BigNumbers answer;
			
			if (largerNumber == 0)
			{
				loopCondition = int(numbers.size());
				
				for (int i = loopCondition-1; i > -1; i--)
				{
					BigNumbers temp;
					temp.numbers.resize(int(otherNumber.numbers.size()));
					int index1 = int(otherNumber.numbers.size()) - 1;
					
					for (int q = int(otherNumber.numbers.size()) - 1; q > -1; q--)
					{
						if (numbers[i] == 0)
						{
							break;
						}
						
						int result = numbers[i] * otherNumber.numbers[q];
						
						if (carry)
						{
							result += remainder;
							carry = false;
						}
												
						if (result >= 10)
						{
							remainder = 0;
							while (result >= 10)
							{
								result -= 10;
								remainder++;
							}
							
							carry = true;
							
							if (q == 0)
							{
								temp.numbers[index1--] = result;
																
								vector<int>::iterator it = temp.numbers.begin();
								temp.numbers.insert(it, remainder);
																
								carry = false;
								break; //exit for loop
							}
						}
						
						temp.numbers[index1--] = result;
					}
					
					for (int r = int(numbers.size()) - i - 1; r > 0; r--)
					{
						temp.numbers.push_back(0);
					}

					answer = answer + temp;
				}
			}
			else //addLarger == 1
			{
				loopCondition = int(otherNumber.numbers.size());
				
				for (int i = loopCondition-1; i > -1; i--)
				{
					BigNumbers temp;
					temp.numbers.resize(int(numbers.size()));
					int index1 = int(numbers.size()) - 1;
					
					for (int q = int(numbers.size()) - 1; q > -1; q--)
					{
						if (otherNumber.numbers[i] == 0)
						{
							break;
						}
						
						int result = otherNumber.numbers[i] * numbers[q];
						
						if (carry)
						{
							result += remainder;
							carry = false;
						}
												
						if (result >= 10)
						{
							remainder = 0;
							while (result >= 10)
							{
								result -= 10;
								remainder++;
							}
							
							carry = true;
							
							if (q == 0)
							{
								temp.numbers[index1--] = result;
																
								vector<int>::iterator it = temp.numbers.begin();
								temp.numbers.insert(it, remainder);
																
								carry = false;
								break; //exit for loop
							}
						}
						
						temp.numbers[index1--] = result;
					}
					
					for (int r = int(otherNumber.numbers.size()) - i - 1; r > 0; r--)
					{
						temp.numbers.push_back(0);
					}

					answer = answer + temp;
				}
			}
			
			loopCondition = int(answer.numbers.size());
			
			//remove leading zeroes from the answer
			for (int i = 0; i < loopCondition; i++)
			{
				if (answer.numbers[0] == 0)
				{
					answer.numbers.erase(answer.numbers.begin());
				}
				else
				{
					break;
				}
			}
			
			return answer;
		}
		
		/*!
		 * \brief A division (/) operator overload to perform division on big numbers.
		 * \details This division implementation first ensures that the number to divide
					by is not larger than the current number. If it is, the result of the
					division will be a fraction less than 0, so 0 is returned. This method
					always returns the floor of the result. For example, 10/3 = 3.33, but this
					method will return 3. If the number to divide by is 0, a DivideByZeroException
					is thrown.
		 * \param otherNumber The object to divide the existing object by
		 */
		BigNumbers operator / (BigNumbers otherNumber)
		{
			//it is impossible to divide by zero
			if (int(otherNumber.numbers.size()) == 1 && otherNumber.numbers[0] == 0)
			{
				throw new DivideByZeroException();
			}
			
			//check if otherNumber is bigger, which would
			//result in a fraction less than one
			if (otherNumber.numbers.size() >= numbers.size())
			{
				bool canDivide = true;
				
				if (otherNumber.numbers.size() > numbers.size())
				{
					canDivide = false;
				}
				else //otherNumber.numbers.size() == numbers.size()
				{
					for (int i = 0; i < int(numbers.size()); i++)
					{
						if (otherNumber.numbers[i] > numbers[i])
						{
							canDivide = false;
							break;
						}
						else if (otherNumber.numbers[i] < numbers[i])
						{
							break;
						}
					}
				}
				
				if (!canDivide)
				{
					//a smaller number cannot be divided by a larger one, or this would
					//result in a fraction less than one. Since this class cannot handle
					//fractions, 0 should therefore be returned.
					BigNumbers result("0");
					return result;
				}
			}
			
			BigNumbers temp;
			BigNumbers remainder;
			
			int index1 = 0;
			
			while (index1 < int(numbers.size()))
			{
				int numberOfDigits = 1;
				
				while (numberOfDigits < int(otherNumber.numbers.size()))
				{
					numberOfDigits++;
				}
				
				for (int i = 0; i < int(otherNumber.numbers.size()); i++)
				{
					if (otherNumber.numbers[i] > numbers[i + index1])
					{
						numberOfDigits++;
						break;
					}
					else if (otherNumber.numbers[i] < numbers[i + index1])
					{
						break;
					}
				}
				
				BigNumbers secondTemp;
				
				for (int i = 0; i < numberOfDigits; i++)
				{
					secondTemp.numbers.push_back(numbers[i + index1]);
				}
				
				int counter = 0;
				
				while(int(secondTemp.numbers.size()) > 0)
				{
					try
					{
						secondTemp = secondTemp - otherNumber;
						counter++;
						remainder.numbers.clear();
					}
					catch (NegativeNumberException)
					{
						remainder = secondTemp;
						break;
					}
				}
				
				temp.numbers.push_back(counter);
				
				cout << "On my first iteration, temp is: ";
				temp.print();
				cout << "\nRemainder is: ";
				remainder.print();
				
				index1 += numberOfDigits;
			}
			return temp;
			
			/**
			//it is impossible to divide by zero
			if (int(otherNumber.numbers.size()) == 1 && otherNumber.numbers[0] == 0)
			{
				throw new DivideByZeroException();
			}
			
			BigNumbers temp;
			
			//check if otherNumber is bigger, which would
			//result in a fraction less than one
			if (otherNumber.numbers.size() >= numbers.size())
			{
				bool canDivide = true;
				
				if (otherNumber.numbers.size() > numbers.size())
				{
					canDivide = false;
				}
				else //otherNumber.numbers.size() == numbers.size()
				{
					for (int i = 0; i < int(numbers.size()); i++)
					{
						if (otherNumber.numbers[i] > numbers[i])
						{
							canDivide = false;
							break;
						}
						else if (otherNumber.numbers[i] < numbers[i])
						{
							break;
						}
					}
				}
				
				if (!canDivide)
				{
					//a smaller number cannot be divided by a larger one, or this would
					//result in a fraction less than one. Since this class cannot handle
					//fractions, 0 should therefore be returned.
					BigNumbers result("0");
					return result;
				}
			}
			
			BigNumbers addOne("1");
			
			while (numbers.size() != 0)
			{
				try
				{
					*this = *this - otherNumber;
				}
				catch (NegativeNumberException)
				{
					break;
				}
				
				temp = temp + addOne;
			}
			
			return temp;*/
		}
		
		/*!
		 * \brief A modulus (%) operator overload to perform modulus on big numbers.
		 * \details This operator overload is performed by subtracting the current
					number from the modulus number until the result is 0 or subtraction
					cannot be performed without leaving the current object negative.
					The current object is then returned.
		 * \param otherNumber The object to modulus the existing object.
		 */
		BigNumbers operator % (BigNumbers otherNumber)
		{
			//the modulus cannot be 0
			if (int(otherNumber.numbers.size()) == 1 && otherNumber.numbers[0] == 0)
			{
				throw new ModulusByZeroException();
			}
			
			while(int(numbers.size()) != 0)
			{
				try
				{
					*this = *this - otherNumber;
				}
				catch (NegativeNumberException)
				{
					return *this;
				}
			}
			
			BigNumbers temp("0");
			return temp;
		}
		
		/*!
		 * \brief A print method to print to screen the content of a BigNumbers object.
		 */
		void print()
		{
			for (int i = 0; i < int(numbers.size()); i++)
			{
				cout << numbers[i];
			}
			cout << endl;
		}
		
		/*!
		 * \brief Set the existing object to the value of the passed string.
		 * \details This method must be used in the same way the overloaded
					constructor is used. See the overloaded constructor for
					the full documentation.
		 * \param otherNumber The string consisting of numbers 0 to 9 to set the BigNumbers object's vector to.
		 */
		void set(string stringNumber)
		{
			numbers.clear();
			
			for (int i = 0; i < stringNumber.length(); i++)
			{
				int converted = (int)stringNumber.at(i) - '0';
				numbers.push_back(converted);
				
				if (int(numbers.size()) > 10000)
				{
					throw NumberOverflowException();
				}
			}
		}
};

/*!
 * \brief An example of using the BigNumbers class to add, subtract, multiply, divide, and modulus numbers.
		  Examples of setting objects and setting objects as equal are also shown.
 */
int main()
{
	//adding numbers
	BigNumbers number("87639"); //these numbers can be up to 10,000 digits
	BigNumbers otherNumber("70");
	BigNumbers resultNumber;
	
	resultNumber = number / otherNumber;
	cout << "Calling print: " << endl;
	resultNumber.print();
	
	/**number.set("1234560");
	otherNumber.set("654321");
	
	//subtracting numbers
	resultNumber = number - otherNumber;
	resultNumber.print();
	
	number.set("1234560");
	otherNumber.set("654321");
	
	//multiplying numbers
	resultNumber = number * otherNumber;
	resultNumber.print();
	
	number.set("1234560");
	otherNumber.set("654321");
	
	//dividing numbers
	resultNumber = number / otherNumber;
	resultNumber.print();
	
	number.set("1234560");
	otherNumber.set("654321");
	
	//modulus numbers
	resultNumber = number % otherNumber;
	resultNumber.print();
	
	number.set("1234560");
	otherNumber.set("654321");
	
	//equating numbers
	number = otherNumber;
	number.print();*/
	
	return 0;
}