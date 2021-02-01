/*
 * 	Copyright (C) 2019 Piotr Przybył
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

package javVerCh.j11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NewHttpClient {
	public static void showcase() {
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(URI.create("https://softwaregarden.dev")).GET().build();
		try {
			var response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.printf("The new HTTP Client available since Java 11 just visited SoftwareGarden.dev " +
				"and received %s code.%n", response.statusCode());
		} catch (Exception e) {
			System.err.println("Oops, the request wasn't successful. Don't handle exceptions like that.");
			e.printStackTrace();
		}
	}
}
