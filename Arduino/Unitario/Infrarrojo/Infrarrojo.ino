void setup() {
 Serial.begin(9600);
 pinMode(13, INPUT);// set pin as input

}

void loop() {
  //Written for Robojax on Dec 28, 2017
  int detect = digitalRead(13);// read obstacle status and store it into "detect"
  if(detect == LOW){
    
   Serial.println("Obastacle on the way"); 
  }else{
    
   Serial.println("All clear");  
  }
  delay(300);
}
