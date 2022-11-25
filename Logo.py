import os
import sys
import time
import tkinter as tk
from PIL import Image,ImageTk
os.chdir(".") 
root = tk.Tk()
w, h = root.winfo_screenwidth(), root.winfo_screenheight()
root.overrideredirect(1)
root.geometry("%dx%d+0+0" % (w, h))
root.focus_set()
canvas = tk.Canvas(root,width=w,height=h)
canvas.pack()
canvas.configure(background='black')


def showPIL(pilImage):
    imgWidth, imgHeight = pilImage.size    
    # resize photo to full screen
    ratio = min(w/imgWidth, h/imgHeight)             
    imgWidth = int(imgWidth*ratio)
    imgHeight = int(imgHeight*ratio)                     
    pilImage = pilImage.resize((imgWidth,imgHeight), Image.ANTIALIAS)                         
    image = ImageTk.PhotoImage(pilImage)                             
    imagesprite = canvas.create_image(w/2,h/2,image=image)
    root.update_idletasks()
    root.update()
    
    

photo = Image.open("AR.png")
showPIL(photo)
time.sleep(10)
root.destroy()
