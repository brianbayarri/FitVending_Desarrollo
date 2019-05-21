#include <Wire.h>
#include <LiquidCrystal_I2C.h>

LiquidCrystal_I2C lcd(0x27, 16, 2);
void setup() {
  Wire.begin();
  lcd.begin(16, 2);
  lcd.clear();
  lcd.backlight();
}

void loop() {
  // put your main code here, to run repeatedly:
  lcd.setCursor(6, 0);
  lcd.print("Elija producto");
  delay(1000);
  lcd.clear();
  lcd.setCursor(4, 1);
  lcd.print("Hay stock");
  delay(1000);
  lcd.clear();
}
