import vlc
import time
import sys
import os
os.chdir("/home/AbhisekPandey/Project/Notices/")
Notices = [f for f in os.listdir('.') if os.path.isfile(f)]
media_player = vlc.MediaPlayer()
media_player.toggle_fullscreen()
for notice in Notices:
    if ".mp4" in notice or ".MP4" in notice or ".mkv" in notice or ".MKV" in notice:        
        media = vlc.Media(notice)
        media_player.set_media(media)
        media_player.play()
        time.sleep(1)
        duration = media_player.get_length()
        time.sleep(duration/1000)
media_player.stop()
