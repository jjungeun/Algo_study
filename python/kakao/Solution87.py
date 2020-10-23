import sys
sys.stdin = open("input.txt", "r")

import math
x, y, c= map(float, input().split())
lidx = 0
ridx = min(x, y)
answer = 0
while abs(ridx-lidx)>1e-6:
	mid = (lidx+ridx)/2.0
	h1=math.sqrt(x**2-mid**2)
	h2=math.sqrt(y**2-mid**2)
	h = (h1*h2)/(h1+h2)
	if h > c:
		lidx = mid
	else:
		answer = mid
		ridx = mid
print("%.3f"%round(answer,3))
