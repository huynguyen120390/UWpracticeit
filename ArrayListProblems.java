/**
   Arraylist Problems in Practiceit by University of Washington 
   Author: Huy Nguyen 
*/
import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;

public class ArrayListProblems{
   /**Main*/
   public static void main(String []args){
      try{
         //1.
         //Scanner sc = new Scanner(new File("arrayListString.txt"));
         Scanner sc = new Scanner(new File("arrayListNums.txt"));
         ArrayList<Integer> list = new ArrayList<Integer>();
         ArrayList<String> Strlist = new ArrayList<String>();
         
         //2/
         list = feedIntArrayListFrom(sc);
         //Strlist = feedStringArrayListFrom(sc);
         //mystery1(list);
         //swapPairs(Strlist);
         //removeEvenLength(Strlist);
         //doubleList(Strlist);
         //mintoFront(list);
         //removeDuplicates(Strlist);
         //removeInRange(list,0,3,10);
         //stutter(Strlist,4);
         //markLength4(Strlist);
         //markLengthDynamic(Strlist);
         filterRange(list,5,7);
      }catch(FileNotFoundException e){
         System.out.println("No File Found!!!!!");
      }
   }
   
   /**feed arrayIntlist*/
   public static ArrayList<Integer> feedIntArrayListFrom(Scanner sc){
      ArrayList<Integer> list = new ArrayList<Integer>();
      int num = 0;
      while(sc.hasNextInt()){
         num = sc.nextInt();
         list.add(num);
      }  
      return list;
   }
   
   /**feed arrayStringList*/
   public static ArrayList<String> feedStringArrayListFrom(Scanner sc){
      ArrayList<String> list = new ArrayList<String>();
      String text = "";
      while(sc.hasNext()){
         text = sc.next();
         list.add(text);
      }
      return list;
   }
   
   /**mystery1*/
   public static void mystery1(ArrayList<Integer> list){
      for(int i = list.size() - 1; i>0; i--){
         if(list.get(i) < list.get(i-1)){
            int element = list.get(i);
            list.remove(i);
            list.add(0,element);
         }  
      } 
      System.out.println(list);
   }
   
   /**swap pairs*/
   public static void swapPairs(ArrayList<String> list){
      if(list.isEmpty() == false){
         int limit = list.size();
         String temp = "";
         
         if(limit % 2 != 0){
            limit = limit - 1;
         }
         
         for(int i = 0; i<limit; i = i + 2){
            temp = list.get(i);
            list.set(i,list.get(i+1));
            list.set(i+1,temp);     
         }
      }
      System.out.println(list);
   }
   public static void removeEvenLength(ArrayList<String> list){
      if(list.isEmpty() == false){
         for(int i = 0; i<list.size(); i++){
            if(list.get(i).length()% 2 == 0){
               list.remove(i);
               i = i - 1;
            }   
         }
      }
      System.out.println(list);
     
   }
   
   public static void doubleList(ArrayList<String> list){
     if(list.isEmpty() == false){
      for(int i = 0; i< list.size(); i+=2){
         list.add(i+1,list.get(i));
      }
     }
     System.out.println(list);
   }
   
   public static void mintoFront(ArrayList<Integer> list){
      if(list.isEmpty() == false){
         int min = list.get(0);
         
         //find the min & store their indice
         for(int i = 1; i<list.size(); i++){
           if(min >= list.get(i)){
            min = list.get(i);
           }
         }
         //remove the ith to front
         for(int i = 0; i< list.size() ; i++){
            if(min == list.get(i) && i != 0){
               list.remove(i);
               list.add(0,min);
               i -=1;
            }
          
         }
      }
      System.out.println(list);

   }
   
   public static void removeDuplicates(ArrayList<String> list){
      for(int i = 0; i< list.size() - 1; i++){
         if(list.get(i).equals(list.get(i+1))){
            list.remove(i);
            i -=1;
         }
      }
      System.out.println(list);
   
   }
   public static void removeInRange(ArrayList<Integer> list,int value, int sIndx, int eIndx){
      try{
         for(int i = sIndx; i <= eIndx ; i++){
            if(list.get(i) == value){
               list.remove(i);
               eIndx -= 1;
               i -=1;
            }
         }
      }catch(IndexOutOfBoundsException e){
         System.out.println("Out of range la!");
      }
      
      System.out.println(list);
   
   }
   public static void stutter(ArrayList<String> list,int k){
      if(list.isEmpty() == false){
         if(k>0){  
            for(int i = 0; i<list.size(); i += k){
               String element = list.get(i);
               for(int j = 1; j < k; j++){
                  list.add(i+j,element);
               }
            }
         }else{
            for(int i = list.size() -1 ; i>=0;i--){
               list.remove(i); 
            }     
         }
      }
      System.out.println(list);

   }
   
   public static void markLength4(ArrayList<String> list){
      String fourAsterisks = "****";
      for(int i = 0; i< list.size(); i++){
         if(list.get(i).length() == 4){
            list.add(i,fourAsterisks);
            i+=1;
         }
      }
      System.out.println(list);
   }
   
   public static void markLengthDynamic(ArrayList<String> list){
      for(int i = 0; i< list.size(); i+=2){
         String asterisks = "";
         for(int j = 0; j< list.get(i).length();j++){
            asterisks = asterisks + "*";
         }
         list.add(i,asterisks);
         
      }
      System.out.println(list);
   }
   
   public static void filterRange(ArrayList<Integer> list, int a, int b){ 
    if(list.isEmpty() == false){
       for(int i = 0; i<list.size(); i++){
          int num = list.get(i);
          if( (num > a && num < b) || num == a || num == b){
              list.remove(i);
              i=-1;
          }
           
       }
    }
    System.out.println(list);
}
}