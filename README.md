# bankaccounts-sim

## A Bank Account Simulator that runs on Java and uses Java DB which runs on a SQL-back end


## What does it do?

It emulates how a bank account works in real life. With some features that you 
might find at different banks. You can create accounts, with REAL usernames and 
initial balances (Unlimited cash, who doesn't want that?), account numbers and account types. You can 
deposit, withdraw and cool enough you can even E-TRANSFER to other accounts and it updates in real 
time. I'm really proud of that feature.  

## What could be improved?

Lots of this code could be improved!

The first thing that comes to mind is maybe autogeneration of account numbers. Maybe one could write a 
accntNumGenerator function that intakes no parameters and produces an account number with 6 digits and 
exists between a certain range of numbers. 

As of right now this code is not non-developer friendly, meaning you kind of have to know java to use 
this application. One could create a GUI to eliminate that need. 

Use of Inheritance. Savings, Chequings and Tax accounts could inherit from a single class but override 
the class methods in order to make a more realistic feel. For example savings accounts in the real 
world are limited to 1 or 2 transactions per month, that could be implemented in the code. 

Security. Creating a login page for the account. 

Now I may be dreaming, but I think most of these are doable. 


## How does it work?

The way it works (as of right now) is that the developer could create accounts using the BankAccount 
constructor to create new bank accounts. The constructor contains calls to a backend Java DB server SQL 
server where instructions are manually typed by the code and run on the Java DB. If there's a faster 
way to do this let me know please!

## What did I use to make this app?

Java, Java DB (Built in Data Base for Java), SQL 

Used the NetBeans IDE, a great tool 

## What did I learn?

I learned A LOT. This is a fairly new language to me and I'm glad to say that I've tried to push my 
limits. I learned about Java constructors, methods, scopes and arguements (the basics). Then I've also 
learned about how back-end servers work. 

I wish I could have used OOP more effectively, but I'll get there.  



  
