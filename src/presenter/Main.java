package presenter;

import model.team.Team;
import state.CreateTeamState;
import state.PrintFixtureState;
import state.SimulateLeagueState;
import state.State;

import java.util.List;

/**
 * Written by Mehmet Ozan Güven
 */
public class Main {
    /**
     * Atölye15 Staj Kampı Workshop Lig Simülasyonu
     * Burada Lig simülasyonunu State design pattern'ni takip ederek
     * kodlamaya çalıştım.
     * Projeyi 3 state böldüm:
     *      State 1: Takımların yaratıldığı durum
     *      State 2: Ligin simüle edildiği durum
     *      State 3: Fikstür'ün yazdırıldığı durum
     *
     * Her state kendi görevini doAction() metodunu çağırarak yapmaktadır.
     */
    public static void main(String[] args) {
        State leagueSimulationState;
        List<Team> createdTeams;

        System.out.println("Simülasyon başlıyor...");
        System.out.println("----------------------");
        System.out.println("Takımlar yaratılıyor..");

        leagueSimulationState = new CreateTeamState();
        leagueSimulationState.doAction();
        createdTeams = ((CreateTeamState) leagueSimulationState).getTeamList();

        System.out.println("Takımlar yaratıldı...");
        System.out.println("----------------------");
        System.out.println("Lig simulasyonu başlıyor...");

        leagueSimulationState = new SimulateLeagueState(createdTeams);
        leagueSimulationState.doAction();

        System.out.println("Lig simulasyonu bitti.");
        System.out.println("----------------------");
        System.out.println();
        System.out.println("Fikstür yazdırılıyor...");
        System.out.println();

        leagueSimulationState = new PrintFixtureState(createdTeams);
        leagueSimulationState.doAction();
    }
}
