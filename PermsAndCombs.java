public class PermsAndCombs {
	StringBuilder out = new StringBuilder();
	boolean[] used;
	final String in;

	public PermsAndCombs(final String str) {
		in = str;
		used = new boolean[in.length()];
	}

	public void permute() {
		if (out.length() == in.length()) {
			System.out.println(out);
			return;
		}

		for (int i = 0; i < used.length; i++) {
			if (used[i])
			System.out.print("Used " + in.charAt(i) + " ");
		}

		for (int i = 0; i < in.length(); i++) {
			if (used[i]) continue;
			out.append(in.charAt(i));
			used[i] = true;
			permute();
			used[i] = false;
			out.setLength(out.length() - 1);
		}
	}

	public static void main(String[] args) {
		PermsAndCombs pac = new PermsAndCombs("abcd");
		pac.permute();
	}
}