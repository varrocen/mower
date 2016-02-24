package com.mowitnow;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mowitnow.model.Movable;
import com.mowitnow.parser.MowerParser;
import com.mowitnow.utils.Orientation;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MowerApplication.class)
public class MowerParserTest {

	@Autowired
	private MowerParser mowerParser;

	@Test
	public void testParseNull() {
		List<Movable> mowers = mowerParser.parse(null);
		assertThat(mowers.isEmpty(), equalTo(true));
	}

	@Test
	public void testParseEmpty() {
		List<String> commands = new ArrayList<>();
		List<Movable> mowers = mowerParser.parse(commands);
		assertThat(mowers.isEmpty(), equalTo(true));
	}

	@Test
	public void testParseNoCommands() {
		List<String> commands = new ArrayList<>();
		commands.add("5 5");
		List<Movable> mowers = mowerParser.parse(commands);
		assertThat(mowers.isEmpty(), equalTo(true));
	}

	@Test
	public void testParseOneMower() {
		List<String> commands = new ArrayList<>();
		commands.add("5 5");
		commands.add("1 2 N");
		commands.add("GAGAGAGAA");
		List<Movable> mowers = mowerParser.parse(commands);
		assertThat(mowers.isEmpty(), equalTo(false));
		assertThat(mowers.size(), equalTo(1));
		assertThat(mowers.get(0).getCoordinate().getX(), equalTo(1));
		assertThat(mowers.get(0).getCoordinate().getY(), equalTo(2));
		assertThat(mowers.get(0).getCoordinate().getOrientation(), equalTo(Orientation.N));
		assertThat(mowers.get(0).getInstructions(), equalTo("GAGAGAGAA"));
	}

	@Test
	public void testParseTwoMowers() {
		List<String> commands = new ArrayList<>();
		commands.add("5 5");
		commands.add("1 2 N");
		commands.add("GAGAGAGAA");
		commands.add("3 3 E");
		commands.add("AADAADADDA");
		List<Movable> mowers = mowerParser.parse(commands);
		
		assertThat(mowers.isEmpty(), equalTo(false));
		assertThat(mowers.size(), equalTo(2));
		assertThat(mowers.get(0).getCoordinate().getX(), equalTo(1));
		assertThat(mowers.get(0).getCoordinate().getY(), equalTo(2));
		assertThat(mowers.get(0).getCoordinate().getOrientation(), equalTo(Orientation.N));
		assertThat(mowers.get(0).getInstructions(), equalTo("GAGAGAGAA"));
		
		assertThat(mowers.get(1).getCoordinate().getX(), equalTo(3));
		assertThat(mowers.get(1).getCoordinate().getY(), equalTo(3));
		assertThat(mowers.get(1).getCoordinate().getOrientation(), equalTo(Orientation.E));
		assertThat(mowers.get(1).getInstructions(), equalTo("AADAADADDA"));
	}

	@Test
	public void testParseMissingsCoordinates() {
		List<String> commands = new ArrayList<>();
		commands.add("5 5");
		commands.add("1 2 N");
		commands.add("GAGAGAGAA");
		commands.add("AADAADADDA");
		List<Movable> mowers = mowerParser.parse(commands);
		
		assertThat(mowers.isEmpty(), equalTo(false));
		assertThat(mowers.size(), equalTo(1));
		assertThat(mowers.get(0).getCoordinate().getX(), equalTo(1));
		assertThat(mowers.get(0).getCoordinate().getY(), equalTo(2));
		assertThat(mowers.get(0).getCoordinate().getOrientation(), equalTo(Orientation.N));
		assertThat(mowers.get(0).getInstructions(), equalTo("GAGAGAGAA"));
	}
	
	@Test
	public void testParseMissingsInstructions() {
		List<String> commands = new ArrayList<>();
		commands.add("5 5");
		commands.add("1 2 N");
		commands.add("GAGAGAGAA");
		commands.add("3 3 E");
		List<Movable> mowers = mowerParser.parse(commands);
		
		assertThat(mowers.isEmpty(), equalTo(false));
		assertThat(mowers.size(), equalTo(1));
		assertThat(mowers.get(0).getCoordinate().getX(), equalTo(1));
		assertThat(mowers.get(0).getCoordinate().getY(), equalTo(2));
		assertThat(mowers.get(0).getCoordinate().getOrientation(), equalTo(Orientation.N));
		assertThat(mowers.get(0).getInstructions(), equalTo("GAGAGAGAA"));
	}
	
}
