package com.mowitnow;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mowitnow.model.Field;
import com.mowitnow.model.Movable;
import com.mowitnow.model.impl.Grass;
import com.mowitnow.model.impl.Mower;
import com.mowitnow.utils.Orientation;
import com.mowitnow.utils.impl.CoordinateImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MowerApplication.class)
public class MovableProcessorTest {

	@Autowired
	private MovableProcessor movableProcessor;

	@Test
	public void testMoveMower() {
		Field grass = new Grass(5, 5);
		Movable mower = new Mower(new CoordinateImpl(1, 2, Orientation.NORTH), "GAGAGAGAA");

		movableProcessor.moveMovable(grass, mower);

		assertThat(mower.getCoordinate().getX(), equalTo(1));
		assertThat(mower.getCoordinate().getY(), equalTo(3));
		assertThat(mower.getCoordinate().getOrientation(), equalTo(Orientation.NORTH));
	}

	@Test
	public void testMoveMowers() {
		Grass grass = new Grass(5, 5);
		Movable mower1 = new Mower(new CoordinateImpl(1, 2, Orientation.NORTH), "GAGAGAGAA");
		Movable mower2 = new Mower(new CoordinateImpl(3, 3, Orientation.EAST), "AADAADADDA");

		List<Movable> mowers = new ArrayList<>();
		mowers.add(mower1);
		mowers.add(mower2);

		movableProcessor.moveMovables(grass, mowers);

		assertThat(mower1.getCoordinate().getX(), equalTo(1));
		assertThat(mower1.getCoordinate().getY(), equalTo(3));
		assertThat(mower1.getCoordinate().getOrientation(), equalTo(Orientation.NORTH));

		assertThat(mower2.getCoordinate().getX(), equalTo(5));
		assertThat(mower2.getCoordinate().getY(), equalTo(1));
		assertThat(mower2.getCoordinate().getOrientation(), equalTo(Orientation.EAST));
	}

}
