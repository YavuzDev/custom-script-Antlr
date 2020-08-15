.class public Script
.super java/lang/Object

.field public static randomNumber I
.field public static guessed Z
.method static public <clinit>()V
.limit stack 16
new java/util/Random
dup
invokespecial java/util/Random/<init>()V
ldc 10
invokevirtual java/util/Random/nextInt(I)I
putstatic Script/randomNumber I
iconst_0
putstatic Script/guessed Z
return
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 100

Label_2048834776_start:
getstatic Script/guessed Z
iconst_0
if_icmpne Label_1605283233_else
iconst_1
goto Label_1605283233_end
Label_1605283233_else:
iconst_0
Label_1605283233_end:
iconst_1
if_icmpne Label_2048834776_end
new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
invokevirtual java/util/Scanner/nextInt()I
istore 0
iload 0
getstatic Script/randomNumber I
if_icmpne Label_55331187_else
iconst_1
goto Label_55331187_end
Label_55331187_else:
iconst_0
Label_55331187_end:
iconst_1
if_icmpne Label_868737467_else
getstatic java/lang/System/out Ljava/io/PrintStream;
iconst_1
invokevirtual java/io/PrintStream/println(Z)V
iconst_1
putstatic Script/guessed Z
goto Label_868737467_end
Label_868737467_else:
getstatic java/lang/System/out Ljava/io/PrintStream;
iconst_0
invokevirtual java/io/PrintStream/println(Z)V
Label_868737467_end:
goto Label_2048834776_start
Label_2048834776_end:
  return
.end method
