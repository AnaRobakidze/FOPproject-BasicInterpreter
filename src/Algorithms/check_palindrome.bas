LET N = 12321
LET ORIGINAL = N
LET REVERSE = 0
WHILE N > 0
    LET REVERSE = REVERSE * 10 + (N MOD 10)
    LET N = N \ 10
WEND
IF ORIGINAL = REVERSE THEN
    PRINT "Palindrome"
ELSE
    PRINT "Not Palindrome"
END IF
