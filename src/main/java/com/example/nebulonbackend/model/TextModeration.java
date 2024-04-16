package com.example.nebulonbackend.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextModeration {
    private String text;
    private final String[] offensiveWords = {"idiot", "stupid", "dummy", "moron"};

    public TextModeration() {
        text = "Hey there! This is a sample text with some offensive words like idiot and stupid.";
    }
    public TextModeration(String text) {
        this.text = text;
    }

    public String getText() {return text;}
    public void setText(String text) {this.text = text;}

    // Method to moderate text
    public static String moderateText(String text, String[] offensiveWords) {
        // Create a pattern to match offensive words
        StringBuilder patternBuilder = new StringBuilder();
        patternBuilder.append("\\b(");
        for (int i = 0; i < offensiveWords.length; i++) {
            patternBuilder.append(Pattern.quote(offensiveWords[i]));
            if (i < offensiveWords.length - 1) {
                patternBuilder.append("|");
            }
        }
        patternBuilder.append(")\\b");
        Pattern pattern = Pattern.compile(patternBuilder.toString(), Pattern.CASE_INSENSITIVE);

        // Replace offensive words with asterisks
        Matcher matcher = pattern.matcher(text);
        StringBuilder moderatedText = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(moderatedText, "*".repeat(matcher.group().length()));
        }
        matcher.appendTail(moderatedText);

        return moderatedText.toString();
    }
}