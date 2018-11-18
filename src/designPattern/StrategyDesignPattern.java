package designPattern;
/**
 * use of Strategy Pattern 
 * @author harsmahe
 *
 */
public class StrategyDesignPattern {

	public static void main(String args[]) {
		Formatter format = new CapsFormatter();
		TextEditor editor = new TextEditor(format);
		editor.publishText("Hello to Strategy Pattern");
		
		format = new LowerFormatter();
		editor = new TextEditor(format);
		editor.publishText("Hello to Strategy Pattern");
		
	}
}

interface Formatter {
	public String format(String text);
}

class CapsFormatter implements Formatter {

	@Override
	public String format(String text) {
		// TODO Auto-generated method stub
		return text.toUpperCase();

	}

}

class LowerFormatter implements Formatter {

	@Override
	public String format(String text) {
		// TODO Auto-generated method stub
		return text.toLowerCase();
	}

}

class TextEditor {

	private final Formatter format;

	public TextEditor(Formatter format) {
		this.format = format;
	}

	public void publishText(String text) {
		String output = format.format(text);
		System.out.println(output);
	}
}
