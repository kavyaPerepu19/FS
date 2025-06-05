#include <iostream>
#include <string>
using namespace std;

// Abstract Product A
class Shape {
public:
    virtual void draw() = 0;
    virtual ~Shape() {}
};

// Concrete Products A
class Circle : public Shape {
public:
    void draw() override {
        cout << "Inside Circle::draw() method." << endl;
    }
};

class Square : public Shape {
public:
    void draw() override {
        cout << "Inside Square::draw() method." << endl;
    }
};

// Abstract Product B
class Widget {
public:
    virtual void draw() = 0;
    virtual ~Widget() {}
};

// Concrete Products B
class LinuxButton : public Widget {
public:
    void draw() override {
        cout << "LinuxButton" << endl;
    }
};

class WindowsButton : public Widget {
public:
    void draw() override {
        cout << "WindowsButton" << endl;
    }
};

class MacButton : public Widget {
public:
    void draw() override {
        cout << "MacButton" << endl;
    }
};

// Abstract Factory
class AbstractFactory {
public:
    virtual Shape* getShape(const string& shape) = 0;
    virtual Widget* getButton(const string& button) = 0;
   
};

// Concrete Factory: ShapeFactory
class ShapeFactory : public AbstractFactory {
public:
    Shape* getShape(const string& shapeType) override {
        if (shapeType == "CIRCLE") return new Circle();
        else if (shapeType == "SQUARE") return new Square();
        else return nullptr;
    }

    Widget* getButton(const string& /*button*/) override {
        return nullptr;
    }
};

// Concrete Factory: ButtonFactory
class ButtonFactory : public AbstractFactory {
public:
    Shape* getShape(const string& /*shape*/) override {
        return nullptr;
    }

    Widget* getButton(const string& button) override {
        if (button == "LINUX") return new LinuxButton();
        else if (button == "WINDOWS") return new WindowsButton();
        else if (button == "MAC") return new MacButton();
        else return nullptr;
    }
};

// Factory Producer
class FactoryProducer {
public:
    static AbstractFactory* getFactory(const string& choice) {
        if (choice == "SHAPE") return new ShapeFactory();
        else if (choice == "BUTTON") return new ButtonFactory();
        else return NULL;
    }
};

// Client Code
int main() {
    // Get Shape Factory
    AbstractFactory* shapeFactory = FactoryProducer::getFactory("SHAPE");

    Shape* shape1 = shapeFactory->getShape("CIRCLE");
    shape1->draw();

    Shape* shape2 = shapeFactory->getShape("SQUARE");
    shape2->draw();

    // Get Button Factory
    AbstractFactory* buttonFactory = FactoryProducer::getFactory("BUTTON");

    Widget* button1 = buttonFactory->getButton("LINUX");
    button1->draw();

    Widget* button2 = buttonFactory->getButton("WINDOWS");
    button2->draw();

    Widget* button3 = buttonFactory->getButton("MAC");
    button3->draw();

   

    return 0;
}
