import entity.MyClass;
import entity.MyClass1;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Iterator;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
/**
 * @author Feng Jie
 * @date 2022/4/19 10:31
 */
public class MockitoTest {
    @Test
    public void test1()  {
        //  创建 mock
        MyClass test = Mockito.mock(MyClass.class);

        // 自定义 getUniqueId() 的返回值
        when(test.getUniqueId()).thenReturn(43);
        System.out.println(test.getUniqueId());
        // 在测试中使用mock对象
        assertEquals(test.getUniqueId(), 43);
    }

    // 返回多个值
    @Test
    public void testMoreThanOneReturnValue()  {
        Iterator i= mock(Iterator.class);
        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        String result=i.next()+" "+i.next();
        System.out.println(result);
        // 断言
        assertEquals("Mockito rocks", result);
    }
    // 如何根据输入来返回值
    @Test
    public void testReturnValueDependentOnMethodParameter1()  {
        Comparable c= mock(Comparable.class);
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);
        System.out.println(c.compareTo("Mockito"));
        // 断言
        assertEquals(1,c.compareTo("Mockito"));
    }

    // 如何让返回值不依赖于输入
    @Test
    public void testReturnValueInDependentOnMethodParameter2()  {
        Comparable c= mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        // 断言
        assertEquals(-1 ,c.compareTo(9));
    }

    // 根据参数类型来返回值
    @Test
    public void testReturnValueInDependentOnMethodParameter()  {
        Comparable c= mock(Comparable.class);
        when(c.compareTo(isA(MyClass.class))).thenReturn(0);
        System.out.println(c.compareTo(new MyClass1(1)));

        // 断言
//        MyClass todo = new MyClass(5);
//        assertEquals(todo ,c.compareTo(new MyClass(1)));
    }

}
