import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    // Overloaded rule 1: Established player (matchesPlayed >= 10)
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Overloaded rule 2: Combined matches and fitness check for newer players
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    // Natural ordering by fantasy points (batting average) in descending order
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}

public class FantasyLeagueAutoDraft {

    public static String draftAndRank(Player[] players) {
        List<Player> draftableList = new ArrayList<>();

        for (Player p : players) {
            // Check established rule OR newer player fitness rule
            if (Player.isDraftable(p.getName() != null ? getMatches(p) : 0) || 
                Player.isDraftable(getMatches(p), isInjured(p))) {
                draftableList.add(p);
            }
        }

        Player[] draftableArray = draftableList.toArray(new Player[0]);
        Arrays.sort(draftableArray);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            result.append(i + 1).append(". ").append(draftableArray[i].getName());
            if (i < draftableArray.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    // Helper getters for draft check
    private static int getMatches(Player p) {
        // Access field via reflect-like helper or direct logic inside Player instance
        return p.compareTo(p) == 0 ? extractMatches(p) : 0;
    }

    private static int extractMatches(Player p) {
        // Helper implementation mapping to matchesPlayed field access
        try {
            java.lang.reflect.Field f = Player.class.getDeclaredField("matchesPlayed");
            f.setAccessible(true);
            return f.getInt(p);
        } catch (Exception e) {
            return 0;
        }
    }

    private static boolean isInjured(Player p) {
        try {
            java.lang.reflect.Field f = Player.class.getDeclaredField("injured");
            f.setAccessible(true);
            return f.getBoolean(p);
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players)); 
        // Output: 1. Rahul | 2. Virat | 3. Dev
    }
}