import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class SubmittedAbstractAnalyser {
	
	private static int countAI; //the number of CSC words counted
	private static int rowCount = 0;
	private static HashMap<String, Integer> groupCounts; //store the count of words present in a group
	private static HashMap<String, Boolean> interested; //track if a certain topic is of interest (if high_focus)
	
	static ArrayList<Float> percents = new ArrayList<Float>();
	
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
	public static void openFile() {
      try{
         readFile(new File("abstract.txt"));
			generateRow();
         }
      catch (Exception e){e.printStackTrace();}
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
	public static void generateRow() {
		String[] groups = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
		String maxGroup = "";
		float maxPercent = 0;
		
		String KRR = "\"Not_Interested\""; String ML = "\"Not_Interested\""; String LP = "\"Not_Interested\"";
		
		String row = rowCount + "\t" + "*" +"\t"; //add prof name as first column
		for(String group: groups) {
			float percent = (float) groupCounts.get(group)/ countAI;
			//System.out.println(groupCounts.get(group) + " " + countAI + " " + (float) groupCounts.get(group)/ countAI);
			percents.add(percent);
			if(percent <= 0.13818) {
				row = row + "\"Low_Focus\"";
			}else if(percent <= 0.20417) {
				row = row + "\"Medium_Focus\"";
			}else {
				row = row + "\"High_Focus\"";
				interested.put(group, true); //if high focus, make that group interested
			}
			//update maximums 
			if(percent > maxPercent) {
				maxPercent = percent;
				maxGroup = group;
			}
			row = row + "\t";
		}
		
		//add interested/ Not Interested data
		if(!interested.containsValue(true)) {
			interested.put(maxGroup, true);
		}
		
		//if any of the subtopics are of high-focus then make that topic interested
		if(interested.get("A") || interested.get("B") || interested.get("C")) {
			KRR = "\"Interested\"";
		}
		if(interested.get("D") || interested.get("E") || interested.get("F") || interested.get("G")) {
			ML = "\"Interested\"";
		}
		if(interested.get("H") || interested.get("I")) {
			LP = "\"Interested\"";
		}
		
		row = row + ML + "\t" + LP + "\t" + KRR;
		
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
		interested.put("A", false); interested.put("B", false); interested.put("C", false);
		interested.put("D", false); interested.put("E", false); interested.put("F", false);
		interested.put("G", false); interested.put("H", false); interested.put("I", false);
	}

	public static void main(String[] args) {
		
		//Initialise HashMap & countAI values
		groupCounts = new HashMap<String, Integer>();
		interested = new HashMap<String, Boolean>();
		reset();

		//Initialise ArrayList to store all rows to write to case file
		rows = new ArrayList<String>();
		
		//Print top row
		System.out.println("IDnum\tJ\tA\tB\tC\tD\tE\tF\tG\tH\tI\tML\tL_and_P\tKRR");
		
		
		/*String[] folderNames = {"Prof_Hussein_Suleman", "Prof_Geoff_Nitschke", "Prof_Deshen_Moodley", "Prof_Maria_Keet", "Prof_Tommie_Meyer"};
		for(String profFolder : folderNames) {
			openFiles(profFolder);
		}*/
     openFile();
		
		//print the proportion values for analysis
		//Collections.sort(percents);
		//System.out.println(percents);

	}// end main

}// end class