package string;

public class ValidNumber {
//	Validate if a given string is numeric.
//
//	Some examples:
//	"0" => true
//	" 0.1 " => true
//	"abc" => false
//	"1 a" => false
//	"2e10" => true
//	Note: It is intended for the problem statement to be ambiguous. 
//	You should gather all requirements up front before implementing one.
//    public boolean isNumber(String s) {
//        if(s == null)
//        	return false;
//        s=s.trim();
//    	int length = s.length();
//        if(length == 0)
//        	return false;
//        return helper(s,0,false,false,false);
//    }
//
//	private boolean helper(String s, int cur, boolean dec, boolean sci, boolean digit) {
//		if(cur == s.length()){
//			return digit;
//		}
//		char onechar = s.charAt(cur);
//		if(onechar == ' ')
//			return helper(s,cur+1,dec,sci,digit);
//		if(onechar - '0' >= 0 && onechar - '0' <= 9){
//			digit=true;
//			return helper(s,cur+1,dec,sci,digit);
//		}else if(onechar == 'e'){
//			if(sci || !digit)
//				return false;
//			sci = true;
//			digit = false;
//			return helper(s,cur+1,dec,sci,digit);
//		}else if(onechar == '.'){
//			if(dec || sci)
//				return false;
//			dec = true;
//			return helper(s,cur+1,dec,sci,digit);
//		}else{
//			return false;
//		}
//	}
//	
    public boolean isNumber(String s) {
        if (s==null)
            return false;
        // trim off head and tail zeros which not affect result depend on question
        s=s.trim();
        if(s.length()==0){
            return false;
        }
       boolean hasNum=false;
       boolean canSign=true;
       boolean canDot=true;
       boolean canE=false;
       boolean hasE=false;
       int i=0;
       while(i<s.length()){
           char c=s.charAt(i++);
           if (c==' '){
              return false;
           }
           if (c=='+' ||c=='-'){
               if (!canSign){
                   return false;
               }
               canSign=false;
               continue;
           }
           if (c=='.'){
               if (!canDot){
                   return false;
               }
               canDot=false;
               canSign=false;
               continue;
           }
           if (c=='e'){
               if (!canE||hasE){
                   return false;
               }
               canE=false;
               hasE=true;
               hasNum=false;
               canDot=false;
               canSign=true;
               continue;
           }
           if (c>='0' && c<='9'){
               hasNum=true;
               if (!canE&&!hasE){
                   canE=true;
               }
               canSign=false;
           }
           else{
               return false;
           }
       }
       return hasNum;
   }
}
