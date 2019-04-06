package model.matchResult;

import java.util.Map;

public interface MatchResult {

    void calculateResult(int hostTeamWeight, int opponentTeamWeight);

    boolean isHostWinner();

    boolean isNoWins();

    int getCalculateHostTeamGoal();

    int getCalculateOpponentGoal();
}
