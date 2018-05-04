package com.editor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class Main {

	public static void main(String[] args) throws IOException {
		Markdown md = new Markdown(new Content("./res/input.txt"));
		Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream("./res/output.html"), "UTF-16")); 
		writer.write(md.getInput());
		writer.close();	
	}
}
	
