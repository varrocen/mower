package com.mowitnow;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mowitnow.model.impl.Grass;
import com.mowitnow.utils.Coordinate;
import com.mowitnow.utils.Orientation;
import com.mowitnow.utils.impl.CoordinateImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MowerApplication.class)
public class GrassTest {

	private Grass grass;

	@Before
	public void setUp() {
		grass = new Grass(5, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGrassWidthIllegalArgumentException() {
		new Grass(-1, 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGrassHeightIllegalArgumentException() {
		new Grass(5, -1);
	}

	@Test
	public void testIsValidCoordinateNull() {
		assertThat(grass.isValidNextPosition(null), equalTo(false));
	}
	
	@Test
	public void testIsValidNextPositionXNegativeReturnFalse() {
		Coordinate coordinate = new CoordinateImpl(-1, 0, Orientation.N);
		assertThat(grass.isValidNextPosition(coordinate), equalTo(false));
	}
	
	@Test
	public void testIsValidNextPositionXOutLimitReturnFalse() {
		Coordinate coordinate = new CoordinateImpl(6, 0, Orientation.N);
		assertThat(grass.isValidNextPosition(coordinate), equalTo(false));
	}
	
	@Test
	public void testIsValidNextPositionYNegativeReturnFalse() {
		Coordinate coordinate = new CoordinateImpl(0, -1, Orientation.N);
		assertThat(grass.isValidNextPosition(coordinate), equalTo(false));
	}
	
	@Test
	public void testIsValidNextPositionYOutLimitReturnFalse() {
		Coordinate coordinate = new CoordinateImpl(0, 6, Orientation.N);
		assertThat(grass.isValidNextPosition(coordinate), equalTo(false));
	}
	
	@Test
	public void testIsValidNextPositionNORTHReturnTrue() {
		Coordinate coordinate = new CoordinateImpl(0, 4, Orientation.N);
		assertThat(grass.isValidNextPosition(coordinate), equalTo(true));
	}

	@Test
	public void testIsValidNextPositionNORTHReturnFalse() {
		Coordinate coordinate = new CoordinateImpl(0, 5, Orientation.N);
		assertThat(grass.isValidNextPosition(coordinate), equalTo(false));
	}

	@Test
	public void testIsValidNextPositionEASTReturnTrue() {
		Coordinate coordinate = new CoordinateImpl(4, 0, Orientation.E);
		assertThat(grass.isValidNextPosition(coordinate), equalTo(true));
	}

	@Test
	public void testIsValidNextPositionEASTReturnFalse() {
		Coordinate coordinate = new CoordinateImpl(5, 0, Orientation.E);
		assertThat(grass.isValidNextPosition(coordinate), equalTo(false));
	}

	@Test
	public void testIsValidNextPositionSOUTHReturnTrue() {
		Coordinate coordinate = new CoordinateImpl(0, 1, Orientation.S);
		assertThat(grass.isValidNextPosition(coordinate), equalTo(true));
	}

	@Test
	public void testIsValidNextPositionSOUTHReturnFalse() {
		Coordinate coordinate = new CoordinateImpl(0, 0, Orientation.S);
		assertThat(grass.isValidNextPosition(coordinate), equalTo(false));
	}

	@Test
	public void testIsValidNextPositionWESTReturnTrue() {
		Coordinate coordinate = new CoordinateImpl(1, 0, Orientation.W);
		assertThat(grass.isValidNextPosition(coordinate), equalTo(true));
	}

	@Test
	public void testIsValidNextPositionNWESTReturnFalse() {
		Coordinate coordinate = new CoordinateImpl(0, 0, Orientation.W);
		assertThat(grass.isValidNextPosition(coordinate), equalTo(false));
	}

}
