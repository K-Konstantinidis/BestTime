import java.util.ArrayList;
import java.util.Scanner;

/*************************************************************************
Copyright © [2022] [Konstantinidis Konstantinos]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at 

      http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software 
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and 
limitations under the License.
*************************************************************************/

public class BestTime implements Message{
	private int n, i, Max_Time, count, maxtime;
	private ArrayList<Band> bands = new ArrayList<Band>();
	private Band band;
	private int[] time = new int[24];
	private boolean flag = true;
	
	public BestTime() {
		Scanner sc = new Scanner(System.in); //A scanner to read from input
		
		System.out.println("Insert the amount of bands that will attend the festival: ");
		n = sc.nextInt();
		
	    while(n<=0){
	    	System.out.println("Amount can't be 0 or less than 0.\nGive the amount of bands that will attend the festival: ");
	    	n = sc.nextInt();
	    }
	    
	    for(i=0; i<n; i++) {
	    	flag = getdata(sc); //Get band data
	    	while(!flag)
	    		flag = getdata(sc); //If there was an error try again
	    }
	    
	    sc.close(); //Close scanner
	    
	    for(i=0; i<24; i++)
	    	time[i] = 0; //Create an array to keep the amount of bands in each time
	    
	    /*Lets say a band comes at 14:00 and leaves at 16:00 so they will be there for 2 hours
	    Lets also say that j is 14 (14:00/24:00). Then: 14<(14+1) && 16>14 so Time[14]++
	    then: 14<(15+1) && 16>15 so Time[15]++, then 14<(16+1) but 16==16 so we stop there.
	    That means that the Array with the amount of bands in each hour got another band at the 14:00 and the 15:00 times*/
	    for(i=0; i<24; i++)
	    	for(Band b : bands)
	    		if(b.getArrivalTime()<(i+1) && b.getDepartureTime()>i)
	    			time[i]++;
	    
	    Max_Time = time[0]; //Find the max hour(the hour with the most bands)
	    for(i=1; i<24; i++)
	        if(Max_Time < time[i])
	            Max_Time = time[i];
	    		
	    count = 0;
	    for(i=0; i<24; i++)
	    	if(Max_Time == time[i])
	    		count++; //If there are more than one hours with the highest amount of bands
	    
	    if(count==1)
	    	for(i=0; i<24; i++)
		    	if(Max_Time == time[i])
		    		maxtime = i; //If there is only one hour with the max amount of numbers get that hour

	    if(count==1) {
		    System.out.println("\nThe best time to arrive is: " + maxtime + ":00 - " + (maxtime+1) + ":00 \n");
		    Message.message(Max_Time, maxtime, bands);
	    }
	    else {
	    	System.out.println("\nThe best times to arrive are: \n");
	    	for(i=0; i<24; i++){
		    	if(Max_Time == time[i]){
		    		System.out.println("-------------------------------------------------");
		    		System.out.println(i + ":00 - " + (i+1) + ":00 \n");
		    		Message.message(Max_Time, i, bands);
		    	}
	    	}
	    	System.out.println("-------------------------------------------------");
	    }
	}
	
	//A function to get the data of each band and then create a band
	private boolean getdata(Scanner sc) {
		int arr, dep;
		String name;
		boolean flag;
		
		System.out.println("Give the name of the band: ");
		name = sc.next();
        
        System.out.println("Give arrival time: ");
        arr = sc.nextInt();
        
        System.out.println("Give departure time: ");
        dep = sc.nextInt();
        
        flag = check(arr, dep);
        if(flag) {
        	band = new Band(name, arr, dep); //Create a band
        	bands.add(band);
        	return flag;
        }
        else
        	return flag;
	}
	
	//A function to check if the given hours are acceptable
	private boolean check(int arr, int dep) {
		if(arr<0 || arr>24 || dep<0 || dep>24 || dep<=arr) {
			System.out.println("There was an error with the given times.\nPlease try again.\n");
        	return false;
		}
		else 
			return true;
	}
}
