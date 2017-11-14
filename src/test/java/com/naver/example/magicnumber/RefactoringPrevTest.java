package com.naver.example.magicnumber;


import org.junit.Test;

/**
 * Created by kim.minjoo on 2017-11-14.
 */
public class RefactoringPrevTest {
	@Test
	public void test() {
		RefactoringPrev robot = new RefactoringPrev("Prev");
		robot.order(0); //walk
		robot.order(1); //stop
		robot.order(2); //jump
		robot.order(3); //error
	}
}