package pojo;

import javax.persistence.*;

@Entity
public class Ranking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	Skill skill;
	@Column(nullable=false)
	Person subject;
	@Column(nullable=false)
	Person observer;
	@Column(nullable=false)
	private int rank;
	
	public Ranking() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Person getSubject() {
		return subject;
	}

	public void setSubject(Person subject) {
		this.subject = subject;
	}

	public Person getObserver() {
		return observer;
	}

	public void setObserver(Person observer) {
		this.observer = observer;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
