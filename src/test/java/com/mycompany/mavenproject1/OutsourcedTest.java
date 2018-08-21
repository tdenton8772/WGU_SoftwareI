/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tdenton
 */
public class OutsourcedTest {
    
    public OutsourcedTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setCompanyName method, of class Outsourced.
     */
    @Test
    public void testBuildPart() {
        System.out.println("setCompanyName");
        String companyName = "companyName";
        int partID = 1234;
        String partName = "testPartName";
        Double price = 1.00;
        int inStock = 1;
        int min = 1;
        int max = 10;
        
        Outsourced instance = new Outsourced();
        instance.setCompanyName(companyName);
        instance.setPartID(partID);
        instance.setName(partName);
        instance.setPrice(price);
        instance.setInStock(inStock);
        instance.setMin(min);
        instance.setMax(max);
        
        String resultCompanyName = instance.getCompanyName();
        int resultPartID = instance.getPartID();
        String resultName = instance.getName();
        Double resultPrice = instance.getPrice();
        int resultInStock = instance.getInStock();
        int resultMin = instance.getMin();
        int resultMax = instance.getMax();
        
        assertEquals(companyName, resultCompanyName);
        assertEquals(partID, resultPartID);
        assertEquals(partName, resultName);
        assertEquals(price, resultPrice);
        assertEquals(inStock, resultInStock);
        assertEquals(min, resultMin);
        assertEquals(max, resultMax);
    }

    
}
