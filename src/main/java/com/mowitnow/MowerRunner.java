package com.mowitnow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mowitnow.reader.CommandFileReader;

@Component
public class MowerRunner implements CommandLineRunner {

	@Value("${command.file}")
	private String commandFile;

	@Autowired
	private CommandFileReader commandFileReader;

	@Override
	public void run(String... args) throws Exception {
		commandFileReader.read(commandFile);
	}

}
