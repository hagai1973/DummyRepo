package Main;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


@WebService(endpointInterface = "Main.AutoCompleteInterface")
public class AutoComplete implements AutoCompleteInterface {

	

	
	public static void main(String args[]) throws IOException {
		
		AutoComplete ac = new AutoComplete();
		ac.autoComplete("aggr");
		
	}
	
	@Override
	public List<String> autoComplete(String word) throws IOException {
		
		
		Trie myAutoCompleteTrie = new Trie();
		
		
		
		return (myAutoCompleteTrie.autoComplete(word));
		
		
	}
}
