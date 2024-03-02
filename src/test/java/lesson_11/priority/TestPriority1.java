package lesson_11.priority;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TestPriority1 {

    @Test(priority = 7)
    public void a() {
        assertTrue(true);
    }

    @Test(priority = 6)
    public void b() {
        assertTrue(true);
    }

    @Test(priority = 5)
    public void c() {
        assertTrue(true);
    }

    @Test(priority = 4)
    public void d() {
        assertTrue(true);
    }

    @Test(priority = 3)
    public void e() {
        assertTrue(true);
    }

    @Test(priority = 2)
    public void f() {
        assertTrue(true);
    }

    @Test(priority = 1)
    public void g() {
        assertTrue(true);
    }

    @Test(dependsOnMethods = "b1")
    public void a1() {
        assertTrue(true);
    }

    @Test(dependsOnMethods = "c1")
    public void b1() {
        assertTrue(true);
    }

    @Test(dependsOnMethods = "d1")
    public void c1() {
        assertTrue(true);
    }

    @Test(dependsOnMethods = "e1")
    public void d1() {
        assertTrue(true);
    }

    @Test(dependsOnMethods = "f1")
    public void e1() {
        assertTrue(true);
    }

    @Test(dependsOnMethods = "g1")
    public void f1() {
        assertTrue(true);
    }

    @Test
    public void g1() {
        assertTrue(true);
    }
}
