#$a0 is n, $a1 is k

fun:
		bge $a0, $a1, funR
		add $v0, $a0, $a1
		jr $ra
		
funR:
		addiu $sp, $sp, -8 #reserve 8 bytes on stack
		sw $ra, 0($sp)
		sw $a0, 4($sp)
		addi $a0, $a0, -1
		jal fun #fun(n-1,k) = $v0

		lw $t0, 4($sp)		#$t0 = n
		add $v0, $v0, $t0	#$v0 = fun(n-1,k) + n
		add $v0, $v0, $a1	#$v0 = fun(n-1, k) + n + k
		lw $ra, 0($sp)
		addiu $sp, $sp, 8
		jr $ra