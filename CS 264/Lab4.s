#Lab 4
#Kendall Haworth
#Bronco ID: 011694826

			.data
array:		.space 480 #size for 10 records, each record need 48 bytes
temp:		.space 48 #temporary array to hold a single record
name:		.asciiz ") Enter the name of the employee: "
age:		.asciiz "\n       Enter the age of the employee: "
salary:		.asciiz "\n       Enter the salary of the employee: "
newLine:	.asciiz "\n"
format:		.asciiz "\n===================================================================\n"
printName:	.asciiz ") Employee name: "
printAge:	.asciiz "| Employee age: "
printSal:	.asciiz "| Employee salary: "
prompt1:	.asciiz "\nEnter a record 1-10 to swap: "
prompt2:	.asciiz "\nEnter a record 1-10 to swap with: "
			.text
			
main:
			la $t0, array #load the array
			li $t1, 10 #counter for all 10 records
			li $t2, 1 #keeps track of the record being read in
			
loop:
			move $a0, $t2 #print out the record number to be read in
			li $v0, 1
			syscall
			la $a0, name #print out the name prompt
			li $v0, 4
			syscall
			move $a0, $t0 #put array into $a0 to get the string
			li $v0, 8
			syscall
			
			move $t3, $t0 #put the array into a temporary register
			li $t4, 40 #counter for size of the string, 40 bytes
			
remove:		#Each string read in has a new line character, it must be removed
			lb $t5, 0($t3) #load the string byte by byte
			beqz $t4, continue #the entire string has been checked, continue
			addi $t4, $t4, -1 #decrement the counter
			bnez $t5, go #the end of the string has not yet been reached
			addi $t3, $t3, -1 #the end of the string has been reached, go to the previous byte
			sb $0, 0($t3) #overwrite the new line character with 0
			b continue #continue with the program
			
go:
			addi $t3, $t3, 1 #go the the next byte
			b remove
			
continue:
			la $a0, age #print the age prompt
			li $v0, 4
			syscall
			move $a0, $t0
			li $v0, 5 #get the age
			syscall
			sw $v0, 40($a0)
			la $a0, salary #print the salary prompt
			li $v0, 4
			syscall
			move $a0, $t0
			li $v0, 5 #get the salary
			syscall
			sw $v0, 44($a0)
			la $a0, newLine #print a new line
			li $v0, 4
			syscall
			addi $t0, $t0, 48 #go the next record
			addi $t1, $t1, -1 #decrement the counter
			addi $t2, $t2, 1 #increment the record number
			bnez $t1, loop #branch until counter is 0
			
			la $t0, array #reset the address of the array
			li $t1, 10 #reset the counter for 10 records
			li $t2, 1 #reset the record number to 1
			la $a0, format #print out nice formatting
			li $v0, 4
			syscall
			la $a0, newLine #print a new line
			li $v0, 4
			syscall
			
print:		#print the data in all 10 records
			move $a0, $t2 #print out the record name
			li $v0, 1
			syscall
			la $a0, printName #print out the name prompt
			li $v0, 4
			syscall
			move $a0, $t0 #move array to $a0 to print the name
			li $v0, 4 #print the name
			syscall
			la $a0, printAge #print out the age prompt
			li $v0, 4
			syscall
			lw $a0, 40($t0) #get the age
			li $v0, 1 #print the age
			syscall
			la $a0, printSal #print the salary prompt
			li $v0, 4
			syscall
			lw $a0, 44($t0) #get the salary
			li $v0, 1 #print the salary
			syscall
			la $a0, newLine #print a new line
			li $v0, 4
			syscall
			addi $t0, $t0, 48 #go to the next record
			addi $t1, $t1, -1 #decrement the counter
			addi $t2, $t2, 1 #increment the record number
			bnez $t1, print #while counter isn't 0, loop
			
			la $a0, prompt1 #prompt the user for the first record to swap
			li $v0, 4
			syscall
			li $v0, 5 #get the record to swap
			syscall
			move $t2, $v0 #t2 holds the first record
			la $a0, prompt2 #prompt the user for the second record to swap
			li $v0, 4
			syscall
			li $v0, 5 #get the second record to swap
			syscall
			move $t3, $v0 #t3 holds the second record
			mul $t2, $t2, 48 #multiply the first record to swap by 48 to get the record place after it
			addi $t2, $t2, -48 #subtract the record place by 48 to get the exact place for the first record
			mul $t3, $t3, 48 #multiply the second record to swap by 48 to get the record place after it
			addi $t3, $t3, -48 #subtract the record place by 48 to get the exact place for the second record
			la $t0, array #load the address of the array
			la $t4, temp #load the address of the temporary array that can hold one record
			add $t0, $t0, $t2 #t0, the array, begins at the first record to swap
			li $t1, 48 #set the counter for one record
			
copy:		#copy the first record into a temporary array
			lb $t5, 0($t0) #get the record from the array
			sb $t5, 0($t4) #save the record to the temporary array
			addi $t0, $t0, 1 #increment the place for the array
			addi $t4, $t4, 1 #increment the place for the temporary array
			addi $t1, $t1, -1 #decrement the counter
			bnez $t1, copy #while the counter isn't 0, loop
			
			la $t0, array #load the address of the array into $t0
			la $t1, array #load the same array into $t1 as well
			add $t0, $t0, $t2 #start $t0 at the place of the first record
			add $t1, $t1, $t3 #start $t1 at the place of the second record
			li $t4, 48 #set the counter for one record
			
replace:    #replace the data in the first record with the data in the second record			
			lb $t5, 0($t1) #get the data in the second record
			sb $t5, 0($t0) #overwrite the data in the first record with the data in the second record
			addi $t1, $t1, 1 #increment the place of the second record spot in the array
			addi $t0, $t0, 1 #increment the place of the first record spot in the array
			addi $t4, $t4, -1 #decrement the counter
			bnez $t4, replace #while the counter isn't 0, loop
			
			la $t0, array #reset the place of the array
			add $t0, $t0, $t3 #start the array at the address of the second record
			la $t1, temp #load the address of the temporary array
			li $t2, 48 #set the counter for one record
			
recopy:		#recopy the data in the temporary array into the second record
			lb $t3, 0($t1) #load the data from the temp array
			sb $t3, 0($t0) #overwrite the data in the array beginning at the second record
			addi $t1, $t1, 1 #increment the place of the temp array
			addi $t0, $t0, 1 #increment the place of the array
			addi $t2, $t2, -1 #decrement the counter
			bnez $t2, recopy #while the counter isn't 0, loop
			
			la $t0, array #reset the address for the array
			li $t1, 10 #set the counter for 10 records
			li $t2, 1 #set the current record number to be printed out
			la $a0, format #print nice formatting
			li $v0, 4
			syscall
			la $a0, newLine #print a new line
			li $v0, 4
			syscall
			
printAll:
			move $a0, $t2 #print out the record name
			li $v0, 1
			syscall
			la $a0, printName #print out the name prompt
			li $v0, 4
			syscall
			move $a0, $t0 #move array to $a0 to print the name
			li $v0, 4 #print the name
			syscall
			la $a0, printAge #print out the age prompt
			li $v0, 4
			syscall
			lw $a0, 40($t0) #get the age
			li $v0, 1 #print the age
			syscall
			la $a0, printSal #print the salary prompt
			li $v0, 4
			syscall
			lw $a0, 44($t0) #get the salary
			li $v0, 1 #print the salary
			syscall
			la $a0, newLine #print a new line
			li $v0, 4
			syscall
			addi $t0, $t0, 48 #go to the next record
			addi $t1, $t1, -1 #decrement the counter
			addi $t2, $t2, 1 #increment the record number
			bnez $t1, printAll #while counter isn't 0, loop
			
			li $v0, 10 #exit the program
			syscall