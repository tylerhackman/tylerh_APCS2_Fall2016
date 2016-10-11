public class Magpie2 {

	//Get a default greeting and return a greeting	
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * takes in a user statement
	 * returns a response based on given rules
	 */
	public String getResponse(String statement) {
		String response = "";
		if (statement.trim().length() < 1) {
			response = "Say something, please."; 
		}
			else if (statement.indexOf("no") >= 0) {
			response = "Why so negative?";
		} else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0) {
			response = "Tell me more about your family.";
		}
		else if (statement.indexOf("Dreyer") >= 0
				|| statement.indexOf("deHeer") >= 0
				|| statement.indexOf("Lamont") >= 0) {
			response = "Your teachers sound like they know what they're doing.";
		}
		else if (statement.indexOf("Trump") >= 0
				|| statement.indexOf("Donald") >= 0
				|| statement.indexOf("trump") >= 0
				|| statement.indexOf("donald") >= 0) {
			response = "Let's make America great again!";
		}
		else {
			response = getRandomResponse();
		}
		return response;
	
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * returns a non-committal string
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
