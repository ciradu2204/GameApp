package Model;

import com.sun.org.apache.xpath.internal.operations.Quo;

import java.io.Serializable;

public class SocialMediaPlayer extends Player  {

    protected String socialMediaApp;
    protected String socialMediaIdentifier;

    public SocialMediaPlayer(){
        super();
        this.socialMediaApp = "Unknown";
        this.socialMediaApp = "Unknown";
    }

    public SocialMediaPlayer(String playerName, String socialMediaApp, String socialMediaIdentifier){
        super(playerName);
        this.socialMediaApp = socialMediaApp;
        this.socialMediaIdentifier = socialMediaIdentifier;

    }

    public SocialMediaPlayer(int id, String playerName, int currentLevel, int pointsEarned, String socialMediaApp, String socialMediaIdentifier){
        super(id,playerName, currentLevel, pointsEarned);
        this.socialMediaApp = socialMediaApp;
        this.socialMediaIdentifier = socialMediaIdentifier;

    }

    public String getSocialMediaApp() {
        return socialMediaApp;
    }

    public void setSocialMediaApp(String socialMediaApp) {
        this.socialMediaApp = socialMediaApp;
    }

    public String getSocialMediaIdentifier() {
        return socialMediaIdentifier;
    }

    public void setSocialMediaIdentifier(String socialMediaIdentifier) {
        this.socialMediaIdentifier = socialMediaIdentifier;
    }

    @Override
    public String toString() {
        return "\nPlayer Id: " + this.id + " _Player Name: " + this.playerName + " _Current Level:" + this.currentLevel + " _Points:" + this.pointsEarned
                + " _social Media App:" + this.socialMediaApp + " _social Media Identifier:" + this.socialMediaIdentifier;
    }

    @Override
    public String toString(char delimeter) {
        return Integer.toString(this.id )+ delimeter + Quote + this.playerName + Quote + delimeter + Integer.toString(this.currentLevel) + delimeter + Integer.toString(this.pointsEarned)  + delimeter +
                Quote + this.socialMediaApp + Quote + delimeter + Quote + this.socialMediaIdentifier + Quote + EQLN;
    }
}
