#include <iostream>
#include <string>
# include <list>
using namespace std;

class Mediator;
 
class Colleague
{
  public:
    virtual ~Colleague() {};
    virtual void SendMsg(string) = 0;
    virtual void GetMsg(string) = 0;
  protected:
    Colleague(Mediator*);
    Mediator* _mediator;
};

class ConcreteColleague1 : public Colleague
{
  public:
    virtual ~ConcreteColleague1() {};
    ConcreteColleague1(Mediator*);
    virtual void SendMsg(string msg);
    virtual void GetMsg(string);
};
 
class ConcreteColleague2 : public Colleague
{
  public:
    virtual ~ConcreteColleague2() {};
    ConcreteColleague2(Mediator*);
    virtual void SendMsg(string msg);
    virtual void GetMsg(string);
};

class ConcreteColleague3 : public Colleague
{
  public:
    virtual ~ConcreteColleague3() {};
    ConcreteColleague3(Mediator*);
    virtual void SendMsg(string msg);
    virtual void GetMsg(string);
};

class ConcreteColleague4 : public Colleague
{
  public:
    virtual ~ConcreteColleague4() {};
    ConcreteColleague4(Mediator*);
    virtual void SendMsg(string msg);
    virtual void GetMsg(string);
};
 
class Mediator
{
  public:
    virtual ~Mediator() {};
    virtual void SendMsg(string, Colleague*) = 0;
  protected:
    Mediator() {};
};

class ConcreteMediator : public Mediator
{
  public:
    ConcreteMediator(Colleague* = NULL);
    virtual ~ConcreteMediator() {};
    void SetColleague(Colleague*);
    virtual void SendMsg(string msg, Colleague*);
  private:
    list <Colleague *> Colleagues;
};

ConcreteMediator::ConcreteMediator(Colleague* o) {
  Colleagues.push_back(o);
}

class ConcreteMediator2 : public Mediator
{
  public:
    ConcreteMediator2(Colleague* = NULL);
    virtual ~ConcreteMediator2() {};
    void SetColleague(Colleague*);
    virtual void SendMsg(string msg, Colleague*);
  private:
    list <Colleague *> Colleagues;
};

ConcreteMediator2::ConcreteMediator2(Colleague* o) {
  Colleagues.push_back(o);
}

Colleague::Colleague(Mediator* pMediator)
{
  this->_mediator = pMediator;
}
 
ConcreteColleague1::ConcreteColleague1(Mediator* pMediator) : 
  Colleague(pMediator) {}

void ConcreteColleague1::SendMsg(string msg)
{
  this->_mediator->SendMsg(msg, this);
}
 
void ConcreteColleague1::GetMsg(string msg)
{
   cout <<"ConcreteColleague1 Received:"<<msg << endl;
}

ConcreteColleague4::ConcreteColleague4(Mediator* pMediator) : 
  Colleague(pMediator) {}

void ConcreteColleague4::SendMsg(string msg)
{
  this->_mediator->SendMsg(msg, this);
}
 
void ConcreteColleague4::GetMsg(string msg)
{
   cout <<"ConcreteColleague1 Received:"<<msg << endl;
}
 
ConcreteColleague2::ConcreteColleague2(Mediator* pMediator) : 
  Colleague(pMediator) {}

void ConcreteColleague2::SendMsg(string msg)
{
  this->_mediator->SendMsg(msg, this);
}

void ConcreteColleague2::GetMsg(string msg)
{
  cout <<"ConcreteColleague2 Received:" <<msg << endl;
}

ConcreteColleague3::ConcreteColleague3(Mediator* pMediator) : 
  Colleague(pMediator) {}

void ConcreteColleague3::SendMsg(string msg)
{
  this->_mediator->SendMsg(msg, this);
}

void ConcreteColleague3::GetMsg(string msg)
{
  cout <<"ConcreteColleague3 Received:" <<msg << endl;
}
 
void ConcreteMediator::SetColleague(Colleague* p)
{
  Colleagues.push_back(p);
}

void ConcreteMediator::SendMsg(string msg, Colleague* p)
{
  list <Colleague *>::iterator o_Iter;

  for (o_Iter = Colleagues.begin(); o_Iter != Colleagues.end(); o_Iter++)
  {
    if(*o_Iter != 0 && p != *o_Iter)
    {
      (*o_Iter)->GetMsg(msg);
    }
  } 
}

void ConcreteMediator2::SetColleague(Colleague* p) {
    Colleagues.push_back(p);
}

void ConcreteMediator2::SendMsg(string msg, Colleague* p) {
    for (Colleague* colleague : Colleagues) {
        if (colleague != nullptr && colleague != p) {
            colleague->GetMsg(msg);
        }
    }
}


int main()
{
  
  ConcreteMediator* mediator1 = new ConcreteMediator();
  ConcreteMediator2* mediator2 = new ConcreteMediator2();


  Colleague* c1 = new ConcreteColleague1(mediator1);
  Colleague* c2 = new ConcreteColleague2(mediator1);
  Colleague* c3 = new ConcreteColleague3(mediator1);

  mediator1->SetColleague(c1);
  mediator1->SetColleague(c2);
  mediator1->SetColleague(c3);

 
  Colleague* c4 = new ConcreteColleague4(mediator2);
  mediator2->SetColleague(c4);
  mediator2->SetColleague(c1);
  mediator2->SetColleague(c3);


  cout << "Mediator1 messages:\n";
  c1->SendMsg("Colleague1 sends message");
  c2->SendMsg("Colleague2 sends message");
  c3->SendMsg("Colleague3 sends message");

  cout << "\nMediator2 message:\n";
  c4->SendMsg("c4 sent message");
  c1->SendMsg("c1 sent message to mediator2");

  return 0;
}
