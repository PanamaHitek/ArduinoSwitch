/*
-------------------------
| Arduino Switch v1.0.0 |        Diseñado por Antony García González, del Panama Hitek Creative Team
-------------------------
Una sencilla aplicación para el encendido de un LED con Arduino y Java. El LED se conecta al pin 13 del Arduino
y desde una interface con dos botones en Java se cambia el estado del LED.

https://github.com/PanamaHitek/ArduinoSwitch
Un video con este ejemplo funcionando está disponible en la siguiente dirección:
https://www.youtube.com/watch?v=9youHjA_fWA
*/

int input;

void setup() {
  pinMode(13, OUTPUT); // Declaramos que utilizaremos el pin 13 como salida
  Serial.begin(9600); //Se inicia la comunicación serie
}

void loop() {
  if (Serial.available() > 0) {

    input = Serial.read();

    if (input == '1') {

      digitalWrite(13, HIGH); //Si el valor de input es 1, se enciende el LED

    }
    else
    {

      digitalWrite(13, LOW); //Si el valor de input es diferente de 1, se apaga el LED

    }

  }
}
