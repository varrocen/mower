package com.mowitnow;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mowitnow.utils.Orientation;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MowerApplication.class)
public class OrientationTest {

	@Test
	public void testRotate90NORTH() {
		Orientation orientation = Orientation.NORTH;
		orientation = orientation.rotate90();
		assertThat(orientation, equalTo(Orientation.EAST));
	}

	@Test
	public void testRotate90EAST() {
		Orientation orientation = Orientation.EAST;
		orientation = orientation.rotate90();
		assertThat(orientation, equalTo(Orientation.SOUTH));
	}

	@Test
	public void testRotate90SOUTH() {
		Orientation orientation = Orientation.SOUTH;
		orientation = orientation.rotate90();
		assertThat(orientation, equalTo(Orientation.WEST));
	}

	@Test
	public void testRotate90WEST() {
		Orientation orientation = Orientation.WEST;
		orientation = orientation.rotate90();
		assertThat(orientation, equalTo(Orientation.NORTH));
	}

	@Test
	public void testRotate270NORTH() {
		Orientation orientation = Orientation.NORTH;
		orientation = orientation.rotate270();
		assertThat(orientation, equalTo(Orientation.WEST));
	}

	@Test
	public void testRotate270WEST() {
		Orientation orientation = Orientation.WEST;
		orientation = orientation.rotate270();
		assertThat(orientation, equalTo(Orientation.SOUTH));
	}

	@Test
	public void testRotate270SOUTH() {
		Orientation orientation = Orientation.SOUTH;
		orientation = orientation.rotate270();
		assertThat(orientation, equalTo(Orientation.EAST));
	}

	@Test
	public void testRotate270EAST() {
		Orientation orientation = Orientation.EAST;
		orientation = orientation.rotate270();
		assertThat(orientation, equalTo(Orientation.NORTH));
	}

}
