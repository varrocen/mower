package com.mowitnow;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mowitnow.model.Field;
import com.mowitnow.parser.GrassParser;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MowerApplication.class)
public class GrassParserTest {

	@Autowired
	private GrassParser grassParser;

	@Test
	public void testParseNull() {
		Optional<Field> grass = grassParser.parse(null);
		assertThat(grass.isPresent(), equalTo(false));
	}

	@Test
	public void testParseEmptyList() {
		Optional<Field> grass = grassParser.parse(new ArrayList<String>());
		assertThat(grass.isPresent(), equalTo(false));
	}

	@Test
	public void testParseNoMatches() {
		List<String> commands = new ArrayList<>();
		commands.add("1 2 N");
		commands.add("3 5");
		Optional<Field> grass = grassParser.parse(commands);
		assertThat(grass.isPresent(), equalTo(false));
	}

	@Test
	public void testParseNoMatchesNegative() {
		List<String> commands = new ArrayList<>();
		commands.add("-1 -1");
		Optional<Field> grass = grassParser.parse(commands);
		assertThat(grass.isPresent(), equalTo(false));
	}

	@Test
	public void testParseNoMatchesWrongCommand() {
		List<String> commands = new ArrayList<>();
		commands.add("@!aB12");
		Optional<Field> grass = grassParser.parse(commands);
		assertThat(grass.isPresent(), equalTo(false));
	}

	@Test
	public void testParseMatches() {
		List<String> commands = new ArrayList<>();
		commands.add("3 5");
		commands.add("1 2 N");
		Optional<Field> grass = grassParser.parse(commands);
		assertThat(grass.isPresent(), equalTo(true));
		assertThat(grass.get().getWidth(), equalTo(3));
		assertThat(grass.get().getHeight(), equalTo(5));
	}

}
