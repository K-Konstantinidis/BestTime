import java.util.ArrayList;

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

public interface Message {
	
	public static void message(int Max_Time, int hour, ArrayList<Band> bands) {
		if(Max_Time>1) {
	    	System.out.println("There will be: " + Max_Time + " bands \n");
			System.out.println("The names of the bands that will be there at this hour are:\n");
	    }
		else {
			System.out.println("There will be: " + Max_Time + " band \n");
			System.out.println("The name of the band that will be there at this hour is:\n");
		}
		for(Band b : bands)
			if(b.getArrivalTime()<=hour && b.getDepartureTime()>=(hour+1))
				System.out.println(b.getName() + "\n");
	}

}
