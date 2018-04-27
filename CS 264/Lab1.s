             .data
array:       .space 80
newLine:     .asciiz  "\n"  # Start a new line
space:		 .asciiz  " " # Make a space
Prompt:      .asciiz "\nEnter an  integer:  "
secPrompt:   .asciiz "\nEnter a number between 1 and 20: "
             .text
main:  		
			 li  $t0, 20  # $t0 for keep track the number of integers to be read
             la  $t1, array  # loading the starting address of the array
loop:	
			 la  $a0, Prompt # Prompt the user to enter a number
             li  $v0, 4
             syscall
             li  $v0, 5        # read the integer
             syscall
             sw  $v0, 0($t1)  # storing the integer entered
             addi $t0, $t0, -1  # decrement the counter
             addi $t1, $t1, 4  # load the address of the next integer
             bgtz $t0, loop # branch to read and store the next integer if the counter > 0
             li $t0, 20 # reset the counter
             la $t1, array # reset the starting address of the array
Lines: 
			 lw $a0, 0($t1) # load an integer from memory location to $a0
             li $v0, 1 # print the integer
             syscall
             addi $t0, $t0, -1 #decrement the counter
             addi $t1, $t1, 4 # load the address of the next integer        
             la $a0, newLine # start a new line
             li $v0, 4
             syscall
             bgtz $t0, Lines # if counter > 0, loop
			 li $t0, 20 # reset the counter
			 la $t1, array # reset the starting address of the array
Spaces:       
			 lw $a0, 0($t1) # load an integer from memory location to $a0
             li $v0, 1 # print the integer
             syscall
             addi $t0, $t0, -1 # decrement the counter
             addi $t1, $t1, 4 # load the address of the next integer         
             la $a0, space # make a space
             li $v0, 4
             syscall
             bgtz  $t0, Spaces # if counter > 0, loop
			 la $a0, newLine # start a new line
             li $v0, 4
             syscall
			 li $t0, 20 # reset the counter
			 la $t1, array # reset the starting address of the array
revSpaces:
			 lw $a0, 76($t1) # load an integer from memory location to $a0 with an offset of 76
             li $v0, 1 # print the integer
             syscall
             addi $t0, $t0, -1 # decrement the counter
             addi $t1, $t1, -4 # load the address of the next integer
             la $a0, space # make a space
             li $v0, 4
             syscall
             bgtz  $t0, revSpaces # if counter > 0, loop
			 la $a0, secPrompt # print to screen the second prompt
			 li $v0, 4
			 syscall
			 li $v0, 5 # get a number from the user and store it in v0
			 syscall
			 move $t2, $v0 # copy v0 to t2; keep t2 to reset t3 later
			 move $t3, $t2 # copy t2 to t3; t3 counts how many numbers per line
			 li $t4, 0 # keep a counter to keep track of how many numbers have been printed from the array
			 la $t1, array # reset the starting address of the array
nNumbers: 
			 lw $a0, 0($t1) # load an integer from memory location to $a0
             li $v0, 1 # print the integer
             syscall
             addi $t3, $t3, -1 # decrement the counter for numbers per line
             addi $t1, $t1, 4 # load the address of the next integer
			 addi $t4, $t4, 1 # increment the counter for total numbers printed
             la $a0, space # make a space
             li $v0, 4
             syscall
			 beq $t4, 20, endProgram # if the last number in the array has been read, end the program
			 bne $t3, 0, nNumbers # if t3 != 0, loop
			 la $a0, newLine # start a new line
             li $v0, 4
             syscall
			 move $t3, $t2 # copy t2 to t3 to reset the counter
			 j nNumbers # jump back to the nNumbers loop now that t3 has been reset
endProgram:         
			 li $v0, 10 # end the program
             syscall