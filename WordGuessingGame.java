package com.monocept.array;

import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("WORD GUESSING GAME");
		System.out.println("Word consists of lowercase letters (a-z)");
		
		
		
        String randomWord = createRandomWord();
        randomWord = randomWord.toLowerCase();
        
        String word = randomWord;
        System.out.println(randomWord);
        
        int wordLength = randomWord.length();
		System.out.println("Guess the word in " + (wordLength*2) + " attempts");
		System.out.println("");
		
		int[] frequencyArray = new int[26];
        createFrequencyArray(randomWord, frequencyArray);
		
		char[] spaces = generateSpaces(wordLength);
		
		randomWord = prefillSpaces(spaces,randomWord,frequencyArray);
        
        playGame(frequencyArray,wordLength,scanner,randomWord,spaces);
        System.out.println("The word is : " + word); 

	}

	
	private static String prefillSpaces(char spaces[], String randomWord, int[] frequencyArray) {
		
		Random random = new Random();
		int index1 = random.nextInt(randomWord.length());
		int index2 = random.nextInt(randomWord.length());
		
		spaces[index1] = randomWord.charAt(index1);
		spaces[index2] = randomWord.charAt(index2);
		
		frequencyArray[spaces[index1] - 'a']--;
		frequencyArray[spaces[index2] - 'a']--;
		
		for(int i=0; i<spaces.length; i++)
			System.out.print(spaces[i]+" ");
		
		randomWord = randomWord.substring(0, index1) + '@' + randomWord.substring(index1 + 1);
		randomWord = randomWord.substring(0, index2) + '@' + randomWord.substring(index2 + 1);
		
		return randomWord;
	}


	private static char[] generateSpaces(int wordLength) {
		
		char[] spaces = new char[wordLength];
		
		for(int i=0; i<wordLength; i++){
			spaces[i] = '_';
		}
		return spaces;
	}


	private static String createRandomWord() {
		
		String[] words = {"Adequate", "Anywhere", "Approach", "Activity", "Anything", "Approval", "Advanced", "Although", "Academic", "Advocate", "Accident", "Athletic", "Aircraft", "Activist", "Actually", "Accurate", "Apparent", "Argument", "Analysis", "Audience", "Announce", "Alliance", "Artistic", "Addition", "Absolute", "Attitude", "Birthday", "Behavior", "Bathroom", "Boundary", "Building", "Business", "Capacity", "Champion", "Campaign", "Convince", "Conflict", "Changing", "Ceremony", "Clothing", "Category", "Complain", "Complete", "Computer", "Coverage", "Creative", "Confront", "Conclude", "Civilian", "Concrete", "Critical", "Criminal", "Clinical", "Collapse", "Customer", "Contract", "Consumer", "Consider", "Cultural", "Criteria", "Constant", "Creature", "Creation", "Continue", "Contrast", "Delivery", "Discover", "Directly", "Darkness", "Document", "Dramatic", "Daughter", "Describe", "Division", "Distinct", "Distance", "Decision", "District", "Decrease", "Director", "Dominant", "Dominate", "Designer", "Disorder", "Dialogue", "Detailed", "Disagree", "Disaster", "Exchange", "Everyday", "Exciting", "Exposure", "Exercise", "Existing", "External", "Employer", "Employee", "Emphasis", "Economic", "Everyone", "Evidence", "Electric", "Entirely", "Educator", "Evaluate", "Estimate", "Entrance", "Enormous", "Emission", "Engineer", "Earnings", "Frequent", "Facility", "Fighting", "Friendly", "Favorite", "Familiar", "Football", "Function", "Graduate", "Generate", "Greatest", "Historic", "Hospital", "Headline", "Heritage", "Identify", "Involved", "Industry", "Identity", "Incident", "Investor", "Indicate", "Instance", "Increase", "Innocent", "Interest", "Internal", "Internet", "Judgment", "Lifetime", "Literary", "Language", "Location", "Learning", "Magazine", "Majority", "Movement", "Military", "Minority", "Moreover", "Multiple", "Mortgage", "Musician", "Marriage", "Moderate", "Material", "Mountain", "Maintain", "Neighbor", "Normally", "Negative", "Northern", "Numerous", "National", "Organize", "Official", "Overlook", "Overcome", "Observer", "Opponent", "Ordinary", "Occasion", "Opposite", "Operator", "Original", "Physical", "Probably", "Publicly", "Powerful", "Purchase", "Possibly", "Properly", "Property", "Province", "Platform", "Perceive", "Prospect", "Provider", "Practice", "Priority", "Preserve", "Producer", "Proposed", "Positive", "Previous", "Proposal", "Presence", "Possible", "Politics", "Painting", "Pregnant", "Progress", "Persuade", "Planning", "Personal", "Pleasure", "Portrait", "Position", "Prisoner", "Pressure", "Question", "Recovery", "Remember", "Recently", "Research", "Resemble", "Romantic", "Relative", "Relevant", "Resource", "Response", "Reporter", "Reaction", "Regulate", "Resident", "Register", "Regional", "Religion", "Relation", "Sequence", "Specific", "Somewhat", "Somebody", "Shopping", "Slightly", "Survival", "Survivor", "Software", "Schedule", "Supposed", "Suddenly", "Security", "Shoulder", "Strongly", "Strength", "Strategy", "Straight", "Spending", "Shooting", "Southern", "Standard", "Scenario", "Surprise", "Separate", "Struggle", "Sentence", "Standing", "Sanction", "Stranger", "Surround", "Solution", "Thinking", "Teaching", "Tendency", "Tomorrow", "Together", "Thousand", "Threaten", "Transfer", "Terrible", "Teaspoon", "Teenager", "Training", "Unlikely", "Universe", "Ultimate", "Vacation", "Valuable", "Variable", "Workshop", "Withdraw", "Whatever", "Whenever", "Yourself"};
		Random random = new Random();
		int index = random.nextInt(words.length);
		
		return words[index];
    }
	
	private static void createFrequencyArray(String randomWord, int[] frequencyArray) {
		for(int i=0; i<randomWord.length(); i++) {
			int index = randomWord.charAt(i) - 'a';
			frequencyArray[index]++;
		}
		
	}
	
	
	private static void playGame(int[] frequencyArray, int wordLength, Scanner scanner, String randomWord, char[] spaces) {
		
		int attempts = wordLength*2;
		int turns = 0;
		
		while(attempts > 0)
		{
			turns++;
			System.out.println("");
			System.out.println("Guess a letter");
			char letter = scanner.next().charAt(0);
			
			checkFrequencyZero(frequencyArray,letter,attempts);
			randomWord = updateFrequency(frequencyArray,letter,attempts,turns,randomWord,spaces);
			
			attempts--;
		}
		
		System.out.println("You Lost");
		
	}
	
	
	private static void checkFrequencyZero(int[] frequencyArray, char letter, int attempts) {
		
		if(frequencyArray[letter-'a'] == 0)
			System.out.println("Incorrect guess. You have " + (attempts-1) +" attempts left");
		return;
	}



	private static String updateFrequency(int[] frequencyArray, char letter, int attempts, int turns, String randomWord, char[] spaces) {
		
		if(frequencyArray[letter-'a'] != 0) {
			frequencyArray[letter-'a']--;
			printGuess(letter,spaces,randomWord);
			checkWin(frequencyArray,turns);
			System.out.println();
			System.out.println("Correct guess. You have " + (attempts-1) +" attempts left");
			int index = randomWord.indexOf(letter);
			randomWord = randomWord.substring(0, index) + '@' + randomWord.substring(index + 1);
		}
		
		return randomWord;
		
	}

	private static void printGuess(char letter, char[] spaces, String randomWord) {
		
		int index = randomWord.indexOf(letter);
		spaces[index] = letter;
		
		for(int i=0; i<spaces.length; i++) {
			System.out.print(spaces[i] + " ");
		}
		
	}


	private static void checkWin(int[] frequencyArray, int turns) {
		
		boolean result = true;
		for(int i=0; i<26; i++)
			if(frequencyArray[i] > 0)
				result = false;
		
		if(result) {
			System.out.println("");
			System.out.println("You Guessed the word correctly");
			System.out.println("You won in " + turns + " attempts");
			System.exit(0);
		}
		
	}





}
