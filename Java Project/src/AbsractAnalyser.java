import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class AbstractAnalyser {
	
	private static int countAI; //the number of CSC words counted
	private static HashMap<String, Integer> groupCounts; //store the count of words present in a group
	
	private static ArrayList<String> rows;
	
	// populate keyword group ArrayLists
	// NB! The first item must be the name of the group
	
	// Logic / Ontologies/ causal networks/ knowledge based systems
	private static ArrayList<String> A = new ArrayList<>(Arrays.asList("A", "logics", "ontology", "casual", "networks", "knowledge",
			"based", "systems", "architecture", "bayesian", "causal", "semantic", "logic", "belief", "beliefs",
			"klm", "defeasible", "entailment", "rational", "closure", "semantics", "subsumption", "description",
			"dls", "network", "system", "alc", "monotonic", "nmr", "classical", "preferential", "typicality",
			"nonmonotonic", "ontologies", "lexicographic", "owl", "languages", "grammar"));
	// Representing and reasoning with expert knowledge
	private static ArrayList<String> B = new ArrayList<>(
			Arrays.asList("B", "represent", "representing", "reason", "expert", "knowledge", "reasoning", "intelligence",
					"representation", "verbalisation", "design", "capture", "domains"));
	// Top down AI
	private static ArrayList<String> C = new ArrayList<>(
			Arrays.asList("C","top", "down", "ai", "algorithm", "algorithms", "controllers", "controller"));
	// artificial neural networks, clustering techniques
	private static ArrayList<String> D = new ArrayList<>(Arrays.asList("D","artificial", "networks", "clustering", "technique",
			"cluster", "decision", "network", "decisions", "hybrid", "artificial", "modularity", "collective",
			"cone", "neural", "neuro", "web"));
	// Building classification and predictive models from labelled historical data
	private static ArrayList<String> E = new ArrayList<>(Arrays.asList("E","build", "building", "predictive", "model", "models",
			"modelled", "label", "labelled", "historical", "history", "historically", "factors", "classification",
			"observations", "predict", "probabilistic", "analytics", "scheduling"));
	// Finding structure or patterns in unlabelled data
	private static ArrayList<String> F = new ArrayList<>(Arrays.asList("F","find", "finding", "structure", "unlabelled", "data",
			"environments", "environment", "mining", "patterns", "emergent"));
	// Bottom up AI
	private static ArrayList<String> G = new ArrayList<>(Arrays.asList("G","bottom", "ip", "ai", "data", "learning"));
	// Reinforcement learning, Markov decision processes
	private static ArrayList<String> H = new ArrayList<>(Arrays.asList("H","reinforcement", "learning", "markov", "decision",
			"process", "processes", "convexity", "interactions", "machine", "adaptive", "stochastic", "behavioural",
			"evolution", "evolutionary", "genotype", "generations"));
	// Models for action/ path selection in complex environments
	private static ArrayList<String> I = new ArrayList<>(Arrays.asList("I","models", "model", "action", "path", "select", "selection",
			"complex", "environment", "environments", "agent", "behaviour", "situations", "control", "autonomous",
			"modelling", "metamodel", "modules", "modelling", "behaviour", "behaviours", "cooperation",
			"cooperative", "robot", "robots", "teams", "traffic", "simulated", "simulation", "multiagent"));
	
	//Add all groups of words to an ArrayList
	@SuppressWarnings("serial")
	private static ArrayList<ArrayList<String>> groups = new ArrayList<ArrayList<String>>() {
		{
			add(A);
			add(B);
			add(C);
			add(D);
			add(E);
			add(F);
			add(G);
			add(H);
			add(I);
		}
	};

	public static void openFiles(String directory) {
		File dir = new File(directory);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				readFile(child);
				generateRow(directory);
			}
		} else {
			// Handle the case where dir is not really a directory.
			System.out.println("Directory \"" + directory + "\" does not exist.");
		}
	}

	public static void readFile(File file) {
		Scanner s;
		try {
			s = new Scanner(file);
			// Iterate through lines
			while (s.hasNextLine()) {
				String line = s.nextLine();
				String afterchars = line.replaceAll("[.\"!,?\'@#$%&*(\")-+^:<>-]*", "").toLowerCase();
            	System.out.println(afterchars);
                String[] words = afterchars.split(" ");//those are your words
                for(String word : words) {
                	classifyWord(word);
                }
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void classifyWord(String word) {
		boolean isAIWord = false;
		for(ArrayList<String> group : groups) {
			if (group.contains(word)){
				String groupName = group.get(0);
				Integer currentCount = groupCounts.get(groupName);
				groupCounts.put(groupName, currentCount++); // update count
				isAIWord = true;
			}
		}
		if(isAIWord) {
			countAI++; //update AI count
		}
	}
	
	public static void generateRow(String profName) {
		String[] groups = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
		String row = "Prof_" + profName; //add prof name as first column
		for(String group: groups) {
			float percent = groupCounts.get(group)/ countAI;
			if(percent <= 0.33) {
				row = row + "\"Low_Focus\"";
			}else if(percent <= 0.66) {
				row = row + "\"Low_Focus\"";
			}else {
				row = row + "\"High_Focus\"";
			}
			row = row + "\t";
		}
		row = row + "*\t*\t*\t*"; //add * for empty values
		rows.add(row);
		System.out.println(row);
		
		//clear counts for next row
		reset();
		
	}
	
	//Clear counts in HashMap to start counting from 0
	public static void reset() {
		countAI = 0;
		groupCounts.put("A", 0); groupCounts.put("B", 0); groupCounts.put("C", 0);
		groupCounts.put("D", 0); groupCounts.put("E", 0); groupCounts.put("F", 0);
		groupCounts.put("G", 0); groupCounts.put("H", 0); groupCounts.put("I", 0);
	}

	public static void main(String[] args) {
		
		//Initialise HashMap & countAI values
		reset();

		//Initialise ArrayList to store all rows to write to case file
		rows = new ArrayList<String>();
		

		// prep abstract for processing

	}// end main

}// end class