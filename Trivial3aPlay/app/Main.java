import business.core.Core;
import business.core.impl.ExtractorLauncher;
import business.core.impl.TrivialLauncher;


public class Main {

	public static void main(String[] args) {
		Core core = new TrivialLauncher();
		if(args != null && args.length > 0){
			switch(args[0]){
			case "-tools":
				core = new ExtractorLauncher(); 
				break;

			}
		}
		core.run();
	}

}
