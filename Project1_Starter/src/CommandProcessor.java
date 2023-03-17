/**
 * The purpose of this class is to parse a text file into its appropriate, line
 * by line commands for the format specified in the project spec.
 * 
 * @author CS Staff
 * 
 * @version 2021-08-23
 */
public class CommandProcessor {

	// the database object to manipulate the
	// commands that the command processor
	// feeds to it
	private Database data;

	/**
	 * The constructor for the command processor requires a database instance to
	 * exist, so the only constructor takes a database class object to feed commands
	 * to.
	 * 
	 * @param dataIn the database object to manipulate
	 */
	public CommandProcessor() {
		data = new Database();
	}

	/**
	 * This method identifies keywords in the line and calls methods in the database
	 * as required. Each line command will be specified by one of the keywords to
	 * perform the actions within the database required. These actions are performed
	 * on specified objects and include insert, remove, regionsearch, search,
	 * intersections, and dump. If the command in the file line is not one of these,
	 * an appropriate message will be written in the console. This processor method
	 * is called for each line in the file. Note that the methods called will
	 * themselves write to the console, this method does not, only calling methods
	 * that do.
	 * 
	 * @param line a single line from the text file
	 */
	public void processor(String line) {
		try {
			String[] values = line.split("( +|\\t+)+");
			String Instruction = values[0];
			String name;
			int x, y, w, h;
			CustomRectangle rect;
			KVPair<String, CustomRectangle> element;

			switch (Instruction) {
			case "insert":
				if (values.length - 1 < 5) {
					throw new Exception();
				}
				name = values[1];
				x = Integer.parseInt(values[2]);
				y = Integer.parseInt(values[3]);
				w = Integer.parseInt(values[4]);
				h = Integer.parseInt(values[5]);
				rect = new CustomRectangle(x, y, w, h);
				element = new KVPair<String, CustomRectangle>(name, rect);
				data.insert(element);
				break;

			case "remove":
				if (values.length - 1 < 1) {
					throw new Exception();
				}
				if (values.length - 1 < 4) {
					name = values[1];
					data.remove(name);
				} else {
					x = Integer.parseInt(values[1]);
					y = Integer.parseInt(values[2]);
					w = Integer.parseInt(values[3]);
					h = Integer.parseInt(values[4]);
					data.remove(x, y, w, h);
				}
				break;

			case "regionsearch":
				if (values.length - 1 < 4) {
					throw new Exception();
				}
				x = Integer.parseInt(values[1]);
				y = Integer.parseInt(values[2]);
				w = Integer.parseInt(values[3]);
				h = Integer.parseInt(values[4]);
				data.regionsearch(x, y, w, h);
				break;

			case "intersections":
				data.intersections();
				break;

			case "search":
				if (values.length - 1 < 1) {
					throw new Exception();
				}
				name = values[1];
				data.search(name);
				break;
			case "dump":
				data.dump();
				break;
			default:
				throw new Exception();
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid value of the argument!");
		} catch (Exception e) {
			System.out.println("Input Syntax Error!");
			System.out.println("The input should meet the following Syntax: ");
			System.out.println("Input Command {Command Parameters}");
			System.out.println("Valid Commands:");
			System.out.println("insert {name} {x} {y} {w} {h}");
			System.out.println("remove {name}");
			System.out.println("remove {x} {y} {w} {h}");
			System.out.println("regionsearch {x} {y} {w} {h}");
			System.out.println("intersections");
			System.out.println("search {name}");
			System.out.println("dump");
			System.out.println("terms in { } are parameters to the command");
		}
	}

}
