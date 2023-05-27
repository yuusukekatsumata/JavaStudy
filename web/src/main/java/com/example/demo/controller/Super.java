package com.example.demo.controller;

public class Super {
	protected int a;
	protected int b;
	protected int c;
	
	public Super(int a) {
		this.constructor(a, 0, 0);
	}
	public Super(int a, int b) {
		this.constructor(a, b, 0);
	}
	public Super(int a, int b, int c) {
		this.constructor(a, b, c);
	}
	
	private void constructor(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		System.out.println("abc = " + (this.a + this.b + this.c));
	}
}
