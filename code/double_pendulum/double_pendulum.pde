/* 
 * double pendulum model
 * use RK4 for numerical differentiation
 * 
 */

// global variables

//phyical variables
// position, angle, and angular velocity
float x1, y1, x2, y2, theta1, theta2, aVel1, aVel2;
float temp1, temp2;

// length, mass, and gravity
float len1, len2, m1, m2, g;

// timestep
float h;

// Runge Kutta variables
float k11, k12, k13, k14;
float k21, k22, k23, k24;

// array to store the trajectory of the 2nd pendulum
float[][] path;
// how many points to store in the array
int pathLength;
// variable to make the path prettier
float scale;


void setup() {
  size(640, 640);
  background(0);
  colorMode(HSB);
  
  // initialize physics variables
  x1 = 0;
  y1 = 0;
  x2 = 0;
  y2 = 0;
  len1 = 140;
  len2 = 80;
  m1 = 8;
  m2 = 32;
  
  // initialize test variables
  theta1 = random(0.7,1)*PI;
  theta2 = random(0.3,1)*PI;
  aVel1 = 0;
  aVel2 = 0;
  
  // initalize time step
  h = 0.06;
  
  // initialize gravity
  g = 6;
  
  // initialize path array
  pathLength = 1024;
  path = new float[pathLength][2];
}

void draw() {
  // refresh the screen and set origin to center of screen
  background(0);
  translate(width/2, height/2);
  rotate(HALF_PI);
  
  float hOver2 = (h/2);
  // implement RK4
  // RK equations for the first DE
  k11 = f1(theta1);
  k12 = f1(theta1 + (hOver2 * k11));
  k13 = f1(theta1 + (hOver2 * k12));
  k14 = f1(theta1 + (h * k13));
  
  // RK equations for the second DE
  k21 = f2(theta2);
  k22 = f2(theta2 + (hOver2 * k21));
  k23 = f2(theta2 + (hOver2 * k22));
  k24 = f2(theta2 + (h * k23));
  
  // update angular velocity
  aVel1 += k14 * h;
  aVel2 += k24 * h;
  
  // update angles
  theta1 += aVel1;
  theta2 += aVel2;
  
  // update position 
  x1 = len1*cos(theta1);
  y1 = len1*sin(theta1);
  x2 = x1 + len2*cos(theta2);
  y2 = y1 + len2*sin(theta2);
 
 
  // update path array
  path[0][0] = x2;
  path[0][1] = y2;
  for (int i = pathLength - 1; i > 0; i--) {
    path[i][0] = path[i-1][0];
    path[i][1] = path[i-1][1];
  }
  
  // draw the path of the second mass
  for (int i = pathLength - 1; i >= 0; i--) {
    if (path[i][0] != 0 && path[i][1] != 0) {
      scale = (pathLength - (float) i) / pathLength;
      noStroke();
      int rainbowColors = color(scale*255,255,255);
      fill(rainbowColors);
      ellipse(path[i][0], path[i][1], 2*m2*scale, 2*m2*scale);
    }
  }
  
  //display the pendulums
  strokeWeight(3);
  stroke(255);
  line(0, 0, x1, y1);
  line(x1, y1, x2, y2);
  fill(255, 200);
  noStroke();
  ellipse(x1, y1, 2*m1, 2*m1);
  ellipse(x2, y2, 2*m2, 2*m2);
  
  
}

// method to compute first DE
float f1(float theta) {
  return (m2*len2*temp2*cos(theta1 - theta2) 
        -m2*aVel2*aVel2*sin(theta1 - theta2)
        -(m1 + m2)*g*sin(theta1)) 
        / (len1*(m1 + m2));
}

// method to compute second DE
float f2(float theta) {
  return (-m2*len1*temp1*cos(theta1 - theta2)
          +m2*len1*aVel1*aVel1*sin(theta1 - theta2)
          -m2*g*sin(theta2))
          / (m2*len2);
          
}