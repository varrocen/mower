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
		Orientation orientation = Orientation.N;
		orientation = orientation.rotate90();
		assertThat(orientation, equalTo(Orientation.E));
	}

	@Test
	public void testRotate90EAST() {
		Orientation orientation = Orientation.E;
		orientation = orientation.rotate90();
		assertThat(orientation, equalTo(Orientation.S));
	}

	@Test
	public void testRotate90SOUTH() {
		Orientation orientation = Orientation.S;
		orientation = orientation.rotate90();
		assertThat(orientation, equalTo(Orientation.W));
	}

	@Test
	public void testRotate90WEST() {
		Orientation orientation = Orientation.W;
		orientation = orientation.rotate90();
		assertThat(orientation, equalTo(Orientation.N));
	}

	@Test
	public void testRotate270NORTH() {
		Orientation orientation = Orientation.N;
		orientation = orientation.rotate270();
		assertThat(orientation, equalTo(Orientation.W));
	}

	@Test
	public void testRotate270WEST() {
		Orientation orientation = Orientation.W;
		orientation = orientation.rotate270();
		assertThat(orientation, equalTo(Orientation.S));
	}

	@Test
	public void testRotate270SOUTH() {
		Orientation orientation = Orientation.S;
		orientation = orientation.rotate270();
		assertThat(orientation, equalTo(Orientation.E));
	}

	@Test
	public void testRotate270EAST() {
		Orientation orientation = Orientation.E;
		orientation = orientation.rotate270();
		assertThat(orientation, equalTo(Orientation.N));
	}

}
