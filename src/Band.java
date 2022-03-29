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

public class Band {
	private String name;
	private int arrivalTime, departureTime;

	public Band(String name, int arrivalTime, int departureTime) {
		this.name = name;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	
	//Getters
	public String getName() {return name;}
	public int getArrivalTime() {return arrivalTime;}
	public int getDepartureTime() {return departureTime;}
}
