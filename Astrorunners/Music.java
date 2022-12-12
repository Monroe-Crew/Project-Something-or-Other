import greenfoot.*;
public class Music  
{
    public static GreenfootSound MenuMusic, joinMusic, jumpMusic, gameMusic, MenuSound, RoundStartSFX, DeathSFX;
    public Music()
    {
        MenuMusic = new GreenfootSound("MenuMusic.mp3");
        joinMusic = new GreenfootSound("GameBegin.mp3");
        jumpMusic = new GreenfootSound("JumpingSFX.mp3");
        MenuMusic = new GreenfootSound("MenuMusic.mp3");
        MenuSound = new GreenfootSound("MenuSound.mp3");
        RoundStartSFX = new GreenfootSound("RoundBegin.mp3");
        gameMusic = new GreenfootSound("GameMusic.mp3");
        DeathSFX = new GreenfootSound("DeathSound.mp3");
    }
    
    public static void stopAllMusic(){
        MenuMusic.stop();
        joinMusic.stop();
        jumpMusic.stop();
        MenuMusic.stop();
        MenuSound.stop();
        MenuSound.stop();
        RoundStartSFX.stop();
        gameMusic.stop();
        DeathSFX.stop();
    }
}
