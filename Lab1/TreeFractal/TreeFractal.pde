float angle, minLength, scale;

void setup() {
  size(800,500);
  background(0);
  //noLoop();
  
  angle = 1.5;
  scale = 0.62;
  minLength = 10;
}

void draw() {
  background(0);
  
  drawLine(width/2, height, width/2, 0.75*height);
  
  angle = map(mouseX, 0, width, 0, 1.2);
  scale = map(mouseY, 0, height, 0.8, 0.4);
  
}

void drawLine(float x1, float y1, float x2, float y2) {
  stroke(255);
  line(x1,y1,x2,y2);
  
  PVector vec = new PVector(x2-x1, y2-y1);
  vec.setMag(scale * vec.mag());
  
  if (vec.mag() > minLength) {
  vec.rotate(-angle);
  drawLine(x2, y2, x2 + vec.x, y2 + vec.y);
  
  vec.rotate(angle);
  drawLine(x2, y2, x2 + vec.x, y2 + vec.y);
  
  vec.rotate(angle);
  drawLine(x2, y2, x2 + vec.x, y2 + vec.y);
  }
}