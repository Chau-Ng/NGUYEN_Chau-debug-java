package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;
/**
 * Constructor for AnalyticsCounter method
 * @param reader: it will read a list of symptoms and return it
 * @param writer: it will write sorted symptoms data to a specified source
 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
/**
* Retrieves the list of symptoms from the reader.
*
* @return the list of symptoms
*/
	public List<String> getSymptoms() {
		List<String> symptoms = reader.getSymptoms();
		return symptoms;
	}
/**
 * Counts the symptoms occurrences from the list returned by reader and return a map of symptoms and its occurrences
 * @param symptoms: list of symptoms 
 * @return a map of symptoms as keys and its occurrences as values
 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomsOccurrencesMap = new HashMap<>();
		for (String symptom : symptoms) {
			if (symptomsOccurrencesMap.containsKey(symptom)) {
				symptomsOccurrencesMap.put(symptom, symptomsOccurrencesMap.get(symptom) + 1);
			} else {
				symptomsOccurrencesMap.put(symptom, 1);
			}

		}
		return symptomsOccurrencesMap;
	}
/**
 * Sorts the symptoms with its corresponding occurrences in alphabetical order
 * @param symptomsOccurrencesMap: map containing symptoms and its occurrences
 * @return a TreeMap of symptoms sorted alphabetically by its names
 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptomsOccurrencesMap) {
		Map<String, Integer> sortedSymptomsMap = new TreeMap<>();
		sortedSymptomsMap.putAll(symptomsOccurrencesMap);

		return sortedSymptomsMap;

	}
/**
 * Writes symptoms data from a sorted symptoms map to a specified source
 * @param sortedSymptomsMap: a map with symptoms and its occurrences sorted alphabetically
 */
	public void writeSymptoms(Map<String, Integer> sortedSymptomsMap) {
		writer.writeSymptoms(sortedSymptomsMap);
	}

	}