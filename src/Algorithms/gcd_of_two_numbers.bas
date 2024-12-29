LET A = 56
LET B = 98
WHILE A <> B
    IF A > B THEN
        LET A = A - B
    ELSE
        LET B = B - A
    END IF
WEND
PRINT "GCD is "; A
