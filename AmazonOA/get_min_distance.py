def getMinDistance(center, destination):
  center.sort()
  destination.sort()
  distance = 0
  n = len(center)
  for i in range(n):
    distance += abs(center[i] - destination[i])
    return distance