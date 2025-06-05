#include <iostream>
using namespace std;
#define interface struct

interface Shape 
{	
    virtual void draw() = 0;
};

class Square : public Shape 
{
  public:
    void draw() {
      cout << "Inside Square::draw() method." << endl;
  }
};

class Circle : public Shape 
{
  public:
    void draw() {
      cout << "Inside Circle::draw() method." << endl;
  }
};

class Rectangle : public Shape 
{
  public:
    void draw() {
      cout << "Inside Rectangle::draw() method." << endl;
  }
};

class Polygon :public Shape{
  public:
    void draw() {
      cout << "Inside Polygon::draw() method." << endl;
  }
};

class ShapeMaker {
  private:
    Shape *circle;
    Shape *rectangle;
    Shape *square;
    Shape *poly;
  
  public:
    ShapeMaker() {
      circle = new Circle();
      rectangle = new Rectangle();
      square = new Square();
      poly = new Polygon();
    }

    void drawCircle(){
      circle->draw();
    }

    void drawRectangle(){
      rectangle->draw();
    }

    void drawSquare(){
      square->draw();
    }

    void drawPoly()
    {
      poly->draw();
    }
};

int main() 
{
  ShapeMaker shapeMaker; 

  shapeMaker.drawCircle();
  shapeMaker.drawRectangle();
  shapeMaker.drawSquare();
  shapeMaker.drawPoly();	

  Circle *c = new Circle();
  (*c).draw();

  Polygon * p = new Polygon();
  (*p).draw();

  return 0;
}