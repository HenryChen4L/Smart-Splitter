package splitter;

import java.util.ArrayList;

public class SplitterDirectory {

	public ArrayList<Splitter> splitterDirectory;
	
	public SplitterDirectory() {
		this.splitterDirectory = new ArrayList<Splitter>();
	}
	
	public Splitter addNewSplitter(String name) {
		Splitter splitter = new Splitter(name);
		this.splitterDirectory.add(splitter);
		return splitter;
	}
}
