package logic;

import java.util.ArrayList;

public class Database {
    private ArrayList<Player> playerList;
    private ArrayList<Region> regionList;

    public Database() {
        this.playerList = new ArrayList<>();
        this.regionList = new ArrayList<>();
    }

    public Database(ArrayList<Player> playerList, ArrayList<Region> regionList) {
        Database database = new Database();
        this.playerList = playerList;
        this.regionList = regionList;
    }

    public Player addPlayer(String name, Region region) throws Exception  {
        for (Player player : playerList) {
            if (player.getName().equals(name)) {
                throw new Exception("Player already exists!");
            }
        }
        Player player = new Player(name);
        region.addPlayerToRegion(player);
        this.playerList.add(player);
        return player;
    }

    public boolean addRegion(String name) {
        for(Region r : regionList) {
            if(r.getName().equals(name)) {
                return false;
            }
        }
        Region newRegion = new Region(name);
        regionList.add(newRegion);
        return true;
    }

    public Region getRegionByName(String name){
        for(Region r : regionList) {
            if(r.getName().equals(name)) {
                return r;
            }
        }
        return null;
    }

    public void addQuest(Player author,Region region, String name, String description)  {
        Quest quest = new Quest(author, region, name, description);
        region.addQuestToRegion(quest);
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public ArrayList<Region> getRegionList() {
        return regionList;
    }

    public void setRegionList(ArrayList<Region> regionList) {
        this.regionList = regionList;
    }
}
