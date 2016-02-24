package com.mowitnow;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mowitnow.model.Field;
import com.mowitnow.model.Movable;

public class MovableService {

	private static final Logger log = LoggerFactory.getLogger(MovableService.class);

	public void moveMovable(Field field, Movable movable) {
		log.info(field.toString());
		log.debug("Start");
		log.debug(movable.toString());

		char[] instructions = movable.getInstructions().toCharArray();
		for (int i = 0; i < instructions.length; i++) {
			switch (instructions[i]) {
			case 'D':
				movable.rotate90();
				break;
			case 'G':
				movable.rotate270();
				break;
			case 'A':
				if (field.isValidNextPosition(movable.getCoordinate())) {
					movable.move();
				} else {
					log.debug("No move");
				}
				break;
			default:
				break;
			}
		}

		log.info(movable.toString());
		log.debug("Stop");
	}

	public void moveMovables(Field field, List<Movable> movables) {
		for (Movable movable : movables) {
			moveMovable(field, movable);
		}
	}

}
