/*
 * 	Copyright (C) 2019 - 2020 Piotr Przybył
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

package javVerCh;

import java.io.*;

import javVerCh.j16.preview.Sealed;


public class VersionCheck {
	public static void main(String[] args) {

		System.out.println("Looks like you can run this Java programme. That's cool!");
		printVersion();

		describeVersion(getVersionFromClassFile());

		checkVersion(16);

		javVerCh.j16.RecordSample.printAndCompareRecords();
		Sealed.getPermitted().forEach(System.out::println);

	}

	private static MajorAndMinor getVersionFromClassFile() {

		ClassLoader classLoader = VersionCheck.class.getClassLoader();
		String classFileName = VersionCheck.class.getName().replace(".", "/") + ".class";
		try (DataInputStream stream = new DataInputStream(classLoader.getResourceAsStream(classFileName))) {

			//skipping CAFEBABE
			stream.readInt();
			//reading minor
			int minor = stream.readUnsignedShort();
			//reading major
			int major = stream.readUnsignedShort();

			return new MajorAndMinor(major, minor);


		} catch (Exception e) {
			throw new IllegalStateException("Ouch... cannot read class file...", e);
		}
	}

	private static void describeVersion(MajorAndMinor version) {

		System.out.printf("The version of this class file is %d.%d (compiled using Java %d), so it's %susing preview features.%n", version.major, version.minor, version.major - 44, version.minor == 65535 ? "" : "not ");

	}

	private static void printVersion() {
		try {
			int runtimeVersion = getRuntimeVersion();
			System.out.printf("The version of JVM is %s.%n", runtimeVersion);

		} catch (Exception e) {
			System.err.println("Ouch... Looks like your version is before 9... Please upgrade.");
			e.printStackTrace();
		}

	}


	private static void checkVersion(int versionRequired) {
		int runtimeVersion = getRuntimeVersion();
		if (runtimeVersion >= versionRequired) {
			System.out.printf("Your JVM version %d is (above) the required one (%d). You're all set.%n",
				runtimeVersion,
				versionRequired);
		} else {
			System.out.printf("Your JVM version %d is not the required one (%d). Please upgrade your JVM. You " +
				"can use http://sdkman.io/ and/or https://adoptopenjdk.net/%n", runtimeVersion, versionRequired);
		}

	}

	private static int getRuntimeVersion() {
		return Runtime.version().feature();
	}
}

