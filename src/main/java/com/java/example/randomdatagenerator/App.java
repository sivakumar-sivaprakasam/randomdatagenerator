package com.java.example.randomdatagenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class App {
	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			throw new IllegalArgumentException("Invalid argument passed. Argument #1: File name to save");
		}
		Files.deleteIfExists(Paths.get(args[0]));
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(args[0]))) {
			IntStream.rangeClosed(1,  20000000).forEach(i -> GenerateRandomAlphaNumeric.Generate(bw));
		}
	}
}

class GenerateRandomAlphaNumeric {
	static void Generate(BufferedWriter bw) {
		StringBuffer sb = new StringBuffer();
		for (int i = 100; i > 0; i -= 12) {
			int n = Math.min(12,  Math.abs(i));
			sb.append(Long.toString(Math.round(Math.random() * Math.pow(36,  n)), 36));
		}
		
		try {
			bw.write(sb.toString());
			bw.newLine();
		} catch (IOException ex) {
			
		}
	}
}
