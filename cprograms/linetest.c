#include "graphics.h"

int main(void)
{
  //setGradient(blue,yellow);
  //fillRect(0, 0, 600, 600);
  //drawImage(50,50,900,500,"Meek.jpeg");
  //fillRoundRect(50,50,70,70,20);
  
  startTurtle(100, 100, 30);
  penDown();
  forward(100);
  turnLeft(90);
  forward(100);
  turnLeft(90);
  forward(100);
  turnLeft(90);
  forward(100);
  turnLeft(90);
  penUp();
  forward(200);
  turnRight(30);
  penDown();
  forward(100);
  turnLeft(90);
  forward(100);
  turnLeft(90);
  forward(100);
  turnLeft(90);
  forward(100);
  turnLeft(90);
  return 0;
}