package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("Project02Eclipse/result.out", false));
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				String symptom = entry.getKey();
				Integer count = entry.getValue();

				writer.write(symptom + ": " + count);
				writer.newLine();
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
