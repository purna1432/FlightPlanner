package vd;

public class FlightDetails {
	private String from;
	private String to;
	private String distance;
	private String travelTime;
	private String fare;

	public FlightDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightDetails(String from, String to, String distance, String travelTime, String fare) {
		super();
		this.from = from;
		this.to = to;
		this.distance = distance;
		this.travelTime = travelTime;
		this.fare = fare;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "FlightDetails [from=" + from + ", to=" + to + ", distance=" + distance + ", travelTime=" + travelTime
				+ ", fare=" + fare + "]";
	}

}
