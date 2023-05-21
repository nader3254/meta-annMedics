import RPi.GPIO as GPIO 
from time import sleep 

buzz=5 


GPIO.setwarnings(False) 
GPIO.setmode(GPIO.BCM) 
GPIO.setup(buzz, GPIO.OUT) 
 

while True: 
    f = open("buzzer.txt", "r")
    s=str(f.read())
    f.close()
    if (s.rfind("on")>=0):
        print("en is : "+s)
        GPIO.output(buzz, True) 
        sleep(0.1)
        f = open("buzzer.txt", "w")
        f.write("off")
        f.close() 
    GPIO.output(buzz, False) 
    #sleep(0.5) 
