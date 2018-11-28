package com.tian.jvm;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {
    public static void main(String[] args)  {
       /* ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }

                    byte[] bytes = new byte[is.available()];
                    is.read();

                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }

        };

        Object obj = myLoader.loadClass("com.tian.jvm.ClassLoaderTest").newInstance();

        System.out.println(obj.getClass());

        System.out.println(obj instanceof com.tian.jvm.ClassLoaderTest);
*/
    }
}
