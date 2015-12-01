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
  
  // initialize physics variables
  x1 = 0;
  y1 = 0;
  x2 = 0;
  y2 = 0;
  len1 = 140;
  len2 = 160;
  m1 = 8;
  m2 = 12;
  
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
  
  // implement RK4
  // RK equations for the first DE
  k11 = 
  k12 = 
  k13 = 
  k14 = 
  
  // RK equations for the second DE
  k21 = 
  k22 = 
  k23 = 
  k24 = 
  
  // update temporary variables
  temp1 =
  temp2 =
  
  // update angular velocity
  aVel1 += temp1;
  aVel2 += temp2;
  
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
      fill(scale*255, 64);
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