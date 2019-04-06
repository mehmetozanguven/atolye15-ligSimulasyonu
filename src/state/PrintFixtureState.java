package state;

import model.fixtures.Fixture;
import model.fixtures.FixtureImpl;
import model.team.Team;

import java.util.List;

/**
 * Fikstürün yazdırıldığı state
 */
public class PrintFixtureState implements State{

    private List<Team> allTeams;
    private Fixture leagueFixture;

    public PrintFixtureState(List<Team> allTeams) {
        this.allTeams = allTeams;
        leagueFixture = new FixtureImpl();
    }

    @Override
    public void doAction() {
        leagueFixture.printFixture(allTeams);
    }
}
