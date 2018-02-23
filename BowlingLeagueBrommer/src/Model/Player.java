package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="player")

public class Player{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="ID")
	private int playerId;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="phoneNumber")
	private String phoneNumber;
	@Column(name="screenName")
	private String screenName;
	
	@ManyToOne
	@JoinColumn(name="teamId")
	private Team teamId;
	

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Player(String firstName, String lastName, String phoneNumber, String screenName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.screenName = screenName;
	}
	
	
	
	
	
	

}
