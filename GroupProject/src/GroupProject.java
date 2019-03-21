
/**
 * Creates a new organization and interface. Calls interface to start.
 *
 */
public class GroupProject {

	/**
	 * Starts the group project with a organization with no existing information.
	 * 
	 * @param args Default args.
	 */
	public static void main(String[] args) {
		Organization org = new Organization();
		Interface io = new Interface(org);
		io.start();
	}

}
