/* 
 * Sketch to model heat
 * diffusion in a rod
 *
 */

// time step
float h;

// declare rod object
Rod rod;

void setup() {
  size(720, 256);
  background(0);
  
  // use HSB so one parameter can control color
  colorMode(HSB, width);
 
  // initialize rod object
  rod = new Rod();
  
  // intialize time step
  h = 0.5;
}

void draw() {
  // refresh the screen and set the origin to
  // the middle of the left edge of the display window
  background(0);
  translate(0, height/2);
  
  // update the rod (numerically evaluate heat equation)
  rod.update();
  
  // clicking the mouse will simulate
  // applying heat to a portion of the rod
  if (mousePressed) {
    // require the mouse to be over the rod
    if (abs(height/2 - mouseY) < 16) {
      for (int i = -5; i < 5; i++) {
        rod.temperature[mouseX + i] -= 10 - 2*abs(i);
      }
    }
  }
  
  // display the rod
  rod.display();

}