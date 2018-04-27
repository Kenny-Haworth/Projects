.data
array1:		.space 40
prompt21:	.asciiz "Enter a number: "
			.text
main:		la $t0, array1
			li $t1, 10		
loop:		la $a0, prompt21
			li $v0, 4
			syscall
			li $v0, 5
			syscall
			sw $v0, 0($t0)
			addi $t0, $t0, 4
			addi $t1, $t1, -1
			bnez $t1, loop		
			li $v0, 10
			syscall
