package com.editor;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Content {
	private StringBuffer content;
	
	public Content(String fileName) {

		this.content = new StringBuffer();
		try {
			Scanner scanner = new Scanner(new File(fileName));
			scanner.useDelimiter("\\\\n");
			while(scanner.hasNext()) {
				this.content.append(scanner.next());
			}
			scanner.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public String getContent() {
		return this.content.toString();
	}
}
