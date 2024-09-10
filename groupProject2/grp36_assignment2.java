public class grp36_assignment2 {
    public static void main(String[] args) {
        //This project was completed by Padraig Shannon (23367687), James Buckley (23385812), Victor Ekhator (23387564), Saif Khawaldeh (23382783)
        //First fetch user name and store as string
        String name = System.getProperty("user.name"); //System.getProperty fetches the username on the device
        //each of us ran the code to fetch and print the username of our devices to ensure the code was working correctly
        
        //THIS VARIABLE CHOOSES HOW MANY DAYS AGO THE MESSAGE WAS POSTED
        long daysSincePost = 2;
        
        //Message
        String message = "Eight bytes walk into a bar. The bartender asks 'Can I get you anything'. Yes replied the bytes. 'Make me a double'";
        //String message = "Test for short"; //This is a test variable for when the length of the string is below 40
        int length, midpoint, i, i2;
        String systemName = System.getProperty("user.name");
        //String name = "Test"; //Test Variable for other output of systemName if statement
        length = message.length();
        midpoint = length / 2;
        String messageHalf1 = message.substring(0, midpoint); //message was split into 2 sections to make it easier for converting to uppercase and lower case
        String messageHalf2 = message.substring(midpoint);
        int width = 40;
        
        //formating the whatsapp post
        System.out.println("Posted By: " + name);//Prints username 
        
        //Calculate Time / Initiate important variables
        long time, millisPerDay , millisToday, secondsPssd, minsPssd, hrsPssd, daysPassed, daysPassedWeek, differenceOfDays;//Declares variables (Pssd stands for passed, e.g MinsPssd = Minutes Passed ect.)
        // daysPassed  Temporarly removed
        time = System.currentTimeMillis(); //Calculates the milliseconds passed since January 1st 1970
        millisPerDay = 86400000 ; //milli Seconds Per Day
        millisToday = time % millisPerDay; //This calculates how many milliseconds in today since midnight
        secondsPssd = millisToday/1000; //Converts milliseconds to seconds
        minsPssd = secondsPssd/60; //Converts seconds to minutes
        secondsPssd = secondsPssd%60; //This will change the value in SecondsPssd from seconds since midnight to seconds since the last minute
        hrsPssd = minsPssd/60; //Changes minutes to hours
        minsPssd = minsPssd%60; //Changes the value of MinsPssd from minutes since midnight to minutes since the last hour
        daysPassed = time / 86400000;//calculates days passed since jan 1 1970
        daysPassedWeek = daysPassed % 7;//calculates days in last week (important to note it starts at thursday)
        long differenceInDays = daysPassedWeek - daysSincePost;
        String dayName = "";
        if (differenceInDays == 0) {
                dayName = "Thursday";
            } else if (differenceInDays == 1) {
                dayName = "Friday";
            } else if (differenceInDays == 2) {
                dayName = "Saturday";
            } else if (differenceInDays == 3) {
                dayName = "Sunday";
            } else if (differenceInDays == 4) {
                dayName = "Monday";
            } else if (differenceInDays == 5) {
                dayName = "Tuesday";
            } else if (differenceInDays == 6) {
                dayName = "Monday";
            } 
        String dayOutput = "";
        if(daysSincePost == 0) {
            dayOutput = "" ;
        } else if (daysSincePost == 1) {
            dayOutput = "Yesterday" ; 
        } else if (daysSincePost < 7) {
            dayOutput = dayName ;
        } else {
            dayOutput = "Some time ago..." ;
        }
        int centre = (length / 2);
        String centredDay = String.format("%" + (centre) + "s", dayOutput); //formats the dayoutput to be centred above the message
            
     
        System.out.println(centredDay);

        if (systemName == name) {
            messageHalf1 = "";//For this i emptied the message halves so that the for statement would add all the charcters back in individually and convert to upper/lower case
            for(i = 0; i < midpoint; ++i) {
                char c= message.charAt(i);
                messageHalf1 += Character.toLowerCase(c);
            } 
            messageHalf2 = "";
            for(i2 = midpoint; i2 != length; ++i2) {
                char d= message.charAt(i2);
                messageHalf2 += Character.toUpperCase(d);
            }
        } else {
            messageHalf1 = "";
            for(i = 0; i < midpoint; ++i) {
                char c= message.charAt(i);
                messageHalf1 += Character.toUpperCase(c);
            } 
            messageHalf2 = "";
            for(i2 = midpoint; i2 != length; ++i2) {
                char d= message.charAt(i2);
                messageHalf2 += Character.toLowerCase(d);
            }
        }
        //String Formatting
        String finalMessage = messageHalf1 + messageHalf2; //two halves of message were put back together
        String leftAlignment = String.format("%-" + width + "s", finalMessage); // .format creates a formatted string that will be aligned to the lefy
        String rightAlignment = String.format("%40s", finalMessage); // the format alignes the string right by 40
        //String centeredString = String.format("%" + (padding + length) + "s", finalMessage); //this will be used to centre the day output
        if ( length < 40) {
            System.out.println(rightAlignment);
        } else {
            System.out.println(leftAlignment);
        }
        
    
        
        System.out.println(" ");//Prints spaces between lines
        System.out.printf("Posted at: %02d:%02d:%02d",hrsPssd, minsPssd, secondsPssd);
        /*Printf prints the the time with "Posted at :" as our explanetory text.
        The % sign marks the start of the format string
        The 0 is used for padding
        The 2 specifies the width or minimum number of characters the argument(,hrsPssd, minsPssd, secondsPssd) will take.*/
        
    }
}
        