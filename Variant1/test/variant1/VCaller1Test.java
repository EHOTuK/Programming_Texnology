package variant1;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author belya
 */
public class VCaller1Test {

    public VCaller1Test() {
    }

    @BeforeClass //метод выполняется перед всеми тестами один раз
    public static void setUpClass() {
    }

    @AfterClass //выполняется после всех тестов один раз
    public static void tearDownClass() {
    }

    /**
     * hиспользуется для указания того, что аннотированный метод должен
     * выполняться перед каждым @Test методом в текущем классе тестирования.
     */
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of filter method, of class VCaller1. Тест, если в метод передается
     * пустая строка, а список не пустой.
     *
     * Тест успешный, если ожидаемый список совпадает с полученным
     */
    @Test
    public void test1Filter() {
        System.out.println("filter");
        System.out.println("----1----");
        VCaller1 instance = new VCaller1();
        //добавляем элементы в список data
        instance.addElementList("test");
        instance.addElementList("egor");
        instance.addElementList("test or");
        instance.addElementList("good");
        String s = "";//задаем пустую строку
        //заполняем список элементами, которые ожидаем получить
        ArrayList<String> expResult = new ArrayList(Arrays.asList("test", "egor", "test or", "good"));
        ArrayList<String> result = instance.filter(s);//получаем результат метода
        assertEquals(expResult, result);//сравниваем ожидаемый результат с полученным
        System.out.println("Тест пройден успешно!");
    }

    /**
     * Test of filter method, of class VCaller1. Тест, если в метод передается
     * не пустая строка и список не пустой.
     *
     * Тест успешный, если ожидаемый список совпадает с полученным
     */
    @Test
    public void test2Filter() {
        System.out.println("filter");
        System.out.println("----2----");
        VCaller1 instance = new VCaller1();
        //добавляем элементы в список data
        instance.addElementList("test");
        instance.addElementList("egor");
        instance.addElementList("test or");
        instance.addElementList("good");
        String s = "test";//задаем строку, на которую хотим проверить
        ArrayList<String> expResult = new ArrayList();
        //заполняем список элементами, которые ожидаем получить
        expResult.add("test");
        expResult.add("test or");
        ArrayList<String> result = instance.filter(s);
        assertEquals(expResult, result);
        System.out.println("Тест пройден успешно!");
    }

    /**
     * Test of filter method, of class VCaller1. Тест, если в метод передается
     * не пустая строка, которую не содержит ни один элемент списка.
     *
     * Тест успешный, если ожидаемый список совпадает с полученным
     */
    @Test
    public void test3Filter() {
        System.out.println("filter");
        System.out.println("----3----");
        VCaller1 instance = new VCaller1();
        instance.addElementList("test");
        instance.addElementList("egor");
        instance.addElementList("test or");
        instance.addElementList("good");
        String s = "asgteh";//строку не содержит ни один из элементов списка
        ArrayList<String> expResult = new ArrayList();
        ArrayList<String> result = instance.filter(s);
        assertEquals(expResult, result);
        System.out.println("Тест пройден успешно!");
    }

    /**
     * Test of filter method, of class VCaller1. Добавим проверку на null.
     * Проверка результата на равенство null
     */
    @Test
    public void testFilter_NO_NULL() {

        System.out.println("filter");
        System.out.println("----4----");
        VCaller1 instance = new VCaller1();
        String s = "asgteh";
        ArrayList<String> result = instance.filter(s);//т.к. список пустой, а не null - тест успешный        
        assertNotNull(result);
        System.out.println("Тест пройден успешно!");
    }

    /**
     * Test of reverse method, of class VCaller1.
     * Проверка изменения порядка элементов вектора data
     */
    @Test
    public void test1Reverse() {
        System.out.println("reverse");
        System.out.println("----1-----");
        VCaller1 instance = new VCaller1();
        instance.addElementList("1");
        instance.addElementList("2");
        instance.addElementList("3");
        instance.addElementList("4");
        boolean expResult = true;//ожидаемый результат
        boolean result = instance.reverse();//получаем результат метода
        assertEquals(expResult, result);//тест успешный, т.к. порядок элементов изменен верно
        System.out.println("Тест пройден успешно!");
    }
    /**
     * Test of reverse2 method, of class VCaller1.
     * Проверка изменения порядка элементов вектора data
     */
    @Test
    public void test2Reverse() {
        System.out.println("reverse");
        System.out.println("----2-----");
        VCaller1 instance = new VCaller1();
        instance.addElementList("1");
        instance.addElementList("2");
        instance.addElementList("3");
        instance.addElementList("4");
        boolean expResult = true;
        boolean result = instance.reverse2();
        assertEquals(expResult, result);
        System.out.println("Тест пройден успешно!");
    }
}
