/*
 * 	Copyright (C) 2021 Piotr Przybył
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

package javVerCh.j16;

public class RecordSample {

	public static void printAndCompareRecords() {
			var record1 = new StringAndInt("Hello Records in Java", 16);
			var record2 = new StringAndInt(record1.stringComp(), record1.integerComp());
			System.out.println(record1);
			System.out.println("Are the records equal? "+ record1.equals(record2));
			System.out.println("What are their hash codes? "+ record1.hashCode() + " and " + record2.hashCode());
		}
}

record StringAndInt(String stringComp, int integerComp) {}
