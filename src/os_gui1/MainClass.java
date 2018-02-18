package os_gui1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MainClass 
{
    FileInputStream FIS;
    BufferedInputStream BIS;
    
    public Player player;
    public long pauseLocation;      // to get the available part of the song
    public long songTotalLength;
    public String fileLocation;
    
    public void Stop()
    {
        if( player != null )
        {
            player.close();
            pauseLocation = 0;      // before that if we use play and stop then resume it will actually resume which is not
            songTotalLength = 0;    // quite right so, we put this variables to zero in order to run the song again
                                    // not just resuming it.
            MP3PlayerGUI.Display.setText("");
        }
    }
    
    public void Pause()
    {
        if( player != null )
        {
            try 
            {
                pauseLocation = FIS.available();    // checks how much of the song available to play
                player.close();
            } catch (IOException ex) 
            {
               
            }
        }
    }
    
    public void Resume()
    {
        try 
        {
            FIS = new FileInputStream(fileLocation);
            BIS = new BufferedInputStream(FIS);
            
            player = new Player(BIS);
            FIS.skip(songTotalLength - pauseLocation);
        }
        catch (FileNotFoundException | JavaLayerException ex) 
        {
            
        } 
        catch (IOException ex) 
        {
            
        }
        new Thread()    // to make the music play in background as a seperate thread in order to run other things easily
        {
            @Override
            public void run()
            {
                try 
                {
                    player.play();
                }
                catch (JavaLayerException ex)
                {
                    
                }
            }
        }.start();
    }
    
    public void Play(String path)
    {
        try 
        {
            FIS = new FileInputStream(path);
            BIS = new BufferedInputStream(FIS);
            
            player = new Player(BIS);
            
            songTotalLength = FIS.available();
            fileLocation = path + "";
        }
        catch (FileNotFoundException | JavaLayerException ex) 
        {
            
        } catch (IOException ex)
        {
            
        }
        new Thread()    // to make the music play in background as a seperate thread in order to run other things easily
        {
            @Override
            public void run()
            {
                try 
                {
                    player.play();
                    
                    if(player.isComplete() && MP3PlayerGUI.count == 1)
                    {
                        Play("fileLocation");
                    }
                    if(player.isComplete())
                    {
                        MP3PlayerGUI.Display.setText("");
                    }
                }
                catch (JavaLayerException ex)
                {
                    
                }
            }
        }.start();
    }
}
