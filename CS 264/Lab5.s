#Lab 5
#Kendall Haworth
#Bronco ID: 011694826

			.data
array:		.space 40 #10 numbers total
prompt:		.asciiz ") Enter a number: "
answer:		.asciiz "\nThe smallest number entered is: "
prompt2:	.asciiz "\n\nEnter a number n where n >= r and n,r >= 0: "
prompt3:	.asciiz "\nEnter a number r where n >= r and n,r >= 0: "
answer2:	.asciiz "\nThe combination of n and r is: "
			.text
			
main:
			la $t0, array #load the array
			li $t1, 1 #the counter and the number currently being entered
			
loop:
			move $a0, $t1 #print out the number to be entered
			li $v0, 1
			syscall
			la $a0, prompt #prompt the user to enter a number
			li $v0, 4
			syscall
			li $v0, 5 #get the number
			syscall
			sw $v0, 0($t0) #store the number
			addi $t0, $t0, 4 #move the array to the next address
			addi $t1, $t1, 1 #increment the counter
			bne $t1, 11, loop #when the counter is 11 (starts at 1), done
			
			la $a0, array #load the array as the first argument
			li $a1, 0 #set the low
			li $a2, 9 #set the high
			li $v0, 0 #set the starting return value
			jal Min #call Min
			move $t0, $v0 #save the answer to $t0
			la $a0, answer #print the answer prompt
			li $v0, 4
			syscall
			move $a0, $t0 #move the answer back into $a0
			li $v0, 1 #print the answer
			syscall
			
			la $a0, prompt2 #print the second prompt for the Comb function
			li $v0, 4
			syscall
			li $v0, 5 #get the number n
			syscall
			move $t0, $v0 #move n to $t0
			la $a0, prompt3 #print the third prompt
			li $v0, 4
			syscall
			li $v0, 5 #get the number r
			syscall
			move $a1, $v0 #store r in $a1
			move $a0, $t0 #store n in $a0
			li $v0, 0 #set the starting return value
			jal Comb #call the Comb function
			move $t0, $v0 #save the answer in $t0
			la $a0, answer2 #print the answer prompt
			li $v0, 4
			syscall
			move $a0, $t0 #move the answer into $a0
			li $v0, 1 #print the answer
			syscall
			li $v0, 10 #exit the program
			syscall
			
#===============================================================================
			
			#$a0 holds the array, $a1 holds low, $a2 holds high, $t0 holds mid
Min:
			beq $a1, $a2, Return #if low == high, go to Return
			add $t0, $a1, $a2 #low + high = $t0
			div $t0, $t0, 2 # (low+high)/2 = $t0
			addiu $sp, $sp, -16 #reserve 16 bytes on the stack
			sw $ra, 0($sp) #store the return address on the stack
			sw $a1, 4($sp) #store low on the stack
			sw $t0, 8($sp) #store mid on the stack
			sw $a2, 12($sp) #store high on the stack
			move $a2, $t0 #set the new high as the mid
			jal Min #$v0 = min1 now
			lw $ra, 0($sp) #pop the return address off the stack
			lw $a1, 4($sp) #pop the low off the stack
			lw $t0, 8($sp) #pop the mid off the stack
			lw $a2, 12($sp) #pop the high off the stack
			addiu $sp, $sp, 16 #release the space on the stack
			addiu $sp, $sp, -8 #reserve 8 bytes on the stack
			sw $ra, 0($sp) #store the return address on the stack
			sw $v0, 4($sp) #store min1 on the stack
			move $a1, $t0 #set the low as the mid
			addi $a1, $a1, 1 #add 1 to the low
			jal Min #$v0 = min2
			lw $ra, 0($sp) #pop the return address off the stack
			lw $t1, 4($sp) #pop min1 off the stack, $t1 = min1
			addiu $sp, $sp, 8 #release the space on the stack
			bgt $t1, $v0, second #if (min1>min2), go to second
			move $v0, $t1 #move min1 to $v0
			jr $ra #return min1
			
second:		
			jr $ra #min2 needs to be returned, it is already in $v0 so simply return
						
Return:		#return array[low]
			move $t2, $a0 #move the array to a temporary variable
			mul $t3, $a1, 4 #multiply low by 4 to get the location
			add $t2, $t2, $t3 #add the address to the array
			lw $v0, 0($t2) #get the number from the array at the location
			jr $ra #return array[low]
			
#==========================================================================			

			#$a0 holds n, $a1 holds r, $v0 = 0
Comb:
			beq $a0, $a1, easy #branch if n = r
			beqz $a1, easy #branch if r = 0
			addiu $sp, $sp, -12 #reserve 8 bytes on the stack
			sw $ra, 0($sp) #store return address on the stack
			sw $a0, 4($sp) #store n on the stack
			sw $a1, 8($sp) #store r on the stack
			addi $a0, $a0, -1 #subtract 1 from n
			jal Comb #Comb(n-1,r) = $v0
			lw $ra, 0($sp) #pop the return address off the stack
			lw $a0, 4($sp) #pop n off the stack
			lw $a1, 8($sp) #pop r off the stack
			addiu $sp, $sp, 12 #release the space on the stack
			addiu $sp, $sp, -4 #reserve 4 bytes on the stack
			sw $ra, 0($sp) #store the return address on the stack
			addi $a0, $a0, -1 #subtract 1 from n
			addi $a1, $a1, -1 #subtract 1 from r
			jal Comb #Comb(n-1,r) + Comb(n-1, r-1) = $v0
			lw $ra, 0($sp) #pop the return address off the stack
			addiu $sp, $sp, 4 #release the space on the stack
			jr $ra #return the answer
			
easy:
			addi $v0, $v0, 1 #add 1 to the answer
			jr $ra #return