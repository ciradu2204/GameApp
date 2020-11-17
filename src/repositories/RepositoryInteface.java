package repositories;

import Model.Player;

import java.util.List;

public interface RepositoryInteface {

    void add(Player item);
    Player getItem(int id);
    List<Player> getItems();
    void remove(int id);
    void setItems(List<Player> items);
    void store(String filename);
    String toString();
    String toString(char delimeter);

}
