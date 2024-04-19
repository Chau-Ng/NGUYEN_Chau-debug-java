package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		List<String> symptoms = reader.GetSymptoms();
		return symptoms;
	}

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

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptomsOccurrencesMap) {
		Map<String, Integer> sortedSymptomsMap = new TreeMap<>();
		sortedSymptomsMap.putAll(symptomsOccurrencesMap);

		return sortedSymptomsMap;

	}

	public void writeSymptoms(Map<String, Integer> sortedSymptomsMap) { 
		writer.writeSymptoms(sortedSymptomsMap);
	}
		
	}