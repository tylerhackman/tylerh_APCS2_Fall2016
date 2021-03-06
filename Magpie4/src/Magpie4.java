// Magpie4.java Tyler Hackman Last Revision : 10-16-16
public class Magpie4 {
	
	//Get a default greeting and return a greeting
	public String getGreeting() {
		return "Hello, let's talk.";
	}	
	/**
	 * Gives a response to a user statement
	 * takes in user statement
	 * response based on the rules given
	 */
	public String getResponse(String statement) {
		String response = "";
		int x = findKeyword(statement, "I", 0);
		int psn = findKeyword(statement, "you", 0);
		if (statement.trim().length() < 1) {
			response = "Say something, please."; 
		}
		// Look for a two word (I <something> you)
		// pattern  
		else if (x >= 0 && findKeyword(statement, "you", x) >= 0) {
			response = transformISomethingYouStatement(statement);
		}
		// Look for a two word (you <something> me)
		// pattern
		else if (psn >= 0 && findKeyword(statement, "me", psn) >= 0) {
			response = transformYouMeStatement(statement);
		} 
		else if (findKeyword(statement, "no", 0) >= 0) {
			response = "Why so negative?";
		}
		else if (findKeyword(statement, "I want to", 0) >= 0) {
			response = transformIWantToStatement(statement);
		}
		// Response to "I want something" statements
		else if (findKeyword(statement, "I want", 0) >= 0) {
			response = transformIWantSomethingStatement(statement);
		}
		// Response to the mention of a type of family member
		else if (findKeyword(statement, "mother", 0) >= 0
	        || findKeyword(statement, "father", 0) >= 0
			|| findKeyword(statement, "sister", 0) >= 0
			|| findKeyword(statement, "brother", 0) >= 0) {
		response = "Tell me more about your family.";
		}	
		// Response to the mention of multiple animals
		else if (findKeyword(statement, "dog",0) >= 0
				|| findKeyword(statement, "cat",0) >= 0
				|| findKeyword(statement," mouse",0) >= 0
				|| findKeyword(statement, "bird",0) >= 0) {
			response = "I'm not a fan of animals.";
		}
		// Response to the mention of the teachers of APCS
		else if (findKeyword(statement, "Dreyer", 0) >= 0
				|| findKeyword(statement, "deHeer", 0) >= 0
				|| findKeyword(statement, "Lamont", 0) >= 0) {
			response = "Your teachers sound like they know what they're doing.";
		}
		else if (findKeyword(statement, "donald trump", 0) >= 0) {
			response = "Let's make America great again!";
		}
		else {
			response = getRandomResponse();
		}
		return response;
		}

	/**
	 * Take a statement with "I want to <something>." and transform it into
	 * "What would it mean to <something>?"
	 * 
	 * @param statement
	 *            the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement) {
		// Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword(statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "What would it mean to " + restOfStatement + "?";
	}
	
	private String transformIWantSomethingStatement(String statement) {
		// Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword(statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}

	/**
	 * Take a statement with "you <something> me" and transform it into
	 * "What makes you think that I <something> you?"
	 * 
	 * @param statement
	 *            the user statement, assumed to contain "you" followed by "me"
	 * @return the transformed statement
	 */
	private String transformYouMeStatement(String statement) {
		// Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}

		int psnOfYou = findKeyword(statement, "you", 0);
		int psnOfMe = findKeyword(statement, "me", psnOfYou + 3);

		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe)
				.trim();
		return "What makes you think that I " + restOfStatement + " you?";
	}
	 private String transformISomethingYouStatement(String statement) {
		// Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}

		int psnOfI = findKeyword(statement, "I", 0);
		int psnOfYou = findKeyword(statement, "you", psnOfI + 2);

		String restOfStatement = statement.substring(psnOfI + 2, psnOfYou)
				.trim();
		return "Why do you " + restOfStatement + " me?";
	} 
	/**
	 * Search for one word in phrase. The search is not case sensitive. This
	 * method will check that the given goal is not a substring of a longer
	 * string (so, for example, "I know" does not contain "no").
	 * 
	 * parameter: statement
	 *            the string to search
	 * parameter: goal
	 *            the string to search for
	 * parameter: startPos
	 *            the character of the string to begin the search at
	 * return the index of the first occurrence of goal in statement or -1 if
	 *         it's not found
	 */
	private int findKeyword(String statement, String goal, int startPos) {
		String phrase = statement.trim();
		// The only change to incorporate the startPos is in the line below
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

		// Refinement--make sure the goal isn't part of a word
		while (psn >= 0) {
			// Find the string of length 1 before and after the word
			String before = " ", after = " ";
			if (psn > 0) {
				before = phrase.substring(psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length()) {
				after = phrase.substring(psn + goal.length(),
						psn + goal.length() + 1).toLowerCase();
			}

			// If before and after aren't letters, we've found the word
			if (before.equals(" ") && after.equals(" ")) {
				return psn;
			}
			// The last position didn't work, so let's find the next, if there
			// is one.
			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);

		}

		return -1;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * 
	 * @return a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		}
		else if (whichResponse == 4) {
			response = "You are very interesting.";
		}
		else if (whichResponse == 5) {
			response = "Don't you know any real people to talk to?";
		}
		return response;
	}

}
