#include <DHT.h>
#include <Wire.h>
#include <LiquidCrystal_I2C.h>

int SENSOR = 2;
LiquidCrystal_I2C lcd(0x27, 16, 2);
DHT dht(SENSOR, DHT11);

void setup() {
  Serial.begin(9600);
  dht.begin();
  Wire.begin();
  lcd.begin(16, 2);
  lcd.clear();
  lcd.backlight();
}

void loop() {
  lcd.setCursor(1,0);
  lcd.print("Elija producto");
  int temp = dht.readTemperature();
  lcd.setCursor(5,1);
  lcd.print(temp);
  lcd.print((char)223);
  lcd.print("C");
  delay(1000);
}
