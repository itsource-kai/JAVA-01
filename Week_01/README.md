第一周学习笔记

字节码技术

- javap -c -verbose

类加载器

![image-20210113163816838](\image\image-20210113163816838.png)

内存模型

![image-20210113163929676](\image\image-20210113163929676.png)

启动参数

1. 系统属性参数
2. 运行模式参数
3. 堆内存设置参数
4. GC 设置参数
5. 分析诊断参数
6.  JavaAgent 参数

工具有哪些？

命令工具:

- jps
- jstat
- jmap
- jstack

图形化工具:

- jconsle
- jvisualvm
- jmc



GC 有哪些？都有什么特点？

- ![](\week_01_2\image-20210113163126798.png)
  - -XX:+UseG1GC                                            使用 G1 垃圾回收器
  - -XX:+UseConcMarkSweepGC                   使用 CMS 垃圾回收器
  - -XX:+UseSerialGC                                       使用串行垃圾回收器
  - -XX:+UseParallelGC                                   使用并行垃圾回收器
  - // Java 11+
    - -XX:+UnlockExperimentalVMOptions -XX:+UseZGC 
  - // Java 12+
    - -XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC



