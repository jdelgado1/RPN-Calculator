# Discussion

**Document all error conditions you determined and why they are error
 conditions. Do this by including the inputs that you used to test your
  program and what error conditions they exposed:**
  
  The first error encountered was if the user entered something other than an integer, 
  operation or command, such as entering the word blah. Nothing happened when something
  like this was entered and rightfully so because the calc program can't do anything
  with the information that was provided. To solve this, I added an else statement at the
  end of the major if else if statement in main, and I printed out an error to the user 
  indicating the token entered was invalid.  
  
  Another error encountered was when there were too few operands in the stack for a given
  operation. For example, I entered 2 +, and I got an empty exception since b, or the second
  value in the stack was empty and therefore nothing with int b could be carried out since b,
  the top of the stack after popping a (the first value) was empty, there was nothing there.
  This caused the top() method in LinkedStack to throw an empty exception. To fix this problem, 
  I added if statements that checked if the stack was empty as well as printed out that there were
  not enough argument to carry put the operation. If it was empty at this point, a was popped back in. 
  I also added one of these if statements at the very beginning of the doOperation method to check if
  an operation was inputted while the stack was completely empty, in which case only an error statement
  was printed to the user.
  
  This program originally had trouble identifying negative numbers because when I typed in something 
  like 2 3 -5, it would recognize the -5 as an invalid token when it was actually valid. The problem was 
  in the isNumeric function, so I added an if statement checking if the first char in the input string was 
  the negative sign, if it was, then the
  original loop would start at 1 to check if all the other characters in the string were numbers to 
  determine if
  the string was numeric. Also the string would not be numberic if there were no more values in the 
  string other than the minus sign. 
  
  There was also an error in the . operation. If I entered . when the stack was empty, LinkedStack threw 
  an empty exception because the stack was empty and so stack.top() was nothing. To fix this I added an 
  if else block where if the stack was empty, an error message was printed out and otherwise the element at 
  the top of the stack was printed out.
  
  Divide by 0 error. I did something like 2 3 4 0 / and obviously you can't divide by zero
  since this is mathematically undefined. An arithmetic exception was thrown, and so I 
  added in doOperation method a simple if statement determining whether the
  parameters for the get result function would be illegal, in this case, the operation
  DIVIDED, and the divisor being zero. In thar case, the two number popped were pushed
  in the correct order they were in before. Otherwise, result would be called as it 
  normally would. 
  
  Mod by 0 error. Similar to the divide by zero error, mod 0 cannot be calculated because 
  this operation also relies on dividing the first number by the second number and subtracting
  that answer of that division from the first number, and the number must be an integer in
  this case. I entered something like 2 4 0 mod, and an arithmetic exception was thrown because 
  again, the divisor can't be zero as anything divided by zero is undefined mathematically. 
  To solve this problem, I added in the if from the solution to the previous error, a statement 
  checking if the input stream (that is an operation is modulo and if the a value, or top of the 
  stack, is zero. If that is the case, an error statement would be printed out, and the two values 
  that the operation would have used to calculate the results, were popped back into the sports they 
  belong in the stack. 
  

  
  
  
  