LET N = 12345
LET REVERSE = 0
WHILE N > 0
    LET REVERSE = REVERSE * 10 + (N MOD 10)
    LET N = N \ 10
WEND
PRINT "Reversed number is "; REVERSE
