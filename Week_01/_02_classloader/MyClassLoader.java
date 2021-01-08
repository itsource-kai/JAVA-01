package _02_classloader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {

    public static void main(String[] args){
        try {
            //实例化对象
            Object obj = new MyClassLoader().findClass("Hello.xlass").newInstance();
            //获取方法
            Method helloMethod = obj.getClass().getMethod("hello");
            //调用方法
            helloMethod.invoke(obj);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 加载文件
        File file = new File(MyClassLoader.class.getClassLoader().getResource(name).getFile());
        byte[] bytes = null;
        try {
            // 读取字节数据
            FileInputStream fileInputStream = new FileInputStream(file);
            long filelength = file.length();
            bytes = new byte[(int)filelength];

            fileInputStream.read(bytes);
            fileInputStream.close();

           // System.out.println(new String(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 字节数据转换
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255-bytes[i]);
        }
//        try {
//            FileOutputStream outputStream = new FileOutputStream("hello.txt");
//            outputStream.write(bytes);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // 返回解码的类
        return defineClass("Hello", bytes, 0, bytes.length);
        // parameter_relation
    }
}
