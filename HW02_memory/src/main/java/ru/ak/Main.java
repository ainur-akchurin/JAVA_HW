package ru.ak;


import java.lang.reflect.Type;

public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InterruptedException {
        //Example
        sizeOfObject(new Object[]{1,2,3});
        sizeOfObject(new String("aaa"));
        sizeOfObject(1);
        sizeOfObject(new Integer(1));
        sizeOfObject(new char[5]);
        sizeOfObject("aa");
        sizeOfObject("a");
    }

    public static void sizeOfObject(Object o) throws IllegalAccessException, InstantiationException, InterruptedException {

            switch (o.getClass().getSimpleName()){
                case "Boolean":;
                case "Byte":;
                case "Short":;
                case "Char":;
                case "Integer":;
                case "Float":;
                case "Double":;
                case "Long":
                    System.out.println(o.toString()+" is primitive type");
                    System.out.println();
                    return;
            }


            final int mb = 1_048_576;
            final char approx = '\u2248'; // ≈
            int size = 2_000_000;
            Runtime runtime = Runtime.getRuntime();

            long mem = runtime.totalMemory() - runtime.freeMemory();//used memory

            System.out.println("Total memory ≈ "+runtime.totalMemory()/mb+" mb");
            System.out.println("Used memory ≈ "+ mem/mb+" mb");
            System.out.println("Free memory before object creation ≈ "+runtime.freeMemory()/mb+" mb");
            System.out.println("Create object type of: "+o.getClass().getSimpleName());

            Object[] array = new Object[size];

            long mem2 = runtime.totalMemory() - runtime.freeMemory();

            System.out.println("Reference size: "+(mem2-mem)/size +" bytes");

            Type type = o.getClass().getGenericSuperclass();
            for(int i = 0; i<size;i++){
                array[i] = ((Class) type).newInstance();
            }

            long mem3 = runtime.totalMemory() - runtime.freeMemory();

            System.out.println("Object size ≈ "+(mem3-mem2)/ size +" bytes");
            System.out.println();
            System.gc();
            Thread.sleep(10);

    }
}
