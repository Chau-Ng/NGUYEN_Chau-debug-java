package com.hemebiotech.analytics;

import java.util.Map;
/**
 * Writes symptom data to a specified source, where each line represents a key-value pair
 * in an ordered map, with keys representing symptoms and values representing their occurrences.
 */
public interface ISymptomWriter {
/**
 * Writes symptom data to a specified source.
 * 
 * @param symptoms: a map containing symptom strings as keys and their counts as values
 */
	public void writeSymptoms(Map<String, Integer> symptoms);

}
