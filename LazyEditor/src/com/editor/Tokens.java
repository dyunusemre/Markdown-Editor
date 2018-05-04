package com.editor;

import java.util.regex.Pattern;

public enum Tokens {

	HEAD_STAR ("(\\*\\*\\*)(.*?)(\\*\\*\\*)","<h1>$2</h1>"),
	ITALIC("(_)(.*?)(_)","<em>$2</em>"),
	IMG_LINK("/\\n\\!\\[([^\\[]+)\\]\\(([^\\)]+)\\)","<img src=\\'$2\\' alt=\\'$1\\'>"),
	LINK("/\\n\\[([^\\[]+)\\]\\(([^\\)]+)\\)","<a href=\\'$2\\'>$1</a>"),
	BOLD("(\\*)(.*?)\\1","<strong>$2</strong>"),
	EOF("(^)([^\\n].+)()","<p>$2</p>"),
	AMP("/\\n&","&amp;")
	;	
	
	private Pattern pattern;
	private String replacement;
	private String regex;
	
	Tokens (String regex) {
		setPattern(Pattern.compile(regex));
	}
	Tokens (String regex,String replacement) {
		setPattern(Pattern.compile(regex,Pattern.MULTILINE));
		setReplacement(replacement);
	}
	public String getRegex() {
		return regex;
	}
	public void setReplacement(String replacement) {
		this.replacement = replacement;
	}
	public String getReplacement() {
		return replacement;
	}
	public Pattern getPattern() {
		return pattern;
	}
	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}
}
