## @file SeqServicesLibrary.py
#  @author Jaskaran Singh
#  @brief Library module that provides functions for working with sequences
#  @details This library assumes that all functions will be provided with arguments of the expected types
#  @date 03/04/2021


def max_val(s):
	if len(s) == 0:
		raise ValueError
	m = s[0]
	for x in s:
		if m >= x:
			continue
		else:
			m = x
	return m 


def count(t,s):
	if len(s) == 0:
		raise ValueError
	c = 0
	for x in range(0,len(s)):
		if t == s[x]:
			c += 1
	return c

def spices(s):
	if len(s) == 0:
		raise ValueError
	str=[]
	c=0
        for i in s:
            if i<=0:
                str.append("nutmeg")
            else:
                str.append("ginger") 
            c=c+1
        return str

def new_max_val(s,f):
	if len(s) == 0:
		raise ValueError
	newMax=0
	for i in s:
		for i in s:
			if i >= newMax:
				newMax=i
        if f(newMax):
    		return newMax
   

