package repositories;

import Model.Player;
import daos.DAOObjImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Repository implements RepositoryInteface, Serializable{

    private List<Player> items;

    public Repository(){
        this.items  = new ArrayList<>();
    }

    public Repository(List<Player> items){
        this.items = items;
    }

    public Repository(String filename){
        this();
        //DAOTextImpl daoText = new DAOTextImpl();
        //this.items = daoText.load(filename).getItems();

        DAOObjImpl daoObj = new DAOObjImpl();
        this.items = daoObj.load(filename).getItems();
    }

    @Override
    public void add(Player item) {
        this.items.add(item);
    }

    @Override
    public Player getItem(int id) {
        for(Player item: this.items){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Player> getItems() {
        return this.items;
    }

    @Override
    public void remove(int id) {
        Predicate<Player> playerPredicate = player -> player.getId() == id;
        this.items.removeIf(playerPredicate);


    }

    @Override
    public void setItems(List<Player> items) {
        this.items = items;

    }


    @Override
    public String toString() {
        return "\nItems:" + this.items;
    }

    @Override
    public String toString(char delimeter) {
        String output = "";
        for(Player item: this.items){
            output += item.toString(delimeter);
        }
        return output;
    }

    @Override
    public void store(String filename) {
        DAOObjImpl daoObj = new DAOObjImpl();
        daoObj.store(filename, this);

        //DAOTextImpl daoText = new DAOTextImpl();
       // daoText.store(filename, this);

    }
}
