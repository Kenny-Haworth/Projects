/*!
 * \brief An example of using the BigNumbers class to add, subtract, multiply, divide, and modulus numbers.
		  Examples of setting objects and setting objects as equal are also shown.
 */
int main()
{
	//adding numbers
	BigNumbers number("1234560"); //these numbers can be up to 10,000 digits
	BigNumbers otherNumber("654321");
	BigNumbers resultNumber;
	
	resultNumber = number + otherNumber;
	resultNumber.print();
	
	number.set("1234560");
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
	number.print();
	
	return 0;
}