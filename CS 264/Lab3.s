#Lab 3
#Kendall Haworth
#Bronco ID: 011694826

			.data
input:		.space 80 #input for user
word:		.space 80 #a new word with no spaces, capitals, or punctuation
array:		.space 512 #space for 512/4 = 128 total ascii characters
prompt:		.asciiz "\nEnter a string: "
blank:		.asciiz "\nNumber of spaces: "
result:		.asciiz "\nNumber of "
colon:		.asciiz " : "
success:	.asciiz "\nThe entered string IS a palindrome."
failure:	.asciiz "\nThe entered string is NOT a palindrome."
			.text

main:		
			la $a0, prompt #Prompt the user to enter a string
			li $v0, 4
			syscall
			li $v0, 8 #get the string from the user
			la $a0, input
			move $t0, $a0
			syscall
			
addValues:
			lb $t1, 0($t0) #load the first byte
			beqz $t1, print
			addi $t0, $t0, 1 #get the next byte
			mul $t1, $t1, 4 #get the array address of the ascii value
			la $a0, array #load the array into $a0
			add $a0, $a0, $t1 #find the address of the ascii value
			lw $t2, 0($a0) #get the number stored at that ascii  value
			addi $t2, $t2, 1 #add 1 to that value
			sw $t2, 0($a0) #restore the value at the address
			b addValues
			
print:
			la $t0, array #load the array with the ascii values
			addi $t0, $t0, 128 #go to number of spaces, 128/4 = 32 in ascii
			lw $t1, 0($t0) #load the number of spaces
			la $a0, blank #load and print the prompt for spaces
			li $v0, 4
			syscall
			move $a0, $t1
			li $v0, 1 #print the number of spaces
			syscall
			addi $t0, $t0, 132 #go to uppercase letters, 32+33=65
			li $t5, 65 #save ascii value for letter printing, starting at A
			
uppercase:
			lw $t1, 0($t0) #get the number at the address
			la $a0, result #print the prompt
			li $v0, 4
			syscall
			move $a0, $t5 #print the letter using the ascii value
			li $v0, 11
			syscall
			la $a0, colon #print the colon for formatting
			li $v0, 4
			syscall
			move $a0, $t1
			li $v0, 1
			syscall
			addi $t5, $t5, 1 #increment the ascii value
			addi $t0, $t0, 4 #load the next address of array
			bgt $t5, 90, continue #while ascii value isn't lowercase, loop
			b uppercase
			
continue:
			la $t0, array #reset address for array
			addi $t0, $t0, 388 #begin at 388/4 = 97, lowercase letters
			li $t5, 97 #load starting ascii value for printing, starting at a
			
lowercase:		
			lw $t1, 0($t0) #get the number at the address
			la $a0, result #print the prompt
			li $v0, 4
			syscall
			move $a0, $t5 #print the letter using the ascii value
			li $v0, 11
			syscall
			la $a0, colon #print the colon for formatting
			li $v0, 4
			syscall
			move $a0, $t1
			li $v0, 1
			syscall
			addi $t5, $t5, 1 #increment the ascii value
			addi $t0, $t0, 4 #load the next address of array
			bgt $t5, 122, checkPalin #loop as long as ascii value is not over 122 = z
			b lowercase
			
#Now check for palindrome. Create a new word that has no spaces, capitals, or special punctuation
			
checkPalin:
			la $t0, input #load the user's input string
			la $t7, word #load the new word
			
checkCases:
			lb $t1, 0($t0) #get the first byte of the string
			beqz $t1, finished #when the byte is 0, the end of the string has been reached
			addi $t0, $t0, 1 #load the next byte in the string
			blt $t1, 97, upper #if the number < 97, go to uppercase branch
			
lower:
			sb $t1, 0($t7) #save the letter in the new word if it is lowercase
			addi $t7, $t7, 1 #load the next byte in the new word
			b checkCases
			
upper:
			blt $t1, 65, checkCases #don't count spaces or numbers less than 65
			addi $t1, $t1, 32 #change uppercase character to lowercase character
			sb $t1, 0($t7) #save the character in the new word
			addi $t7, $t7, 1 #load the next byte in the new word
			b checkCases

finished:	
			jal palindrome #branch to the function to check palindrome or not
			beqz $v0, No #if $v0, the return address, is 0, it is not a palindrome

Yes:
			la $a0, success #it is a palindrome, load and print success message
			li $v0, 4
			syscall
			b done
			
No:
			la $a0, failure #it is not a palindrome, load and print failure message
			li $v0, 4
			syscall

done:
			li $v0, 10 #exit the program
			syscall
		
#=======================================================================================
		
palindrome:
			li $v0, 0 #load return value, initially 0 to indicate failure
			li $t0, 0 #counter for the length of the new word
			la $t1, word #load the address for the new word

getLength:
			lb $t3, 0($t1) #load the first byte
			beqz $t3, complete #if $t3 is null, the end of the new word has been reached
			addi $t1, $t1, 1 #load the next byte
			addi $t0, $t0, 1 #increment counter
			b getLength
			
complete:
			addi $t0, $t0, -1 #set proper length for the new word
			la $t1, word #get address for word
			la $t2, word #get address for word
			add $t2, $t2, $t0 #begin at the end of the word for $t2
			
equal:
			lb $t3, 0($t1) #start at the beginning of the word
			lb $t4, 0($t2) #start at the end of the word
			beqz $t3, good #if t3 is 0, the end of the word has been reached and it is a palindrome
			bne $t3, $t4, terminate #if the bytes are not equal, it is not a palindrome
			addi $t1, $t1, 1 #load next byte moving forward
			addi $t2, $t2, -1 #load next byte moving backwards
			b equal
good:
			li $v0, 1  # Set return value to 1 to indicate success
terminate:	
			jr $ra #return with the value $v0