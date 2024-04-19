package com.hemebiotech.analytics;

public class Main {

	public static void main(String[] args) {
		ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile();
		AnalyticsCounter analyzer = new AnalyticsCounter(reader, writer);
		analyzer.writeSymptoms(analyzer.sortSymptoms(analyzer.countSymptoms(analyzer.getSymptoms())));
	}

}
