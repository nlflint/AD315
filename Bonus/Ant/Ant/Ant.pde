

boolean[] grid;
int antIndex;
int test;
int widthInSquares = 101;
int squarePixelSize = 6;
Bearing lastBearing;
int numberOfSquares = widthInSquares * widthInSquares;
int stepCount = 0;

enum Bearing {
  North,
  South,
  East,
  West
}

enum Direction {
  Left,
  Right
}

void setup() {
  int mid = widthInSquares / 2;
  antIndex = getIndex(mid,mid);
  
  initializeGrid();
  lastBearing = Bearing.West;
  
  size(606,606); 
  background(0);
  rectMode(CORNERS);
  
}

void initializeGrid() {
  grid = new boolean[numberOfSquares];
  for (int i = 0; i < numberOfSquares; i++) {
    grid[i] = true;
  }
}
void draw() {
  stepCount++; //<>//
  drawBoard();
  Direction newDirection = getNewDirection();
  Bearing newBearing = getNewBearing(newDirection);
  flipSquareColor();
  antIndex = getNewIndexFrom(newBearing);
  lastBearing = newBearing;
  
  
   
  
  
}

Direction getNewDirection() {
  return grid[antIndex] ? Direction.Right : Direction.Left;
}

Bearing getNewBearing(Direction direction) {
  switch(lastBearing) {
    case North:
      return direction.equals(Direction.Left) ? Bearing.West : Bearing.East;
    case East:
      return direction.equals(Direction.Left) ? Bearing.North : Bearing.South;
    case South:
      return direction.equals(Direction.Left) ? Bearing.East : Bearing.West;
    default:
      return direction.equals(Direction.Left) ? Bearing.South : Bearing.North;
  }
}

int getNewIndexFrom(Bearing bearing) {
  switch(bearing) {
    case North:
      return antIndex - widthInSquares;
    case East:
      return antIndex + 1;
    case South:
      return antIndex + widthInSquares;
    default:
      return antIndex - 1;
  }
}

int getIndex(int row, int column) {
  
  return (widthInSquares * row) + column;   
}

void flipSquareColor() {
  grid[antIndex] = !grid[antIndex];
}

void drawBoard() {
  for(int i = 0; i < numberOfSquares; i++) {
    int x = getxCoordinate(i);
    int y = getyCoordinate(i);
    if (grid[i]) {
      fill(255,255,255);
    } else {
      fill(0,0,0);
    }
    
    rect(x,y,x + squarePixelSize, y + squarePixelSize);
  }
  
  drawAnt();
}

int getxCoordinate(int index) {
  return (index % widthInSquares) * squarePixelSize;
}

int getyCoordinate(int index) {
  return (index / widthInSquares) * squarePixelSize;
}

void drawAnt() {
  int x = getxCoordinate(antIndex);
  int y = getyCoordinate(antIndex);
  fill(255,0,0);
  int antWidth = squarePixelSize - 2;
  rect(x + antWidth, y + antWidth, x + squarePixelSize - antWidth, y + squarePixelSize - antWidth);
}