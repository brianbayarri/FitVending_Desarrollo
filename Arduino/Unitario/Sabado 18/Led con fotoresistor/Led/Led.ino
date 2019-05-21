int LED = 2;
int lightlevel;

void setup() {
  pinMode(LED, OUTPUT);
  digitalWrite(LED,LOW);
}

void loop() {
  //Nivel leido del fotoresistor
  lightlevel = analogRead(A3);
  //25 es el valor que ponemos nosotros
  if(lightlevel < 25 )
  {
    digitalWrite(LED, HIGH);
  }
  else
  {
    digitalWrite(LED, LOW);
  }
}

//VIDEO BASE: https://www.youtube.com/watch?v=RbV4EGW7nCM
/*
 Conecciones:
 -Led pin digital 2
 -Fotoresistor pin analogico 5
 -Resistencia 220 al le y al fotoresistor (ver foto)
 */
