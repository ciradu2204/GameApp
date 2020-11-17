package daos;

import Model.Player;
import Model.SocialMediaPlayer;
import repositories.Repository;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.*;

public class DAOTextImpl implements DAOInterface{
    static final char DELIMITER=',';
    @Override
    public Repository load(String filename) {
        Repository repository = new Repository();

        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String[] temp;
            String line = br.readLine();
            while(line != null){
                temp = line.split(Character.toString(DELIMITER));
                int id  = Integer.parseInt(temp[0]);
                String playerName = stripQuotes(temp[1]);
                int currentLevel = Integer.parseInt(temp[2]);
                int pointsEarned = Integer.parseInt(temp[3]);
                Player player;
                if(temp.length > 4){
                    String socialMediaApp = stripQuotes(temp[4]);
                    String socialMediaIdentifier = stripQuotes(temp[5]);
                     player = new SocialMediaPlayer(id, playerName, currentLevel, pointsEarned, socialMediaApp, socialMediaIdentifier);
                }else{
                     player = new Player(id, playerName, currentLevel,pointsEarned);
                }
                repository.add(player);
                line = br.readLine();


            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return repository;
    }

    @Override
    public void store(String filename, Repository repository) {

        try(PrintWriter output = new PrintWriter(filename)){
                 output.print(repository.toString(DELIMITER));
                 output.close();
        }catch (FileNotFoundException e){
            Logger.getLogger(DAOTextImpl.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    private String stripQuotes(String str) {
        return str.substring(1, str.length()-1);
    }
}
