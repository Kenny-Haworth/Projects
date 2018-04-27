			.data
input:		.space 80
array:		.space 512
prompt:		.asciiz "\nEnter a string: "
blank:		.asciiz "\nNumber of spaces: "
result:		.asciiz "\nNumber of "
colon:		.asciiz " : "
			.text

main:		
			la $a0, prompt
			li $v0, 4
			syscall
			li $v0, 8
			la $a0, input
			move $t0, $a0
			syscall
			
loop:
			lb $t1, 0($t0)
			beqz $t1, done
			addi $t0, $t0, 1
			mul $t1, $t1, 4
			la $a0, array
			add $a0, $a0, $t1
			lw $t2, 0($a0)
			addi $t2, $t2, 1
			sw $t2, 0($a0)
			b loop
			
done:
			la $t0, array
			addi $t0, $t0, 128
			lw $t1, 0($t0)
			la $a0, blank
			li $v0, 4
			syscall
			move $a0, $t1
			li $v0, 1
			syscall
			addi $t0, $t0, 132
			li $t5, 65
			
hugeLoop:
			lw $t1, 0($t0)
			la $a0, result
			li $v0, 4
			syscall
			move $a0, $t5
			li $v0, 11
			syscall
			la $a0, colon
			li $v0, 4
			syscall
			move $a0, $t1
			li $v0, 1
			syscall
			addi $t5, $t5, 1
			addi $t0, $t0, 4
			bgt $t5, 90, continue
			b hugeLoop
			
continue:
			la $t0, array
			addi $t0, $t0, 388
			li $t5, 97
			
onward:		
			lw $t1, 0($t0)
			la $a0, result
			li $v0, 4
			syscall
			move $a0, $t5
			li $v0, 11
			syscall
			la $a0, colon
			li $v0, 4
			syscall
			move $a0, $t1
			li $v0, 1
			syscall
			addi $t5, $t5, 1
			addi $t0, $t0, 4
			bgt $t5, 122, terminate
			b onward
	
terminate:
			li $v0, 10
			syscall