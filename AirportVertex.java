package assignment13;

import java.util.LinkedList;

public class AirportVertex implements Comparable<AirportVertex>{
	
	private boolean visited = false;
	private String origin = "";
	private LinkedList<FlightEdge> flights = new LinkedList<>();
	private AirportVertex previous = null;
	private double cost;
	
	public AirportVertex(String airport){
		origin = airport;
		cost = Double.MAX_VALUE;
	}
	
	public void addFlight(FlightEdge flight) {
		if(!flights.contains(flight)) {
			flights.add(flight);
		}
	}
	
	public boolean containsFlight(FlightEdge flight) {
		return flights.contains(flight);
	}
	
	public FlightEdge getFlight(FlightEdge flight) {
		int flightIndex = flights.indexOf(flight);
		
		if (flightIndex >= 0) {
			return flights.get(flights.indexOf(flight));
		}
		
		return null;
	}
	
	public LinkedList<FlightEdge> getAllFlights() {
		return flights;
	}
	
	public LinkedList<FlightEdge> getAllFlightsCarrierSpecific(String carrier){
		
		LinkedList<FlightEdge> carrierFlights = new LinkedList<>();
		
		for(FlightEdge element : flights) {
			if(element.isCarrierOffered(carrier)){
				carrierFlights.add(element);
			}
		}
		return carrierFlights;
	}
	
	public boolean isVisited(){
		return visited;
	}
	
	public void setAsVisited(){
		visited = true;
	}
	
	public void setAsUnvisited() {
		visited = false;
	}
	
	public String getAirportName(){
		return origin;
	}
	
	@Override
	public boolean equals(Object _other) {
		if(!(_other instanceof AirportVertex)){
			return false;
		}
		AirportVertex other = (AirportVertex) _other;
		return this.origin.equals(other.origin);
	}
	
	public void setPrevious(AirportVertex _previous){
		previous = _previous;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double _cost) {
		cost = _cost;
	}

	public AirportVertex getPrevious() {
		return previous;
	}

	@Override
	public int compareTo(AirportVertex o) {
		
		if(this.cost - o.getCost()<0){
			return -1;
		}
		else if(this.cost - o.getCost()>0){
			return 1;
		}
		
		return 0;
	}
	

}
