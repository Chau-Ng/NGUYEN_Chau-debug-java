package com.hemebiotech.analytics;

public class Main {
/**
 *Starts the analytics counter program by initializing a reader to read symptoms data from the specified file,
 *a writer to write the sorted list of symptoms produced in the process called analyzer.
 *The process is to get symptoms from a specified source, count their corresponding occurrences, sort them alphabetically by their names and write them in a specified source
 * @param args
 */
	public static void main(String[] args) {
		ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile();
		AnalyticsCounter analyzer = new AnalyticsCounter(reader, writer);
		analyzer.writeSymptoms(analyzer.sortSymptoms(analyzer.countSymptoms(analyzer.getSymptoms())));
	}

}
