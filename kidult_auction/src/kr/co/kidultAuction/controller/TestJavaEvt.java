package kr.co.kidultAuction.controller;

public class TestJavaEvt  {
private Test t;
	public TestJavaEvt(Test t) {
		this.t=t;
		t.getJtf().setText("hi!!!!!");
		String s=t.getJtf().getText();
		System.out.println(s);
	}
}
