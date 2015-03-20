package CompareVersionNumbers;

public class Solution {

	public static int compareVersion(String version1, String version2) {
		int num1,num2,pos1,pos2,lastPos1,lastPos2;
		lastPos1 = -1;
		lastPos2 = -1;
		pos1=0;
		pos2=0;
		while(pos1 != -1 || pos2 != -1){
			if(pos1==-1)
				num1 =0;
			else {
				pos1 = version1.indexOf('.', ++lastPos1);
				num1 = pos1==-1 ? Integer.parseInt(version1.substring(lastPos1)) : Integer.parseInt(version1.substring(lastPos1,pos1));
				lastPos1 = pos1;
			}
			if(pos2 == -1)
				num2 = 0;
			else { 
				pos2 = version2.indexOf('.', ++lastPos2);
				num2 = pos2==-1 ? Integer.parseInt(version2.substring(lastPos2)) : Integer.parseInt(version2.substring(lastPos2,pos2));
				lastPos2 = pos2;
			}
			if(num1 < num2)
				return -1;
			else if(num1 > num2)
				return 1;
		}
		return 0;
        
    }
	public static void main(String[] args) {
		String a = "1",b="1.1";
		System.out.println(compareVersion(a,b));
		

	}

}
