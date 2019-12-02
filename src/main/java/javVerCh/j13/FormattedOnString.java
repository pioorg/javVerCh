/*
 * 	Copyright (C) 2020 Piotr Przybył
 *
 * 	This program is free software: you can redistribute it and/or modify
 * 	it under the terms of the GNU General Public License as published by
 * 	the Free Software Foundation, either version 3 of the License, or
 * 	(at your option) any later version.
 *
 * 	This program is distributed in the hope that it will be useful,
 * 	but WITHOUT ANY WARRANTY; without even the implied warranty of
 * 	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * 	GNU General Public License for more details.
 *
 * 	You should have received a copy of the GNU General Public License
 * 	along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package javVerCh.j13;

import java.time.*;

public class FormattedOnString {

	/**
	 * The String.formatted method allows formatting using instance method.
	 * In Java 13 it's deprecated for removal, because Text Blocks are a preview feature.
	 */
	public static String formatStringOnInstance() {
		return "Now we can call formatted on String instance! (Today is %s)".formatted(LocalDate.now());
	}
}
