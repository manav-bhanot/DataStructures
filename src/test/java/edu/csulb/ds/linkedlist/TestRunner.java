/**
 * 
 */
package edu.csulb.ds.linkedlist;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author Manav
 *
 */
public class TestRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(LinkedListTest.class);
		
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());
	}

}
