package hw_05_03;
/*Создайте класс, в нем определите 3 поля, к этим полям создайте конструкторы и методы.
Под средством рефлексии получите всю информацию о полях, методах, конструкторах,
а также модификаторах доступа.
 */


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Sample{
    private int val;       //Modifier.PRIVATE = 2
    protected String str;  //Modifier.PROTECTED = 4
    public Boolean logic;  //Modifier.PUBLIC = 1

    public Sample() { }

    private Sample(int val, String str) {
        this.val = val;
        this.str = str;
    }

    protected Sample(int val, String str, Boolean logic) {
        this.val = val;
        this.str = str;
        this.logic = logic;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void anyMethod(String str){
        this.str = str;
        System.out.println("Hello! " + str);
    }

    private void someMethod(int val, String str){
        this.val = val;
        this.str = str;
    }

    @Override
    public String toString() {
        return "Sample{" + "val =" + val + ", str ='" + str +
                '\'' + ", logic =" + logic + '}';
    }
}

public class Main {
    public static void main(String[] args) {

        Class<?> cls = Sample.class;
        System.out.println("Class name: " + cls.getSimpleName());
        System.out.println("======================");

        try {
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                Class<?> fld = field.getType();
                System.out.println("Field name : " + field.getName());
                System.out.println("Field modifier : " + field.getModifiers());
                System.out.println("Field type : " + fld.getName());
                System.out.println("    ");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("======================");

        try {
            Constructor[] constructors = cls.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                System.out.println("Constructor name : " + constructor.getName());
                System.out.println("Constructor modifier : " + constructor.getModifiers());
                Class<?>[] parameter = constructor.getParameterTypes();
                System.out.print("Constructor parameters : ");
                for (Class<?> param : parameter) {
                    System.out.print(param.getName() + ", ");
                }
                System.out.println("\n ");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("======================");

        try{
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                method.setAccessible(true);
                System.out.println("Method name : " + method.getName());
                System.out.println("Method modifier : " + method.getModifiers());
                System.out.println("Method return type : " + method.getReturnType().getName());

                Class<?>[] params = method.getParameterTypes();
                System.out.print("Method parameters : ");
                for (Class<?> paramType : params) {
                    System.out.print(paramType.getName() + ", ");
                }
                System.out.println("\n ");
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
