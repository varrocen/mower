package com.mowitnow.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import com.mowitnow.model.Movable;
import com.mowitnow.model.impl.Mower;
import com.mowitnow.utils.Coordinate;
import com.mowitnow.utils.Orientation;
import com.mowitnow.utils.impl.CoordinateImpl;

@Component
public class MowerParser {

	/**
	 * Parse commands and return a list of movable
	 * 
	 * @param commands
	 *            list of commands
	 * @return list of movable
	 */
	public List<Movable> parse(List<String> commands) {
		List<Movable> mowers = new ArrayList<>();

		if (CollectionUtils.isNotEmpty(commands) && commands.size() >= 3) {

			List<Coordinate> coordinates = new ArrayList<>();
			List<String> instructions = new ArrayList<>();

			// Ignore first command (grass)
			for (String command : commands.subList(1, commands.size())) {

				if (Pattern.matches("^[0-9] [0-9] [neswNESW]$", command)) {
					String[] coordinate = command.split(" ");
					coordinates.add(new CoordinateImpl(Integer.parseInt(coordinate[0]), Integer.parseInt(coordinate[1]),
							Orientation.valueOf(coordinate[2].toUpperCase())));
				} else {
					// If pattern not matches then this is an instruction
					instructions.add(command);
				}
			}

			// Create mowers
			for (int i = 0; i < coordinates.size(); i++) {
				if (i < instructions.size()) {
					mowers.add(new Mower(coordinates.get(i), instructions.get(i)));
				}
			}

		}
		return mowers;
	}

}
