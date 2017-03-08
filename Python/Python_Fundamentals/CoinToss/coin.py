import random

def CoinToss(num):

    headcount = 0

    tailcount = 0

    for i in range(1, num+1):

        print "attempt #", i, ": Throwing a coin... "

        if random.randint(0,1) == 0:

            print("It's heads! ... ")

            headcount += 1

        else:

            print("It's tails! ... ")

            tailcount += 1

        print "Got " + str(headcount) +" head(s) so far and "+ str(tailcount)+ " tails(s) so far."



CoinToss(5000)