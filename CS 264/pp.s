			.data
input:		.space 80
word:		.space 80
prompt:		.asciiz "\nEnter a string: "
success:	.asciiz "\nThe entered string IS a palindrome."
failure:	.asciiz "\nThe entered string is NOT a palindrome."
			.text

main:		
			la $a0, prompt
			li $v0, 4
			syscall
			li $v0, 8
			la $a0, input
			move $t0, $a0
			syscall
			la $t7, word
			
checkCases:
			lb $t1, 0($t0)
			beqz $t1, finished
			addi $t0, $t0, 1
			blt $t1, 97, uppercase
			
lowercase:
			sb $t1, 0($t7)
			addi $t7, $t7, 1
			b checkCases
			
uppercase:
			blt $t1, 65, checkCases #don't count spaces or numbers less than 65
			addi $t1, $t1, 32 #change uppercase to lowercase
			sb $t1, 0($t7)
			addi $t7, $t7, 1
			b checkCases

finished:	
			jal palindrome
			beqz $v0, No

Yes:
			la $a0, success
			li $v0, 4
			syscall
			b done
			
No:
			la $a0, failure
			li $v0, 4
			syscall

done:
			li $v0, 10
			syscall
			
#================================================================
			
palindrome:
			li $v0, 0
			li $t0, 0 #counter for length of word
			la $t1, word

getLength:
			lb $t3, 0($t1)
			beqz $t3, complete
			addi $t1, $t1, 1
			addi $t0, $t0, 1 #increment counter
			b getLength
			
complete:
			addi $t0, $t0, -1
			la $t1, word #reset address for word
			la $t2, word #get address for word
			add $t2, $t2, $t0
			
equal:
			lb $t3, 0($t1)
			lb $t4, 0($t2)
			beqz $t3, good
			bne $t3, $t4, terminate
			addi $t1, $t1, 1
			addi $t2, $t2, -1
			b equal
good:
			li $v0, 1  # Set return value to 1 (true)
terminate:	
			jr $ra