def draw_stars(list):

    for x in list:

        if type(x) == str:

            print x[0]*len(x)

        else:

            print ("*"*x)





draw_stars([4,"tom",1,"michael",5,7,"jimmy smith"])