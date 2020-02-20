/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.and.replace;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kenneth Haahr
 */
public class SearchAndReplaceTest {
    
    public SearchAndReplaceTest() {
    }

    /**
     * Test of start method, of class SearchAndReplace.
     */
    @Test
    public void testStart() throws Exception {
        System.out.println("start");
        Stage stage = null;
        SearchAndReplace instance = new SearchAndReplace();
        instance.start(stage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class SearchAndReplace.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        SearchAndReplace.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
