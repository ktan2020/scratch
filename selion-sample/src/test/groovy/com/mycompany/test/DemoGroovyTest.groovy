package com.mycompany.test

import org.testng.annotations.Test

import geb.Browser

import com.paypal.selion.annotations.WebTest
import com.paypal.selion.platform.grid.Grid
import com.paypal.selion.platform.html.TextField
import com.paypal.selion.platform.html.Button
import com.paypal.selion.platform.utilities.WebDriverWaitUtils

public class DemoGroovyTest {
	
  /**
   * This test case launches the google URL in the browser and search for the
   * string “SeLion”
   */
  @Test
  @WebTest
  public void test1() throws InterruptedException {
	
	//Launch the google URL in the browser
	def browser = new Browser()
	browser.driver = Grid.driver()
	browser.go "http://www.google.com/"
	
	//Define the text field
    def field = new TextField(".//input[@title='Search']")
	
	//Define Search button
	def search = new Button(".//input[@id='gbqfbb' or @type='submit']")

    //Thread will wait until TextField element present in the browser
    WebDriverWaitUtils.waitUntilElementIsPresent(field.getLocator())
	browser.waitFor { ! browser.title.contains("Yahoo!") }
	browser.waitFor { search.isVisible() }

    //Search for the string 'SeLion' in the text box
    field.type("selion\n")
	
	//Click on Search!
	//search.click()
    
    println("Done!")
  }
  
  /*
  @Test
  @WebTest
  public void test2() {
	assert true
	//runnerrun.main(["-v"])
  }
  */
  
}