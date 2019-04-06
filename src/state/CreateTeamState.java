package state;

import model.team.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Takımların yaratıldığı state
 * Her bir takımın ağırlığını random olarak belirledim
 */
public class CreateTeamState implements State {

    List<Team> teamList;

    public CreateTeamState() {
        this.teamList = new ArrayList<>();
    }

    @Override
    public void doAction() {
        createTeams();
    }

    public List getTeamList(){
        return this.teamList;
    }

    private void createTeams() {
        Team gs = new Galatasaray("Galatasaray", (int)(Math.random() * 10 + 1));
        Team fb = new Fenerbahce("Fenerbahçe", (int)(Math.random() * 10 + 1));
        Team bjk = new Besiktas("Beşiktaş", (int)(Math.random() * 10 + 1));
        Team ts = new Trabzonspor("Trabzonspor", (int)(Math.random() * 10 + 1));
        Team basaksehir = new Basaksehir("Başakşehir", (int)(Math.random() * 10 + 1));
        Team bbErzurum = new BBErzurum("BBErzurum", (int)(Math.random() * 10 + 1));

        teamList.add(gs);
        teamList.add(fb);
        teamList.add(bjk);
        teamList.add(ts);
        teamList.add(basaksehir);
        teamList.add(bbErzurum);
    }
}
