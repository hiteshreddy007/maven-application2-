package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testEligibleStudent() {
        Student student = new Student("Test Alpha", "T001");
        student.registerSubject(new Subject("Sub1", 5));
        student.registerSubject(new Subject("Sub2", 5));
        student.registerSubject(new Subject("Sub3", 5)); // Total 15
        
        assertEquals(15, student.calculateTotalCredits());
        assertTrue(student.isEligible());
    }

    @Test
    public void testIneligibleStudent() {
        Student student = new Student("Test Beta", "T002");
        student.registerSubject(new Subject("Sub1", 4));
        student.registerSubject(new Subject("Sub2", 4)); // Total 8
        
        assertEquals(8, student.calculateTotalCredits());
        assertFalse(student.isEligible());
    }
}
