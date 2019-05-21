int LED_MINY = 9;
int LED_MAXY = 8;
int LED_MAXX = 10;
int LED_MINX = 11;
int EJE_X = A1;
int EJE_Y = A0;
int valorX = 0;
int valorY = 0;
int i;

void setup() {
  for(i=8; i<=12; i++){
    pinMode(i, OUTPUT);
    digitalWrite(i, LOW);
  }
  Serial.begin(9600);
}

void loop() {
  valorX = analogRead(EJE_X);
  valorY = analogRead(EJE_Y);
  Serial.print("X: ");
  Serial.print(valorX);
  Serial.print("Y: ");
  Serial.print(valorY);
  if(valorX == 0){
    digitalWrite(LED_MINX, HIGH);
  }else if(valorX == 1023){
    digitalWrite(LED_MAXX, HIGH);
  }else{
    digitalWrite(LED_MINX, LOW);
    digitalWrite(LED_MAXX, LOW);
  }
  if(valorY == 0){
    digitalWrite(LED_MINY, HIGH);
  }else if(valorY == 1023){
    digitalWrite(LED_MAXY, HIGH);
  }else{
    digitalWrite(LED_MINY, LOW);
    digitalWrite(LED_MAXY, LOW);
  }
  delay(500);
}
