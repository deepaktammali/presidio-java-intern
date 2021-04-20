package test;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import pojo.Person;
import pojo.Ranking;
import pojo.Skill;
import utils.HibernateUtil;

public class RankingTest {
	
	public static Person findPerson(Session session,String name) {
		Query<Person> query = session.createQuery("from Person p where p.name=:name");
		query.setParameter("name", name);
		Person person = query.uniqueResult();
		return person;
	}
	
	public static Skill findSkill(Session session,String name) {
		Query<Skill> query = session.createQuery("from Skill s where s.name=:name");
		query.setParameter("name", name);
		Skill skill = query.uniqueResult();
		return skill;
	}
	
	public static Person savePerson(Session session,String name) {
		Person person = findPerson(session, name);
		if(person==null) {
			person = new Person(name);
			session.save(person);
		}
		return person;
	}
	
	public static Skill saveSkill(Session session,String name) {
		Skill skill = findSkill(session, name);
		if(skill==null) {
			skill = new Skill(name);
			session.save(skill);
		}
		return skill;
	}
	
	public static double getRanking(Session session,String subject,String skill) {
		Query<Ranking> query = session.createQuery("from Ranking r "
				+ "where r.subject.name=:subject"
				+ "and r.skill.name=:skill");
		query.setParameter("subject", subject);
		query.setParameter("skill", skill);
		
		List<Ranking> rankList = query.list();
		double averageRank = 0;
		for(Ranking rank:rankList) {
			averageRank+=rank.getRank();
		}
		return ((double)averageRank/rankList.size());
	}
	
	public static Ranking changeRanking(Session session,String subjectName,String observerName,String skillName,int rank) throws Exception {
		
		Query<Ranking> query = session.createQuery("from Ranking r where"
				+ "r.subject.name=:subjectname "
				+ "r.observer.name=:observername "
				+ "r.skill.name=:skill");
		query.setParameter("subjectname", subjectName);
		query.setParameter("observername", observerName);
		query.setParameter("skill", skillName);
		
		Ranking ranking = query.uniqueResult();
		
		if(ranking==null) {
			return null;
		}
		ranking.setRank(rank);
		return ranking;
	}
	
	
	public static Ranking saveRanking(Session session,String subjectName,String observerName,String skillName,int rank) {
			Person subject = savePerson(session, subjectName);
			Person observer = savePerson(session,observerName);
			Skill skill = saveSkill(session, skillName);
			Ranking ranking = new Ranking();
			ranking.setSubject(subject);
			ranking.setObserver(observer);
			ranking.setSkill(skill);
			ranking.setRank(rank);
			session.save(ranking);
			return ranking;
	}
	
	
	public static Ranking deleteRanking(Session session,String subjectName,String observerName,String skillName,int rank) throws Exception {
		Ranking ranking = changeRanking(session, subjectName, observerName, skillName, rank);
		assert(ranking!=null);
		session.delete(ranking);
		return null;
	}
	
	
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.getSession();
			saveRanking(session, "Nagato", "Kirito", "Ametaratsu", 8);
			saveRanking(session, "Nagato", "Slime", "Ametaratsu", 9);
			saveRanking(session, "Nagato", "Konan", "Ametaratsu", 10);
			System.out.println(getRanking(session, "Nagato", "Ametaratsu"));
			HibernateUtil.closeSession(null);
		}
		catch (Exception e) {
			HibernateUtil.closeSession(e);
		}
	}
}
