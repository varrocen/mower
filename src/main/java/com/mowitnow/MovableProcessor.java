package com.mowitnow;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mowitnow.model.Field;
import com.mowitnow.model.Movable;
import com.mowitnow.parser.GrassParser;
import com.mowitnow.parser.MowerParser;
import com.mowitnow.reader.CommandFileReader;

@Component
public class MovableProcessor {

	private static final Logger log = LoggerFactory.getLogger(MovableProcessor.class);

	@Autowired
	private CommandFileReader commandFileReader;

	@Autowired
	private GrassParser grassParser;

	@Autowired
	private MowerParser mowerParser;

	/**
	 * Reads commands file and move mowers
	 * 
	 * @param file
	 *            commands file
	 */
	public void process(String file) {
		try {
			List<String> commands = commandFileReader.read(file);

			Optional<Field> field = grassParser.parse(commands);

			if (field.isPresent()) {
				List<Movable> movables = mowerParser.parse(commands);

				if (CollectionUtils.isNotEmpty(movables)) {

					for (Movable movable : movables) {
						moveMovable(field.get(), movable);
					}
				} else {
					log.error("No mower no beautiful lawn");
				}
			} else {
				log.error("Grass command is invalid : {}", commands.get(0));
			}

		} catch (Exception e) {
			log.error("Failed to read file", e);
		}
	}

	/**
	 * Reads the instructions and moves the movable
	 * 
	 * @param field
	 * @param movable
	 */
	public void moveMovable(Field field, Movable movable) {

		if (field != null && movable != null) {
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
					}
					break;
				default:
					break;
				}
			}
			log.info(movable.toString());
		}
	}

}
