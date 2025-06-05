#include <iostream>
#include <string.h>
using namespace std;

#define interface struct

interface MediaPlayer 
{
  virtual void play(char * audioType, char * fileName) = 0;
};

interface AdvancedMediaPlayer 
{	
  virtual void playVlc(char * fileName) = 0;
  virtual void playMp4(char * fileName) = 0;
  virtual void playAvi(char * fileName) = 0;

};

class AviPlayer :public AdvancedMediaPlayer{
  public:
  void playVlc(char * fileName)
  {

  }

  void playMp4(char * fileName){}

  void playAvi(char * fileName){
    cout << "Playing avi file. Name: " << fileName << endl;
  }
};

class VlcPlayer : public AdvancedMediaPlayer 
{
  public:
    void playVlc(char * fileName) 
    {
      cout << "Playing vlc file. Name: " << fileName << endl;
    }
    void playMp4(char * fileName) 
    {
      //do nothing
    }

    void playAvi(char * fileName)
    {

    }
};

class Mp4Player : public AdvancedMediaPlayer
{
   public:
    void playVlc(char * fileName) 
    {
      //do nothing
    }
    void playMp4(char * fileName) 
    {
      cout << "Playing mp4 file. Name: " << fileName << endl;	
    }
    void playAvi(char * fileName)
    {
      
    }
};

class MediaAdapter : public MediaPlayer 
{
  private:
    AdvancedMediaPlayer *advancedMusicPlayer;
  public:
    MediaAdapter(char * audioType)
    {
      if(strcmp(audioType, "vlc") == 0)
      {
        advancedMusicPlayer = new VlcPlayer();		         
      } 
      else if(strcmp(audioType, "mp4") == 0)
      {
        advancedMusicPlayer = new Mp4Player();
      }	
      else if(strcmp(audioType,"avi") == 0)
      {
        advancedMusicPlayer = new AviPlayer();
      }
    }

    void play(char * audioType, char * fileName)
    {
      if(strcmp(audioType, "vlc") == 0)
      {
        advancedMusicPlayer->playVlc(fileName);
      }
      else if(strcmp(audioType, "mp4") == 0)
      {
         advancedMusicPlayer->playMp4(fileName);
      }

      else if(strcmp(audioType, "avi") == 0)
      {
         advancedMusicPlayer->playAvi(fileName);
      }

    }
};

class AudioPlayer : public MediaPlayer 
{
   MediaAdapter *mediaAdapter; 
   public:     
    void play(char * audioType, char * fileName) 
    {		
      //inbuilt support to play mp3 music files
      if(strcmp(audioType, "mp3") == 0)
      {
         cout << "Playing mp3 file. Name: "  << fileName << endl;			
      }       
      //mediaAdapter is providing support to play other file formats
      else if(strcmp(audioType, "vlc") == 0 || strcmp(audioType, "mp4") == 0 || strcmp(audioType, "avi") == 0 )
      {
         mediaAdapter = new MediaAdapter(audioType);
         mediaAdapter->play(audioType, fileName);
      }      
      else{
         cout << "Invalid media. " << audioType << " format not supported" << endl;
    }
  }   
};

int  main() {
  MediaPlayer *audioPlayer = new AudioPlayer();

  audioPlayer->play("mp3", "beyond the horizon.mp3");
  audioPlayer->play("mp4", "homealone.mp4");
  audioPlayer->play("vlc", "far far away.vlc");
  audioPlayer->play("avi", "test.avi");
  return 0;
}