/* AD 315
 * Programming Assignment 3
 *
 * Determining whether sequences are
 * bounded in a discrete complex space
 *
 * The sequence is recursively defined as
 * z_{n+1} = (z_n)^2 + c.
 * Here c is a complex number and z_0 = c
 */

// variables for the real and complex part of 
// a complex number
double a, b;

// variables to determine the real and
// imaginary range of the viewing window
double xmin, xmax, ymin, ymax, dx, dy;

// variable to determine how many iterations
// of the sequence we will look at.
int iterations;

// variable to determine number of iterations
int iterationCount;

// color variable to represent number of iterations
color c;

// since we are in a discrete space, we will choose a finite 
// number to represent infinity
int infinity;

void setup() {
  // be sure to fill in the size method
  size(960 ,540);
  // HSB stands for hue, saturation, and brightness
  colorMode(HSB);
  // we are only writing to the display window once
  noLoop();
  // initialize the background.
  background(255);
  
  // set the number of iterations
  iterations = 100;
  
  // here we decide what our discrete
  // infinity will be
  infinity = 12;

  // initialize the viewing window
  xmin = -3.2;
  xmax = 1.6;
  ymin = -1.35;
  ymax = 1.35;
}

void draw() {
  // to use the pixels[] array you need to first 
  // call the loadpixels() method
  loadPixels();
  
  // dx and dy should be defined using the 
  // height and width keywords. 
  dx = (xmax - xmin) / width;
  dy = (ymax - ymin) / height;

  for (int i = 0; i < width; i++) {
   for (int j = 0; j < height; j++) {
     // a and b represent the current value of c
     // which depends on i and j. Here c = a + bi
     a = xmin + (i * dx);
     b = ymin + (j * dy);
        
     // determine whether the sequence is bounded
     // at the current value of c //<>//
     iterationCount = checkBounded(a,b);
        
     // write a color to the pixels[] array based
     // on iterationCount 
     c = color(255 - iterationCount * 7, iterationCount * 16, iterationCount * 12);
     pixels[(j * width) + i] = c;
   }
  }
  // you need to call updatePixels() to display
  // the colors stored in the pixels[] array.
  updatePixels();
}

// method to check if the sequence is bounded. x 
// is the real part of c, and y is the imaginary part.
int checkBounded(double originalReal, double originalImaginary) {
  // result is used to determine if a sequence
  // is bounded for a given value of c
  double result;
  
  // temporary variables used for computation
  double currentReal = originalReal;
  double currentImaginary = originalImaginary;
  
  // this loop will check if the sequence
  // is bounded for the particular value of c
  for (int i = 0; i < iterations; i++) {
    result = square(currentReal) + square(currentImaginary);
    // if result is larger than our discrete infinity
    // return the number of iterations it took to get
    // to the discrete infinity
    if (result > infinity) {
      return i;
    }
    
    double workingReal = square(currentReal) - square(currentImaginary) + originalReal;
    double workingImaginary = (2.0 * currentReal * currentImaginary) + originalImaginary;
    currentReal = workingReal;
    currentImaginary = workingImaginary;
  }
  
  // once we've ran through the specified //<>//
  // number of iterations we decide the
  // sequence is bounded for the particular
  // value of c and return 0 as a result.
  return 0;
}

//
double square(double x) {
  return x * x;
}

void keyPressed() {
  double xDelta = (xmax - xmin) * 0.02;
  double yDelta = (ymax - ymin) * 0.02;
  
  if (keyCode == RIGHT) {
    xmax += xDelta;
    xmin += xDelta;
  } else if (keyCode == LEFT) {
    xmax -= xDelta;
    xmin -= xDelta;
  } else if (keyCode == UP) {
    ymax -= yDelta;
    ymin -= yDelta;
  } else if (keyCode == DOWN) {
    ymax += yDelta;
    ymin += yDelta;
  } else if (key == '=') {
    ymax -= yDelta; //<>//
    ymin += yDelta;
    xmax -= xDelta;
    xmin += xDelta;
  } else if (key == '-') {
    ymax += yDelta;
    ymin -= yDelta;
    xmax += xDelta;
    xmin -= xDelta;
  }
  draw();
}