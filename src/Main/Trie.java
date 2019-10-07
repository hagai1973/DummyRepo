package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Trie {
    private TrieNode root;
    
    //ArrayList<String> ans=new ArrayList<>();

    public Trie() throws IOException {
        this.root = new TrieNode('\0');
        
        String currentDir = System.getProperty("user.dir");
        File file = new File(currentDir + "/files/dict.txt"); 
        
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        ArrayList<String> arrayList = new ArrayList<String>();
        
        String st; 
        while ((st = br.readLine()) != null) 
          arrayList.add(st); 
        
        
        
    	
        
        
        for(int i=0;i<arrayList.size();i++)
        {
            this.add(arrayList.get(i)); 
        }
    }

    private void add(TrieNode root, String word){
        if(word.length() == 0){
            root.isTerminating = true;
            return;
        }       
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        add(child, word.substring(1));
    }

    public void add(String word){
        add(root, word);
    }

    private ArrayList<String> searchHelper(TrieNode root,String word,String ans,ArrayList<String> results)
    {
    	
    	boolean bAns2 = true;
      try            
      {
    	  
    	  
    	
      if(word.length()==0)
      {
        if(root.isTerminating == true)
        {
          
          System.out.println(ans);
          results.add(ans);
        }
        for(int i=0;i<26;i++)
        {
          TrieNode temp=root.children[i];
          if(temp !=null)
          {
        	  
               searchHelper(temp,word,ans+temp.data,results);
        	  
        		
          }
        }
      }
      if (!word.isEmpty()) {
    	  int childIndex=word.charAt(0)-'a';
    	  TrieNode child=root.children[childIndex];
    	  if(child == null)
          {
            //System.out.print();
            return results;
          }
    	  
    	 ans=ans+word.charAt(0);
    	 return searchHelper(child,word.substring(1),ans,results);
    	 
    	 
      }
      
      
      return results;
      
      

    }
      catch(Exception e)
      {
        return results;
      }
    }

    public List<String> search(String word)
    {
      boolean isEmptyRes = true;
      
      
      
      ArrayList<String> results = new ArrayList<String>();
      String s="";
      results = searchHelper(root,word,s,results);
      
      boolean emptyRes =  results.isEmpty();
      //System.out.println("is result tree empty " + emptyRes);
      
      if (emptyRes) {
    	  add(word);
    	  addToDict(word);
      }
      
      //return GetStringArray(results);
      return results;
                  
    }

    private void addToDict(String word) {
    	
    	String currentDir = System.getProperty("user.dir");
        File file = new File(currentDir + "/files/dict.txt");
    	try {
    		Files.write(file.toPath(), "\n".getBytes(), StandardOpenOption.APPEND);
    	    Files.write(file.toPath(), word.getBytes(), StandardOpenOption.APPEND);
    	}catch (IOException e) {
    	    //exception handling left as an exercise for the reader
    	}
		
	}

	public List<String> autoComplete(String word) {
         
    	
    	System.out.println("results for word " + word);
        return search(word);
                	
        
    }
	
	
	public static String[] GetStringArray(ArrayList<String> arr) 
    { 
  
        // declaration and initialise String Array 
        String str[] = new String[arr.size()]; 
  
        // ArrayList to Array Conversion 
        for (int j = 0; j < arr.size(); j++) { 
  
            // Assign each value to String array 
            str[j] = arr.get(j); 
        } 
  
        return str; 
    } 

}
