//
// TestNG
//


import org.testng.annotations.Test
import static org.testng.Assert.assertEquals
import static org.testng.Assert.assertTrue

import geb.Browser

class SampleTestNGTest {
    @Test
    void additionIsWorking() {
        assertEquals 4, 2+2
        assertTrue true
    }

    @Test(expectedExceptions = ArithmeticException.class)
    void divideByZero() {
        println 1/0
    }
    
    @Test
    void browserTest() {
    	Browser.drive {
    		go "http://google.com/ncr"
    		assert title == "Google"
    		
    		// enter wikipedia into the search field
			$("input", name: "q").value("wikipedia")
		 
			// wait for the change to results page to happen
			// (google updates the page dynamically without a new request)
			waitFor { title.endsWith("Google Search") }
		 
			// is the first link to wikipedia?
			def firstLink = $("li.g", 0).find("a.l")
			assert firstLink.text() == "Wikipedia"
		 
			// click the link
			firstLink.click()
		 
			// wait for Google's javascript to redirect to Wikipedia
			waitFor { title == "Wikipedia" }
    	}
    }
}