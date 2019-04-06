package state;

import model.matchResult.MatchResult;
import model.matchResult.MatchResultImpl;
import model.team.Team;
import java.util.List;

/**
 * Lig simülasyonunun yapıldığı state.
 */
public class SimulateLeagueState implements State {
    private List<Team> teamList;

    private MatchResult matchResult;

    public SimulateLeagueState(List<Team> teamList) {
        this.teamList = teamList;
        this.matchResult = new MatchResultImpl();
    }

    @Override
    public void doAction() {
        leagueSimulation();
    }

    private void leagueSimulation() {
        for (int i = 0; i < teamList.size(); i++){
            int hostTeamIndex = i;
            for (int opponentTeamIndex = 0; opponentTeamIndex < teamList.size(); opponentTeamIndex++){
                if (opponentTeamIndex != hostTeamIndex){
                    Team hostTeam = teamList.get(hostTeamIndex);
                    Team opponentTeam = teamList.get(opponentTeamIndex);
                    int hostTeamWeight = hostTeam.getWeight();
                    int opponentTeamWeight = opponentTeam.getWeight();
                    matchResult.calculateResult(hostTeamWeight, opponentTeamWeight);
                    updateTeams(hostTeam, opponentTeam, matchResult.getCalculateHostTeamGoal(), matchResult.getCalculateOpponentGoal());
                }
            }
        }
    }

    /**
     * İki takımın maç sonucuna göre güncellediğim metod
     * @param hostTeam evsahibi takımı
     * @param opponentTeam deplasman takımı
     * @param hostTeamGoalNum evsahibinin attığı gol sayısı
     * @param opponentTeamGolNum deplasman takımının attığı gol sayısı
     */
    private void updateTeams(Team hostTeam, Team opponentTeam, int hostTeamGoalNum , int opponentTeamGolNum) {
        int avarageForHost = hostTeamGoalNum - opponentTeamGolNum;
        int avarageForOpponent = opponentTeamGolNum - hostTeamGoalNum;

        hostTeam.updateAverageNum(avarageForHost);
        hostTeam.incrementTotalMatchNum();

        opponentTeam.updateAverageNum(avarageForOpponent);
        opponentTeam.incrementTotalMatchNum();

        if (matchResult.isNoWins()){
            hostTeam.incrementTieNum();
            hostTeam.incrementTotalPointBy1();

            opponentTeam.incrementTieNum();
            opponentTeam.incrementTotalPointBy1();
        }else if (matchResult.isHostWinner()){
            hostTeam.incrementWinNum();
            hostTeam.incrementTotalPointBy3();

            opponentTeam.incrementBeatNum();
        }else{
            hostTeam.incrementBeatNum();

            opponentTeam.incrementWinNum();
            opponentTeam.incrementTotalPointBy3();
        }
    }


}
