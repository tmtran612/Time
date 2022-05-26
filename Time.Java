//Name: Ted Tran

//comment every line

public class Time implements Comparable<Time> //creates public class named time
{ //opening bracket
   private int hour; //declare class variable hour
   private int minute; //declare class variale minute
   
   public Time(int h, int m) //two arg constructr
   {//opening bracket
      if ((h >= 0) && (m >= 0)) //check if time is valid
      {//opening bracket
         hour = h; //assigns hour
         minute = m; //assigns minute
         if(minute >= 60) //if minute greater than 60
         {//opening bracket
            hour = hour + (minute) / 60; //adds hours based on amount of minutes
            if(hour >= 24) //checks if hour is equal to or more than 24
            {//opening bracket
               hour = hour % 24 ; //puts hour within 0-24
            }//closing bracket
            minute = (minute) % 60; //puts minute within 0-60
            
         }//closing bracket
         
         
      }//closing bracket
   }//closing bracket
   public Time()//default constructor
   {//opening bracket
      this(0,0);//calls Time with two arg default constructor
   }//closing bracket
   
   public int compareTo(Time that) {
      if (this.hour > that.hour) return 1;
      if (this.hour < that.hour) return -1;
      if (this.minute > that.minute) return 1;
      if (this.minute < that.minute) return -1;
      return 0;
   }
   
   public String toString() //creates method toString()
   {//opening bracket
      return ((hour >= 0 && hour<= 9 ? "0" : "") + hour + (minute >= 0 && minute<= 9 ? "0" : "")+ minute); //add 0 next to hour if hour is less than 10, adds 0 next to minute if minute is less than 10
   }//closing bracket
   
   public void increment(int x)//increment method
   {//opening bracket
      if (x<0) return;//returns if negative
      minute = minute + x;//adds x to minutes
      hour = hour + minute/60;//adds the amount of hours from minute/60
      hour = hour % 24;//resets hour back to 24 or below
      minute = minute % 60;//resets minutes back to 60 or below
      
   }
   
   public String convert() //convert method
   {//opening bracket
      String ans = ""; //declared and defined string variable
      if (hour > 12)//if hour is greater than three
      {//opening bracket
         int standardHour = hour - 12; //standard hour
         ans = standardHour + ":" + (minute >= 0 && minute<= 9 ? "0" : "") + minute + " pm";//concatenates ":", concatenate 0 behind minute if minute is less than 10,  concatenates 0
      }//closing bracket
      else if (hour == 0 || hour == 12) //elseif hour is 0 or 12
         ans = 12 + ":" + (minute >= 0 && minute<= 9 ? "0" : "") + minute + (hour == 12 ? " pm" : " am");//concatenates "12:" with concatenated 0 (if minute less than 10)and minute then if hour is 12 then its pm otherise it's am
      else//else
         ans = hour + ":" + (minute >= 0 && minute<= 9 ? "0" : "") + minute + " am";//otherwise hour concatenates ":" with minute with 0 at the beginning if minute less than 10 and then " am" at the end
      
      return ans;//returns answer
   }//closing bracket
   
   public static void main(String[] args)//main methodx
   {//opening bracket
      
   
      Time t1 = new Time();//creates new time object
      System.out.println("Expected Output: 0000 - " + t1);//prints result
      System.out.println("Expected Output: 12:00 am - " + t1.convert());//prints result
      
      Time t2 = new Time(-6, -9);//creates new time object
      System.out.println("Expected Output: 0000 - " + t2);//prints result
      
      Time t3 = new Time(23, 125);//creates new time object
      System.out.println("Expected Output: 0105 - " + t3);//prints result
      System.out.println("Expected Output: 1:05 am - " + t3.convert());//prints result
      
      Time t4 = new Time(14,9);//creates new time object
      System.out.println("Expected Output: 2:09 am - " + t4.convert());//prints result
      System.out.println("Expected Output: 1409 - " + t4);//prints result
      
      Time t5 = new Time(12,8);//creates new time object
      System.out.println("Expected Output: 12:08 am - " + t5.convert());//prints result
      
      Time t6 = new Time(23,40);//creates new time object
      t6.increment(30);//increase time by 30 minutes
      System.out.println("Expected Output: 0010 - " + t6);//prints result
      
      Time t7 = new Time(11,50);//creates new time object
      t7.increment(-10);//increase time by -10 minutes
      System.out.println("Expected Output: 1150 - " + t7);//prints result
      
   }//closing bracket
}//closing bracket
