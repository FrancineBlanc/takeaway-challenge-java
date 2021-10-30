Takeaway Challenge
==================
```
                            _________
              r==           |       |
           _  //            |  JAVA |   ))))
          |_)//(''''':      |       |
            //  \_____:_____.-------D     )))))
           //   | ===  |   /        \
       .:'//.   \ \=|   \ /  .:'':./    )))))
      :' // ':   \ \ ''..'--:'-.. ':
      '. '' .'    \:.....:--'.-'' .'
       ':..:'                ':..:'

 ```

## Introduction
____

This program is the Java implementation of the takeaway challenge (which I previously programmed using Ruby). The 
program uses JUnit for testing and is a takeaway app designed to deal with the following user stories:

```
As a customer
So that I can check if I want to order something
I would like to see a list of dishes with prices

As a customer
So that I can order the meal I want
I would like to be able to select some number of several available dishes

As a customer
So that I can verify that my order is correct
I would like to check that the total I have been given matches the sum of the 
various dishes in my order

As a customer
So that I am reassured that my order will be delivered on time
I would like to receive a text such as "Thank you! Your order has been placed 
and will be delivered before 18:52" after I have ordered
```
## Installation
After forking and cloning this repo, please run `gradle` to install the necessary dependencies.

## Usage
You can run the program in a text editor such as VSCode or IntelliJ. An example snippet of functionality is below:
```java
Welcome to Lucian flavours! Take a look at our menu:
plain rice: £2.50;
fried plantain: £2.00;
ackee with sweet peppers: £6.00;
curried goat: £7.50;
fried snapper: £7.00;
fried chicken: £6.50;
rice and peas: £3.00;
mac and cheese: £4.00
Please select some items from the menu and type 'exit' when you are done:
curried goat
curried goat added to basket
mac and cheese
mac and cheese added to basket
exit
You have the following items in your basket:
item: curried goat, quantity: 1;
item: mac and cheese, quantity: 1.
Your total comes to £11.50.
Please confirm you are ready to place your order by typing 'yes'
yes
Your order has been successfully placed!
```
The user will also receive a text message confirming that their order has been received and will be delivered within 
the hour.