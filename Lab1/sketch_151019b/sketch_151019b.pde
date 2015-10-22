Walker w;

void setup() {
  size(256,256);
  background(255);
  PVector center = new PVector(width,height).mult(0.5);
  w = new Walker(center);
}

void draw() {
  //background(255);
  w.update();
  w.display();
}

  