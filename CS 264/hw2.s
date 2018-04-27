largest:    add $t0, $a1, -1            #t0=size-1
            bne $a2, $t0, largestR
            mul $t0, $a2, 4
            move $t1, $a0
            add $t1, $t1, $t0
            lw $v0, ($t1)
            jr $ra
largestR:    addiu $sp, $sp, -8
            sw $ra, ($sp)
            sw $a2, 4($sp)
            add $a2, $a2, -1
            jal largest
            lw $t0, 4($sp)
            mul $t0, $t0, 4
            move $t1, $a0
            add $t1, $t1, $t0
            lw $t0, ($t1)                 #A[i] = t0
            bgt $t0, $v0, DUCKS
            move $v0, $t0
            jr $ra
			
DUCKS: