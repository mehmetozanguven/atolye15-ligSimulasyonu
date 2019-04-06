package model.team;

/**
 * Takımların ortak özelliklerinin bulunduğu Team abstact sınıfı.
 */
public abstract class Team {
    private String name;
    private int winNums;
    private int tieNums;
    private int beatNums;
    private int averageNum;
    private int totalMatchNum;
    private int weight;
    private int totalPoint;

    public Team(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public String toString(){
        String returnStr = name + "\t " + totalMatchNum + "\t " + winNums + "\t " +
                tieNums + "\t " + beatNums + "\t " + averageNum + "\t\t " + totalPoint;

        return returnStr;
    }

    public String getName() {
        return name;
    }

    public int getWinNums() {
        return winNums;
    }

    public int getTieNums() {
        return tieNums;
    }

    public int getBeatNums() {
        return beatNums;
    }

    public int getAverageNum() {
        return averageNum;
    }

    public int getTotalMatchNum() {
        return totalMatchNum;
    }

    public int getTotalPoint(){
        return totalPoint;
    }

    public int getWeight() {
        return weight;
    }

    public void incrementWinNum() {

        this.winNums++;
    }

    public void incrementTieNum() {
        this.tieNums++;
    }

    public void incrementBeatNum() {
        this.beatNums++;
    }

    public void updateAverageNum(int averageNum) {
        this.averageNum += averageNum;
    }

    public void incrementTotalMatchNum(){
        this.totalMatchNum ++;
    }

    public void incrementTotalPointBy1(){
        this.totalPoint ++;
    }

    public void incrementTotalPointBy3(){
        this.totalPoint = totalPoint + 3;
    }
}
