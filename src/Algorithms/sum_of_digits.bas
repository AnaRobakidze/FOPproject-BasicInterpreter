LET N = 12345
LET SUM = 0
WHILE N > 0
    LET SUM = SUM + (N MOD 10)
    LET N = N \ 10
WEND
PRINT "Sum of digits is "; SUM
