int buzzer = 7;
int period = 1000;
unsigned long lastTick;
void setup() {
  // put your setup code here, to run once:

}

void loop() {
  // put your main code here, to run repeatedly:
  unsigned long currentMillis = millis();
  if(currentMillis - lastTick >= 1000){
    countDown--;
    displayCountdownToSerial(); 
    lastTick += 1000;   
  }  
  if(millis() > time_now + period){
        time_now = millis();
        tone(7, 600);
    }
    else
    {
      
  noTone(7);
    }
}
