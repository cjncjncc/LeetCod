
public class IntegertoRoman {
	public static String ToRoman(int input,String[] numberString){
		String ret="";
		switch (input) {
		case 0:
			break;
		case 1:
			ret=numberString[0];
			break;
		case 2:
			ret=numberString[0]+numberString[0];
			break;
		case 3:
			ret=numberString[0]+numberString[0]+numberString[0];
			break;
			
		case 4:
			ret=numberString[0]+numberString[1];
			break;
		case 5:
			ret=numberString[1];
			break;
		case 6:
			ret=numberString[1]+numberString[0];
			break;
		case 7:
			ret=numberString[1]+numberString[0]+numberString[0];
			break;
		case 8:
			ret=numberString[1]+numberString[0]+numberString[0]+numberString[0];
			break;
		case 9:
			ret=numberString[0]+numberString[2];
			
			break;

		default:
			break;
		}
		return ret;
	}
	public static String Solution(int input){
		String number1[]={"I","V","X"};
		String number2[]={"X","L","C"};
		String number3[]={"C","D","M"};
		String number4[]={"M","M","M"};
		String ret="";
		String a1;
		String a2;
		String a3;
		String a4;
		a1=ToRoman(input%10,number1);
		a2=ToRoman((input%100)/10,number2);
		a3=ToRoman((input%1000)/100,number3);
		a4=ToRoman(input/1000,number4);
		ret=a4+a3+a2+a1;
		return ret;
	}
}
