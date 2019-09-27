import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class AbstractAnalyser {
	
	static String path = "C:\\Users\\Josh\\eclipse-workspace\\Bayesian_Network\\Abstracts\\"; //MAKE SURE to update path to the 'Abstracts' Folder
	private static int countAI; //the number of CSC words counted
	private static int rowCount = 0;
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
	
	//reads all txt files in a directory and generates a row for each file
	public static void openFiles(String directory) {
		File dir = new File(path+directory);
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
	
	//reads lines of a txt file
	public static void readFile(File file) {
		Scanner s;
		try {
			s = new Scanner(file);
			// Iterate through lines
			while (s.hasNextLine()) {
				String line = s.nextLine();
				String afterchars = line.replaceAll("[.\"!,?\'@#$%&*(\")-+^:<>-]*", "").toLowerCase();
            	//System.out.println(afterchars);
                String[] words = afterchars.split(" ");//those are your words
                for(String word : words) {
                	classifyWord(word);
                }
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//classifies a word into AI groups
	public static void classifyWord(String word) {
		boolean isAIWord = false;
		for(ArrayList<String> group : groups) {
			if (group.contains(word)){
				String groupName = group.get(0);
				groupCounts.put(groupName, groupCounts.get(groupName)+1); // update count
				//System.out.println("updated: " + groupCounts.get(groupName));
				isAIWord = true;
			}
		}
		if(isAIWord) {
			countAI++; //update AI count
		}
	}
	
	//using counts in the hashmap, generate the row for the case file
	public static void generateRow(String profName) {
		String[] groups = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
		String row = rowCount + "\t" + profName +"\t"; //add prof name as first column
		for(String group: groups) {
			float percent = (float) groupCounts.get(group)/ countAI;
			//System.out.println(groupCounts.get(group) + " " + countAI + " " + (float) groupCounts.get(group)/ countAI);
			if(percent <= 0.33) {
				row = row + "\"Low_Focus\"";
			}else if(percent <= 0.66) {
				row = row + "\"Medium_Focus\"";
			}else {
				row = row + "\"High_Focus\"";
			}
			row = row + "\t";
		}
		row = row + "*\t*\t*"; //add * for empty values
		rows.add(row);
		rowCount++;
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
		groupCounts = new HashMap<String, Integer>();
		reset();

		//Initialise ArrayList to store all rows to write to case file
		rows = new ArrayList<String>();
		
		//Print top row
		System.out.println("IDnum\tSupervisor\tA\tB\tC\tD\tE\tF\tG\tH\tI\tML\tL_and_P\tKRR");
		
		
		String[] folderNames = {"Prof_Hussein_Suleman", "Prof_Geoff_Nitschke", "Prof_Deshen_Moodley", "Prof_Maria_Keet", "Prof_Tommie_Meyer"};
		for(String profFolder : folderNames) {
			openFiles(profFolder);
		}

	}// end main

}// end class