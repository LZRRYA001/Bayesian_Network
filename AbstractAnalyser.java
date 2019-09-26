import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

class AbstractAnalyser{

   public static void main (String [] args){
         
      //read in abstract to be processed
      ArrayList<String> deshen = new ArrayList<String>(); 
      ArrayList<String> geoff = new ArrayList<String>(); 
      ArrayList<String> maria = new ArrayList<String>(); 
      ArrayList<String> tommie = new ArrayList<String>();
      ArrayList<String> hussein = new ArrayList<String>();

      Scanner input;
      /*try {
         input = new Scanner(new File("deshen.txt"));
         while (input.hasNextLine()){ deshen.add(input.nextLine());}//end while
         input = new Scanner(new File("geoff.txt"));
         while (input.hasNextLine()){ geoff.add(input.nextLine());}//end while
         input = new Scanner(new File("maria.txt"));
         while (input.hasNextLine()){ maria.add(input.nextLine());}//end while
         input = new Scanner(new File("tommie.txt"));
         while (input.hasNextLine()){ tommie.add(input.nextLine());}//end while
         input = new Scanner(new File("hussein.txt"));
         while (input.hasNextLine()){hussein.add(input.nextLine());}//end while
         input.close();
      } 
      catch (Exception e) {System.out.println(e);}*/

      //init an arraylist for each keyword group / concept node title
      ArrayList<String> A = new ArrayList<>(Arrays.asList("architecture",	"bayesian",	"causal",	"semantic",	"logic",	"belief",	"beliefs",	"klm",	"defeasible",	"entailment",	"rational",	"closure",	"semantics",	"subsumption",	"description",	"dls",	"logics",	"alc",	"monotonic",	"nmr",	"classical",	"preferential",	"typicality",	"nonmonotonic",	"ontology",	"ontologies",	"lexicographic",	"owl",	"languages",	"grammar"));
      ArrayList<String> B = new ArrayList<>(Arrays.asList("knowledge",	"represent",	"reasoning",	"intelligence",	"representation",	"verbalisation",	"design",	"capture",	"domains"));
      ArrayList<String> C = new ArrayList<>(Arrays.asList("algorithm",	"algorithms",	"controllers",	"controller"));
      ArrayList<String> D = new ArrayList<>(Arrays.asList("decision",	"network",	"decisions",	"hybrid",	"artificial",	"modularity",	"collective",	"cone",	"neural",	"neuro",	"web"));
      ArrayList<String> E = new ArrayList<>(Arrays.asList("factors",	"classification",	"observations",	"predict",	"probabilistic",	"analytics",	"scheduling"));
      ArrayList<String> F = new ArrayList<>(Arrays.asList("environments",	"environment",	"mining",	"patterns",	"emergent"));
      ArrayList<String> G = new ArrayList<>(Arrays.asList("data",	"learning"));
      ArrayList<String> H = new ArrayList<>(Arrays.asList("convexity",	"interactions",	"machine",	"adaptive",	"stochastic",	"behavioural",	"evolution",	"evolutionary",	"genotype",	"generations"));
      ArrayList<String> I = new ArrayList<>(Arrays.asList("agent",	"model",	"behaviour",	"situations",	"control",	"models",	"autonomous",	"modelling",	"metamodel",	"modules",	"modelling",	"behaviour",	"behaviours",	"cooperation",	"cooperative",	"robot",	"robots",	"teams",	"traffic",	"simulated",	"simulation",	"multiagent"));      
      ArrayList<ArrayList> groups = new ArrayList<ArrayList>(){{add(A);add(B);add(C);add(D);add(E);add(F);add(G);add(H);add(I);}};

      
      //populate keyword group arraylists
      
      
 
      
      //prep abstract for processing
      
      
   
   }//end main

}//end class