class Walker {
  //location variables
  float xLoc;
  float yLoc;

  Walker (float x, float y) {
    xLoc = x;
    yLoc = y;
  }
  
  void update() {
    if (random(1) < 0.5) {
     if (random(1) < 0.5) {
       xLoc++;
     } else {
       xLoc--;
     }
    } else {
     if (random(1) < 0.5) {
       yLoc++;
     } else {
       yLoc--;
     }
    }
  }


  void display() {
    noStroke();
    
    fill(200,100,60);
    
    ellipse(xLoc, yLoc, 4,4);
  }
  
}