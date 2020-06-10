.class public If
.super java/lang/Object

.field public static x I
.field public static y D
.field public static z I
.field public static k Z
.method static public <clinit>()V
.limit stack 32
ldc 50
putstatic If/x I
ldc2_w 100.0
putstatic If/y D
ldc 500
putstatic If/z I
iconst_1
putstatic If/k Z
return
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 100

getstatic If/x I
ldc 0
if_icmple Label_597255128_else
iconst_1
goto Label_597255128_end
Label_597255128_else:
iconst_0
Label_597255128_end:
iconst_1
if_icmpne Label_333362446_false
getstatic If/x I
ldc 50
if_icmpge Label_985397764_else
iconst_1
goto Label_985397764_end
Label_985397764_else:
iconst_0
Label_985397764_end:
iconst_1
if_icmpne Label_333362446_false
iconst_1
goto Label_333362446_end
Label_333362446_false:
iconst_0
Label_333362446_end:
iconst_1
if_icmpne Label_258754732_else
getstatic java/lang/System/out Ljava/io/PrintStream;
iconst_1
invokevirtual java/io/PrintStream/println(Z)V
goto Label_258754732_end
Label_258754732_else:
getstatic java/lang/System/out Ljava/io/PrintStream;
iconst_0
invokevirtual java/io/PrintStream/println(Z)V
Label_258754732_end:
getstatic If/y D
ldc2_w 20.0
dcmpl
ifge Label_837764579_else
iconst_1
goto Label_837764579_end
Label_837764579_else:
iconst_0
Label_837764579_end:
iconst_1
if_icmpne Label_1476394199_else
getstatic java/lang/System/out Ljava/io/PrintStream;
iconst_0
invokevirtual java/io/PrintStream/println(Z)V
goto Label_1476394199_end
Label_1476394199_else:
getstatic If/y D
ldc2_w 20.0
dcmpl
ifle Label_348100441_else
iconst_1
goto Label_348100441_end
Label_348100441_else:
iconst_0
Label_348100441_end:
iconst_1
if_icmpne Label_1007603019_false
getstatic If/y D
ldc2_w 100.0
dcmpl
ifgt Label_1597249648_else
iconst_1
goto Label_1597249648_end
Label_1597249648_else:
iconst_0
Label_1597249648_end:
iconst_1
if_icmpne Label_1007603019_false
iconst_1
goto Label_1007603019_end
Label_1007603019_false:
iconst_0
Label_1007603019_end:
iconst_1
if_icmpne Label_1501587365_end
getstatic java/lang/System/out Ljava/io/PrintStream;
iconst_1
invokevirtual java/io/PrintStream/println(Z)V
goto Label_1501587365_end
Label_1501587365_end:
Label_1476394199_end:
getstatic If/z I
ldc 50
if_icmpge Label_1333592072_else
iconst_1
goto Label_1333592072_end
Label_1333592072_else:
iconst_0
Label_1333592072_end:
iconst_1
if_icmpne Label_89387388_else
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 50
invokevirtual java/io/PrintStream/println(I)V
goto Label_89387388_end
Label_89387388_else:
getstatic If/z I
ldc 100
if_icmpne Label_1486371051_else
iconst_1
goto Label_1486371051_end
Label_1486371051_else:
iconst_0
Label_1486371051_end:
iconst_1
if_icmpne Label_655381473_else
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 100
invokevirtual java/io/PrintStream/println(I)V
goto Label_655381473_end
Label_655381473_else:
getstatic If/z I
ldc 200
if_icmpne Label_1694556038_else
iconst_1
goto Label_1694556038_end
Label_1694556038_else:
iconst_0
Label_1694556038_end:
iconst_1
if_icmpne Label_1121647253_else
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 200
invokevirtual java/io/PrintStream/println(I)V
goto Label_1121647253_end
Label_1121647253_else:
getstatic If/z I
ldc 300
if_icmpne Label_1291286504_else
iconst_1
goto Label_1291286504_end
Label_1291286504_else:
iconst_0
Label_1291286504_end:
iconst_1
if_icmpne Label_1508646930_right
goto Label_1508646930_true
Label_1508646930_right:
getstatic If/z I
ldc 500
if_icmpne Label_795372831_else
iconst_1
goto Label_795372831_end
Label_795372831_else:
iconst_0
Label_795372831_end:
iconst_1
if_icmpne Label_1508646930_false
Label_1508646930_true:
iconst_1
goto Label_1508646930_end
Label_1508646930_false:
iconst_0
Label_1508646930_end:
iconst_1
if_icmpne Label_1076496284_else
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 500
invokevirtual java/io/PrintStream/println(I)V
goto Label_1076496284_end
Label_1076496284_else:
getstatic java/lang/System/out Ljava/io/PrintStream;
iconst_0
invokevirtual java/io/PrintStream/println(Z)V
Label_1076496284_end:
Label_1121647253_end:
Label_655381473_end:
Label_89387388_end:
getstatic If/k Z
iconst_1
if_icmpne Label_1072601481_end
getstatic java/lang/System/out Ljava/io/PrintStream;
iconst_1
invokevirtual java/io/PrintStream/println(Z)V
goto Label_1072601481_end
Label_1072601481_end:
invokestatic If/testLocal()V
  return
.end method
.method public static testLocal()V

ldc 100
istore 0
iload 0
ldc 100
if_icmpne Label_1887813102_else
iconst_1
goto Label_1887813102_end
Label_1887813102_else:
iconst_0
Label_1887813102_end:
iconst_1
if_icmpne Label_121295574_end
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 0
invokevirtual java/io/PrintStream/println(I)V
goto Label_121295574_end
Label_121295574_end:
return
.limit stack 8
.limit locals 11
.end method
