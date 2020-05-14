/**
 * CCPS209 Final Exam Project
 * BACImplementation.java
 * This program is designed compete as a player in a simple game of Bulls and Cows.
 * 
 * @author Fayemi, Toluwa
 * @studentID 501027617
 *
 *
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BACImplementation implements BACPlayer {
	
	private Random randomGenerator = new Random();
	List<String> wordBank = new ArrayList();
	List<String> gameList = new ArrayList();
	List<String> cacheMoney = new ArrayList();

	
	public String getAuthor() {
		return("Fayemi, Toluwa");
	}
	
	public String getStudentID() {
		return("501027617");
	}
	
	public void initializeWordList(List<String> words) {
		//Copy list
		//probably gotta pre-make a variable to store this list in.
		wordBank = words;
	}
	
	
	public int[] headCount(String word, String guess) {
		
		int[] out = new int[2];
		
		boolean[] seen = new boolean[26];
		for(int i = 0; i < word.length(); i++) {
			int c = ((int)word.charAt(i)) - 'a';
			seen[c] = true;
		}
		
		int bulls = 0, cows = 0;
		try {
			for(int i=0; i < word.length(); i++) {
				int c1 = ((int)word.charAt(i)) - 'a';
				int c2 = ((int)guess.charAt(i)) - 'a';
				if(c1==c2) {
					bulls++;
				}
				else if(seen[c2]) {
					cows++;
				}
			}
		}
		catch(Exception e) {
			bulls = cows = 0;
		}
		
		out[0] = bulls;
		out[1] = cows;
		return out;
	}
	
	public void clearField(int n) {
		List<String> newRoundList = new ArrayList();
		
		for (String word: wordBank) {
			if(word.length() == n) {
				newRoundList.add(word);
			}
			gameList = newRoundList;
			cacheMoney = newRoundList;
		}
	}
	
	public String guess(int n, List<String> guesses, List<Integer> bulls, List<Integer> cows) {

		if (guesses.isEmpty()) {
			clearField(n);
			int idx = randomGenerator.nextInt(gameList.size());
			return gameList.get(idx);
		}
		
		String lastGuess = guesses.get(guesses.size() -1);
		int lastBulls = bulls.get(guesses.size()-1);
		int lastCows = cows.get(guesses.size()-1);
		int min_score = n;
		List<String> prizeBozine = new ArrayList();

		gameList.removeIf(word -> (headCount(word, lastGuess))[1] != lastCows);
		gameList.removeIf(word -> (headCount(word, lastGuess))[0] != lastBulls);
		
		List<Integer> cacheCount = new ArrayList<>(cacheMoney.size());
		int[] wordCount = new int[26];
		
		for(String word : gameList) {
			for(char c: word.toCharArray()) {
				wordCount[(int)(c-'a')]++; 
			}
		}
		int highest_freq = 0;
		
		for(int i : wordCount) {
			if(i >= highest_freq) {
				highest_freq = i;
			}
		}
		int highest_score = 0;
		List<String> prizeBovine = new ArrayList();
		
		for(String word : cacheMoney) {
			if(guesses.contains(word)) {
				
			}
			else {
				int score = 0;
				for(char c : word.toCharArray()) {
					
					if((int)(c-'a') == highest_freq) {
						score++;
					}
					
					if(score >= highest_score) {
						highest_score = score;
						prizeBovine.add(word);
					}
				}
			}
		}
		return prizeBovine.get(randomGenerator.nextInt(prizeBovine.size()));
	}
}
