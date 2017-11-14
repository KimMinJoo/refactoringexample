package com.naver.example.magicnumber;

/**
 * Created by kim.minjoo on 2017-11-14.
 */
public class RefactoringPrev {
	private final String _name;

	public RefactoringPrev(String name) {
		this._name = name;
	}

	public void order(int command) {
		if (command ==0) {
			System.out.println(this._name + " walks.");
		} else if (command == 1) {
			System.out.println(this._name + " stops.");
		} else if (command == 2) {
			System.out.println(this._name + " jumps.");
		} else {
			System.out.println("Command eroor. command = " + command);
		}
	}
}
