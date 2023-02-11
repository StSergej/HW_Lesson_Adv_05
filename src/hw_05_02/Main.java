package hw_05_02;
/*Напишите программу, которая будет выводить всю информацию о классе,
пользователь сам выбирает, какой именно класс интересует.
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Main {

    public static void getInfoClass(Object obj) throws ClassNotFoundException {

        Class<?> cls = Class.forName("hw_05_02.SomeClass");//указываем путь к классу
        System.out.println("Name class: " + cls.getSimpleName());
        System.out.println("    ");


        try {
            Field[] fields = cls.getDeclaredFields();//получаем данные с полей класса
            for (Field field : fields) {
                Class<?> fld = field.getType();
                System.out.println("Field modifier : " + field.getModifiers());
                System.out.println("Field type : " + fld.getName());
                System.out.println("Field name : " + field.getName());
                System.out.println("=====================");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("    ");

        try {
            Constructor[] constructors = cls.getDeclaredConstructors();//конструкторы класса
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);//разрешаем доступ
                System.out.println("Constructor name : " + constructor.getName());
                System.out.println("Constructor modifier : " + constructor.getModifiers());

                Class<?>[] params = constructor.getParameterTypes();
                System.out.print("Constructor parameters : ");
                for (Class<?> param : params) {
                    System.out.print(param.getName());
                }
                System.out.println("\n=====================");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("  ");

        try{
            Method[] methods = cls.getDeclaredMethods();//методы класса
            for (Method method : methods) {
                method.setAccessible(true);//разрешаем доступ
                System.out.println("Method name : " + method.getName());
                System.out.println("Method modifier : " + method.getModifiers());
                System.out.println("Method return type : " + method.getReturnType().getName());

                Class<?>[] params = method.getParameterTypes();
                System.out.print("Method parameters : ");
                for (Class<?> paramType : params) {
                    System.out.print(paramType.getName());
                }
                System.out.println("\n=====================");
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    //Modifier.PUBLIC = 1   Modifier.PRIVATE = 2  Modifier.PROTECTED = 4

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> cl = Class.class;
        getInfoClass(cl);

    }
}
