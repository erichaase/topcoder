# DistantPoints[http://community.topcoder.com/stat?c=problem_statement&pm=11077]

class DistantPoints
  def self.solution (n, k)
    @max = 2 ** n + 2

    points = {}
    p = [1, 1]

    (k - 1).times do
      points[p] = true
      p = nextPoint(points)
    end

    p
  end

  def self.nextPoint (points)
    dMax       = 0
    nextPoints = []

    1.upto(@max - 1) do |x|
      1.upto(@max - 1) do |y|
        p = [x, y]
        next if points.has_key? p

        d = distance(p, points)
        if d > dMax
          dMax = d
          nextPoints = [p]
        elsif d == dMax
          nextPoints << p
        end
      end
    end

    nextPoints.sort! do |a, b|
      if a[0] < b[0]
        -1
      elsif a[0] > b[0]
        1
      elsif a[1] < b[1]
        -1
      elsif a[1] > b[1]
        1
      else
        0
      end
    end

    nextPoints[0]
  end

  def self.distance (p1, points)
    dMin = 1.0/0.0 # infinity

    points.keys.each do |p2|
      d = Math.sqrt( ((p1[0] - p2[0]) ** 2) + ((p1[1] - p2[1]) ** 2) )
      if d < dMin
        dMin = d
      end
    end

    dMin
  end
end
