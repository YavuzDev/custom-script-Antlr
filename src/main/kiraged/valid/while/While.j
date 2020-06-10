.class public While
.super java/lang/Object

.field public static x I
.method static public <clinit>()V
.limit stack 8
ldc 10
putstatic While/x I
return
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 100

Label_1917513796_start:
getstatic While/x I
ldc 0
if_icmple Label_1182320432_else
iconst_1
goto Label_1182320432_end
Label_1182320432_else:
iconst_0
Label_1182320432_end:
iconst_1
if_icmpne Label_1917513796_end
getstatic java/lang/System/out Ljava/io/PrintStream;
getstatic While/x I
invokevirtual java/io/PrintStream/println(I)V
getstatic While/x I
ldc 1
isub
putstatic While/x I
goto Label_1917513796_start
Label_1917513796_end:
Label_1734853116_start:
getstatic While/x I
ldc 10
if_icmpeq Label_703504298_else
iconst_1
goto Label_703504298_end
Label_703504298_else:
iconst_0
Label_703504298_end:
iconst_1
if_icmpne Label_1734853116_end
getstatic java/lang/System/out Ljava/io/PrintStream;
getstatic While/x I
invokevirtual java/io/PrintStream/println(I)V
getstatic While/x I
ldc 1
iadd
putstatic While/x I
goto Label_1734853116_start
Label_1734853116_end:
  return
.end method
