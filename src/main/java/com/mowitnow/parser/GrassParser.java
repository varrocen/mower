package com.mowitnow.parser;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import com.mowitnow.model.Field;
import com.mowitnow.model.impl.Grass;

@Component
public class GrassParser {

	/**
	 * Parse first command and return field object
	 * 
	 * @param commands
	 *            list of commands
	 * @return field or not
	 */
	public Optional<Field> parse(List<String> commands) {
		Field field = null;

		if (CollectionUtils.isNotEmpty(commands)) {
			String command = commands.get(0);

			if (Pattern.matches("^[0-9] [0-9]$", command)) {
				String[] size = command.split(" ");
				field = new Grass(-1, Integer.parseInt(size[1]));
			}
		}
		return Optional.ofNullable(field);
	}

}
