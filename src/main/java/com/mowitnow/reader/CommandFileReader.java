package com.mowitnow.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CommandFileReader {

	/**
	 * Read commands file
	 * 
	 * @param commandFile
	 * @return list of commands
	 * @throws IOException
	 */
	public List<String> read(String commandFile) throws IOException {
		Path file = Paths.get(commandFile);
		return Files.readAllLines(file);
	}

}
