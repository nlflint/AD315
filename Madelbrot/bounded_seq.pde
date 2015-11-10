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
  size();
  // HSB stands for hue, saturation, and brightness
  colorMode(HSB);
  // we are only writing to the display window once
  noLoop();
  // initialize the background.
  background(255);
  
  // set the number of iterations
  iterations = 
  
  // here we decide what our discrete
  // infinity will be
  infinity = 
  
  // initialize the viewing window
  xmin = 
  xmax = 
  ymin = 
  ymax = 
  // dx and dy should be defined using the 
  // height and width keywords. 
  dx = 
  dy = 
}

void draw() {
  // to use the pixels[] array you need to first 
  // call the loadpixels() method
  loadPixels();
  
  for (int i = 0; i < width; i++) {
    for (int j = 0; j < height; j++) {
      // a and b represent the current value of c
      // which depends on i and j. Here c = a + bi
      a = 
      b = 
      
      // determine whether the sequence is bounded
      // at the current value of c
      iterationCount = checkBounded(a,b);
      
      // write a color to the pixels[] array based
      // on iterationCount
      c = color();
      pixels[] = c;
    }
  }
  
  // you need to call updatePixels() to display
  // the colors stored in the pixels[] array.
  updatePixels();
}

// method to check if the sequence is bounded. x 
// is the real part of c, and y is the imaginary part.
int checkBounded(double x, double y) {
  // result is used to determine if a sequence
  // is bounded for a given value of c
  int result;
  
  // temporary variables used for computation
  double x1;
  double x2;
  double y1;
  double y2;
  
  // this loop will check if the sequence
  // is bounded for the particular value hof c
  for (int i = 0; i < iterations; i++) {
   
    result = ;
    
    // if result is larger than our discrete infinity
    // return the number of iterations it took to get
    // to the discrete infinity
    if (result > infinity) {
      return i;
    }
  }
  
  // once we've ran through the specified
  // number of iterations we decide the
  // sequence is bounded for the particular
  // value of c and return 0 as a result.
  return 0;
}