package daos;

import repositories.Repository;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.*;

public class DAOObjImpl implements DAOInterface {
    Repository repository;
    @Override
    public Repository load(String filename) {
        try{
            FileInputStream inputStream = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(inputStream);
                repository = (Repository) ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            System.exit(0);
        }

        return repository;
    }

    @Override
    public void store(String filename, Repository repository) {
        try{
            FileOutputStream output = new FileOutputStream(filename);
            ObjectOutputStream OOS = new ObjectOutputStream(output);
            OOS.writeObject(repository);
            OOS.close();
        }catch(IOException e){
            Logger.getLogger(DAOObjImpl.class.getName())
                    .log(Level.SEVERE, null, e);
        }
    }
}
