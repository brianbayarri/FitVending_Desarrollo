#include <DHT.h>

int SENSOR = 2;

DHT dht(SENSOR, DHT11);

void setup() {
  Serial.begin(9600);
  dht.begin();
}

void loop() {
  float temp = dht.readTemperature();
  Serial.println(temp);
  delay(1000);
}
