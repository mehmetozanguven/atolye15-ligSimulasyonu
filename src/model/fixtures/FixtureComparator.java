package model.fixtures;

import model.team.Team;

import java.util.Comparator;

/**
 * Takımları puanlarına göre veya puanların eşit olduğu
 * durumlarda isimlerine göre sıralamama yardımcı olan FixtureComparator sınıfı
 */
public class FixtureComparator implements Comparator<Team> {

    @Override
    public int compare(Team team, Team anotherTeam) {
        if (team.getTotalPoint() > anotherTeam.getTotalPoint()){
            return -1;
        }else if (team.getTotalPoint() < anotherTeam.getTotalPoint()){
            return 1;
        }else{
            return team.getName().compareTo(anotherTeam.getName());
        }
    }
}
