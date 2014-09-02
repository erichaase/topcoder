# Isoceles[http://community.topcoder.com/stat?c=problem_statement&pm=1169]

class Isoceles
  def self.solution (xs, ys)
    ps = []
    xs.each_index { |i| ps << [xs[i], ys[i]] }

    ts = []
    ps.combination(3) do |t|
      a,  b,  c  = t[0], t[1], t[2]
      ab, ac, bc = distance(a,b), distance(a,c), distance(b,c)
      next if not isosceles(ab, ac, bc)
      next if not right(ab, ac, bc)
      ts << t
    end

    ts.size
  end

  def self.isosceles (d1, d2, d3)
    if [d1, d2, d3].uniq.size < 3
      true
    else
      false
    end
  end

  def self.right (d1, d2, d3)
    return true if rightAngle(d1, d2, d3)
    return true if rightAngle(d2, d1, d3)
    return true if rightAngle(d3, d1, d2)
    return false
  end

  # Pythagorean theorem: a^2 + b^2 = c^2
  def self.distance (a, b)
    Math.sqrt((a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2)
  end

  def self.rightAngle (d1, d2, d3)
    a = angle(d1, d2, d3)
    (a - 90.0).abs <= 0.1
  end

  # Law of cosines: c^2    = a^2 + b^2 - 2ab * cos(c)
  # SSS:            cos(c) = (a^2 + b^2 - c^2) / 2ab
  def self.angle (d1, d2, d3)
    x = ((d3**2 + d2**2 - d1**2).to_f / (2 * d3 * d2).to_f).round(2)
    Math.acos(x) * (180 / Math::PI)
  end

end
