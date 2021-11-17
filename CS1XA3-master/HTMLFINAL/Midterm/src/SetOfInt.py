## @file SetOfInt.py
#  @author Jaskaran Singh
#  @brief Set of integers
#  @date 03/04/2021
class SetOfInt:
	def __init__(self,xs):
		self.s = set(xs)

	def is_member(self,x):
		if x in self.s:
			return True
		return False

	def to_seq(self):
		return self.__set_to_seq(self.s)

	def __set_to_seq(self,xs):
		return list(xs)


	def union(self,t):
		return SetOfInt(self.to_seq() + t.to_seq())

	#def diff(self,t):
	#	return SetOfInt()

	def size(self):
		return len(self.s)

	def empty(self):
		if len(self.s):
			return True
		return False
	
	def equals(self,t):
		if len(self.s) != len(t.to_seq()):
			return False
		r = t.to_seq()
		for x in self.s:
			if (x not in r):
				return False
		return True

