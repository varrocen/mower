package com.mowitnow;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mowitnow.model.impl.Mower;
import com.mowitnow.utils.Orientation;
import com.mowitnow.utils.impl.CoordinateImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MowerApplication.class)
public class MowerTest {

	@Test
	public void testMoveNORTH() {
		Mower mower = new Mower(new CoordinateImpl(0, 0, Orientation.N), "");
		mower.move();
		assertThat(mower.getCoordinate().getX(), equalTo(0));
		assertThat(mower.getCoordinate().getY(), equalTo(1));
		assertThat(mower.getCoordinate().getOrientation(), equalTo(Orientation.N));
	}

	@Test
	public void testMoveEAST() {
		Mower mower = new Mower(new CoordinateImpl(0, 0, Orientation.E), "");
		mower.move();
		assertThat(mower.getCoordinate().getX(), equalTo(1));
		assertThat(mower.getCoordinate().getY(), equalTo(0));
		assertThat(mower.getCoordinate().getOrientation(), equalTo(Orientation.E));
	}

	@Test
	public void testMoveSOUTH() {
		Mower mower = new Mower(new CoordinateImpl(1, 1, Orientation.S), "");
		mower.move();
		assertThat(mower.getCoordinate().getX(), equalTo(1));
		assertThat(mower.getCoordinate().getY(), equalTo(0));
		assertThat(mower.getCoordinate().getOrientation(), equalTo(Orientation.S));
	}

	@Test
	public void testMoveWEST() {
		Mower mower = new Mower(new CoordinateImpl(1, 1, Orientation.W), "");
		mower.move();
		assertThat(mower.getCoordinate().getX(), equalTo(0));
		assertThat(mower.getCoordinate().getY(), equalTo(1));
		assertThat(mower.getCoordinate().getOrientation(), equalTo(Orientation.W));
	}

}
