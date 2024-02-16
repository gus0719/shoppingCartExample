package myLearn.myTest;

public class UserAPI{
	void mLine(char mark, int length){
		for(int repeat = 0; repeat < length; repeat++){
			System.out.print(mark);
		}
		System.out.println();
	}
	String mLineReturn(char mark, int length){
		String markLine = "";
		for(int repeat = 0; repeat < length; repeat++){
			markLine += mark;
		}
		return markLine;
	}
}