package com.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Markdown {
	private String input;
	private List<Tokens> tokens; 
	public Markdown(Content content) {
		this.input = content.getContent();
		this.tokenize();
	}
	public Markdown(String text) {
		this.input = text;
		this.tokenize();
	}
	public void tokenize() {
		this.setTokens(new ArrayList<Tokens>());
		this.tokens.add(Tokens.AMP);
		this.tokens.add(Tokens.HEAD_STAR);
		this.tokens.add(Tokens.IMG_LINK);
		this.tokens.add(Tokens.ITALIC);
		this.tokens.add(Tokens.LINK);
		this.tokens.add(Tokens.BOLD);	
		this.tokens.add(Tokens.EOF);
		for(Tokens tokensInfo : this.tokens) {
			Matcher m = tokensInfo.getPattern().matcher(this.input);
			if(m.find()) {					
				this.input = m.replaceAll(tokensInfo.getReplacement());
			}	
		}
	}
	public void setTokens(ArrayList<Tokens> tokens) {
		this.tokens = tokens;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	
}
