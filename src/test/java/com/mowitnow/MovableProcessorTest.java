package com.mowitnow;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mowitnow.model.Movable;
import com.mowitnow.model.impl.Grass;
import com.mowitnow.model.impl.Mower;
import com.mowitnow.utils.Orientation;
import com.mowitnow.utils.impl.CoordinateImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MowerApplication.class)
public class MovableProcessorTest {

	private Grass grass;

	@Before
	public void setUp() {
		grass = new Grass(5, 5);
	}
	
	@Autowired
	private MovableProcessor movableProcessor;

	@Test
	public void testMoveGrassNull() {
		Movable mower = new Mower(new CoordinateImpl(3, 3, Orientation.E), "AADAADADDA");
		movableProcessor.moveMovable(null, mower);
		assertThat(mower.getCoordinate().getX(), equalTo(3));
		assertThat(mower.getCoordinate().getY(), equalTo(3));
		assertThat(mower.getCoordinate().getOrientation(), equalTo(Orientation.E));
	}
	
	@Test
	public void testMoveMowerNull() {
		Movable mower = new Mower(new CoordinateImpl(3, 3, Orientation.E), "AADAADADDA");
		movableProcessor.moveMovable(grass, null);
		assertThat(mower.getCoordinate().getX(), equalTo(3));
		assertThat(mower.getCoordinate().getY(), equalTo(3));
		assertThat(mower.getCoordinate().getOrientation(), equalTo(Orientation.E));
	}
	
	@Test
	public void testMoveMower() {
		Movable mower = new Mower(new CoordinateImpl(1, 2, Orientation.N), "GAGAGAGAA");
		movableProcessor.moveMovable(grass, mower);
		assertThat(mower.getCoordinate().getX(), equalTo(1));
		assertThat(mower.getCoordinate().getY(), equalTo(3));
		assertThat(mower.getCoordinate().getOrientation(), equalTo(Orientation.N));
	}

	@Test
	public void testMoveMowerWithInvalidNextPosition() {
		Movable mower = new Mower(new CoordinateImpl(3, 3, Orientation.E), "AADAADADDA");
		movableProcessor.moveMovable(grass, mower);
		assertThat(mower.getCoordinate().getX(), equalTo(5));
		assertThat(mower.getCoordinate().getY(), equalTo(1));
		assertThat(mower.getCoordinate().getOrientation(), equalTo(Orientation.E));
	}

}
