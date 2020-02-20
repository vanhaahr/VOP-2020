/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.and.replace;

import java.net.URL;
import java.util.ResourceBundle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kenneth Haahr
 */
public class FXMLDocumentControllerTest {
    
    public FXMLDocumentControllerTest() {
    }

    /**
     * Test of initialize method, of class FXMLDocumentController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        FXMLDocumentController instance = new FXMLDocumentController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTextArea method, of class FXMLDocumentController.
     */
    @Test
    public void testSetTextArea() throws Exception {
        System.out.println("setTextArea");
        FXMLDocumentController instance = new FXMLDocumentController();
        instance.setTextArea();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chooseFile method, of class FXMLDocumentController.
     */
    @Test
    public void testChooseFile() throws Exception {
        System.out.println("chooseFile");
        FXMLDocumentController instance = new FXMLDocumentController();
        instance.chooseFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveAsFile method, of class FXMLDocumentController.
     */
    @Test
    public void testSaveAsFile() throws Exception {
        System.out.println("saveAsFile");
        FXMLDocumentController instance = new FXMLDocumentController();
        instance.saveAsFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
