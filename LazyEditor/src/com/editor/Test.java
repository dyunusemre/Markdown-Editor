package com.editor;

public class Test {
	public static void main(String[] args) {
		Markdown testMd = new Markdown("_italic yazi_");
		String testText = "<p><em>italic yazi</em></p>";
		if(testMd.getInput().equals(testText)) {
			System.out.println(true);
		}else {
			System.out.println("Test fails!!");
		}
		testText = "<p><em>italik <strong>hem koyu hem italik</strong></em></p>";
		testMd.setInput("_italik *hem koyu hem italik*_");
		testMd.tokenize();
		if(testMd.getInput().equals(testText)) {
			System.out.println(true);
		}else {
			System.out.println("Test fails!!");
		}
		testText = " <p>​<a href=”http://site.com”>bu metin *koyu  değildir*</a></p>";
		testMd.setInput("[bu metin *koyu değildir*](http://site.com)");
		testMd.tokenize();
		if(testMd.getInput().equals(testText)) {
			System.out.println(true);
		}else {
			System.out.println("Test fails!!");
		}
		
		
	}
}
