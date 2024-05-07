package entity.model;

public class Participants {

	int ParticipantID;  
	String ParticipantName; 
	String ParticipantType ;
	int EventID;
	public Participants()
	{
		
	}
	public Participants(int participantID,String participantName,String participantType,int EventID)
	{
		this.ParticipantID=participantID;
		this.ParticipantName=participantName;
		this.ParticipantType=participantType;
		this.EventID=EventID;
	}
	public int getParticipantID() {
		return ParticipantID;
	}
	
	public String getParticipantName() {
		return ParticipantName;
	}
	
	public String getParticipantType() {
		return ParticipantType;
	}
	
	public int getEventID() {
		return EventID;
	}
	
	 public String toString() {
	        return "Participant Id: " +ParticipantID + ", Participant Name: " + ParticipantName + ", participant Type: " +ParticipantType+",EventID:"+EventID;
	 }
}
