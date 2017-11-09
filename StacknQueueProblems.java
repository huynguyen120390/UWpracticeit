import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;


public class StacknQueueProblems{
   public static void main(String[] args){
      try{
         Scanner sc = new Scanner(new File("arrayListNums.txt"));
         Stack<Integer> s = new Stack<Integer>();
         Queue<Integer> q = new LinkedList<Integer>();
         
         //s = feedInt2Stack(sc);
         q = feedInt2Queue(sc);
         System.out.println(q);
         //collapse(s);
         System.out.println(isPalindrome(q));
      }catch(FileNotFoundException e){
         System.out.println("No this file!");
      }
   }
   
   public static Stack<Integer> feedInt2Stack(Scanner sc){
      Stack<Integer> s = new Stack<Integer>();
      while(sc.hasNextInt()){
         s.push(sc.nextInt());
      }
      
      return s;
   }
   public static Queue<Integer> feedInt2Queue(Scanner sc){
      Queue<Integer> q = new LinkedList<Integer>();
      while(sc.hasNextInt()){
         q.add(sc.nextInt());
      }
      return q;
   }
   
   public static Stack<String> feedString2Stack(Scanner sc){
      Stack<String> s = new Stack<String>();
      while(sc.hasNext()){
         s.push(sc.next());
      }
      return s;
   }
   public static Queue<String> feedString2Queue(Scanner sc){
      Queue<String> q = new LinkedList<String>();
      while(sc.hasNext()){
         q.add(sc.next());
      }
      return q;
   }

   public static void splitStack(Stack<Integer> s){
        Stack<Integer> neg = new Stack<Integer>();
        Stack<Integer> nonNeg = new Stack<Integer>();
        int num = 0;
       
        while(!s.isEmpty()){
            num = s.pop();
            
            if(num >= 0 ){
               nonNeg.push(num); 
            }else{
               neg.push(num);
            }  
        }
       
        while(!neg.isEmpty()){
           s.push(neg.pop());   
        }
       
        while(!nonNeg.isEmpty()){
           s.push(nonNeg.pop());   
        }   
   }
   
   public static void stutter(Stack<Integer> s){
    Stack<Integer> s2 = new Stack<Integer>();
    int num = 0;
    while(!s.isEmpty()){    
       num = s.pop();
       s2.push(num);
       s2.push(num);
    }  
    while(!s2.isEmpty()){
       num = s2.pop();
       s.push(num);
    }
   }
   
   public static Stack<Integer> copyStack(Stack<Integer> s){
    
    Stack<Integer> s2 = new Stack<Integer>();
    while(!s.isEmpty()){
        s2.push(s.pop());    
    }
    while(!s2.isEmpty()){
        s.push(s2.pop());    
    }
    return s;   
   }
   
   public static void collapse(Stack<Integer> theS){
       Stack<Integer> s2 = new Stack<Integer>();
       Stack<Integer> s = new Stack<Integer>();
       int num, num1, num2;
       while(!theS.isEmpty()){
         s.push(theS.pop());
       }
       
       while(!s.isEmpty()){
           num1 = s.pop();
           if(!s.isEmpty()){
               num2 = s.pop();
               num = num1 + num2;
           }else{
               num = num1;  
           }
           s2.push(num);
       }
   
       System.out.println(s2);
   }
   
   public static boolean equals(Stack<Integer> s1, Stack<Integer> s2){
       boolean isEqual;
       while(!s1.isEmpty()){
           if(s1.size() != s2.size()){
               return isEqual = false;  
           }else if(s1.pop() != s2.pop()){
               return isEqual = false;   
           }
           
       }
       return isEqual = true;
   }
   

   public static void rearrange(Queue<Integer> q){
       Queue<Integer> oddNum = new LinkedList<Integer>();
       Queue<Integer> evenNum = new LinkedList<Integer>();
       int num;
       while(!q.isEmpty()){
           num = q.remove();
           if(num % 2 == 0){
               evenNum.add(num);
           }else{
               oddNum.add(num);
           } 
       }
       while(!evenNum.isEmpty()){
           q.add(evenNum.remove());   
       }
       while(!oddNum.isEmpty()){
           q.add(oddNum.remove());    
       }   
   }
   
   public void reverseHalf(Queue<Integer> q){
       Stack<Integer> s1 = new Stack<Integer>();
       Queue<Integer> q1 = new LinkedList<Integer>();
       int num1,num2;
    
       //separate odd-inx and even-inx into stack and queue alternatively
       while(!q.isEmpty()){
           num1 = q.remove();//even
           q1.add(num1);
           
           if(!q.isEmpty()){
               num2 = q.remove();//odd
               s1.push(num2);
           } 
       }
       //put them back odd-inx and even-inx into original queue, with odd and even-inx alternatively 
       while(!s1.isEmpty() || !q1.isEmpty()){
           if(!q1.isEmpty()){
               q.add(q1.remove());
           }
           if(!s1.isEmpty()){
               q.add(s1.pop());
           }
           
       }  
   }
   
   public static boolean isPalindrome(Queue<Integer> q){
    Queue<Integer> halfQ1 = new LinkedList<Integer>();
    Queue<Integer> tempQ = new LinkedList<Integer>();
    Stack<Integer> s1 = new Stack<Integer>();

    int qSize = q.size();
    int halfQSize = qSize/2;
    int midElement;
    int num;
  
    //work
    for(int i = 0; i < halfQSize;i++){
        num = q.remove();
        halfQ1.add(num); 
        tempQ.add(num);
        
    }
    System.out.println("Half first" + halfQ1);
    if(qSize%2 != 0){
        midElement = q.remove();
        tempQ.add(midElement);
    }
    
    for(int i = 0; i < halfQSize;i++){
        num = q.remove();
        s1.push(num); 
        tempQ.add(num);
    }
    System.out.println("Half last" + s1);

    //recover
    while(!tempQ.isEmpty()){
        q.add(tempQ.remove());  
    }
    //compare halfQ1 FIFO and s2 FILO
    while(!halfQ1.isEmpty()){
        int num1 = halfQ1.remove();
        int num2 = s1.pop();
      
        if(num1 != num2){
            return false;
        }  
    } 
   return true; 
 }
 
 public static void switchPairs(Stack<Integer> s){
    Stack<Integer> s1 = new Stack<Integer>();
    int oddHolder = 0;
    int num1, num2;
    int size = s.size();
    
    if(size%2 != 0){
        oddHolder = s.pop();
    }
    while(!s.isEmpty()){
        num1 = s.pop();
        num2 = s.pop();
        s1.push(num2);
        s1.push(num1);
    }
    
    while(!s1.isEmpty()){
        s.push(s1.pop());     
    }
    
    if(size%2 !=0){
        s.push(oddHolder);
    }
}   
}