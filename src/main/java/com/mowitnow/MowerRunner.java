package com.mowitnow;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MowerRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(MowerRunner.class);

	@Autowired
	private ApplicationArguments applicationArguments;

	@Autowired
	private MovableProcessor movableProcessor;

	/*
	 * (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		if (applicationArguments.containsOption("file")) {
			List<String> files = applicationArguments.getNonOptionArgs();
			for (String file : files) {
				movableProcessor.process(file);
			}
		} else {
			log.info("Nothing to do !");
		}
	}

}
