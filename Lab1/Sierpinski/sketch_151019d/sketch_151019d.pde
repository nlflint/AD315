void setup() {
  size(500,500);
  stroke(255,0,0);
  
}

void draw() {
  background(0);
  PVector top = new PVector(width/2, 0);
  PVector left = new PVector(0, height);
  PVector right = new PVector(width, height);
  
  int startingDepth = (int) map(mouseY, 0, height, 0, 8.0);
  
  drawTriangle(top, left, right, startingDepth);
}

void drawTriangle(PVector top, PVector left, PVector right, int depth) {
  if (depth < 1) {
    line(left.x, left.y, top.x, top.y);
    line(right.x, right.y, top.x, top.y);
    line(left.x, left.y, right.x, right.y);
    return;
  }
  
  PVector topLeft = getAaverage(top, left);
  PVector topRight = getAaverage(top, right);
  PVector leftRight = getAaverage(left, right);
  
  drawTriangle(top, topLeft, topRight, depth - 1);
  drawTriangle(topLeft, left, leftRight, depth - 1);
  drawTriangle(topRight, leftRight, right, depth - 1);  
}

PVector getAaverage(PVector first, PVector second) {
  return new PVector((first.x + second.x) / 2, (first.y + second.y) / 2);  
}