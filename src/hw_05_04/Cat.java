package hw_05_04;
/*Создайте 2 класса, Animal и Cat.
В классе Animal инициализируйте 3 поля различных модификаторов.
В классе Cat используя рефлексию получите доступ к полям класса Animal
и измените содержимое каждого из полей.
 */

import java.lang.reflect.Field;

class Animal{

    private String name = "Tom";
    protected Boolean breed = false;
    public int age = 5;

    public Animal() { }

    @Override
    public String toString() {
        return "Animal { " + "name ='" + name + '\'' +
                ", breed ='" + breed + '\'' + ", age = " + age + " year }";
    }

}

public class Cat {
    public static void main(String[] args) {

        try{
            Class<?> cl = Animal.class;//Получаем доступ к классу Animal
            Animal cat = new Animal();//Создаем обьект класса Animal

            System.out.println(cat.toString());//Выводим информацию об обьекте
            System.out.println("  ");

            Field[] declaredFields = cl.getDeclaredFields();//Получаем информацию о полях класса Animal
            for (Field field : declaredFields) {
                System.out.println(field);
            }
            System.out.println("  ");

            Field ageNew = cl.getField("age");//обращаемся к переменной 'age' класса Animal
            ageNew.setInt(cat,2);//Изменяем значение поля 'age'

            Field nameNew = cl.getDeclaredField("name");//вызываем переменную 'name' класса Animal
            nameNew.setAccessible(true);//Разрешаем допуск к private полю
            nameNew.set(cat,"Simon");//Изменяем значение поля 'name'

            Field breedNew = cl.getDeclaredField("breed");//обращаемся к переменной 'breed' класса Animal
            breedNew.set(cat,true);//Изменяем значение поля 'breed'

            System.out.println(cat.toString());//Выводим новые данные об обьекте

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
