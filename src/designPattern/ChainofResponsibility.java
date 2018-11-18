package designPattern;

enum RequestLevel {
	LEVEL1, LEVEL2
}

interface Support {

	public String getResponse(RequestLevel level);
}

class Level1 implements Support {

	@Override
	public String getResponse(RequestLevel level) {
		// TODO Auto-generated method stub
		if (level.equals(RequestLevel.LEVEL1)) {
			return "Level-1 Support handled";
		} else if (level.equals(RequestLevel.LEVEL2)) {
			Support s = new Level2();
			return s.getResponse(RequestLevel.LEVEL2);
		} else {
			return "No Response";
		}

	}

}

class Level2 implements Support {

	@Override
	public String getResponse(RequestLevel level) {
		// TODO Auto-generated method stub
		if (level.equals(RequestLevel.LEVEL2)) {
			return "Level-2 Escalation handled";
		} else {
			return "No Response";
		}

	}

}

public class ChainofResponsibility {

	public static void main(String args[]) {
		Support support = new Level1();
		System.out.println(support.getResponse(RequestLevel.LEVEL1));
		System.out.println(support.getResponse(RequestLevel.LEVEL2));
	}
}
