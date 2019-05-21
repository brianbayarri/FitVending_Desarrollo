int SENSOR;
float TEMPERATURA;

void setup() {
  Serial.begin(9600);
}

void loop() {
  SENSOR = analogRead(A0);
  TEMPERATURA = ((SENSOR * 5000.0) / 1023) / 10;
  Serial.println(TEMPERATURA,1);
  delay(1000);
}
