#write a program that receives the address of the string (a0) and returns the number of characters in the string
#use ld instead of lw because every character is one byte, then check it if you need special character

			.data
string:		.asciiz "hellohellohellohello"
			.text
			la $a0, string
			jal getLength
			move $a0, $v0
			li $v0, 1
			syscall
			li $v0, 10
			syscall
getLength:	li $v0, 0
loop:		lb $t0, 0($a0)
			beqz $t0, done
			addi $v0, $v0, 1
			addi $a0, $a0, 1
			b loop
done:		jr $ra

#write a program that counts the number of even and odd integers in an array
			
			
			.data
mydata:		.space 400
even:		.asciiz “\n The number of even integers  ”
odd:		.asciiz “\n The number of odd integers  ”
.text
			la $a0, mydata
			jal evenOdd
			move $t0, $v0 #Because we need $v0 for printing
			la $a0, even
			li $v0, 4
			syscall
			move $a0, $t0
			li $v0, 1
			syscall
			la $a0, odd
			li $v0, 4
			syscall
			li $v0, 1
			move $a0, $v1
			syscall
			li $v0, 10
			syscall
evenOdd:	li $t1, 100
			li $v0, 0
			li $v1, 0
next:		lw $t2, ($a0)
			andi $t2, $t2, 1
			addi $t1, $t1, -1
			addi $a0, $a0, 4
			beqz $t2, incEven
incOdd:		addi $v1, $v1, 1
			b compare
incEven:	addi $v0, $v0, 1
compare:	bnez $t1, next
			jr $ra

#write a function that receieves the address of a string a0 and returns the number of uppercase and lowercase letters

			.data
String:		.asciiz "This is the string"
Uppercase:	.asciiz "The number of uppercase letters: "
Lowercase:	.asciiz "The number of lowercase letters: "
			.text
			la $a0, String
			jal count
			move $t0, $v0 #need v0 for printing
			la $a0, Uppercase
			li $v0, 4
			syscall
			li $v0, 1
			syscall
			la $a0, Lowercase
			li $v0, 4
			syscall
			move $a0, $v1
			li $v0, 1
			syscall
count:		li $v0, 0 #store uppercase
			li $v1, 0 #store lowercase
loop:		lb $t0, 0($a0)
			beqz $t0, done
			bge $t0, 97, up
			addi $v0, $v0, 1 #increment uppercase
			b increment
up:			addi $v1, $v1, 1 #increment lowercase
increment:	addi $a0, $a0, 1 #increment counter
			b loop
done:		jr $ra

#function that takes a number and converts it into binary

convert:
			bgtz $a1, recu
			li $a0, 0
			li $v0, 1
			syscall
			jr $ra
recu:
			addiu $sp, $sp, -8
			sw $ra, 0($sp)
			sw $a1, 4($sp)
			sra $a1, $a1, 1
			jal convert
			lw $ra, 0($sp)
			lw $t0, 4($sp)
			rem $a0, $t0, 2
			li $v0, 1
			syscall
			addiu $sp, $sp, 8
			jr $ra
			
#function that performs exponent

exp:
		bgtz $a1, next1 #a1 is n, $a0 is a0
		li $v0, 1
		jr $ra
next1:
		andi $t0, $a1, 1
		bgtz $t0, expRo
		addiu $sp, $sp, -4
		sw $ra, 0($sp)