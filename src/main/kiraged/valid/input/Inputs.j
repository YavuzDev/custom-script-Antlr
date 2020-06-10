.class public Inputs
.super java/lang/Object

.field public static x I
.field public static d D
.field public static b Z
.field public static z I
.method static public <clinit>()V
.limit stack 32
new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
invokevirtual java/util/Scanner/nextInt()I
putstatic Inputs/x I
new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
invokevirtual java/util/Scanner/nextDouble()D
putstatic Inputs/d D
new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
invokevirtual java/util/Scanner/nextBoolean()Z
putstatic Inputs/b Z
new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
invokevirtual java/util/Scanner/nextInt()I
putstatic Inputs/z I
return
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 100

getstatic java/lang/System/out Ljava/io/PrintStream;
invokestatic Inputs/test()I
invokevirtual java/io/PrintStream/println(I)V
  return
.end method
.method public static test()I

new java/util/Random
dup
invokespecial java/util/Random/<init>()V
new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
invokevirtual java/util/Scanner/nextInt()I
invokevirtual java/util/Random/nextInt(I)I
ireturn
.limit stack 8
.limit locals 10
.end method
