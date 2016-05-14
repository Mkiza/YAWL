package Anno.app;

import java.util.HashMap;
import java.util.Map;

import project.yawl.Arc;

public class SelectArcs {

	private static SelectArcs instance;
	Map<Arc, Boolean> out = new HashMap<Arc, Boolean>();
	Map<Arc, Boolean> in = new HashMap<Arc, Boolean>();
	
	public static SelectArcs getInstance(){
		if(instance == null){
			instance = new SelectArcs();
		}
		return instance;
	}
	
	public Map<Arc, Boolean> getOut() {
		return out;
	}
	public void setOut(Map<Arc, Boolean> out) {
		this.out.clear();
		this.out.putAll(out);
	}
	public Map<Arc, Boolean> getIn() {
		return in;
	}
	public void setIn(Map<Arc, Boolean> in) {
		this.in.clear();
		this.in.putAll(in);
	}
	
}
