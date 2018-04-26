While (the number n has not been found)
{
	Split the data set into equal sizes of 1/3 and 2/3 of the data
	if (the value between these two sets equals the number n)
	{
		The number has been found
	}
	else if (the value is less than the value between these two sets)
	{
		take the left set (of size 1/3 the original) and loop
	}
	else if (the value is greater than the value between these two sets)
	{
		take the right set (of size 2/3 the original) and loop
	}
	else
	{
		the value does not exist in this data set
	}
}

								1 2 3 4 5 6 7 8 9

								1 2 3 	4 5 6 7 8 9

1 	2 3									4 5		6 7 8 9
1	2	3	4	5								6	7 8 9
1	2	3	4	5	6								7	8 9
1	2 	3	4	5	6	7								8	9

1 2 3 4 5 6 7 8 9

1 2 3 4 5	6 7 8 9
			6 7		8 9
					8	9