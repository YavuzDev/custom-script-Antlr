.class public Variables
.super java/lang/Object

.field public static x I
.field public static y D
.field public static z Z
.field public static l Z
.field public static k I
.method static public <clinit>()V
.limit stack 40
ldc 50
putstatic Variables/x I
ldc2_w 50.5
putstatic Variables/y D
iconst_1
putstatic Variables/z Z
iconst_1
putstatic Variables/l Z
ldc 0
putstatic Variables/k I
return
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 100

invokestatic Variables/test()V
ldc 100
putstatic Variables/x I
iconst_0
putstatic Variables/z Z
getstatic java/lang/System/out Ljava/io/PrintStream;
getstatic Variables/x I
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
getstatic Variables/z Z
invokevirtual java/io/PrintStream/println(Z)V
getstatic java/lang/System/out Ljava/io/PrintStream;
getstatic Variables/l Z
invokevirtual java/io/PrintStream/println(Z)V
  return
.end method
.method public static test()V

ldc 50
istore 0
ldc2_w 50.5
dstore 1
iconst_1
istore 2
iload 0
ldc 500
iadd
istore 0
ldc2_w 20.0
dstore 1
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 0
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
dload 1
invokevirtual java/io/PrintStream/println(D)V
return
.limit stack 24
.limit locals 13
.end method
