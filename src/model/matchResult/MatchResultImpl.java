package model.matchResult;

import java.util.HashMap;
import java.util.Map;

public class MatchResultImpl implements MatchResult {

    private int opponentTeamWeightNum;
    private int hostTeamWeightNum;
    private int calculateHostTeamGoal;
    private int calculateOpponentGoal;
    private boolean isHostWinner, isNoWins;

    public MatchResultImpl() {
        isHostWinner = true;
        isNoWins = false;
    }

    public void calculateResult(int hostTeamWeight, int opponentTeamWeight){
        this.opponentTeamWeightNum = opponentTeamWeight;
        this.hostTeamWeightNum = hostTeamWeight;
        this.calculateHostTeamGoal = 0;
        this.calculateOpponentGoal = 0;


        calculateGoalApproach();

        if (calculateHostTeamGoal > calculateOpponentGoal)
            isHostWinner = true;
        else if (calculateHostTeamGoal == calculateOpponentGoal){
            isHostWinner = false;
            isNoWins = true;
        }else{
            isHostWinner = false;
            isNoWins = false;
        }
    }

    public boolean isHostWinner(){
        return isHostWinner;
    }

    public boolean isNoWins(){
        return isNoWins;
    }

    public int getCalculateHostTeamGoal(){
        return calculateHostTeamGoal;
    }

    public int getCalculateOpponentGoal(){
        return calculateOpponentGoal;
    }

    /**
     * Takım ağırlığına göre kimin kazanacağını belirlediğim metod
     */
    private void calculateGoalApproach() {
        int totalGoalNumber = (int)(Math.random() * 7 + 1);
        int arraylenght = hostTeamWeightNum + opponentTeamWeightNum + 1;
        int[] randomArr = new int[arraylenght];
        int i = 1;
        randomArr[0] = hostTeamWeightNum;
        while (i < hostTeamWeightNum){
            randomArr[i] = hostTeamWeightNum;
            i++;
        }
        int j = 0;
        while (j < opponentTeamWeightNum){
            randomArr[i] = opponentTeamWeightNum;
            i++;
            j++;
        }

        i = 0;
        while(i < totalGoalNumber){
            int randomNumToCalculateScor = (int)(Math.random() *  arraylenght);
            if (randomArr[randomNumToCalculateScor] == hostTeamWeightNum){
                calculateHostTeamGoal++;
            }else{
                calculateOpponentGoal++;
            }
            i++;
        }
    }

}
