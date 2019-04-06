package model.fixtures;

import model.team.Team;

import java.util.Collections;
import java.util.List;

public class FixtureImpl implements Fixture{


    public FixtureImpl() {

    }

    private void sortTheTeamList(List<Team> allTeams) {
        Collections.sort(allTeams, new FixtureComparator());
    }

    public void printFixture(List<Team> allTeams){
        sortTheTeamList(allTeams);

        System.out.println("İsim\t\t OM\t G\t B\t Y\t Avj.\t P");
        System.out.println("-----------------------------------");

        for (Team eachTeam : allTeams){
            System.out.println(eachTeam);
        }
    }

}
