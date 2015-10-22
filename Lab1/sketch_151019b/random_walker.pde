class random_walker {
  PVector centerPoint;

   (PVector vector) {
    centerPoint = vector;
  }
  
  void update() {
    if (random(1) < 0.5) {
     if (random(1) < 0.5) {
       centerPoint.x++;
     } else {
       centerPoint.x--;
     }
    } else {
     if (random(1) < 0.5) {
       centerPoint.y++;
     } else {
       centerPoint.y--;
     }
    }
  }


  void display() {
    noStroke();
    
    fill(200,100,60);
    
    ellipse(centerPoint.x, centerPoint.y, 4,4);
  }
  
}