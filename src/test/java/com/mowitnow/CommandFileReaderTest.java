package com.mowitnow;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mowitnow.reader.CommandFileReader;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MowerApplication.class)
public class CommandFileReaderTest {

	@Autowired
	private CommandFileReader commandFileReader;

	@Test
	public void testReadGoodFile() throws IOException {
		List<String> lines = commandFileReader.read("src/test/resources/mower.txt");
		assertThat(lines.size(), equalTo(5));
	}

	@Test(expected = IOException.class)
	public void testIOException() throws IOException {
		List<String> lines = commandFileReader.read("src/test/resources/mower.pdf");
	}

}
