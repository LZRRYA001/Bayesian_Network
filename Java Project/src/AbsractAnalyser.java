import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

class AbstractAnalyser {
	
	public static openFiles(String directory) {
		File dir = new File(directory);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				// Do something with child
			}
		} else {
			// Handle the case where dir is not really a directory.
			System.out.println("Directory \"" + directory + "\" does not exist." );
		}
	}

	public static void main(String[] args) {

		// read in abstract to be processed
		ArrayList<String> deshen = new ArrayList<String>();
		ArrayList<String> geoff = new ArrayList<String>();
		ArrayList<String> maria = new ArrayList<String>();
		ArrayList<String> tommie = new ArrayList<String>();
		ArrayList<String> hussein = new ArrayList<String>();

		Scanner input;
		/*
		 * try { input = new Scanner(new File("deshen.txt")); while
		 * (input.hasNextLine()){ deshen.add(input.nextLine());}//end while input = new
		 * Scanner(new File("geoff.txt")); while (input.hasNextLine()){
		 * geoff.add(input.nextLine());}//end while input = new Scanner(new
		 * File("maria.txt")); while (input.hasNextLine()){
		 * maria.add(input.nextLine());}//end while input = new Scanner(new
		 * File("tommie.txt")); while (input.hasNextLine()){
		 * tommie.add(input.nextLine());}//end while input = new Scanner(new
		 * File("hussein.txt")); while
		 * (input.hasNextLine()){hussein.add(input.nextLine());}//end while
		 * input.close(); } catch (Exception e) {System.out.println(e);}
		 */

		

		// init an arraylist for each keyword group / concept node title

		// Logic / Ontologies/ causal networks/ knowledge based systems
		ArrayList<String> A = new ArrayList<>(Arrays.asList("logics", "ontology", "casual", "networks", "knowledge",
				"based", "systems", "architecture", "bayesian", "causal", "semantic", "logic", "belief", "beliefs",
				"klm", "defeasible", "entailment", "rational", "closure", "semantics", "subsumption", "description",
				"dls", "network", "system", "alc", "monotonic", "nmr", "classical", "preferential", "typicality",
				"nonmonotonic", "ontologies", "lexicographic", "owl", "languages", "grammar"));
		// Representing and reasoning with expert knowledge
		ArrayList<String> B = new ArrayList<>(
				Arrays.asList("represent", "representing", "reason", "expert", "knowledge", "reasoning", "intelligence",
						"representation", "verbalisation", "design", "capture", "domains"));
		// Top down AI
		ArrayList<String> C = new ArrayList<>(
				Arrays.asList("top", "down", "ai", "algorithm", "algorithms", "controllers", "controller"));
		// artificial neural networks, clustering techniques
		ArrayList<String> D = new ArrayList<>(Arrays.asList("artificial", "networks", "clustering", "technique",
				"cluster", "decision", "network", "decisions", "hybrid", "artificial", "modularity", "collective",
				"cone", "neural", "neuro", "web"));
		// Building classification and predictive models from labelled historical data
		ArrayList<String> E = new ArrayList<>(Arrays.asList("build", "building", "predictive", "model", "models",
				"modelled", "label", "labelled", "historical", "history", "historically", "factors", "classification",
				"observations", "predict", "probabilistic", "analytics", "scheduling"));
		// Finding structure or patterns in unlabelled data
		ArrayList<String> F = new ArrayList<>(Arrays.asList("find", "finding", "structure", "unlabelled", "data",
				"environments", "environment", "mining", "patterns", "emergent"));
		// Bottom up AI
		ArrayList<String> G = new ArrayList<>(Arrays.asList("bottom", "ip", "ai", "data", "learning"));
		// Reinforcement learning, Markov decision processes
		ArrayList<String> H = new ArrayList<>(Arrays.asList("reinforcement", "learning", "markov", "decision",
				"process", "processes", "convexity", "interactions", "machine", "adaptive", "stochastic", "behavioural",
				"evolution", "evolutionary", "genotype", "generations"));
		// Models for action/ path selection in complex environments
		ArrayList<String> I = new ArrayList<>(Arrays.asList("models", "model", "action", "path", "select", "selection",
				"complex", "environment", "environments", "agent", "behaviour", "situations", "control", "autonomous",
				"modelling", "metamodel", "modules", "modelling", "behaviour", "behaviours", "cooperation",
				"cooperative", "robot", "robots", "teams", "traffic", "simulated", "simulation", "multiagent"));
		ArrayList<ArrayList> groups = new ArrayList<ArrayList>() {
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

		// populate keyword group arraylists

		// prep abstract for processing

	}// end main

}// end class