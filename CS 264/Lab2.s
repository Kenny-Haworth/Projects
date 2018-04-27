			.data
array:      .space  80
Prompt:     .asciiz "\nEnter an  integer:  "
Smallest:	.asciiz "\nThe smallest number is "
Largest:	.asciiz "\nThe largest number is "
Even:		.asciiz "\nThe number of even numbers is "
Odd:		.asciiz "\nThe number of odd numbers is "
			.text
main:  		
			li  $t0, 20  #Counter for array
			la  $t1, array
loop:	
			la  $a0, Prompt #Prompt the user to enter a number
			li  $v0, 4
			syscall
			li  $v0, 5 #Read the integer
			syscall
			sw  $v0, 0($t1)  #Store the integer entered
			addi $t0, $t0, -1  #Decrement counter
			addi $t1, $t1, 4  #Load next address
			bgtz $t0, loop #Branch to read and store the next integer if the counter > 0
			li $t0, 19 #Reset the counter
			la $t1, array #Reset starting address of array
			lw $a0, 0($t1)
			move $t2, $a0 #$t2 holds the smallest number
			move $t3, $t2 #$t3 holds the largest number
			addi $t1, $t1, 4
			jal SmallestLargest
			la $a0, Smallest #Print the smallest number
			li $v0, 4
			syscall
			move $a0, $t2
			li $v0, 1
			syscall
			la $a0, Largest #Print the largest number
			li $v0, 4
			syscall
			move $a0, $t3
			li $v0, 1
			syscall
			li $t1, 0 #$t1 holds the number of even numbers
			li $t2, 0 #$t2 holds the number of odd numbers
			li $t3, 20 #Set the counter
			la $t0, array
			jal oddEven
			la $a0, Even #Print out the number of even numbers
			li $v0, 4
			syscall
			move $a0, $t1
			li $v0, 1
			syscall
			la $a0, Odd #Print out the number of odd numbers
			li $v0, 4
			syscall
			move $a0, $t2
			li $v0, 1
			syscall
			li $v0, 10 #Exit the program
			syscall
			
#---------------------------------------------------------------------------------------			
			
SmallestLargest:	
			lw $a0, 0($t1) #Check the next number in the array
			addi $t1, $t1, 4 #Load next address
			addi $t0, $t0, -1 #Decrement counter
			blt $a0, $t2, Small #If it's the smallest number, save is as the smallest
			bgt $a0, $t3, Large #If it's the largest number, save it as the largest
Go:	
			bnez $t0, SmallestLargest #While counter != 0, continue going through the array
			jr $ra #When counter = 0, return
Small:	
			move $t2, $a0 #Save the new smallest
			b Go
Large:
			move $t3, $a0 #Save the new largest
			b Go
			
#---------------------------------------------------------------------------------------

oddEven:
			lw $t4, 0($t0) #$t4 holds the current array number
			addi $t3, $t3, -1 #Decrement counter
			addi $t0, $t0, 4 #Load next array address
			andi $t4, $t4, 1 #Check if the number is odd or even
			bnez $t4, incOdd #If the number is odd, increment odd
incEven:	
			addi $t1, $t1, 1 #Increment even
			bnez $t3, oddEven
			jr $ra
incOdd:	
			addi $t2, $t2, 1 #Increment odd
			bnez $t3, oddEven
			jr $ra