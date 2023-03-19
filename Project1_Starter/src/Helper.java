public class Helper {
	public static boolean isValidName(String name) {
		if (name == null)
			return false;
		if ((name.charAt(0) >= 'a' && name.charAt(0) <= 'z') || (name.charAt(0) >= 'A' && name.charAt(0) <= 'Z')) {
			for (int i = 1; i < name.length(); i++) {
				if ((name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z')
						|| (name.charAt(i) >= '0' && name.charAt(i) <= '9') || name.charAt(i) == '_') {
					// Do nothing
				} else
					return false;
			}
			return true;
		}
		return false;
	}

	public static String generateRandomName(int size) {
		int randomSize = (int) (Math.random() * 10) % size + 1;
		String randomName = "";
		for (int i = 0; i < randomSize; i++) {
			int randomNumber = (int) (Math.random() * 100) % 26;
			char character;
			if (i == 0)
				character = (char) (randomNumber + 65);
			else
				character = (char) (randomNumber + 97);
			randomName += character;
		}
		return randomName;
	}
}
