LET N = 10
LET A = 0
LET B = 1
FOR I = 1 TO N
    LET TEMP = A
    LET A = B
    LET B = TEMP + B
NEXT I
PRINT "Nth Fibonacci number is "; A
