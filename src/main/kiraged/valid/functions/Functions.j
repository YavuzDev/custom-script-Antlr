.class public Functions
.super java/lang/Object

.field public static x I
.field public static y D
.field public static z Z
.method static public <clinit>()V
.limit stack 24
ldc 50
putstatic Functions/x I
ldc2_w 80.0
putstatic Functions/y D
iconst_1
putstatic Functions/z Z
return
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 100

invokestatic Functions/testVoid()V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokestatic Functions/testInt()I
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 100
invokestatic Functions/testIntParameters(I)I
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 100
ldc 200
invokestatic Functions/testIntMath(II)I
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokestatic Functions/testIntExpression()I
ldc 1000
iadd
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokestatic Functions/testIntLocal()I
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokestatic Functions/testIntStatic()I
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokestatic Functions/testDouble()D
invokevirtual java/io/PrintStream/println(D)V
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc2_w 200.0
invokestatic Functions/testDoubleParameters(D)D
invokevirtual java/io/PrintStream/println(D)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokestatic Functions/testDoubleLocal()D
invokevirtual java/io/PrintStream/println(D)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokestatic Functions/testDoubleStatic()D
invokevirtual java/io/PrintStream/println(D)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokestatic Functions/testBoolean()Z
invokevirtual java/io/PrintStream/println(Z)V
getstatic java/lang/System/out Ljava/io/PrintStream;
iconst_0
invokestatic Functions/testBooleanParameters(Z)Z
invokevirtual java/io/PrintStream/println(Z)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokestatic Functions/testBooleanLocal()Z
invokevirtual java/io/PrintStream/println(Z)V
getstatic java/lang/System/out Ljava/io/PrintStream;
invokestatic Functions/testBooleanStatic()Z
invokevirtual java/io/PrintStream/println(Z)V
ldc 100
invokestatic Functions/testReturn(I)V
ldc 10
invokestatic Functions/testReturn(I)V
  return
.end method
.method public static testVoid()V

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 20
invokevirtual java/io/PrintStream/println(I)V
return
.limit stack 8
.limit locals 10
.end method
.method public static testVoidParameters(I)V

iload 0
istore 0
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 0
invokevirtual java/io/PrintStream/println(I)V
return
.limit stack 16
.limit locals 12
.end method
.method public static testInt()I

ldc 30
ireturn
.limit stack 8
.limit locals 10
.end method
.method public static testIntParameters(I)I

iload 0
istore 0
iload 0
ireturn
.limit stack 16
.limit locals 12
.end method
.method public static testIntMath(II)I

iload 0
istore 0
iload 1
istore 1
iload 0
iload 1
imul
iload 0
iadd
iload 0
iload 1
imul
iadd
ireturn
.limit stack 32
.limit locals 14
.end method
.method public static testIntExpression()I

ldc 1000
ireturn
.limit stack 8
.limit locals 10
.end method
.method public static testIntLocal()I

ldc 40
istore 0
iload 0
ireturn
.limit stack 8
.limit locals 11
.end method
.method public static testIntStatic()I

getstatic Functions/x I
ireturn
.limit stack 8
.limit locals 10
.end method
.method public static testDouble()D

ldc2_w 60.0
dreturn
.limit stack 8
.limit locals 10
.end method
.method public static testDoubleParameters(D)D

dload 0
dstore 0
dload 0
dreturn
.limit stack 16
.limit locals 12
.end method
.method public static testDoubleLocal()D

ldc2_w 70.0
dstore 0
dload 0
dreturn
.limit stack 8
.limit locals 11
.end method
.method public static testDoubleStatic()D

getstatic Functions/y D
dreturn
.limit stack 8
.limit locals 10
.end method
.method public static testBoolean()Z

iconst_0
ireturn
.limit stack 8
.limit locals 10
.end method
.method public static testBooleanParameters(Z)Z

iload 0
istore 0
iload 0
ireturn
.limit stack 16
.limit locals 12
.end method
.method public static testBooleanLocal()Z

iconst_0
istore 0
iload 0
ireturn
.limit stack 8
.limit locals 11
.end method
.method public static testBooleanStatic()Z

getstatic Functions/z Z
ireturn
.limit stack 8
.limit locals 10
.end method
.method public static testReturn(I)V

iload 0
istore 0
iload 0
ldc 100
if_icmpne Label_1897871865_else
iconst_1
goto Label_1897871865_end
Label_1897871865_else:
iconst_0
Label_1897871865_end:
iconst_1
if_icmpne Label_1071097621_end
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 0
invokevirtual java/io/PrintStream/println(I)V
return
goto Label_1071097621_end
Label_1071097621_end:
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 0
ldc 1000
imul
invokevirtual java/io/PrintStream/println(I)V
return
return
.limit stack 16
.limit locals 12
.end method
