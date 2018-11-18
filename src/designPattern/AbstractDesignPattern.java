package designPattern;

/**
 * Demo of Abstract Factory Design Pattern
 * 
 * @author Harsh Maheshwari
 *
 */
public class AbstractDesignPattern {

	public static void main(String args[]) {
		AbstractPasserFactory factory = new NYParserFactory();
		Parser parser = factory.getParserInstance("NYJSONErrorParser");
		System.out.println(parser.parse());
	}

}

interface AbstractPasserFactory {

	public Parser getParserInstance(String type);
}

class NYParserFactory implements AbstractPasserFactory {

	@Override
	public Parser getParserInstance(String type) {
		// TODO Auto-generated method stub
		switch (type) {
		case "NYERROR":
			return new NYError();
		case "NYFeedBack":
			return new NYFeedBack();
		case "NYJSONErrorParser":
			return new NYJSONErrorParser();
		case "NYJSONFeedBack":
			return new NYJSONFeedBack();
		default:
			return null;
		}
	}

}

class CNParserFactory implements AbstractPasserFactory {

	@Override
	public Parser getParserInstance(String type) {
		switch (type) {
		case "CNXMLParser":
			return new CNXMLParser();
		case "CNFeedBackParser":
			return new CNFeedBackParser();
		case "CNJSONErrorParser":
			return new CNJSONErrorParser();
		case "CNJSONFeedBack":
			return new CNJSONFeedBack();
		default:
			return null;
		}
	}

}

class NYError implements XMLParser {

	@Override
	public String parse() {
		// TODO Auto-generated method stub
		return NYError.class.getName();
	}

}

class NYFeedBack implements XMLParser {

	public String parse() {
		return NYFeedBack.class.getName();
	}
}

interface Parser {
	public String parse();
}

interface XMLParser extends Parser {
	@Override
	public String parse();
}

interface JSONParser extends Parser {
	public String parse();
}

class CNXMLParser implements XMLParser {

	@Override
	public String parse() {
		// TODO Auto-generated method stub
		return CNXMLParser.class.getName();
	}

}

class CNFeedBackParser implements XMLParser {

	@Override
	public String parse() {
		// TODO Auto-generated method stub
		return CNFeedBackParser.class.getName();
	}

}

class NYJSONErrorParser implements JSONParser {

	@Override
	public String parse() {
		// TODO Auto-generated method stub
		return NYJSONErrorParser.class.getName();
	}

}

class NYJSONFeedBack implements JSONParser {

	@Override
	public String parse() {
		// TODO Auto-generated method stub
		return NYJSONFeedBack.class.getName();
	}

}

class CNJSONErrorParser implements JSONParser {

	@Override
	public String parse() {
		// TODO Auto-generated method stub
		return CNJSONErrorParser.class.getName();
	}

}

class CNJSONFeedBack implements JSONParser {

	@Override
	public String parse() {
		// TODO Auto-generated method stub
		return CNJSONFeedBack.class.getName();
	}

}
