
// class to make a rod object
class Rod {
  
  // array to store the temperatures 
  // on the different sections of the rod
  float[] temperature;
  
  // contstructor
  Rod() {
    // intialize temperature array
    temperature = new float[width];
    
    // rod is initially 'cold'
    for (int i = 0; i < width; i++) {
      temperature[i] = 0.72*width;
    }
  }
  
  // Use the laplacian here to solve
  // the differential equation
  void update() {
    float timeStepSquared = h * h;
    float lastTemperature = temperature[0];
    for (int currentSpot = 1; currentSpot < temperature.length - 1; currentSpot++) {
      float nextTemperature = temperature[currentSpot + 1];
    
      float changeInTemperature = (lastTemperature + nextTemperature - (2 * temperature[currentSpot])) * h;
      lastTemperature = temperature[currentSpot];
      temperature[currentSpot] += changeInTemperature;
    }
  }
  
  // display the rod on the screen
  void display() {
    for (int i = 0; i < width; i++) {
      stroke(temperature[i], width, width);
      //stroke(i, width, width);
      line(i, -16, i, 16);
    }
  }
 
}